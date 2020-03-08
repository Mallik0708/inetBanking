package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig()
	{
	File src= new File("./ConfigurationFiles/config.properties");
	
	try {
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
	}
	catch(Exception e)
	{
		System.out.println("Exception Occured: "+e.getMessage());
	}
	}
	
	public String getApplicationURL()
	{
		String baseURL = prop.getProperty("loginURL");
		return baseURL;
	}
	
	public String getUserName()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
		
	}
	
	public String getSignUpURL()
	{
		String signUpURL = prop.getProperty("AccessRequestURL");
		return signUpURL;
		
	}
	
}

