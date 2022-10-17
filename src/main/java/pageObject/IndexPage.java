package pageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;


public class IndexPage extends Base {
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement logo;
	
	@FindBy(id="search_query_top")
	private WebElement searchBox;
	
	@FindBy(name="submit_search")
	private WebElement searchBtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
//		action.fluentWait(getDriver(), signBtn, 10);
//		action.click(getDriver(), signBtn);
//		return new LoginPage();
		
		Action.click(getDriver(), signBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws Throwable {
		return Action.isDisplayed(getDriver(), logo);
	}
	
	public String getMyStoreTitle() {
		String storeTitel=getDriver().getTitle();
		return storeTitel;
	}
	
	public SearchResult searchProduct(String productName) throws Throwable {
		Action.type(searchBox, productName);
		//action.scrollByVisibilityOfElement(getDriver(), searchBtn);
		Action.click(getDriver(), searchBtn);
		//Thread.sleep(3000);
		return new SearchResult();
	}
}
