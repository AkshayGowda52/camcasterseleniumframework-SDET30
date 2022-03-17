package com.crm.ContactTest;

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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDataProviderTest 
{
	
	PropertyFileUtility pLib = new PropertyFileUtility();
    ExcelFileUtility eLib = new ExcelFileUtility();
    WebDriverUtility wLib = new WebDriverUtility();
    JavaUtility jLib = new JavaUtility();
    
    
	@Test(dataProvider = "contestdata")
	public void createContctWithDataProviderTest(String conlastname) throws Throwable
	{
	     
	     String BROWSER = pLib.readDataFromPropertyFile("Browser");
	     String URL = pLib.readDataFromPropertyFile("Url");
	    String USERNAME = pLib.readDataFromPropertyFile("Username");
	    String PASSWORD = pLib.readDataFromPropertyFile("Password");
	     
	     String conlastName = conlastname+jLib.getRandomNumber();
	     
	     WebDriverManager.chromedriver().setup();
	     WebDriverManager.firefoxdriver().setup();
	     WebDriver driver=null;
	     if(BROWSER.equalsIgnoreCase("chrome"))
	    	{
	    		driver=new ChromeDriver();
	    	}else if(BROWSER.equalsIgnoreCase("firefox"))
	    	{
	    		driver=new FirefoxDriver();
	    	}else
	    	{
	    		System.out.println("invlid browser");
	    	}
	     wLib.maximizeWindow(driver);
	     wLib.waitForPageLoad(driver);
	     driver.get(URL);
	     
	     LoginPage lp = new LoginPage(driver);
	     lp.loginToApp(USERNAME, PASSWORD);
	     
	     HomePage hp = new HomePage(driver);
	     hp.ClickOnContactLnk();
	     Reporter.log("login successfull",true);
	     
	     ContactPage cp = new ContactPage(driver);
	     cp.createNewCon();
	     Reporter.log("click contact ",true);
	     
	     CreateContactPage ccp= new CreateContactPage(driver);
	     ccp.clickOnContact(conlastName);
	     Reporter.log("contact created",true);
	     
	     ContactInfoPage cip = new ContactInfoPage(driver);
	     String actualheader = cip.conNameInfo();
	     
	     if(actualheader.contains(conlastName))  	 	 
	     {
	    	 System.out.println("passed");
	     }
	     else
	     {
	    	 System.out.println("failed");
	     }
	     
	     hp.signOutOfApp(driver);
	     
	     driver.quit();
	  
	}
	@DataProvider(name = "contestdata")
	public Object[][] getdata() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("Contacts1");
		return data;
	}
     
     
     
}
