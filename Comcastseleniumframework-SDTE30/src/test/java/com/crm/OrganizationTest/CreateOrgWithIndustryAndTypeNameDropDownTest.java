package com.crm.OrganizationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryAndTypeNameDropDownTest 
{
	 PropertyFileUtility pLib = new PropertyFileUtility();
	 ExcelFileUtility eLib = new ExcelFileUtility();
	 WebDriverUtility wLib = new WebDriverUtility();
	 JavaUtility jLib = new JavaUtility();
	
      @Test(dataProvider = "ReadFromOrgSheet")
      public void createOrgWithIdustryAndTypeNameDropDownTest(String organizationname, String industrytypename, String typedropdown) throws Throwable
      {
    	  String organizationname1 = organizationname+jLib.getRandomNumber();
    	  
    	  String BROWSER = pLib.readDataFromPropertyFile("Browser");
    	  String URL = pLib.readDataFromPropertyFile("Url");
    	  String USERNAME = pLib.readDataFromPropertyFile("Username");
    	  String PASSWORD = pLib.readDataFromPropertyFile("Password");
    	  
    	  WebDriverManager.chromedriver().setup();
    	  WebDriverManager.firefoxdriver().setup();
    	  WebDriver driver=null;
    	  if(BROWSER.equalsIgnoreCase("chrome"))
    	  {
    		  driver = new ChromeDriver();
    	  }
    	  else if(BROWSER.equalsIgnoreCase("firefox"))
    	  {
    		  driver = new FirefoxDriver();
    	  }
    	  else
    	  {
    		  System.out.println("invalid browser");
    	  }
    	  wLib.maximizeWindow(driver);
    	  wLib.waitForPageLoad(driver);
    	  driver.get(URL);
    	  
    	  LoginPage lp = new LoginPage(driver);
    	  lp.loginToApp(USERNAME, PASSWORD);
    	  Reporter.log("login successfull",true);
    	  
    	  HomePage hp = new HomePage(driver);
    	  hp.ClickOnOrgLnk();
    	  Reporter.log("click on organization",true);
    	  
    	  OrganizationsPage op = new OrganizationsPage(driver);
    	  op.clickOnCreateOrgImg();
    	  Reporter.log("create organization",true);
    	  
    	  CreateOrganizationPage cop = new CreateOrganizationPage(driver);
    	  cop.createNewOrg(organizationname1, industrytypename, typedropdown);
    	  Reporter.log("created organization",true);
    	  
    	  OrganizationInfoPage cip = new OrganizationInfoPage(driver);
    	  String actualheader = cip.OrgNameInfo();
    	  if(actualheader.contains(organizationname1))
    	  {
    		  System.out.println("passed");
    	  }
    	  else
    	  {
    		  System.out.println("failed");
    	  }
    	  
    	  hp.signOutOfApp(driver);
    	  Reporter.log("sinout successfull");
    	  
    	  driver.quit();
      }
      
      @DataProvider(name = "ReadFromOrgSheet")
      public Object[][] readData() throws Throwable
      {
    	  Object[][] data = eLib.readmultipleDataFromExcel("Organazition2");
    	  return data;
      }
      
}
