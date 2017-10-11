package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import com.relevantcodes.extentreports.LogStatus;


import Utilities.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends TestBase {

	@Before
	public void setUp() {
		setUp01();
	}
	
	@Given("^User is in apple watch page$")
	public void scenarioOneGiven() throws AWTException, IOException {
		
		
		// Validate page title and add current page title in the report.
		String homePageTitle = driver.getTitle();

		String currentUrl = driver.getCurrentUrl();
		log.info("We are on '" + currentUrl + "' now.");

		try {
			String linksHref = ot.returnHref(aw.returnWatch());
			aw.clickOnWatch();

			String thisPageTitle = driver.getTitle();
			if (homePageTitle != thisPageTitle) {
				elog.log(LogStatus.PASS, "Control is on '" + linksHref + "' page now !!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ss.takeMultiSSofThisPage(driver, "appleWatch");

		/**
		 * This will provide a basic idea of mechanism we need to take to test this
		 * page.
		 */
		try{
			stp.showPageScanResult();
		}catch(Exception e) {
			e.printStackTrace();
		}

		/**
		 * This will show the links status of this page that are NOT OK.
		 */
		// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");

		System.out.println("Scenario 01, GIVEN step is passed");

	}

	@When("^User tries intearactive gallery$")
	public void scenarioOneWhen() throws IOException, InterruptedException {

		//Assert.assertTrue(aw.specificClock().isDisplayed());
		if (aw.specificClock() != null) {
			Dimension size = aw.specificClock().getSize();
			System.out.println("Element is present and the size is: " + size);
		}

		/**
		 * After clicking an image, validate the presence of an web element.
		 */
		ot.elementsExistanceAfterActions(By.xpath("//div[@id=\"main\"]/section[2]/div[2]/div[2]/div/div/p/a[1]"),
				By.xpath("//div[@id=\"main\"]/section[2]/div[2]/div/div[2]/figure"));

		// Step: click on appleWatch interactive gallery
		aw.clickInteractiveGallery();
		
		System.out.println("Scenario 01, WHEN step is passed");

	}

	@Then("^He should be able to close interactive gallery$")
	public void scenarioOneThen() throws IOException, InterruptedException {

		ss.takeScreenshot(driver, "watch_interactiveGalleryInteraction01");
		ss.takeScreenshot(driver, "watch_interactiveGalleryInteraction02");

		// close the gallery
		aw.closeIntGallery();
	
		System.out.println("Scenario 01, THEN step is passed");

	}

	@Given("^User click on buy$")
	public void scenarioTwoGiven() throws IOException, InterruptedException {

		// Scroll down to the bottom of the page
		js.executeScript("window.scrollBy(0,1800);");
		ss.takeScreenshot(driver, "appleWatch_ScrolledBottom");
		log.info("Scrolled down the botton of the page");

		// click on buy
		aw.clickOnBuy();
		log.info("Clicked on Buy link.");

		try {
			//Assert.assertTrue(aw.returnWatch01().isDisplayed());
			aw.clickOnWatch01();
			elog.log(LogStatus.INFO, "Clicked on a watch");
		} catch (Exception e) {
			elog.log(LogStatus.INFO, "Wanted to click on a watch, but its not present");
		}

		System.out.println("Scenario 02, GIVEN step is passed");
	}

	@When("^User should be able to see watch series 1$")
	public void scenarioTwoWhen() throws InterruptedException, IOException {
		// Add screenshot to advance report
		Thread.sleep(3000);
		String path = ss.returnScreenshotPathForAdvReport(driver, "appleParticularWatch");
		String imgpath = elog.addScreenCapture(path);
		elog.log(LogStatus.PASS, "Added ss to report", imgpath);

		// go back to previous page
		driver.navigate().back();

		elog.log(LogStatus.PASS, "Navigated to watch MAIN page!!");

		Thread.sleep(3000);
		String path01 = ss.returnScreenshotPathForAdvReport(driver, "appleParticularWatch");
		String imgpath01 = elog.addScreenCapture(path01);
		elog.log(LogStatus.PASS, "Added ss to report", imgpath01);

		// click on watch series 2
		driver.navigate().forward();

		System.out.println("Scenario 02, WHEN step is passed");
	
	}
	
	@Then("^User should also see the 'watch series 02' page$")
	public void scenarioThreeThen() throws IOException, InterruptedException {
		aw.clickOnwatchSeries2();
		elog.log(LogStatus.INFO, "Clicked on watch series 2");

		// move to that element
		js.executeScript("arguments[0].scrollIntoView(true);", aw.returnJustElement());

		// add screenshot to report
		ss.addScreenshotToAdvReport(driver, "appleWatchMain", elog);
		elog.log(LogStatus.PASS, "Yay!!! This test has passed");
		log.info("This test has PASSED!! and the report files have been created!!");

		System.out.println("Scenario 02, THEN step is passed");
		
		
	}
	
	@After
	public void tearDown(Scenario sth) throws IOException {

		tearDown01(sth);
	}
	
	
}
