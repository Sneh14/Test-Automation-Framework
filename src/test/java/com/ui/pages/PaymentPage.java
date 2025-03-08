package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By PAY_BY_BANK_WIRE_LOCATOR = By.xpath("//a[@class='bankwire']");
	private static final By I_CONFIRM_MY_ORDER = By.xpath("//span[contains(text(),'I confirm my order')]");
	private static final By ORDER_COMPLETE_MSG_LOCATOR = By.xpath("//p[@class='alert alert-success']");
	
	public String completePayment() {
		clickOn(PAY_BY_BANK_WIRE_LOCATOR);
		clickOn(I_CONFIRM_MY_ORDER);
		return getVisibleText(ORDER_COMPLETE_MSG_LOCATOR);
	}
}
