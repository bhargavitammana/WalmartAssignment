package com.walmart.ecommerce.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.walmart.ecommerce.Browser;
import com.walmart.ecommerce.LoginPage;
import com.walmart.ecommerce.ProductDetailPage;
import com.walmart.ecommerce.SearchResultsPage;
import com.walmart.ecommerce.ShoppingCartPage;
import com.walmart.ecommerce.testdata.TestData;

public class TestWalmart {

	private Browser browser;
	
	private ShoppingCartPage shoppingCartPage;

	@Before
	public void setUp() throws Exception {
		browser = new Browser("Chrome");
	}

	@Test
	public void testAddItemToCart() {
		browser.open("http://www.walmart.com/account/login");

		// Login with valid username and password
		LoginPage loginPage = browser.getLoginPage();
		loginPage.doLoginWithCredentials(TestData.testUser, TestData.testPasswd);

		// Verify Manage Account caption after login is successful
		loginPage.validateSuccessfulLogin(TestData.testUser, TestData.testPasswd);

		// Search for the item and click on Search button
		SearchResultsPage searchResultsPage = browser.getSearchResultsPage();
		searchResultsPage.generateSearchResults(TestData.searchTerm);

		String productTitleFromSearchResultPage = searchResultsPage.getProductTitleForFirstResult();

		//On Search Results page, click on the first result to open PDP
		searchResultsPage.clickResultsForPDP();

		// Click on Add to cart button to add item to cart
		ProductDetailPage productDetailPage = browser.getProductDetailPage();

		// Click on View cart button to move to cart
		productDetailPage.addItemToCart();
		productDetailPage.clickOnViewCart();

		shoppingCartPage = browser.getShoppingCartPage();

		// Verifying cart product Title with PDP product title
		verifyResults(
				shoppingCartPage.getProductTitleFromCart(),
				productTitleFromSearchResultPage,
				"Title for product from cart page is not matched with title from PDP,"
						+ " title from cartPage: "
						+ shoppingCartPage.getProductTitleFromCart()
						+ " title from SearchResults Page: " + productTitleFromSearchResultPage);

		verifyResults("1 item.", shoppingCartPage.getItemCount(),
				"Number of items in the shopping cart are not matched with the items added and current count in cart: " + shoppingCartPage.getItemCount() );
	}

	public void verifyResults(String expectedText, String actualText,
			String customMessage) {
		try {
			assertEquals(expectedText, actualText);
		} catch (Error e) {
			fail(customMessage);
		}
	}

	@After
	public void tearDown() throws Exception {
		shoppingCartPage.removeItemsInCart();
		browser.cleanUp();
	}
}
