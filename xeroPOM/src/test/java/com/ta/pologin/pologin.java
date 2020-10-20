package com.ta.pologin;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.ta.xeroPOM.TestBase;
public class pologin extends TestBase{

	//page objects/ web elements needs to be loaded
	// that is your constructor
	public pologin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']")
	WebElement ph_login;
	@FindBy(id="xl-form-email")
	WebElement ph_emailField;
	@FindBy(id="xl-form-password")
	WebElement ph_password;
	@FindBy(id="xl-form-submit")
	WebElement button_loginToAccount;
	@FindBy(xpath="//a[@name='navigation-menu/dashboard']")
	WebElement text_Dashboard;
	@FindBy(xpath="//li[contains(text(),'Your email or password is incorrect')]")
	WebElement text_loginfail;
	@FindBy(xpath="//a[contains(text(),'Forgot password?')]")
	WebElement link_forgotpw;
	@FindBy(id="Email")
	WebElement enter_email;
	@FindBy(id="submit-reset-password")
	WebElement submit_email;
	@FindBy(xpath="//div[@class='xui-text-secondary']")
	WebElement text_resetpw;
	@FindBy(xpath="//a[@class='btn btn-primary global-ceiling-bar-btn at-element-marker']")
	WebElement link_freetrial;
	
	static int count=0;

	public void logingIntoBrowserTWithTestData(String sUserName, String sPassword, String sXpath) throws Exception{
		count++;
		logger = reports.startTest("logingIntoBrowserWithTestData_"+count);
		loginToWebSite(sUserName, sPassword, sXpath);
		logger.log(LogStatus.INFO, "Login button clicked");
		explicitWaitFunc(driver.findElement(By.xpath(sXpath)));
		Assert.assertEquals(driver.findElement(By.xpath(sXpath)).isDisplayed(), true);
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		//source which we saved is not physically saved. but it is there in the object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+"logingIntoBrowserWithTestData_"+count+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.INFO, "Test case is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		reports.endTest(logger);
	}


	public Object[][] getDataForLogin() throws Exception{
		
		return readExcelAndReturnObject(System.getProperty("user.dir")+"/resources/testData/TD_UserNameAndPassword.xls");
		//how to read ExcelFile -- On Reading Excel file you have to convert data to an multiDimensionalObject
				
	}


