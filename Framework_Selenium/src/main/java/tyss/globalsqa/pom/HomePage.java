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

	@FindBy(xpath = "//input[@value='Subscribe']")
	private WebElement subscribeButton;

	public WebElement getSubscribeButton() {
		return subscribeButton;

	}

	@FindBy(xpath = "//div[text()='Enter valid email']")
	private WebElement errorMessageText;

	public WebElement getErrorMessageText() {
		return errorMessageText;

	}

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;

	}

	@FindBy(xpath = "//a[text()='Sitemap']")
	private WebElement sitemapLink;

	public WebElement getSitemapLink() {
		return sitemapLink;

	}

	@FindBy(xpath = "//h1[text()='Sitemap']")
	private WebElement sitemapText;

	public WebElement getSitemapText() {
		return sitemapText;

	}

}
