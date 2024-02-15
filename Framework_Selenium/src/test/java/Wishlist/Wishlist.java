package Wishlist;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import tyss.globalsqa.baseclass.BaseClass;
import tyss.globalsqa.pom.HomePage;
import tyss.globalsqa.pom.LoginPage;
import tyss.globalsqa.pom.WishlistPage;

public class Wishlist extends BaseClass {

	@Test()
	public void name() {
		Assertion assertion = new Assertion();
		assertion.assertEquals(driver.getTitle(), "Demo Web Shop");
		LoginPage lp = new LoginPage(driver);
		lp.getLoginLink().click();
		lp.getEmailTextField().sendKeys("mohammadadil@gmail.com");
		lp.getPasswordTextField().sendKeys("4049087");
		lp.getLoginButton().click();
		HomePage hp = new HomePage(driver);
		assertion.assertEquals(true, hp.getlogoutLink().isDisplayed());
		Reporter.log("Logged in Successfully", true);
		WishlistPage wp = new WishlistPage(driver);
		hp.getWishListLink().click();
		assertion.assertEquals(true, wp.getWishlistText().isDisplayed());
		
	}

}
