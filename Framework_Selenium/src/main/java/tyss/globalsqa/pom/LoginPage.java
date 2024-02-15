package tyss.globalsqa.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Log in']")
	private WebElement loginLink;

	public WebElement getLoginLink() {
		return loginLink;
	}

	@FindBy(id = "Email")
	private WebElement emailTextField;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	@FindBy(id = "Password")
	private WebElement PasswordTextField;

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

}
