package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ui.pages.BasePage;
import com.ui.pages.MyAccountPage;
import com.ui.pages.PaymentPage;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchResultPage;
import com.ui.pages.ShoppingCartPage;
import com.ui.pojo.User;

public class CheckoutProductTest extends TestBase{
	
	MyAccountPage myAccountPage;
	SearchResultPage searchResultPage;
	ProductDetailPage productDetailPage;
	ShoppingCartPage shoppingCartPage;
	BasePage basePage;
	PaymentPage paymentPage;
	
	private static final String PRODUCT_NAME = "Printed Chiffon Dress";
	private static final String SIZE = "M";
	

	@Test(description = "Verify user is able to checkout product successfully",
			groups = {"e2e"}, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider ="loginTestExcelDataProvider")
	public void checkoutProduct(User user) {
		myAccountPage = homePage.goToLoginInPage().doLoginWith(user.getEmail(), user.getPassword());
		productDetailPage = myAccountPage.searchProduct(PRODUCT_NAME).clickOnProductAt(0);
		Assert.assertEquals(productDetailPage.selectSizeAndAddToCart(SIZE),"Product successfully added to your shopping cart");
		paymentPage = productDetailPage.proceedToCheckoutAndGoToShoppingCart().proceedToCheckoutAndGoToAddressPage().proceedToCheckoutAndGoToShippingPage()
		.proceedToCheckoutAndGoToPayment();
		Assert.assertEquals(paymentPage.completePayment(),"Your order on My Shop is complete.");
	}
}
