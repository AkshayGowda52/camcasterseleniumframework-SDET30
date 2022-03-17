package com.crm.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import com.crm.ObjectRepository.CampaignInfoPage;
import com.crm.ObjectRepository.CampaignPage;
import com.crm.ObjectRepository.CreateNewCampaignPage;
import com.crm.ObjectRepository.CreateNewProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.Productpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductAndCampaiginIntegratedTest 
{
   @Test
   public void productandcampaiginintegratedtest() throws Throwable
   {
		 //Step 1:create object all the generic file
	   PropertyFileUtility pLib = new PropertyFileUtility();
	   ExcelFileUtility eLib = new ExcelFileUtility();
	   JavaUtility jLib = new JavaUtility();
	   WebDriverUtility wLib = new WebDriverUtility();
			   
       int random = jLib.getRandomNumber();
      
	   /* Step 1: read all data*/
	   String BROWSER = pLib.readDataFromPropertyFile("Browser");
	   String URL = pLib.readDataFromPropertyFile("Url");
	   String USERNAME = pLib.readDataFromPropertyFile("Username");
	   String PASSWORD = pLib.readDataFromPropertyFile("Password");
	   
	   String productName = eLib.readDtaFromExcel("Products", 16, 2)+random;
	   String campaignName = eLib.readDtaFromExcel("Products", 16, 3)+random;
	   
    /* Step 2: launch the browser*/
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
   	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	
	/* Step 3: Login to application*/
	LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	/* Step 4: navigate to product*/
	HomePage hp = new HomePage(driver);
	hp.ClickOnProductLnk();
	
	/* Step 5:create the product*/
	Productpage pdp = new Productpage(driver);
	pdp.clickOnnewProduct();
	
	
	/* Step 6:enter the product name*/
	CreateNewProductPage pnp = new CreateNewProductPage(driver);
	pnp.createNewProduct(productName);
	
	/* Step 6:product name verification*/
	ProductInfoPage pip = new ProductInfoPage(driver);
	String actualheader = pip.productNameinfo();
	if(actualheader.contains(productName))
	{
		System.out.println(actualheader +"------------>verification is done" );
	}
	else
	{
		System.out.println("verification is faild");
	}
	
	 /* Step 7: click on more*/
	hp.ClickOnMore();
  
    
    /* Step 8: click on campaigns*/
	hp.ClickOnCompaignLnk();
   
    /* Step 9: create the campaigns*/
	CampaignPage cp = new CampaignPage(driver);
	cp.CreateNewCamp();
  
	 /* Step 10: enter campaign name*/
	CreateNewCampaignPage cnp = new CreateNewCampaignPage(driver);
	cnp.createNewcampaign(driver, campaignName, productName);
	
	
    /* Step 10: verification*/
	CampaignInfoPage cip = new CampaignInfoPage(driver);
	String campName = cip.campaignNameInfo();
	if(campName.contains(campaignName))
	{
		System.out.println(campName="----->verification is done");
	}
	else
	{
		System.out.println("verification if faild");
	}
	

	/* Step 11: sing out application*/
	hp.signOutOfApp(driver);
	
	
	/* Step 11: close the application*/
	driver.quit();

    


   }
}
