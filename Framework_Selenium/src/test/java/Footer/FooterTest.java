package Footer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import tyss.globalsqa.baseclass.BaseClass;
import tyss.globalsqa.pom.HomePage;
import tyss.globalsqa.pom.LoginPage;

public class FooterTest extends BaseClass {
	static Assertion assertion;
	static HomePage hp;
	static LoginPage lp;

	@Test(testName = "TC007", description = "Verify user is able to navigate to Sitemap")
	public void tc007() throws Throwable {
		assertion = new Assertion();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);

		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", hp.getSitemapLink());
		
		hp.getSitemapLink().click();
		
		Assert.assertEquals(true, hp.getSitemapText().isDisplayed());

	}

}
