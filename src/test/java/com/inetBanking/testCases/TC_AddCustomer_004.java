package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer_004 extends TestBase {

	
	@Test
	public void addNewCustomer() throws InterruptedException
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
		Thread.sleep(5000);
		
		AddCustomerPage acp = new AddCustomerPage(driver);
		acp.addNewCustomer();
		Thread.sleep(3000);
		acp.setCustomerName("Arjun");
		acp.selectGender("male");
		acp.setDateOfBirth("08", "09", "1996");
		acp.setAddress("1/125, Road No:2, Banjara Hills");
		acp.setCity("Hyderabad");
		acp.setState("Telangana");
		acp.enterPIN(500061);
		acp.enterMobileNumber("5421212454");
		String email = randomEmailString()+"gmail.com";
		acp.enterEmail(email);
		acp.setPassword("abcdeF");
		
	}
	
	public String randomEmailString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return generatedString;
	}
	
}
