package UtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

		public static boolean explicitWait1(WebDriver driver, String xpath)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			boolean	element1 = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			return element1;
		}
	
		public static String getproperty(String key) throws IOException {
			FileInputStream file = new FileInputStream("configuration\\config.properties");
			Properties p = new Properties();
			p.load(file);
			
			String b =	p.getProperty(key);
			return  b;
		}

		public static WebElement explicitclick(WebDriver driver, String xpath) {
			  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			  WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			  return element1;
		}
		public static void mouseaction(WebDriver driver,WebElement element) {
			  Actions act = new Actions(driver);
			  act.moveToElement(element).perform();
		}
		 
		public static Boolean explicitWait(WebDriver driver, WebElement xpath)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
			boolean newElement = wait.until(ExpectedConditions.invisibilityOf(xpath));
			return newElement;
		}
		public static void scroolact(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
		
		public static String screenshot(WebDriver driver, String sname) throws IOException {
		  TakesScreenshot ss = (TakesScreenshot)driver;
				File source = ss.getScreenshotAs(OutputType.FILE);
				
				String  shot = "C:\\Automation notes\\selenium\\Screenshot\\"+sname+".jpg";
				File dest = new File (shot);
				FileHandler.copy(source, dest);
				
				return shot;
}
}