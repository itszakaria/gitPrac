package WebDrivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
	WebDriver driver;
	
	public SelectDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver selectDriver(String browser){
		if(browser.equals("chr")){
			System.setProperty("webdriver.chrome.driver", "C://users//itszakaria_bd//downloads//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("ff")){
			System.setProperty("webdriver.gecko.driver", "C://users//itszakaria_bd//downloads//geckodriver//geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("edg")){
			System.setProperty("webdriver.edge.driver", "C:\\Users\\itszakaria_bd\\Downloads\\microsoftwebdriver.exe");
			driver = new EdgeDriver();
		}
		
		return driver;
	}
	
	

}
