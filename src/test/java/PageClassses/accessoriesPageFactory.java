package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class accessoriesPageFactory {
	WebDriver driver;
	ExtentTest test;

	public accessoriesPageFactory(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
}
