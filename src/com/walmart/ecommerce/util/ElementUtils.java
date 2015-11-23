package com.walmart.ecommerce.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementUtils {

	/**
	 * Method created to manage the text elements
	 * @param driver
	 * @param uiElement
	 * @param inputData
	 */
	public static void sendKeys(WebDriver driver, String uiElement, String inputData) {
		driver.findElement(By.id(uiElement)).clear();
		driver.findElement(By.id(uiElement)).sendKeys(inputData);
	}

}
