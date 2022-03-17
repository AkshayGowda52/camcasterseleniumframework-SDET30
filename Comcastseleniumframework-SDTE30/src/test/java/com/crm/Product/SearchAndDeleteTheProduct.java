package com.crm.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.Productpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAndDeleteTheProduct 
{
     @Test
     public void searchanddeletetheproduct() throws Throwable		
     {
    	 //Step 1:create object all the generic file
    	 PropertyFileUtility pLib = new PropertyFileUtility();
    	 ExcelFileUtility eLib = new ExcelFileUtility();
    	 WebDriverUtility wLib = new WebDriverUtility();
    	 JavaUtility jLib = new JavaUtility();
    	 
         int random = jLib.getRandomNumber();
    	 /*Step 1:read all data*/
    	 //read the data from property file
    	 String BROWSER = pLib.readDataFromPropertyFile("Browser");
    	 String URL = pLib.readDataFromPropertyFile("Url");
    	 String USERNAME = pLib.readDataFromPropertyFile("Username");
    	 	String PASSWORD = pLib.readDataFromPropertyFile("Password");
    	 
    	 //read the data from excel
    	 String productname1 = eLib.readDtaFromExcel("Products", 10, 2)+random;
     
    	 /*Step 2:launch the browser*/
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
    		 System.out.println("invalid browser");
    	 }
    	 wLib.maximizeWindow(driver);
    	 wLib.waitForPageLoad(driver);
         driver.get(URL);
    	 
    	 /*Step 3: login to application*/
    	 LoginPage lp = new LoginPage(driver);
    	 lp.loginToApp(USERNAME, PASSWORD);
     	 
     	 /* Step 4: navigate to product*/
     	 HomePage hp = new HomePage(driver);
     	 hp.ClickOnProductLnk();
     			 
   
    	 /*Step 5: search the product*/
     	Productpage pp = new Productpage(driver);
     	pp.searchEdt(productname1);
     	pp.clicOnSearchNow();
        pp.clickOnDelete();
        
        /*Step 8: click on delete*/
        wLib.accetAlert(driver);
   
   	    /*Step 09: logout application*/
   	   hp.signOutOfApp(driver);
   	 
   	    /*Step 10: close the application*/
   	    driver.quit();
    	 
     }
}
