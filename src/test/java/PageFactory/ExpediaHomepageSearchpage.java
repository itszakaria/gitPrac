package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExpediaHomepageSearchpage {
	WebDriver driver;
	public static WebElement element;

	public ExpediaHomepageSearchpage(WebDriver driver) {
		this.driver = driver;
	}

	// flight tab WebElement
	public WebElement flightTab() {
		element = driver.findElement(By.xpath("//*[@id='tab-flight-tab']"));
		return element;
	}

	// Roundtrp WebElement
	public WebElement roundtripTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='flight-type-roundtrip-label']"));
		return element;
	}

	// one way WebElement
	public WebElement onewayTab(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#flight-type-one-way-label"));
		return element;
	}

	// multi way WebElement
	public WebElement multidestTab(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='flight-type-multi-dest-label']"));
		return element;
	}

	// originating airport WebElement
	public WebElement originCity(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='flight-origin']"));
		element.sendKeys("jfk");
		return element;
	}

	// destination airport WebElement, b ut we dint put value in this class,
	// will be provided we we call this meth_
	public WebElement destinationCity(WebDriver driver, String destination) {
		element = driver.findElement(By.xpath("//*[@id='flight-destination']"));
		element.sendKeys(destination);
		return element;
	}

	// Departing date WebElement
	public WebElement departingDate(WebDriver driver, String date) {
		element = driver.findElement(By.className("datepicker-trigger-input"));
		element.sendKeys(date);
		return element;
	}

	// adult WebElement
	public WebElement adultNo(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='flight-adults']"));
		return element;
	}

	// adult WebElement
	public WebElement kidsNo(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='flight-children']"));
		return element;
	}

	// Search button WebElement
	public WebElement searchButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='search-button']"));
		return element;
	}

}
