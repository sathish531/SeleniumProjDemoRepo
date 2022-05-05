package stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LoadingPage;
import pageobject.LoginPage;
import resources.Base;

public class Login extends Base{
	
	public WebDriver driver;
	public LoginPage loginPage;
	@Given("^Open browser$")
    public void open_browser() throws IOException {
		driver = initializeDriver();
       
    }
	@And("^Navigate to login page$")
	public void navigate_to_login_page() throws InterruptedException{
		
		driver.get(prop.getProperty("url"));
		LoadingPage loadingPage = new LoadingPage(driver);
		loadingPage.myAccount().click();
		loadingPage.loginOption().click();
		Thread.sleep(3000);
	        
	}
    @When("^User entered username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_entered_username_as_something_and_password_as_something(String email, String pwd){
    	
    	loginPage = new LoginPage(driver);
		loginPage.emailAddress().sendKeys(email);
		loginPage.password().sendKeys(pwd);
		
    }
  
 
    @And("^User clicked on login option$")
    public void user_clicked_on_login_option(){
    	
    	loginPage.loginButton().click();
    	
    }
    @Then("^verify user is able to login$")
    public void verify_user_is_able_to_login() {
    	
    	AccountPage ap = new AccountPage(driver);
    	Assert.assertTrue(ap.accountInfo().isDisplayed());
       
    }
    @After
    public void closure() {
    	driver.close();
    	
    }
}
