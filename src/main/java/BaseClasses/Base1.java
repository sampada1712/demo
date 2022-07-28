package BaseClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import UtilityClasses.Utility;

public class Base1 {
	static WebDriver driver = null;
	static ExtentHtmlReporter extentReporter = null;
	static ExtentReports report = null;
	static ExtentTest test = null;
	public static WebDriver getDriver(String browser) throws IOException {
		System.out.println(driver);
		if(driver == null) {
		if(browser.equals("chrome")) {
		
			System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browsers\\chromedriver.exe");
		
			 driver = new ChromeDriver();
		
		}
		else if (browser.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
			driver.get("https://www.flipkart.com/");
			System.out.println("in else");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		}
		else {
			System.out.println("else");
			return driver;
		}
	}

	public static ExtentHtmlReporter getHtmlReporter() {
		if(extentReporter == null) {
			extentReporter = new ExtentHtmlReporter("ExtentReport.html");
			return extentReporter;
		}
		else {
		return extentReporter;
		}
	}
	
	public static ExtentTest getExtentTest(String testName) {
		test = report.createTest(testName);
		return test;
	}
	
	public static ExtentReports getReports() {
		if(report == null) {
			report = new ExtentReports();
			report.attachReporter(extentReporter);
		}
	return report;
	}
	


}
