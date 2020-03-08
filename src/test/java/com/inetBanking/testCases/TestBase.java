package com.inetBanking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBanking.utilities.ExcelReading;
import com.inetBanking.utilities.ReadConfig;
import com.inetBanking.utilities.Screenshots;

public class TestBase {

	ReadConfig readConfig = new ReadConfig();
	ExcelReading er = new ExcelReading();
	public static WebDriver driver;
	public static Logger logger;
	public String loginURL = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String signUpURL = readConfig.getSignUpURL();
	
	
	
	@BeforeSuite
	public void setUp()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/GuruTestAutomation.html");

		  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
		  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
		  htmlReporter.config().setTheme(Theme.STANDARD);
	
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		  
		  // Passing General information
		  extent.setSystemInfo("Host name", "localhost");
		  extent.setSystemInfo("Environment", "QA Regression");
		  extent.setSystemInfo("User Name", "Mallikarjuna"); 
		  
		
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getChromePath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.iedriver.driver", readConfig.getChromePath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		logger = Logger.getLogger("inetBanking");
		PropertyConfigurator.configure("log4j.properties");
	
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, "TEST CASE FAILED is " + result.getName()); // to add name in extent report
		   test.log(Status.FAIL, "TEST CASE FAILED is " + result.getThrowable()); // to add error/exception in extent report
		   String screenshotPath = Screenshots.getScreenshot(driver, result.getName());
		   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		  } else if (result.getStatus() == ITestResult.SKIP) {
		   test.log(Status.SKIP, "Test Case SKIPPED is " + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case PASSED is " + result.getName());
		  }
		 driver.quit();
	}
	
	@AfterSuite
	public void flushMethod()
	{
		extent.flush();
	}
	
	

	
}
