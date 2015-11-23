package com.walmart.ecommerce;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.walmart.ecommerce.testdata.TestData;
import com.walmart.ecommerce.tests.config.UIElements;
import com.walmart.ecommerce.util.ElementUtils;

public class LoginPage {

	private WebDriver driver = null;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateSuccessfulLogin(String testuser, String testpasswd) {
		Assert.assertEquals(
				TestData.MANAGE_ACCOUNT_TITLE,
				driver.findElement(
						By.cssSelector(UIElements.ACCOUNT_PAGE_TITLE_TEXT_CSS))
						.getText().toLowerCase());
	}

	public void doLoginWithCredentials(String testuser, String testpasswd) {
		ElementUtils.sendKeys(driver, UIElements.LOGIN_USERNAME_ELEMENT_ID,
				TestData.testUser);
		ElementUtils.sendKeys(driver, UIElements.LOGIN_PASSWORD_ELEMENT_ID,
				TestData.testPasswd);
		driver.findElement(By.cssSelector(UIElements.SIGN_IN_CSS_SELECTOR))
				.click();
	}

}
