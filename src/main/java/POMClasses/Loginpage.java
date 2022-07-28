package POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Utility;

public class Loginpage extends Utility{
	WebDriver driver;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailfield;

	@FindBy(xpath="//input[@class='_2IX_2- _3mctLh VJZDxU']")
	private WebElement passfield;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement loginfield;
	
	public Loginpage (WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
}
	public void enteremail(String id) throws IOException {
		emailfield.sendKeys(id);
	}
	public void enterpassword(String pass) throws IOException {
	passfield.sendKeys(pass);
	}
	public void btnlogin() {
		loginfield.click();
	
}
	
		
			
		
}