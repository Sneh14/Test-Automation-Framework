package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{

	public AddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private static final By COMPANY_TEXT_BOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR = By.id("city");
	private static final By ZIPCODE_TEXT_BOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXT_BOX_LOCATOR = By.id("phone");
	private static final By MOBILE_NUMBER_TEXT_BOX_LOCATOR = By.id("phone_mobile");
	private static final By OTHER_INFO_TEXT_BOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXT_BOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING_LOCATOR = By.tagName("h3");
	
	public String saveAddress(AddressPOJO addressPOJO) {
		enterText(COMPANY_TEXT_BOX_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPOJO.getCity());
		enterText(ZIPCODE_TEXT_BOX_LOCATOR, addressPOJO.getZipcode());
		enterText(HOME_PHONE_TEXT_BOX_LOCATOR, addressPOJO.getHomePhoneNumber());
		enterText(MOBILE_NUMBER_TEXT_BOX_LOCATOR, addressPOJO.getMobilePhoneNumber());
		enterText(OTHER_INFO_TEXT_BOX_LOCATOR, addressPOJO.getOtherInformation());
		clearText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXT_BOX_LOCATOR, addressPOJO.getAddressAlias());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
		clickOn(SAVE_ADDRESS_LOCATOR);
		return getVisibleText(ADDRESS_HEADING_LOCATOR);
	}
	

	
}
