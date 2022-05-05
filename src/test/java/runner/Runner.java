package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/feature",
		glue="stepdefinitions"
		)
public class Runner extends AbstractTestNGCucumberTests {

}
