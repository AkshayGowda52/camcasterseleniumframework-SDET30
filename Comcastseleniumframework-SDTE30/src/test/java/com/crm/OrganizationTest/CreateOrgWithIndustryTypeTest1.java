package com.crm.OrganizationTest;

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
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgWithIndustryTypeTest1 
{

    @Test
    public void creayeorgwithindustytypetest() throws Throwable
    {
    	 //Step 1:create object all the generic file
    	PropertyFileUtility pLib = new PropertyFileUtility();
    	ExcelFileUtility eLib = new ExcelFileUtility();
    	JavaUtility jLib = new JavaUtility();
    	WebDriverUtility wLib = new WebDriverUtility();
    	
    	int random = jLib.getRandomNumber();
    	
    	/* Step 2: read all the data*/
    	String BROWSER = pLib.readDataFromPropertyFile("Browser");
    	String URL = pLib.readDataFromPropertyFile("Url");
    	String USERNAME = pLib.readDataFromPropertyFile("Username");
    	String PASSWORD = pLib.readDataFromPropertyFile("Password");
    	
    	String organizationname = eLib.readDtaFromExcel("Organazition", 4, 2);
    	String industrytypename = eLib.readDtaFromExcel("Organazition", 4, 3);
    
    	
    	/* Step 3: Launch the browser*/
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
    	
    	/* Step 4: Login  to application*/
        LoginPage lp = new LoginPage(driver);
        lp.loginToApp(USERNAME, PASSWORD);

    	
    	/* Step 4: navigation to organization*/
    	HomePage hp = new HomePage(driver);
    	hp.ClickOnOrgLnk();
    	
    	/* Step 5: navigation to create organization*/
    	OrganizationsPage op = new OrganizationsPage(driver);
    	op.clickOnCreateOrgImg();
    	
    	/* Step 6: navigation to create organization mandatory fields*/
        CreateOrganizationPage cop = new  CreateOrganizationPage(driver);
        cop.createNewOrg(organizationname, industrytypename);
        
        /* step 7: verification*/
        OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        String header = oip.OrgNameInfo();
        if(header.contains(organizationname))
        {
        	System.out.println(header+"-------->verification is done");
        }
        else
        {
        	System.out.println("verification faild");
        }
  
    	 /* Step 8: Logout application*/
    	hp.signOutOfApp(driver);
    	
    	/* Step 8: close the browser*/
    	driver.quit();
    }
}
