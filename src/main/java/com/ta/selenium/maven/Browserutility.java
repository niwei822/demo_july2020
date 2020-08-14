package com.ta.selenium.maven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserutility {
	public static WebDriver driver = null;
	
public static void launchBrowser(String sBrowserName) {
	
	switch (sBrowserName) {
	case "ch":
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		break;
		default:
			break;
		
	
	}
 }

 public static void explicitWaitFunc(WebElement ele, int iTime) {
	 WebDriverWait wait1 = new WebDriverWait(driver, iTime);
	 wait1.until(ExpectedConditions.visibilityOf(ele));
 }
 public static void explicitWaitFunc(WebElement ele) {
	 WebDriverWait wait1 = new WebDriverWait(driver, 10);
	 wait1.until(ExpectedConditions.visibilityOf(ele));
 }
 public static void loginToWebSite() throws Exception{
	    
		//driver.get("http://www.google.com");
		driver.get("https://qa-tekarch.firebaseapp.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		driver.findElement(By.id("email_field")).clear();
		driver.findElement(By.id("email_field")).click();
		driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("password_field")).clear();
		driver.findElement(By.id("password_field")).sendKeys("admin123");
		driver.findElement(By.xpath( "//button[contains(text(),'Login to Account')]")).click();
		explicitWaitFunc(driver.findElement(By.xpath("//a[contains(text(),'Home')]")),10);
		//explicitWaitFunc(driver.findElement(By.xpath("//input[@value='male']")),5);
		//System.out.println(driver.findElement(By.xpath("//input[@value='male']")).isSelected());
		

	 
	 
 }
 public static void printListOfWebElements(List<WebElement> liWebElements) throws Exception {
	 for (int i=0;i<liWebElements.size();i++) {
			System.out.print(liWebElements.get(i).getText()+"\t");
 }
	 System.out.println();
	 
}
}
