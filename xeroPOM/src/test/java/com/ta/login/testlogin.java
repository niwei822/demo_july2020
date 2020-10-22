package com.ta.login;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ta.pologin.pologin;
import com.ta.xeroPOM.TestBase;

@Listeners(com.ta.testNGlistener.testNGlistener.class)

public class testlogin extends TestBase{
	
	pologin oLogin;
	
	@BeforeTest
	public void triggerDependency() {
		oLogin = new pologin(driver);
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
