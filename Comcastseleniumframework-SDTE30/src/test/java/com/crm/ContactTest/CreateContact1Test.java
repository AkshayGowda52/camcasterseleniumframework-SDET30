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
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class CreateContact1Test 
{
	@Test
	   public void createcontacttest() throws Throwable
	   {
		//Step 1:create object all the generic file
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
	    int random = jLib.getRandomNumber();
		
	  //Step 2: read all the data from property file and excel file
		  
	   	String BROWSER = pLib.readDataFromPropertyFile("Browser");
	   	String URL = pLib.readDataFromPropertyFile("Url");
	   	String USERNAME = pLib.readDataFromPropertyFile("Username");
	   	String PASSWORD = pLib.readDataFromPropertyFile("Password");
	   	
	   	String conlastname = eLib.readDtaFromExcel("Contacts", 1, 2)+random;
	   
	  //Step 3: launch the browser
	   	WebDriverManager.chromedriver().setup();
	   	WebDriverManager.firefoxdriver().setup();
	   	
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefoxdriver"))
		{
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 4: login to Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step 5: navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
	
		//Step 6: Click on Create  contact link
		ContactPage co = new ContactPage(driver);
		co.createNewCon();
		
		//step 7: Create Contact With Mandatory Fields
		CreateContactPage cop = new CreateContactPage(driver);
		cop.clickOnContact(conlastname);
		
		//Step 8: verification
		ContactInfoPage coi = new ContactInfoPage(driver);
		String header = coi.conNameInfo();
		if(header.contains(conlastname))
		{
			System.out.println(header+"--------->verification is done");
		}
		else
		{
			System.out.println("verification is faild");
		}
		
		//Step 9: logout to the application
		hp.signOutOfApp(driver);
		
		
		driver.quit();
	   }
}
