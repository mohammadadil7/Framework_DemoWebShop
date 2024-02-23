package tyss.globalsqa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class PasswordRecoveryPage {

	public PasswordRecoveryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Password recovery']")
	private WebElement passwordRecoveryText;

	public WebElement getPasswordRecoveryText() {
		return passwordRecoveryText;
	}

	@FindBy(xpath = "//input[@data-val-email='Wrong email']")
	private WebElement recoveryEmailTextfield;

	public WebElement getRecoveryEmailTextfield() {
		return recoveryEmailTextfield;
	}

	@FindBy(xpath = "//input[@value='Recover']")
	private WebElement recoverButton;

	public WebElement getRecoverButton() {
		return recoverButton;
	}

	@FindBy(xpath = "//div[contains(text(),'Email with instructions has been sent to you.')]")
	private WebElement emailSentText;

	public WebElement getEmailSentText() {
		return emailSentText;
	}

}
