package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelReading;

public class TC_LoginWithSetOfAccounts_003 extends TestBase {

	
	@Test(dataProvider="DifferentLoginTestData")
	public void loginTest(String username, String password)
	{  
		test = extent.createTest("Login Test");
		driver.get(loginURL);
		test.info("Application is Launched");
		logger.info("Login URL is entered");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username is Entered");
		lp.setPassword(password);
		logger.info("Password is Entered");
		lp.clickOnSubmitButton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			test.info("Account " +username+ " Login is Passed");
		}
		else
		{
			Assert.assertTrue(false);
			test.info("Account " +username+ " Login is Failed");
		}
	}
	
	@DataProvider(name="DifferentLoginTestData")
	public String[][] getData() throws IOException
	{
		String path="C:\\Users\\Mallik\\eclipse-workspace\\inetBanking\\src\\test\\java\\com\\"
				+ "inetBanking\\testData\\LoginTestData.xlsx";
		int rownum = ExcelReading.getRowCount(path, "Sheet1");
		int colcount = ExcelReading.getCellCount(path, "Sheet1", 1);
		
		String[][] data = new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				data[i-1][j]=ExcelReading.getCellData(path, "Sheet1", i, j);
			}
		}
		return data;
		
	}
	
	
}
