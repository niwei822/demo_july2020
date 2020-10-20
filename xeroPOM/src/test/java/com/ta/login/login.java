package com.ta.login;

import java.util.Arrays;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ta.xeroPOM.TestBase;
import com.ta.pologin.pologin;

public class login extends TestBase{

	
	
	pologin oLogin;
	
	@BeforeTest
	public void triggerDependency() {
		oLogin = new pologin(driver);
	}
	
	@Test
	public void logingIntoBrowserTWithTestData() throws Exception{
		Object[][] excelData = oLogin.getDataForLogin();

		for (int row = 0; row < excelData.length; row++) { 
			String sUserName = (String) excelData[row][0];
			String sPassword = (String) excelData[row][1];
			String sXpath = (String) excelData[row][2];
			oLogin.logingIntoBrowserTWithTestData(sUserName, sPassword, sXpath);
		}
		oLogin.logOut();
	}
	

	@Test
	public void loginToWebsite() throws Exception {
		oLogin.loginToWebSite1();
		oLogin.logOut();
	
	}
	
	@Test
	public void InvalidPassword() throws Exception {
		oLogin.loginToWebSite2();
		
		
	}
	@Test
	public void InvalidEmail() throws Exception {
		oLogin.loginToWebSite3();
		
	}
	@Test
	public void ForgotPassword() throws Exception {
		oLogin.ForgotPW();
		
	}

	
}

	
