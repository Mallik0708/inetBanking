package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// Find Elements by using @FindBy annotation
	
	@FindBy(name="uid")
	public WebElement enterUsername;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement enterPassword;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	public WebElement clickLoginBtn;
	
	@FindBy(xpath="//input[@name='btnReset']")
	public WebElement clickResetBtn;
	
	
	// Create Methods to perform action on Elements of that web page
	
	public void setUserName(String username)
	{
		enterUsername.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		enterPassword.sendKeys(password);
	}
	
	public void clickOnSubmitButton()
	{
		clickLoginBtn.click();
	}
	
	public void clickOnResetButton()
	{
		clickResetBtn.click();
	}
}
