package com.ta.selenium.maven;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumSwitchtoTab extends Browserutility {
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		loginToWebSite();
		WebElement eleTabSwitchTo = driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"));
		explicitWaitFunc(eleTabSwitchTo);
		eleTabSwitchTo.click();
		WebElement eleTabs = driver.findElement(By.xpath("//a[contains(text(),'Tabs')]"));
		explicitWaitFunc(eleTabs);
		eleTabs.click();
		
		WebElement eleButton1 = driver.findElement(By.xpath("//button[contains(text(),'London')]"));
		explicitWaitFunc(eleButton1);
		eleButton1.click();
		
		Thread.sleep(1000); ////*[@id="London"]/h3
		ArrayList<String> Tabs = new ArrayList(driver.getWindowHandles());
		System.out.println(Tabs.size());
		
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"London\"]/h3")).getText());
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"London\"]/p")).getText());
		Thread.sleep(1000);

		WebElement eleButton2 = driver.findElement(By.xpath("//button[contains(text(),'Paris')]"));
		explicitWaitFunc(eleButton2);
		eleButton2.click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Paris\"]/h3")).getText());
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Paris\"]/p")).getText());
		Thread.sleep(1000);
		WebElement eleButton3 = driver.findElement(By.xpath("//button[contains(text(),'Tokyo')]"));
		explicitWaitFunc(eleButton3);
		eleButton3.click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Tokyo\"]/h3")).getText());
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//*[@id=\"Tokyo\"]/p")).getText());
		Thread.sleep(1000);
		
		
	}
		
		
		}
		
		
	


