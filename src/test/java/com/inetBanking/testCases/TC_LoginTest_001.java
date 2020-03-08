package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends TestBase {

	//it contains only the test methods
	@Test(priority=1)
	public void loginTest()
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
			logger.info("Login Test is Passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login is Failed");
		}
	}
	
	@Test(priority=2)
	public void sampleTest() throws InterruptedException
	{
		test = extent.createTest("Sample Test");
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		//Assert.assertTrue(false);
		logger.info("sampleTest is Failed");
		
	}
	
	@Test(priority=3)
	public void sampleTest1()
	{
		test = extent.createTest("sample Test1");
		driver.get(loginURL);
		test.info("Login Page is Launched");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test is Passed");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login is Failed");
		}
		
	}
	
}
