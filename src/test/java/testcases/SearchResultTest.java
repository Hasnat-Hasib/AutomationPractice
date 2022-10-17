package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageObject.IndexPage;
import pageObject.LoginPage;
import pageObject.SearchResult;

public class SearchResultTest extends Base {
	
	IndexPage indexPage;
	SearchResult searchResult;
	
	@BeforeMethod
	public void setup() {
	launchApp();
	}
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void productAvailabilityTest() throws Throwable {
		indexPage = new IndexPage();
		searchResult = indexPage.searchProduct("t-shirt");
		boolean result = searchResult.isProductAvailable();
		Assert.assertTrue(result);
		
	}
	

}
