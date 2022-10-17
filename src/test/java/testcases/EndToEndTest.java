package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.AddPage;
import pageObject.CartPage;
import pageObject.IndexPage;
import pageObject.LoginPage;
import pageObject.OrderConfPage;
import pageObject.OrderPage;
import pageObject.OrderSummary;
import pageObject.PaymentPage;
import pageObject.SearchResult;
import pageObject.Shipping;

public class EndToEndTest extends Base {

	IndexPage indexPage;
	SearchResult searchResult;
	CartPage cartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddPage addPage;
	Shipping shipping;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfPage orderConfPage;
	
	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void endToEndTest () throws Throwable {
		indexPage = new IndexPage();
		searchResult = indexPage.searchProduct("t-shirt");
		cartPage = searchResult.clickOnProduct();
		cartPage.enterQuantity("2");
		cartPage.selectSize("M");
		cartPage.clickOnAddToCart();
		orderPage = cartPage.clickOnCheckOut();
		loginPage = orderPage.clickOnCheckOut();
		addPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shipping = addPage.clickOnCheckOut();
		shipping.checkTheTerms();
		paymentPage = shipping.clickOnProceedToCheckOut();
		orderSummary = paymentPage.clickOnPaymentMethod();
		orderConfPage = orderSummary.clickOnconfirmOrderBtn();
		String actualMess = orderConfPage.validateConfirmMessage();
		String expectedMess = "Your order on My Store is complete.";
		Assert.assertEquals(actualMess, expectedMess);
		
	}
	
	
	
}
