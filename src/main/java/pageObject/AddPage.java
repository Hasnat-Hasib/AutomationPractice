package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;


public class AddPage extends Base {
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public Shipping clickOnCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOut);
		return new Shipping();
	}
	

}
