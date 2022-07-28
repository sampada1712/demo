package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.Base1;
import POMClasses.Homepage;
import POMClasses.Loginpage;
import POMClasses.Profilepage;
import UtilityClasses.Utility;

public class VerifyLogin extends Utility {
	static WebDriver driver;
	Loginpage lp;
	Homepage hp;
	Profilepage pf;
	ExtentHtmlReporter ExtentReporter;
	ExtentReports Report;
	ExtentTest test;
	
	@BeforeClass
	public void beforeclass() throws IOException {
	
	ExtentReporter = Base1.getHtmlReporter();
	
	Report = new ExtentReports();
	
	test = Report.createTest("VerifyLogin");
	driver =Base1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforemethod() {
		
		lp= new Loginpage(driver);
		 
		pf = new Profilepage(driver);
		hp = new Homepage(driver);
	}
	
	@Test(priority=0)
	
		public void  verifylogin() throws IOException, InterruptedException {
			lp.enteremail(getproperty("username"));
			lp.enterpassword(getproperty("password"));
			lp.btnlogin();
			
			Assert.assertEquals(hp.getProfilename() , "Sampada"); 
			
		
//		Homepage hp = new Homepage(driver);
//		//hp.getProfilename();
//		Assert.assertTrue(hp.getProfilename());
}
	

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+ "test passed");
			
		}
		else {
			String path = screenshot(driver,result.getName());
			test.log(Status.FAIL, result.getName()+"test failed",  MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
	
	
	}
	
	
	
	
	@AfterClass
	public void afterClass()
	{
		Report.flush();
	}


}
