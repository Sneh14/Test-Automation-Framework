package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class BasePage extends BrowserUtility {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");
	
	public void clickOnCheckout() {
		waitUntilElementIsLoaded(PROCEED_TO_CHECKOUT_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
	}
	
}
