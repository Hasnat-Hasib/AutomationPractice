package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;

public class CartPage extends Base{
	
	@FindBy(id="quantity_wanted")
	 WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	WebElement addCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public void enterQuantity(String quantity1) throws Throwable {
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1) throws Throwable {
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		Action.click(getDriver(), addBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable {
		Action.fluentWait(getDriver(), addCartMessag, 10);
		return Action.isDisplayed(getDriver(), addCartMessag);
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
	

}
