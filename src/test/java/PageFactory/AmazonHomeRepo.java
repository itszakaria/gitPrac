package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomeRepo {

	WebDriver driver = null;
	
	public AmazonHomeRepo(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement searchBox() {
		WebElement searchBoxA = null;
		searchBoxA = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")); 
		// i left the "searchBoxA =" part, and it di not work, be careful
		return searchBoxA;

	}
	
	
	

}
