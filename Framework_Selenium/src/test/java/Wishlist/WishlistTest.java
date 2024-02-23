package Wishlist;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import tyss.globalsqa.baseclass.BaseClass;
import tyss.globalsqa.pom.HomePage;
import tyss.globalsqa.pom.LoginPage;
import tyss.globalsqa.pom.WishlistPage;

public class WishlistTest extends BaseClass {
	static Assertion assertion;
	static LoginPage lp;
	static HomePage hp;
	static WishlistPage wp;

	@Test(testName = "TC005", description = "Verify user is able to navigate to Wishlist page")
	public void tc005() {
		assertion = new Assertion();
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		wp = new WishlistPage(driver);

		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");

		lp.getLoginLink().click();
		lp.getEmailTextField().sendKeys("mohammadadil@gmail.com");
		lp.getPasswordTextField().sendKeys("7674049087");
		lp.getLoginButton().click();

		assertion.assertEquals(true, hp.getlogoutLink().isDisplayed());
		Reporter.log("Logged in Successfully", true);

		hp.getWishListLink().click();
		assertion.assertEquals(true, wp.getWishlistText().isDisplayed());
	}

}
