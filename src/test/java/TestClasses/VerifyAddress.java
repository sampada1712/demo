package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.Base1;
import POMClasses.Homepage;
import POMClasses.Loginpage;
import POMClasses.Profilepage;

import UtilityClasses.Utility;

public class VerifyAddress {

	static WebDriver driver;
	Homepage hp;
	Loginpage lp;
	Profilepage pf;
	
	
	@BeforeClass
	public void beforeclass() throws IOException {
		
		driver = Base1.getDriver("chrome");
	}
	@BeforeMethod
	public void beforemethod() {
		hp = new Homepage(driver);
	    pf = new Profilepage(driver);
	    lp = new Loginpage(driver);
	}
 
	@Test(priority=0)
	public void verifyuserprofilepage() throws InterruptedException  {
		pf.getprofilename();
		pf.clickmyprofile();
		pf.movetoseller();
		}
	@Test(priority=1)
	public void verifyaddresses() throws InterruptedException {
	
		pf.manageaddclick();
		pf.addressesclick();
		pf.filladdressdeatails();
		pf.addresshome();
		//pf.popuppage();
		pf.clicksavebtn();
		
		
	}
	


}
