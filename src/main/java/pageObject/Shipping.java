package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;

public class Shipping extends Base {
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public Shipping() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() throws Throwable {
		Action.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		Action.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

	

}
