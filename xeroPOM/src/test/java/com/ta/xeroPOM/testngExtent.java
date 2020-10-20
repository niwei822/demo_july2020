package com.ta.xeroPOM;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class testngExtent extends TestBase{
	static int count=0;
	@Test(dataProvider = "loginUserDataDetails")
	public void logingIntoBrowserTWithTestData(String sUserName, String sPassword, String sXpath) throws Exception{
		count++;
		logger = reports.startTest("logingIntoBrowserWithTestData_"+count);
		oBroUtil.loginToWebSite();
		logger.log(LogStatus.INFO, "Login button clicked");
		//Thread.sleep(2000);
		oBroUtil.explicitWaitFunc(driver.findElement(By.xpath(sXpath.trim())));
		Assert.assertEquals(driver.findElement(By.xpath(sXpath.trim())).isDisplayed(), true);
		//logger.log(LogStatus.PASS, "Test case is passed");
		
		// taking screenshot using selenium - 
		TakesScreenshot ts = (TakesScreenshot) driver; //screenshot setup will be done
		File source = ts.getScreenshotAs(OutputType.FILE);//Takes the screenshot and saving it to surce object
		//source which we saved is not physically saved. but it is there in the object
		String sPathOFScreenshot = System.getProperty("user.dir")+"//screenshot/screnshot_"+"logingIntoBrowserWithTestData_"+count+".png";
		File dest = new File(sPathOFScreenshot);
		FileUtils.copyFile(source, dest);
		logger.log(LogStatus.INFO, "Test case is passed");
		logger.log(LogStatus.PASS, logger.addScreenCapture(sPathOFScreenshot));
		reports.endTest(logger);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	@DataProvider(name="loginUserDataDetails")
	public Object[][] getDataForLogin() throws Exception{
		/*return new Object[][] {{"admin123@gmail.com","admin12345","//button[contains(text(),'Login to Account')]"},
				{"admin12345@gmail.com","admin12345","//button[contains(text(),'Login to Account')]"},
				{"admin123@gmail.com","admin123","//a[contains(text(),'Home')]"}};*/
		return new Object[][] {{"admin123@gmail.com","admin123","//a[contains(text(),'Home')]"},
			{"admin123@gmail.com","admin123","//a[contains(text(),'Home')]"},
					{"admin123@gmail.com","admin123","//a[contains(text(),'Home')]"}};
		//return readExcelAndReturnObject(System.getProperty("user.dir")+"/resources/testData/TD_UserNameAndPassword.xls");
		//how to read ExcelFile -- On Reading Excel file you have to convert data to an multiDimensionalObject
				
	}
	
		
	
	public Object[][] readExcelAndReturnObject(String sFile) throws Exception{
		
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
		//td_userpass
		HSSFSheet myExcleSheet = myExcelBook.getSheet("td_userpass");
		HSSFRow row1 = myExcleSheet.getRow(0);
		System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
		//System.out.println(row1.getLastCellNum());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol = 0; countCol<iCountCol;countCol++) {
			
				HSSFRow tempRow=myExcleSheet.getRow(countRow);
				String sTemp;
				try {
				sTemp=tempRow.getCell(countCol).getStringCellValue();
				}catch(Exception a) {
					sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
				}
				excelData[countRow][countCol] = sTemp;
			}
			
		}
			
		return excelData;
	}
}
