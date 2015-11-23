package com.walmart.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.walmart.ecommerce.testdata.TestData;
import com.walmart.ecommerce.tests.config.UIElements;
import com.walmart.ecommerce.util.ElementUtils;

public class SearchResultsPage {

	private WebDriver driver = null;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void generateSearchResults(String searchterm) {
		ElementUtils.sendKeys(driver, UIElements.SEARCH_TEXT_INPUT_ID, TestData.searchTerm);
		driver.findElement(By.cssSelector(UIElements.SEARCH_SUBMIT_CSS_SELECTOR)).click();
	}

	public void clickResultsForPDP() {
		driver.findElement(By.cssSelector(UIElements.SEARCH_RESULTS_TILE_TITLE_ID)).click();		
	}

	public String getProductTitleForFirstResult() {
		return driver.findElement(By.cssSelector(UIElements.SEARCH_RESULTS_TILE_TITLE_ID)).getText();
	}

}
