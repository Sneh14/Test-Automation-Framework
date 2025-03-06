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
public class LoginTest extends TestBase {
	
		
	@Test(description = "Verifies if valid user is able to login into the application", groups = {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "LoginTestDataProvider" )
	public void loginTest(User user) {
		
		assertEquals(homePage.goToLoginInPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Aaa bbb");
	}
	
	
	@Test(description = "Verifies if valid user is able to login into the application", groups = {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "LoginTestCSVDataProvider" , retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginCSVTest(User user) {
		
		assertEquals(homePage.goToLoginInPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Aaa bbb");
	}
	
	@Test(description = "Verifies if valid user is able to login into the application", groups = {"e2e","Sanity"},
			dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "loginTestExcelDataProvider" )
	public void loginExcelTest(User user) {
		assertEquals(homePage.goToLoginInPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Aaa bbb");
	}
}
