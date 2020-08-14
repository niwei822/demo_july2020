package com.ta.selenium.maven;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Seleniumday4widget extends Browserutility {
	public static void main(String[] args) throws Exception {
		launchBrowser("ch");
		loginToWebSite();
		WebElement widget = driver.findElement(By.xpath("//button[contains(text(),'Widget')]"));
		explicitWaitFunc(widget);
		widget.click();
		/*WebElement eletable = driver.findElement(By.xpath("//a[contains(text(),'Table')]"));
		explicitWaitFunc(eletable);
		eletable.click();
		WebElement eletableheader = driver.findElement(By.xpath("//p[contains(text(),'Table')]"));
		explicitWaitFunc(eletableheader);
		eletableheader.click();
		List<WebElement> lfirstcolumn = driver.findElements(By.xpath("//tr/td[1]"));
		printListOfWebElements(lfirstcolumn);
		List<WebElement> lsecondcolumn = driver.findElements(By.xpath("//tr/td[2]"));
		printListOfWebElements(lsecondcolumn);
		List<WebElement> lthirdcolum = driver.findElements(By.xpath("//tr/td[3]"));
		printListOfWebElements(lthirdcolum);
		List<WebElement> lfourthcolumn = driver.findElements(By.xpath("//tr/td[4]"));
		printListOfWebElements(lfourthcolumn);
		List<WebElement> lheader = driver.findElements(By.xpath("//tr/th"));
		printListOfWebElements(lheader);*/
		
		
		}
		
		
	}


