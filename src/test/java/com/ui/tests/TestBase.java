package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod (description = "Load the home page of website")
	public void setup(@Optional("Chrome")String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("false") boolean isHeadless, ITestResult result) {
		if(isLambdaTest) {
			this.isLambdaTest = isLambdaTest;
			WebDriver lambdaDriver;
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(result.getMethod().getMethodName(), browser);
			homePage = new HomePage(lambdaDriver);
		}else {
			//Running tests on local machine
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
//	@AfterMethod
//	public void tearDown() {
//		if(isLambdaTest) {
//			LambdaTestUtility.quitSession();
//		}else {
//		homePage.getDriver().quit();
//		}
//	}
}
