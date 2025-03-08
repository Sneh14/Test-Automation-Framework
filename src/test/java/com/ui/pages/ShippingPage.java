package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShippingPage extends BasePage {

	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By TERMS_AND_CONDITIONS_CHBOX_LOCATOR = By.xpath("//input[@type='checkbox']");
	private static final By PROCEED_TO_CHECKOUT_SHIPPING_LOCATOR = By.xpath("//button[@name='processCarrier']");
	
	public PaymentPage proceedToCheckoutAndGoToPayment() {
		clickOn(TERMS_AND_CONDITIONS_CHBOX_LOCATOR);
		waitUntilElementIsLoaded(PROCEED_TO_CHECKOUT_SHIPPING_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_SHIPPING_LOCATOR);
		return new PaymentPage(getDriver());
	}
}
