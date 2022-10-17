package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;

public class HomePage extends Base{
	
	//Action action= new Action();
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement wishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return Action.isDisplayed(getDriver(), wishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
