package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadingPage {
	
	WebDriver driver;
	public LoadingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	public WebElement myAccount() {
		return myAccount;
	}
	
	public WebElement loginOption() {
		return loginOption;
	}

}
