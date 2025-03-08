package com.ui.tests;



import static com.constants.Browser.*;

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class InvalidCredentialsLoginTest extends TestBase {
	
	
	@Test(description = "Verify if the proper error message is shown for the user with invalid credentials", groups = {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "LoginTestDataProvider" )
	public void InvalidCredLoginTest(User user) {
		
		assertEquals(homePage.goToLoginInPage().doLoginWithInvalidCredentials("bbb@gmail.com", "hjhasvdj").getErrorMessage(), "Authentication failed.");
	}
	
	
}
