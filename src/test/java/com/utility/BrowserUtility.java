package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

import com.constants.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
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
	
	public void enterText(By locator, String input) {
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(input);
	}
	
	public String getVisibleText(By locator) {
		WebElement ele = driver.get().findElement(locator);
		return ele.getText();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot)driver.get(); 
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-MM-ss");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir")+"//screenshots//"+name+"-"+timeStamp+".png";
		try {
			FileUtils.copyFile(sourceFile, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;		
	}
	
}
