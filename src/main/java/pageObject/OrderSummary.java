package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;

public class OrderSummary extends Base {
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}

	public OrderConfPage clickOnconfirmOrderBtn() throws Throwable {
		Action.click(driver, confirmOrderBtn);
		return new OrderConfPage();
	}
	

}
