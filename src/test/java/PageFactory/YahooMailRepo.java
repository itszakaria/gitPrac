package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YahooMailRepo {
	WebDriver driver;
	WebElement element;
	
	public YahooMailRepo (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this); // i missed this statement
	}
	
	
	// to return the userName
	public WebElement userName(){
		element = driver.findElement(By.xpath("//*[@id='login-username']"));
		return element;
		
	}
	
	// return next 
	public WebElement next(){
		element = driver.findElement(By.xpath("//*[@id='login-signin']"));
		return element;
		
	}
	
	
	// to retuen the password
	@FindBy(id="login-passwd")
	WebElement password;
	
	public WebElement password(){
		return password;
	}
	
	// to click sign in button
	public WebElement signIN(){
		element = driver.findElement(By.xpath("//*[@id='login-signin']"));
		return element;
		
	}
	
	// to return the compose 
	@FindBy(className="icon-text")
	WebElement compose;
	
	public WebElement compose(){
		return compose;
	}
	
	// to return send to button
	
	public WebElement sendTo(){
		//element = driver.findElement(By.xpath("//*[@id='yui_3_16_0_ym19_1_1483894498781_2221']"));
		element = driver.findElement(By.xpath("//*[@id='to-field']"));
		return element;
		
	}
	
	// to return subject 
	@FindBy(id="subject-field")
	WebElement subject;
	
	public WebElement subject(){
		return subject;
	}
	
	// to return body
	public WebElement body(){
		element = driver.findElement(By.xpath("//*[@id='rtetext']"));
		return element;
		
	}
	
	
	// to return attach filed
	@FindBy(xpath="//*[@id='attach-btn-menu']")
	WebElement attach;
	
	public WebElement attach(){
		return attach;
	}
	
	// to return send button

	@FindBy(xpath="//*[@id='yui_3_16_0_ym19_1_1483898122281_2520']")
	WebElement send;
	
	public WebElement send(){
		return attach;
	}
}
