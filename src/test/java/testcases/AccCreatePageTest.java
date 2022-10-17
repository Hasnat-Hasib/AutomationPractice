package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.AccCreatePage;
import pageObject.HomePage;
import pageObject.IndexPage;
import pageObject.LoginPage;

public class AccCreatePageTest extends Base {
	IndexPage indexPage;
	LoginPage loginPage;
	AccCreatePage accCreationPage;
	

	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void verifyCreateAccPageTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		accCreationPage = loginPage.createNewAccount("jamil8nh@gmail.com");
		boolean result = accCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		
	}
	

}
