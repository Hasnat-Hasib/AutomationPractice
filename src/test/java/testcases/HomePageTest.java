package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.HomePage;
import pageObject.IndexPage;
import pageObject.LoginPage;

public class HomePageTest extends Base {
		IndexPage indexPage;
		LoginPage loginPage;
		HomePage homePage;
	
	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void wishListTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage= indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    boolean result = homePage.validateMyWishList();
	    Assert.assertTrue(result);	   
	}
	
	@Test
	public void orderHistoryTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage= indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    boolean result = homePage.validateOrderHistory();
	    Assert.assertTrue(result);		
	}

}
