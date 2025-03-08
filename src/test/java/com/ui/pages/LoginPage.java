package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By AUTHENTICATION_ERROR_LOCATOR = By.xpath("//li[text()='Authentication failed.']");
	
	public MyAccountPage doLoginWith(String email, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}

	public LoginPage doLoginWithInvalidCredentials(String email, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, email);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	public String getErrorMessage() {
		return getVisibleText(AUTHENTICATION_ERROR_LOCATOR);
	}
}
