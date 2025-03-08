package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressConfirmation extends BasePage {

	public AddressConfirmation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//button[@name='processAddress']");

	public ShippingPage proceedToCheckoutAndGoToShippingPage() {
		waitUntilElementIsLoaded(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShippingPage(getDriver());
	}
}
