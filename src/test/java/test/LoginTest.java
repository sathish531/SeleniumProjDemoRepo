package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.AccountPage;
import pageobject.LoadingPage;
import pageobject.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
	WebDriver driver;
	Logger log;
	
	@Test(dataProvider="getLoginData")
	public void loginTest(String email, String pwd, String expectedResult) throws IOException {
		
		LoadingPage loadingPage = new LoadingPage(driver);
		loadingPage.myAccount().click();
		log.debug("Clicked on my account option");
		loadingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddress().sendKeys(email);
		log.debug("Entered emailaddress");
		loginPage.password().sendKeys(pwd);
		log.debug("Entered password");
		loginPage.loginButton().click();
		log.debug("Clicked on login option");
		
		AccountPage ap = new AccountPage(driver);
		String actualResult = null;
		try {
			if(ap.accountInfo().isDisplayed()) {
				actualResult="Successful";
				log.debug("User got logged in");
			}
		}catch(Exception e) {
			actualResult="Failure";
			log.debug("User did not login");
		}
		
		Assert.assertEquals(actualResult, expectedResult);
		log.debug("Login test got passed");
	}
	@AfterMethod
	public void closure() {
		driver.quit();
		log.debug("Browser got closed");
		
	}
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data={ {"sathish12@gmail.com","12345","Successful"},{"dummy@gmail.com","1234","Failure"}};   
		return data;
	}
	@BeforeMethod
	public void setup() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got initialized");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

}
