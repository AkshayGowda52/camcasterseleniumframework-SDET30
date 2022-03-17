package com.crm.OrganizationTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest 
{
    @Test
    public void creatorganizationtest()
    {
    	//Step 1: launch the browser
    	WebDriver driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get("http://localhost:8888");
    	
    	//Step 2: login to Application
    	driver.findElement(By.name("user_name")).sendKeys("admin");
    	driver.findElement(By.name("user_password")).sendKeys("admin");
    	driver.findElement(By.id("submitButton")).click();
    	
    	//Step 3: Navigate to Organization link
    	driver.findElement(By.linkText("Organizations")).click();
    	
    	//Step 4: Click on Create link
    	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    	
    	//step 5: Create org With Mandatory Fields
    	driver.findElement(By.name("accountname")).sendKeys("alpa");
    	
    	//Step 6:Save
    	driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
    	driver.quit();
    }
}
