package com.walmart.ecommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.walmart.ecommerce.tests.config.UIElements;

public class ShoppingCartPage {

	private WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getItemCount() {
		String itemCountStr = driver.findElement(
				By.cssSelector(UIElements.CART_PAGE_VERIFY_TEXT_CSS_SELECTOR))
				.getText();

		return itemCountStr;
	}

	public String getProductTitleFromCart() {
		return driver.findElement(By.cssSelector(UIElements.CART_ITEM_TITLE_CSS_SELECTOR)).getAttribute("innerHTML");
	}

	public void removeItemsInCart() {
		driver.findElement(By.id("CartRemItemBtn")).click();
	}
}
