package com.walmart.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.walmart.ecommerce.tests.config.UIElements;

public class ProductDetailPage {

	private WebDriver driver = null;

	public ProductDetailPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addItemToCart() {
		driver.findElement(By.id(UIElements.ADD_TO_CART_BUTTON_ID)).click();
	}

	public void clickOnViewCart() {
		driver.findElement(By.id(UIElements.VIEW_CART_BUTTON_ID)).click();
	}

	public String getProductTitleFromPdp() {
		return driver.getTitle();
	}
}