package com.ta.selenium.maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Seleniumday2login extends Browserutility{
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		launchBrowser("ch");
		loginToWebSite();
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("Home"))));
		//System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed());
		//WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//driver.findElement(By.id("name")).click();
		//driver.findElement(By.id("name")).se.ndKeys("teresa");
		//explicitWaitFunc(driver.findElement(By.xpath("//input[@value='male']")), 10);
		//WebDriverWait wait2 = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@value='male']"))));
		/*explicitWaitFunc(driver.findElement(By.xpath("//input[@value='male']")),5);
		System.out.println(driver.findElement(By.xpath("//input[@value='male']")).isSelected());
		explicitWaitFunc(driver.findElement(By.id("name")),5);
		driver.findElement(By.id("name")).click();
	    driver.findElement(By.id("name")).sendKeys("Niwei");
	    explicitWaitFunc(driver.findElement(By.id("lname")),5);
		driver.findElement(By.id("lname")).click();
	    driver.findElement(By.id("lname")).sendKeys("Li");
	    explicitWaitFunc(driver.findElement(By.id("postaladdress")),5);
		driver.findElement(By.id("postaladdress")).click();
	    driver.findElement(By.id("postaladdress")).sendKeys("123 Abc Street");
	    explicitWaitFunc(driver.findElement(By.id("personaladdress")),5);
		driver.findElement(By.id("personaladdress")).click();
	    driver.findElement(By.id("personaladdress")).sendKeys("456 Xyz Street");
	    explicitWaitFunc(driver.findElement(By.xpath("//input[@value='female']")),5);
		driver.findElement(By.xpath("//input[@value='female']")).click();
		explicitWaitFunc(driver.findElement(By.id("city")),5);
		driver.findElement(By.xpath("//option[@value='newdelhi']")).click();
		//explicitWaitFunc(driver.findElement(By.id("city")),5);
		driver.findElement(By.xpath("//option[@value='mba']")).click();
		driver.findElement(By.xpath("//select[@id='district']//option[contains(text(),'NEW DELHI')]")).click();
		driver.findElement(By.xpath("//option[contains(text(),'NALANDA')]")).click();
		driver.findElement(By.id("pincode")).click();
	    driver.findElement(By.id("pincode")).sendKeys("12345");
	    driver.findElement(By.id("emailid")).click();
	    driver.findElement(By.id("emailid")).sendKeys("abc@gmail.com");
	    explicitWaitFunc(driver.findElement(By.xpath("//button[@class='bootbutton']")),10);
	    driver.findElement(By.xpath("//button[@class='bootbutton']")).click();
	    
	    //driver.findElement(By.xpath( "/a[contains(text(),'Home'")).click();
	    explicitWaitFunc(driver.findElement(By.xpath("//button[contains(text(),'Intractions')]")),10);
	    driver.findElement(By.xpath("//button[contains(text(),'Intractions')]")).click();
	    explicitWaitFunc(driver.findElement(By.xpath("//a[contains(text(),'Tool Tip')]")),10);
	    driver.findElement(By.xpath("//a[contains(text(),'Tool Tip')]")).click();
	    
	    Actions ac = new Actions(driver);
	    WebElement element = driver.findElement(By.className("tooltipr"));
	    explicitWaitFunc(driver.findElement(By.className("tooltipr")),5);
		ac.moveToElement(element).build().perform();
		System.out.println(element.isDisplayed());
		WebElement toolTip = driver.findElement(By.className("tooltiptextr"));
		String tooltipText = toolTip.getText();	
        
        System.out.println(tooltipText);*/
		//System.out.println(driver.findElement(By.xpath("//input[@value=\"male\"]")).isEnabled());
		WebElement eleInteraction = driver.findElement(By.xpath("//button[contains(text(),'Intractions')]"));
		explicitWaitFunc(eleInteraction);
		eleInteraction.click();
		/*WebElement eleMouse = driver.findElement(By.xpath("//a[contains(text(),'Mouse Hover')]"));
		explicitWaitFunc(eleMouse);
		eleMouse.click();
		explicitWaitFunc(driver.findElement(By.xpath("//button[contains(text(),'mousehover')]")));
		Actions ac = new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'mousehover')]"))).build().perform();*/
		
		explicitWaitFunc(driver.findElement(By.xpath("//a[contains(text(),'Double Click')]")),60);
		driver.findElement(By.xpath("//a[contains(text(),'Double Click')]")).click();
		
		explicitWaitFunc(driver.findElement(By.xpath("//button[contains(text(),'Double Click')]")));
		/*driver.findElement(By.xpath("//button[contains(text(),'single Click')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'single Click')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'single Click')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'single Click')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'single Click')]")).click();
		System.out.println(driver.findElement(By.id("demo1")).getText());*/
		
		
		
		
		
		
		
	    	
	    
	    
		
		
	    
	    
		
	}

}
