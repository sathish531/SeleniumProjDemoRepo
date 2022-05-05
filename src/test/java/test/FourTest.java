package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{
	
	public WebDriver driver;
		@Test
	public void fourTest() throws IOException {
		System.out.println("Foure Test");
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void closure() throws InterruptedException {
		
		driver.close();
	}
}
