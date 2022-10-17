package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.HomePage;
import pageObject.IndexPage;
import pageObject.LoginPage;
import utility.Log;

public class LoginPageTest extends Base {
	
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
	public void loginTest() throws Throwable {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Log.info("Enter Username and Password");
	    homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}


}
