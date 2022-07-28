package POMClasses;

import java.util.List;
import java.util.Set;

import javax.swing.Popup;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Utility;

public class Profilepage extends Utility{

	WebDriver driver;
	
	@FindBy(xpath="(//div[@class='_28p97w'])[1]")
	private WebElement  sampadaname;
	
	@FindBy(xpath="(//a[@class='_2kxeIr'])[1]")
	private WebElement profilename;
	
	@FindBy(xpath="//div[@class='NS64GK']")
	private WebElement manageadd;
	
	@FindBy(xpath="//div[@class='_1QhEVk']")
	private WebElement addresses;
	
	@FindBy(xpath="//a[@class='_3-PJz-']")
	private WebElement bcmseller;
	
	@FindBy (xpath="//div[@class='_1lRtwc _1Jqgld']/input")
	 private List<WebElement> entername;
	
	@FindBy (xpath="//textarea")
	private WebElement enteraddress;
	
	@FindBy(xpath= "//button[@class='_2KpZ6l _1KAjNd']")
	private WebElement popup;
	
	@FindBy (xpath="(//button[@type='button'])[1]")
	private WebElement savebtn;
	
	
	public Profilepage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	public void getprofilename() throws InterruptedException {
		
		WebElement profile = explicitclick(driver,"(//div[@class='_28p97w'])[1]");
		mouseaction(driver,sampadaname);
		
	}
	public void clickmyprofile() throws InterruptedException {
	//	Thread.sleep(2000);
		  profilename.click();
	}
	public void movetoseller() throws InterruptedException {
		  explicitclick(driver , "//a[@class='_3-PJz-']");
		 
		  mouseaction(driver,bcmseller);
	}
	 	public void manageaddclick() {
		manageadd.click();
	}
	public void addressesclick() {
		addresses.click();
	}
	public void filladdressdeatails() {
		
		String[] j = {"Sampada Wankhede","7028360339","442001","Wardha"};
		 for(int i=0; i<4; i++) {
			 entername.get(i).sendKeys(j[i]);
	}
	}
	public void addresshome() {
		
		enteraddress.sendKeys("Sai Nagar Near Hanuman Temple Wardha 442001");
	}
	public void popuppage() throws InterruptedException {
		
		popup.click();
	}
	
	
	public void clicksavebtn() throws InterruptedException {
		
		scroolact(driver , savebtn);
		Thread.sleep(2000);
		savebtn.click();
	}
	
	}

