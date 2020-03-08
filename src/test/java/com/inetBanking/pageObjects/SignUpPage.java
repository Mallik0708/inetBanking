package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

	
	public WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='emailid']")
	public WebElement enterEmailId;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	public WebElement submitButton;
	
	public void setEmailId(String emailID)
	{
		enterEmailId.sendKeys(emailID);
	}
	
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	
	
}
