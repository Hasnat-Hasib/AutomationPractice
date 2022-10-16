package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.HomePage;
import pageObject.IndexPage;
import pageObject.LoginPage;

public class HomepPageTest extends Base {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test 
	public void wishListTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	
	@Test
	public void orderHistoryandDetailsTest() throws Throwable {
		
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
		
	}
	

}
