package tyss.globalsqa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
	public WishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//H1[contains(text(),'Wishlist')]")
	private WebElement wishlistText;

	public WebElement getWishlistText() {
		return wishlistText;

	}
}
