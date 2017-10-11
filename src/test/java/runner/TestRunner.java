package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		// features = {"src/test/java/features"} , 
		features = {"src/test/resources"} , 
		format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
		// glue = "steps")
		glue = "testCases")
public class TestRunner {

}
