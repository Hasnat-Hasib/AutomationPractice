package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.CartPage;
import pageObject.IndexPage;
import pageObject.SearchResult;

public class CartPageTest extends Base {
	IndexPage indexPage;
	SearchResult searchResult;
	CartPage cartPage;
	
	
	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	@Test
	public void addToCartTest() throws Throwable {
		indexPage = new IndexPage();
		searchResult = indexPage.searchProduct("t-shirt");
		cartPage = searchResult.clickOnProduct();
		cartPage.enterQuantity("2");
		cartPage.selectSize("M");
		cartPage.clickOnAddToCart();
		boolean result= cartPage.validateAddtoCart();
		
	}
	
}
