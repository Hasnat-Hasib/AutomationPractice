package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;

public class SearchResult extends Base {
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;
	
	public SearchResult() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() throws Throwable {
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public CartPage clickOnProduct() throws Throwable {
		Action.click(getDriver(), productResult);
		return new CartPage();
	}
	

}
