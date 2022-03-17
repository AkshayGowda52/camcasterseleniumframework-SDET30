package com.cem.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
    // Create Object of All utilities
	public DatabaseUtility dbLib = new DatabaseUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void connectDataBase() throws Throwable
	{
		dbLib.connectToDB();
		Reporter.log("=====db connection successful====",true);
	}
	
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	//@Parameters("Browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable
	{
		 //read data from property
		String BROWSER = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("Url");
		
		//Create run time polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		sdriver = driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("========browser launch successful===",true);
	
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("Username");
		String PASSWORD = pLib.readDataFromPropertyFile("Password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("======login successful====",true);
	
	}
	
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("====logout successfull====",true);
	}
	
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	//@AfterTest
	public void closeBrowser()
	{
		driver.quit();
		Reporter.log("======browser close successful===",true);
	}
	
	@AfterSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void closeDb() throws Throwable
	{
		dbLib.closeDB();
		Reporter.log("====Database close successful===",true);
	}
}
