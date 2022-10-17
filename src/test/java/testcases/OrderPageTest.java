package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.CartPage;
import pageObject.IndexPage;
import pageObject.OrderPage;
import pageObject.SearchResult;

public class OrderPageTest extends Base{
	
	IndexPage indexPage;
	SearchResult searchResult;
	CartPage cartPage;
	OrderPage orderPage;
	
	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyTotalPrice() throws Throwable {
		indexPage = new IndexPage();
		searchResult = indexPage.searchProduct("t-shirt");
		cartPage = searchResult.clickOnProduct();
		cartPage.enterQuantity("2");
		cartPage.selectSize("M");
		cartPage.clickOnAddToCart();
		orderPage = cartPage.clickOnCheckOut();
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPriceDouble = (unitPrice*2) + 2;
		Assert.assertEquals(totalPrice, totalExpectedPriceDouble);
		
	}
	
	

}
