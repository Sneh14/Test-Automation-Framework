package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By ALL_SEARCH_RESULTS_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	private static final By MORE_BUTTON_LOCATOR = By.xpath("//p[contains(text(),'Printed chiffon')]//following-sibling::div//a[@title='View']");
	 
	
	public String searchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchedProductPresentInProductList(String searchTerm) {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productList  = getAllVisibleTexts(ALL_SEARCH_RESULTS_LOCATOR);
		boolean result = productList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	public ProductDetailPage clickOnProductAt(int index) {
		clickOn(getAllElements(ALL_SEARCH_RESULTS_LOCATOR).get(index));
		return new ProductDetailPage(getDriver());
	}
}
