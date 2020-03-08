package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.SignUpPage;
import com.inetBanking.utilities.ExcelReading;

public class TC_CreateGuruAccounts_002 extends TestBase {

	
	@Test(dataProvider="AccountsInfo")
	public void createAccounts(String emailID) throws InterruptedException
	{
		test = extent.createTest("createAccounts");
		SignUpPage sup = new SignUpPage(driver);
		driver.get(signUpURL);
		sup.setEmailId(emailID);
		sup.clickSubmitButton();
		Thread.sleep(3000);
	
	}
	
	@DataProvider(name="AccountsInfo")
	public String[][] getData() throws IOException
	{
		String path="C:\\Users\\Mallik\\eclipse-workspace\\inetBanking\\src\\test\\java\\com\\"
				+ "inetBanking\\testData\\GuruDemoAccessData.xlsx";
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
