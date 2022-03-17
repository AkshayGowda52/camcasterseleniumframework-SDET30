package com.crm.ContactTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactUsingQuickCreate1Test 
{

    @Test
    public void createcontactusingquickcreatetest() throws Throwable
    {
    	//Step 1:create object all the generic file
    	PropertyFileUtility pLib = new PropertyFileUtility();
    	ExcelFileUtility eLib = new ExcelFileUtility();
    	JavaUtility jLib = new JavaUtility();
    	WebDriverUtility wLib = new WebDriverUtility();
    	 
    	int random = jLib.getRandomNumber();

    	/*Step 1: read all data*/
    	//read data from property file
    	String BROWSER = pLib.readDataFromPropertyFile("Browser");
    	String URL = pLib.readDataFromPropertyFile("Url");
    	String USERNAME = pLib.readDataFromPropertyFile("Username");
    	String PASSWORD= pLib.readDataFromPropertyFile("Password");
    	
    	//read data from excel
    	String contactname = eLib.readDtaFromExcel("Contacts", 7, 2);
		String lastname1 = eLib.readDtaFromExcel("Contacts", 7, 3)+" "+random;
		
    
    	/*Step 2: launch the browser*/
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
    	
    	/*Step 3: login to application*/
    	LoginPage lp = new LoginPage(driver);
    	lp.loginToApp(USERNAME, PASSWORD);
    	
    	/*Step 4: navigate to the contact*/
    	HomePage hp = new HomePage(driver);
    	hp.ClickOnContactLnk();		
    	
    	/*Step 5: click on quick create*/
    	//hp.ClickOnQuickCreateDropDown(contactname);
        
    	/* Step 6: fill mandatory details*/
      //  hp.getLastNameEdt().sendKeys(lastname1);
     //   hp.newContactPopUpSaveBtn();
       
   	    /*Step 11: logout application*/
   	    hp.signOutOfApp(driver);
     
   	    /*Step 10: close the application*/
   	    driver.quit();

    }
}
