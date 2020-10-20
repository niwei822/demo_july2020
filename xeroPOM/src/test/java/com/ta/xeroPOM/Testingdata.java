package com.ta.xeroPOM;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testingdata extends BrowserUtiltiy{
	
@BeforeSuite
public void lstartingBrowser() {
			launchBrowser("ch");
		}
		/*
		 some websites are content oriented websites
		 
		 DataProviders
		 * */
@Test(dataProvider = "loginUserDataDetails")
public void logingIntoBrowserTWithTestData(String sUserName, String sPassword, String sXpath) throws Exception{
	loginToWebSite();
	explicitWaitFunc(driver.findElement(By.xpath(sXpath)));
	Assert.assertEquals(driver.findElement(By.xpath(sXpath)).isDisplayed(), true);
}

@DataProvider(name="loginUserDataDetails")
public Object[][] getDataForLogin() throws Exception{
	
	return readExcelAndReturnObject(System.getProperty("user.dir")+"/resources/testData/TD_UserNameAndPassword.xls");
	//how to read ExcelFile -- On Reading Excel file you have to convert data to an multiDimensionalObject
			
}

		@Test
		//public void testing() throws Exception {
			
			
		//}
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
		@AfterSuite
		public void closingTest() {
			tearDownBrowser();
		}
}
	
	


