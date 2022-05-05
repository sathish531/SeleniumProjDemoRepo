package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	
	public WebDriver driver;
	@Test
	public void twoTest() throws IOException, InterruptedException {
		System.out.println("Two test");
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		Thread.sleep(5000);
		Assert.assertTrue(false);
	}
	@AfterMethod
	public void closure() throws InterruptedException {
		driver.close();
	}

}
