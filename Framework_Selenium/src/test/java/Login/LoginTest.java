package Login;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.WorkbookProvider;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.util.Assert;
import tyss.globalsqa.baseclass.BaseClass;
import tyss.globalsqa.javautils.JavaUtility;
import tyss.globalsqa.pom.HomePage;
import tyss.globalsqa.pom.LoginPage;
import tyss.globalsqa.pom.PasswordRecoveryPage;

public class LoginTest extends BaseClass {
	static JavaUtility javaUtility;
	static Assertion assertion;
	static LoginPage lp;
	static HomePage hp;
	static PasswordRecoveryPage passwordRecoveryPage;

	@Test(testName = "TC003", description = "Verify user is able to Login")
	public void tc003() throws Throwable {
		javaUtility = new JavaUtility();
		assertion = new Assertion();
		hp = new HomePage(driver);

		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");
		lp = new LoginPage(driver);
		lp.getLoginLink().click();

		String emailId = javaUtility.getLoginCredentialsExcelSheet().getRow(1).getCell(0).toString();

		lp.getEmailTextField().sendKeys(emailId);
		String password = javaUtility.getLoginCredentialsExcelSheet().getRow(1).getCell(1).toString();

		lp.getPasswordTextField().sendKeys(password);
		lp.getLoginButton().click();

		assertion.assertEquals(true, hp.getlogoutLink().isDisplayed());
		Reporter.log("Logged in Successfully", true);

	}

	@Test(testName = "TC004", description = "Verify user is able to Logout", dependsOnMethods = "tc003")
	public void tc004() {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);

		hp.getlogoutLink().click();
		assertEquals(true, lp.getLoginLink().isDisplayed());

	}

	@Test(testName = "TC005", description = "Verify Login was unsuccessful Error Message.")
	public void tc005() throws Throwable {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		assertion = new Assertion();
		javaUtility = new JavaUtility();

		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");

		lp.getLoginLink().click();

		String emailId = javaUtility.getLoginCredentialsExcelSheet().getRow(2).getCell(0).toString();
		lp.getEmailTextField().sendKeys(emailId);

		String password = javaUtility.getLoginCredentialsExcelSheet().getRow(2).getCell(1).toString();
		lp.getPasswordTextField().sendKeys(password);

		lp.getLoginButton().click();

		assertion.assertEquals(true, lp.getLoginUnsuccessfulErrorMessage().isDisplayed());
		Reporter.log("Login Unsuccessful", true);

	}

	@Test(testName = "TC006", description = "Verify user is able to recover password")
	public void tc006() throws Throwable {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		passwordRecoveryPage = new PasswordRecoveryPage(driver);
		assertion = new Assertion();
		javaUtility = new JavaUtility();

		assertEquals(true, lp.getLoginLink().isDisplayed());

		lp.getLoginLink().click();
		assertEquals(true, lp.getForgotpasswordLink().isDisplayed());

		lp.getForgotpasswordLink().click();

		assertion.assertEquals(true, passwordRecoveryPage.getPasswordRecoveryText().isDisplayed());

		String recoverEmail = javaUtility.getProprtiesFileData().getProperty("RecoveryEmail");

		passwordRecoveryPage.getRecoveryEmailTextfield().sendKeys(recoverEmail);
		passwordRecoveryPage.getRecoverButton().click();

		assertion.assertEquals(true, passwordRecoveryPage.getEmailSentText().isDisplayed());

	}

}
