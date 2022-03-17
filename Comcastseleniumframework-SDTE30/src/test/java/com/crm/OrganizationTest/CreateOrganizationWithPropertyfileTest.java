package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateOrganizationWithPropertyfileTest 
{
   @Test
   public void createOrgTest() throws Throwable
   
   {
	   //Step 1: Read Data From Property file
	   FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
	   Properties pObj = new Properties();
	   pObj.load(fil);
	   String BROWSER = pObj.getProperty("Browser");
	   String URL = pObj.getProperty("Url");
	   String USERNAME = pObj.getProperty("Username");
	   String PASSWORD = pObj.getProperty("Password");
	   
	   //Step 2: Lunch The Browser
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
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   driver.get(URL);
	   
	   //Step 3: Login
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.id("submitButton")).click();
	   
	   //Step 4: Navigate To Organization
	   driver.findElement(By.linkText("Organizations")).click();
	   
	   //Step 5: Click on Create Link
	   driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	   
	   //Step 6: Create Org With Mandatory Field
	   driver.findElement(By.name("accountname")).sendKeys("ALL STATE");
	   
	   //Step 7: Save
	   driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	   driver.quit();
	   
   }
}
