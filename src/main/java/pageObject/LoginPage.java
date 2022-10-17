package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionDriver.Action;
import base.Base;


public class LoginPage extends Base {
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signBtn;
	
	@FindBy(name="email_create")
	private WebElement emailNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddPage login1(String uname, String pswd) throws Throwable {
		//Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signBtn);
		//Thread.sleep(2000);
		return  new AddPage();
		
	}
	
	
	public HomePage login(String uname, String pswd) throws Throwable {
		//Action.scrollByVisibilityOfElement(driver, userName);
		Action.type(userName, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), signBtn);
		//Thread.sleep(2000);
		return new HomePage();
		
	}
	
	public AccCreatePage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountBtn);
		return new AccCreatePage();
	}
	
	
	
	

}
