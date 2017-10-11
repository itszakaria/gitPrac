package testCases;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
// import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		// dryRun=true,
		monochrome = true, 
		features = "src/test/resources", 
		glue = {"testCases"} 
		)

public class AppleWatchPage {

}

