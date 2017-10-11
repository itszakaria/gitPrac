package Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance(String testName) {
		ExtentReports extent;
		String path = "C:\\Users\\itszakaria_bd\\workspace\\appleWebTest_BDD\\src\\test\\documentation\\" + testName + ".html";
		extent = new ExtentReports(path, false);
		
		extent 
			.addSystemInfo("Selenium Version", "3.4.0")
			.addSystemInfo("Platrm", "WINDOWS");
 
		return extent;
	}
}
