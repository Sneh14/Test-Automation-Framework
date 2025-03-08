package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.ui.pojo.User;
import com.utility.FakeAddressUtility;

public class AddressTest extends TestBase{

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO addressPOJO;

	
	@Test(description = "Verify user is able to add New Address Successfully", dataProviderClass = com.ui.dataproviders.loginDataProvider.class, 
			dataProvider = "loginTestExcelDataProvider")
	public void addFirstNewAddress(User user) {
		myAccountPage= homePage.goToLoginInPage().doLoginWith(user.getEmail(), user.getPassword());
		addressPOJO = FakeAddressUtility.getFakeAddress();
		String address = myAccountPage.goToAddressPage().saveAddress(addressPOJO);
		Assert.assertEquals(address, addressPOJO.getAddressAlias().toUpperCase());
		
		
	}
}
