package com.walmart.ecommerce;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {

	private WebDriver driver = null;
		
	public Browser(String browser) {
		if ("chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", "/Users/bhargavi/Desktop/jarfiles/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--test-type");
			options.addArguments("chrome.switches", "--disable-extensions");
			driver = new ChromeDriver(options);
		} else {
		    driver = new SafariDriver();
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void cleanUp() {
		driver.quit();
	}

	public LoginPage getLoginPage() {
		return new LoginPage(driver);
	}

	public SearchResultsPage getSearchResultsPage() {
		return new SearchResultsPage(driver);
	}

	public ProductDetailPage getProductDetailPage() {
		return new ProductDetailPage(driver);
	}

	public ShoppingCartPage getShoppingCartPage() {
		return new ShoppingCartPage(driver);
	}

	public void open(String url) {
		driver.get(url);
	}
}