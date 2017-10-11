package Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
//import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;



import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import PageClassses.*;

import PageFactory.ExpediaHomepagePF;
import Utilities.SelectDriver;
import cucumber.api.Scenario;
import testCases.StepDefinition;

public class TestBase {
	public static WebDriver driver;
	public static SelectDriver sd;
	public static Screenshot ss;
	public static appleWatchPF aw;
	public static linksStatus ls;
	public static ScanThisPage stp;
	public static Others ot;
	public static String baseUrl;
	public static homePageFactory hpf;
	public static iPhonePagePF ippf;
	public static macLinkPageFactory mpf;
	public static macBookAirPageFacotory mapf;
	public static macBookProPF mbpf;
	public static supportPF spf;
	public static ExpediaHomepagePF epf;
	
	public static Logger log;
	public static JavascriptExecutor js;

	public static ExtentReports report;
	public static ExtentTest elog;

	
	public static void setUp01() {
		sd = new SelectDriver(driver);
		// driver = sd.invokeBrowser();
		driver = sd.selectMyDriver("chrome");

		epf = new ExpediaHomepagePF(driver);
		aw = new appleWatchPF(driver, elog);
		log = LogManager.getLogger(StepDefinition.class.getName());
		ss = new Screenshot();
		stp = new ScanThisPage(driver);
		ot = new Others(driver);
		js = (JavascriptExecutor) driver;

		report = ExtentFactory.getInstance("AppleWatchPage");
		elog = report.startTest("Apple watch Page Testing");

		// baseUrl = "https://www.expedia.com/";
		baseUrl = "http://www.apple.com/";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	
	/*@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult tResult) throws IOException {
		if (tResult.getStatus() == tResult.SUCCESS) {
			ot.writeResultToPropertiesFile(
				tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(), "Passed!!");
			// Screenshot.takeScreenshot(driver, "PackageClass_" +
			// tResult.getTestClass().getName() + "_MethodName_"+ tResult.getName() +
			// "_PASSED_");
			
		} else if (tResult.getStatus() == tResult.FAILURE) {
			ot.writeResultToPropertiesFile( tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Failed, See the screenshot!!");
			Screenshot.takeScreenshot(driver, tResult.getTestClass().getName() + "_MethodName_"
					+ tResult.getName() + "_FAILED_");
			ot.writeTestResult(tResult.getTestClass().getName() + "_Method_" + tResult.getName() + "_" + ot.getRandomName(3), ".txt", tResult.getTestClass().getName(), " - Failed, See the screenshot!!");
		}
	}*/
	
	
	public void tearDown01(Scenario scen) throws IOException {
			if (scen.isFailed()) {
			ot.writeResultToPropertiesFile( 
					scen.getName(), "Failed, See the screenshot!!");
			Screenshot.takeScreenshot(driver, scen.getName());
			ot.writeTestResult(scen.getName() + "_" + ot.getRandomName(3), ".txt", scen.getName(), " - Failed, See the screenshot!!");
		}else {
			ot.writeResultToPropertiesFile( 
					scen.getName(), "Passed!!.");
			}
		
		
		report.endTest(elog);
		report.flush();
	}
	
	
	

}