	public Object[][] readExcelAndReturnObject(String sFile) throws Exception{
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
		HSSFSheet myExcelSheet = myExcelBook.getSheet("td_userpass");
		HSSFRow row1 = myExcelSheet.getRow(0);
		System.out.println(myExcelSheet.getPhysicalNumberOfRows());
		int iCountCol = row1.getLastCellNum();
		int iCountRow = myExcelSheet.getPhysicalNumberOfRows();
		Object[][] excelData = new Object[iCountRow][iCountCol];
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol=0;countCol<iCountCol;countCol++) {
				HSSFRow tempRow = myExcelSheet.getRow(countRow);
				//String sTemp=tempRow.getCell(countCol).getStringCellValue();
				//HSSFRow tempRow=myExcleSheet.getRow(countRow);
				String sTemp;
				try {
					sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception a) {
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
					}
					excelData[countRow][countCol] = sTemp;
						//excelData[countRow][countCol] = sTemp;
			}
		}
		return excelData;	
	}
	
	public void explicitWaitFunc(WebElement ele, int iTime) {
		WebDriverWait wait1 = new WebDriverWait(driver, iTime);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}
	public void explicitWaitFunc(WebElement ele) {
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.visibilityOf(ele));
	}		
	
	public void loginToWebSite(String sUserName , String sPassword, String sXpath) throws Exception{
		//driver.get("https://www.google.com");
		driver.get("https://www.xero.com/us/");
		
		driver.manage().window().maximize();
	
		
		oBroUtil.ufClickElement(ph_login);
		oBroUtil.explicitWaitFunc(ph_emailField);
		//ph_emailField.click();
		oBroUtil.ufClickElement(ph_emailField);
		//ph_emailField.clear();
		oBroUtil.ufClearElement(ph_emailField);
		oBroUtil.ufSenKeys(ph_emailField, sUserName);
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		oBroUtil.ufClearElement(ph_password);
		oBroUtil.ufSenKeys(ph_password, sPassword);
		oBroUtil.ufClickElement(button_loginToAccount);
		
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();//10 seconds
		//oBroUtil.ufgetText(text_loginfail);
		oBroUtil.ufisDisplayed(driver.findElement(By.xpath(sXpath)));
		//Assert.assertEquals(driver.findElement(By.xpath(sXpath)).isDisplayed(), true);
		
		/*explicitWaitFunc(driver.findElement(By.xpath("//a[contains(text(),'Home')]")), 10);
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();//10 seconds
*/	} 

	
	public void loginToWebSite1() throws Exception{
	
		driver.get("https://www.xero.com/us/");
		//ngwebdriver
		driver.manage().window().maximize();
		oBroUtil.ufClickElement(ph_login);
		oBroUtil.explicitWaitFunc(ph_emailField);
		//ph_emailField.click();
		oBroUtil.ufClickElement(ph_emailField);
		//ph_emailField.clear();
		oBroUtil.ufClearElement(ph_emailField);
		//ph_emailField.sendKeys("");
		oBroUtil.ufSenKeys(ph_emailField, "cecily.li.822@gmail.com");
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		oBroUtil.ufClearElement(ph_password);
		oBroUtil.ufSenKeys(ph_password, "cecilyli822");
		oBroUtil.ufClickElement(button_loginToAccount);
		
		//driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		

		
		oBroUtil.explicitWaitFunc(text_Dashboard, 10);
		//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();//10 seconds
		oBroUtil.ufClickElement(text_Dashboard);
	}
	public void logOut() throws Exception{
		   driver.findElement(By.xpath("//abbr[@class='xrh-avatar xrh-avatar-color-5']")).click();
		   driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		   Thread.sleep(5000);
	}
	
	public void loginToWebSite2() throws Exception{
		
		driver.get("https://www.xero.com/us/");
		//ngwebdriver
		driver.manage().window().maximize();
		oBroUtil.ufClickElement(ph_login);
		oBroUtil.explicitWaitFunc(ph_emailField);
		//ph_emailField.click();
		oBroUtil.ufClickElement(ph_emailField);
		//ph_emailField.clear();
		oBroUtil.ufClearElement(ph_emailField);
		//ph_emailField.sendKeys("");
		oBroUtil.ufSenKeys(ph_emailField, "cecily.li.822@gmail.com");
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		oBroUtil.ufClearElement(ph_password);
		oBroUtil.ufSenKeys(ph_password, "cecilyli823");
		oBroUtil.ufClickElement(button_loginToAccount);
		
		//driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		

		
		oBroUtil.explicitWaitFunc(text_loginfail, 10);
		//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();//10 seconds
		oBroUtil.ufgetText(text_loginfail);
		oBroUtil.ufisDisplayed(text_loginfail);
	}
public void loginToWebSite3() throws Exception{
		
		driver.get("https://www.xero.com/us/");
		//ngwebdriver
		driver.manage().window().maximize();
		oBroUtil.ufClickElement(ph_login);
		oBroUtil.explicitWaitFunc(ph_emailField);
		//ph_emailField.click();
		oBroUtil.ufClickElement(ph_emailField);
		//ph_emailField.clear();
		oBroUtil.ufClearElement(ph_emailField);
		//ph_emailField.sendKeys("");
		oBroUtil.ufSenKeys(ph_emailField, "cecily.li.823@gmail.com");
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		oBroUtil.ufClearElement(ph_password);
		oBroUtil.ufSenKeys(ph_password, "cecilyli822");
		oBroUtil.ufClickElement(button_loginToAccount);
		
		//driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		

		
		oBroUtil.explicitWaitFunc(text_loginfail, 10);
		//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();//10 seconds
		oBroUtil.ufgetText(text_loginfail);
		oBroUtil.ufisDisplayed(text_loginfail);
	}
public void ForgotPW() throws Exception{
	
	driver.get("https://www.xero.com/us/");
	//ngwebdriver
	driver.manage().window().maximize();
	oBroUtil.ufClickElement(ph_login);
	oBroUtil.explicitWaitFunc(link_forgotpw);
	//ph_emailField.click();
	oBroUtil.ufClickElement(link_forgotpw);
	//ph_emailField.clear();
	oBroUtil.ufClearElement(enter_email);
	//ph_emailField.sendKeys("");
	oBroUtil.ufSenKeys(enter_email, "cecily.li.822@gmail.com");
	//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
	 
	oBroUtil.ufClickElement(submit_email);
	
	//driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
	

	
	oBroUtil.explicitWaitFunc(text_resetpw, 10);
	//driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();//10 seconds
	oBroUtil.ufgetText(text_resetpw);
	oBroUtil.ufisDisplayed(text_resetpw);
}
}