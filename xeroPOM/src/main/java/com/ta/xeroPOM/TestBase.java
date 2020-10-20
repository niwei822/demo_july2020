package com.ta.xeroPOM;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(com.ta.testNGlistener.testNGlistener.class)

public class TestBase {
	public static BrowserUtiltiy oBroUtil = new BrowserUtiltiy();
	public WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	String sPath = System.getProperty("user.dir")+"/ExtentReport/samplereportBrowser.html";
	
	@BeforeSuite
	public void launchingTheBrowser() throws Exception{
		reports = new ExtentReports(sPath);
		driver = oBroUtil.launchBrowser("ch");
	}
	@AfterSuite
	public void closingTest() {
		oBroUtil.tearDownBrowser();
		reports.flush();
	}

}
