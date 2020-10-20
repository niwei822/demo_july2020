package com.ta.xeroPOM;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtiltiy extends TestBase{

	
	public WebDriver launchBrowser(String sBrowserName) {
		
		switch (sBrowserName) {
		case "ch":
			//WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		default:
			break;
		}
		return driver;
	}
	
	public void explicitWaitFunc(WebElement ele, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}
	public void explicitWaitFunc(WebElement ele) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void printListOfWebElements(List<WebElement> liWebElements) {
		for(int count = 0; count<liWebElements.size();count++) {
			System.out.print(liWebElements.get(count).getText()+"\t");
		}
		System.out.println();
	}
	
	public void tearDownBrowser() {
		driver.quit();
	}
	
	public void ufClickElement(WebElement ele) {
		
		ele.click();
	}
	public void ufClearElement(WebElement ele) {
		ele.clear();
	}
	
	public void ufSenKeys(WebElement ele, String text) {
		ele.sendKeys(text);
	}
	public void ufgetText(WebElement ele) {
		System.out.println(ele.getText());
	}
	public void ufisDisplayed(WebElement ele) {
		System.out.println(ele.isDisplayed());
	}

	public void loginToWebSite() {
		// TODO Auto-generated method stub
		
	}
}