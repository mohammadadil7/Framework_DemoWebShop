package Home;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import tyss.globalsqa.baseclass.BaseClass;
import tyss.globalsqa.pom.HomePage;
import tyss.globalsqa.pom.LoginPage;

public class HomeTest extends BaseClass {
	static Assertion assertion;
	static HomePage hp;
	static LoginPage lp;

	
	@Test(testName = "TC001", description = "Verify Enter valid email error message")
	public void tc001() throws Throwable {
		assertion = new Assertion();
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		
		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");
		hp.getSubscribeButton().click();

		assertion.assertEquals(true, hp.getErrorMessageText().isDisplayed());
	}

	@Test(testName = "TC002", description = "Verify Popup")
	public void tc002() throws Throwable {
		assertion = new Assertion();
		hp = new HomePage(driver);
		
		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");

		hp.getSearchButton().click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}
}
