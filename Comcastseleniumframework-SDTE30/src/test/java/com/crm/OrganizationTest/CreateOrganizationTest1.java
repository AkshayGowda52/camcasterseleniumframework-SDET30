package com.crm.OrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest1 
{
	@Test
    public void creatorganizationtest() throws Throwable
    {
		//Step 1:create object all the generic file
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		//Step 2: read all the data from property file and excel file
		String BROWSER = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("Url");
		String USERNAME = pLib.readDataFromPropertyFile("Username");
		String PASSWORD = pLib.readDataFromPropertyFile("Password");
		
		String organizationname = eLib.readDtaFromExcel("Organazition", 1, 2);
		
		//Step 3: launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		WebDriver driver=null;
		   if(BROWSER.equalsIgnoreCase("chrome"))
		   {
			   driver=new ChromeDriver();
		   }
		   else if(BROWSER.equalsIgnoreCase("firefox"))
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
    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    	driver.findElement(By.id("submitButton")).click();
    	
    	//Step 5: Navigate to Organization link
    	driver.findElement(By.linkText("Organizations")).click();
    	
    	//Step 6: Click on Create Organization link
    	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    	
    	//step 7: Create org With Mandatory Fields
    	driver.findElement(By.name("accountname")).sendKeys(organizationname);
    	
    	//Step 8:Save
    	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
    	driver.quit();
    }

}
