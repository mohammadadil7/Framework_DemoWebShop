package Login;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.AssertJUnit;
import org.testng.Reporter;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.util.Assert;
import tyss.globalsqa.baseclass.BaseClass;
import tyss.globalsqa.pom.HomePage;
import tyss.globalsqa.pom.LoginPage;

public class TC001_Test extends BaseClass {

	@Test
	public void login() throws Throwable {
		Assertion assertion = new Assertion();
		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");
		LoginPage lp = new LoginPage(driver);
		lp.getLoginLink().click();
		lp.getEmailTextField().sendKeys("mohammadadil@gmail.com");
		lp.getPasswordTextField().sendKeys("7674049087");
		lp.getLoginButton().click();
		HomePage hp = new HomePage(driver);
		assertion.assertEquals(true, hp.getlogoutLink().isDisplayed());
		Reporter.log("Logged in Successfully", true);

	}

	@Test(dependsOnMethods = "login")
	public void logOut() {
		HomePage hp = new HomePage(driver);
		LoginPage lp = new LoginPage(driver);
		hp.getlogoutLink().click();
		assertEquals(true, lp.getLoginLink().isDisplayed());

	}
	

}
