package com.ta.selenium.maven;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Seleniumday5switchto extends Browserutility {
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		loginToWebSite();
		/*WebElement eleTabSwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		explicitWaitFunc(eleTabSwitchTo);
		eleTabSwitchTo.click();
		WebElement eleButtonAlert = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
		explicitWaitFunc(eleButtonAlert);
		eleButtonAlert.click();
		
		WebElement eleWindowAlertOne = driver.findElement(By.xpath("(//button[contains(text(),'Window Alert')])[1]"));
		explicitWaitFunc(eleWindowAlertOne);
		eleWindowAlertOne.click();
		
		Thread.sleep(1000);
		
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		al.accept(); // To click OK we say accept(). qTo click cancel We say dismiss()
		
		
		/*Thread.sleep(5000);
		WebElement eleWindowAlertTwo = driver.findElement(By.xpath("(//button[contains(text(),'Window Alert')])[2]"));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", eleWindowAlertTwo);
		
		Thread.sleep(5000);
		eleWindowAlertTwo.click();
		System.out.println(al.getText());
		al.accept();*/
		
	}
		
		
		}
		
		
	}


