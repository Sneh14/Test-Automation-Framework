package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private static final By PROCEED_TO_CHECKOUT_SHOPPING_CART_LOCATOR = By.xpath("//p//a[@title='Proceed to checkout']");
	
	
	public AddressConfirmation proceedToCheckoutAndGoToAddressPage() {
		waitUntilElementIsLoaded(PROCEED_TO_CHECKOUT_SHOPPING_CART_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_SHOPPING_CART_LOCATOR);
		return new AddressConfirmation(getDriver());
	}
}
