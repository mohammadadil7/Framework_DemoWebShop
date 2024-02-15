package tyss.globalsqa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logoutLink;

	public WebElement getlogoutLink() {
		return logoutLink;

	}

	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement wishListLink;

	public WebElement getWishListLink() {
		return wishListLink;

	}

}
