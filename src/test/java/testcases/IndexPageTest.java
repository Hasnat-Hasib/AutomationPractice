package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.IndexPage;

public class IndexPageTest extends Base {
	private IndexPage indexPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifyLogo() throws Throwable {
		//Log.startTestCase("verifyLogo");
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		//Log.endTestCase("verifyLogo");
	}
	
	@Test
	public void verifyTitle() {
		//Log.startTestCase("verifyTitle");
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store");
		//Log.endTestCase("verifyTitle");
	}

	
	


}
