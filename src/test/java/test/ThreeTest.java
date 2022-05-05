package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{
	public WebDriver driver;
	@Test
	public void threeTest() throws IOException {
		System.out.println(" this is statement is updated by Karan");
		System.out.println("ThreeTest");
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@AfterMethod
	public void closure() throws InterruptedException {
		
		driver.close();
	}

}
