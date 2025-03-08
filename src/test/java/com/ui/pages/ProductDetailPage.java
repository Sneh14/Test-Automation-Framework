package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ProductDetailPage extends BasePage {

	public ProductDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By SIZE_DROPDOWN_LOCATOR = By.xpath("//select[@id='group_1']");
	private static final By ADD_TO_CART_LOCATOR = By.xpath("//button[@name='Submit']");
	private static final By PRODUCT_ADDED_TO_CART_MSG_LOCATOR = By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']/h2");

	
	
	public String selectSizeAndAddToCart(String size) {
		selectFromDropDown(SIZE_DROPDOWN_LOCATOR, size);
		clickOn(ADD_TO_CART_LOCATOR);
		waitUntilElementIsLoaded(PRODUCT_ADDED_TO_CART_MSG_LOCATOR);
		return getVisibleText(PRODUCT_ADDED_TO_CART_MSG_LOCATOR);
	}
	
	public ShoppingCartPage proceedToCheckoutAndGoToShoppingCart() {
		clickOnCheckout();
		return new ShoppingCartPage(getDriver());
	}
	
	

}
