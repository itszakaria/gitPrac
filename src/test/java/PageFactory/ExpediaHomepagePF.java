package PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaHomepagePF {
	WebDriver driver;

	public ExpediaHomepagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath= "//*[@id='tab-flight-tab']")
	WebElement flightTab01;
	
	@FindBy(xpath= "//*[@id='flight-type-roundtrip-label']")
	WebElement roundTrip;
	
	@FindBy(xpath="//*[@id='flight-origin']")
	WebElement originCity;
	
	@FindBy(xpath="//*[@id='flight-destination']")
	WebElement destCity;
	
	// flight tab WebElement
	public WebElement flightTab() {
		return flightTab01;
	}

	// Roundtrp WebElement
	public WebElement roundTrip(){
		return roundTrip;
	}


	// originating airport WebElement
	public WebElement originCity(){
	return originCity;
	}
	

	// destination airport WebElement, b ut we dint put value in this class,
	// will be provided we we call this meth_
	public WebElement destCity(){
		return destCity;
	}

	// Departing date WebElement
	@FindBy(id="flight-departing")
	WebElement startDate;
	
	public WebElement startDate(){
		return startDate;
	}
	
	public WebElement fillStartDate(){
		WebElement datepick = driver.findElement(By.xpath(".//*[@id='flight-departing-wrapper']/div/div/div[3]/table/tbody/tr[2]/td[2]/button"));
		return datepick;
		}
	
				// for another way
				public WebElement fillStartDate2() {
					WebElement datepick = null;
					datepick = driver.findElement(By.xpath(".//*[@id='flight-departing-wrapper']/div/div/div[3]/table"));
					int dateSize = datepick.findElements(By.tagName("td")).size();
			
					for (int i = 0; i < dateSize; i++) {
						String dateValue = datepick.findElements(By.tagName("button")).get(i).getText();
						// System.out.println(dateValue);
						if (dateValue.contains("10")) {
							datepick.findElements(By.tagName("button")).get(i).click();
							break;
						}
					}
					return datepick;
				}
				
	// Ending date WebElement
	@FindBy(xpath=".//*[@id='flight-returning']")
	WebElement returnDate;
	
	public WebElement returnDate(){
		return returnDate;
	}
	
	

	// adult passenger WebElement
	@FindBy(xpath="//*[@id='flight-adults']")
	WebElement adultPassenger;
	
	public WebElement adultPassenger(){
		return adultPassenger;
	}
	
	// child passenger WebElement
	

	// Search button WebElement
	@FindBy(xpath="//*[@id='search-button']")
	WebElement searchButon;
	
	public WebElement search(){
		return searchButon;
	}
	
	public void clickSearch(){
		search().click();
	}
	
	
	// to return the account button
	
	@FindBy(xpath="//*[@id='header-account-menu']")
	WebElement signIn;
	
	public WebElement signIn(){
		return signIn;
	}
	
	
	// to return sign in field
	public WebElement signIn2(){
		WebElement element = driver.findElement(By.xpath("//*[@id='header-account-signin-button']"));
		return element;
	}
	
	
	// to return email field
		public WebElement emailId(){
			WebElement element = driver.findElement(By.xpath("//*[@id='signin-loginid']"));
			return element;
		}
		
		// to return email field
				public WebElement password(){
					WebElement element = driver.findElement(By.xpath("//*[@id='signin-password']"));
					return element;
				}
				
//return signIn button INSIDE the signIN page
		public WebElement signIn3(){
			WebElement element = driver.findElement(By.xpath("//button[@id='submitButton']"));
			return element;
		}
				
	
	
}
