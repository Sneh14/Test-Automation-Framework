package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new EdgeDriver());
		}else {
			System.err.println("Invalid browser name");
		}
	}
		
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if(browserName == Browser.CHROME) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=old");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--remote-debugging-pipe");
				driver.set(new ChromeDriver(options));
			}else {
				driver.set(new ChromeDriver());
				
				
			}
		}
		else if(browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
			}else {
				driver.set(new EdgeDriver());
			}
		}else if(browserName == Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
			}else {
				driver.set(new FirefoxDriver());
			}
		}		
		else {
			System.err.println("Invalid browser name");
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	public void goToWebsite(String url) {
		driver.get().get(url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	public void clickOn(WebElement element) {
		element.click();
	}
	
	public void enterText(By locator, String input) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(input);
	}
	
	public void enterSpecialKey(By locator, Keys KeyToEnter) {
		WebElement ele = driver.get().findElement(locator);
		ele.sendKeys(KeyToEnter);
	}
	
	public String getVisibleText(By locator) {
		WebElement ele = driver.get().findElement(locator);
		return ele.getText();
	}
	
	public String getVisibleText(WebElement ele) {
		return ele.getText();
	}
	
	public void clearText(By locator) {
		WebElement ele = getDriver().findElement(locator);
		ele.clear();
	}
	
	public List<String> getAllVisibleTexts(By locator) {
		List<WebElement> ele = driver.get().findElements(locator);
		logger.info("Elements found and now printing list of elements");
		List<String> visibleTextList = new ArrayList();
		for(WebElement e : ele) {
			 visibleTextList.add(getVisibleText(e));
		}
		
		return visibleTextList;
	}
	
	public List<WebElement> getAllElements(By locator) {
		List<WebElement> eleList = getDriver().findElements(locator);
		return eleList;
	}
	
	public void selectFromDropDown(By dropDownLocator, String textToSelect) {
		WebElement ele = getDriver().findElement(dropDownLocator);
		Select select = new Select(ele);
		logger.info("Selecting the option "+textToSelect);
		select.selectByVisibleText(textToSelect);
		
	}
	
	public void waitUntilElementIsLoaded(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
		
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot)driver.get(); 
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-MM-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/"+name+"-"+timeStamp+".png";
		try {
			FileUtils.copyFile(sourceFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;		
	}
	
}
