package POMClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Utility;

public class Homepage extends Utility{
   WebDriver driver;
	@FindBy(xpath="//div[text()='Sampada']")
	private WebElement profilefield;
	
	private WebElement  profilename;
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	private WebElement searchbox;

	@FindBy (xpath="//button[@type='submit']")
	private WebElement searchbtn;
	
	public Homepage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
	}
	
	public String getProfilename() throws InterruptedException  {
		
		Utility.explicitWait1(driver,"//div[text()='Sampada']");
		//Thread.sleep(2000);
		String pName= profilefield.getText();
		return pName;
	}

	
}
	
	

	


