package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;

public class SearchProductTest extends TestBase {

	MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Chiffon Dress";
	
	@Test(description = "Verify if logged in user is able to search product and correct search result are displayed",
			groups = {"e2e", "sanity", "smoke"}, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "loginTestExcelDataProvider")
	public void verifyProductSearchTest(User user) {
		myAccountPage = homePage.goToLoginInPage().doLoginWith(user.getEmail(), user.getPassword());
		boolean  actualResult = myAccountPage.searchProduct("Printed Chiffon Dress").isSearchedProductPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}
}
