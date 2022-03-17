package com.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

public class CreateContactWithOrgTest 
{
    @Test
    public void createcontactanyorgtest() throws Throwable
    {
    	 Random ran = new Random();
    	   	int random = ran.nextInt(500);
    	   	
    	    FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
    	   	Properties pObj = new Properties();
    	   	pObj.load(fil);
    	   	String BROWSER = pObj.getProperty("Browser");
    	   	String URL = pObj.getProperty("Url");
    	   	String USERNAME = pObj.getProperty("Username");
    	   	String PASSWORD = pObj.getProperty("Password");
    	   	
    	   	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test data1.xlsx");
    		Workbook wb = WorkbookFactory.create(fi);
    		Sheet sh = wb.getSheet("Contacts");
    		Row ro = sh.getRow(4);
    		Cell cel = ro.getCell(2);
    		String conlastname = cel.getStringCellValue();
    		
    		
    		Cell cel1 = ro.getCell(3);
    		String searchOrgname = cel1.getStringCellValue();
    		
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
    		
    		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    		driver.findElement(By.id("submitButton")).click();
    		
    		driver.findElement(By.linkText("Contacts")).click();
    		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    		driver.findElement(By.name("lastname")).sendKeys(conlastname+" "+random);
    		driver.findElement(By.xpath("//img[@title='Select']")).click();
    		
    		
    		Set<String> window = driver.getWindowHandles();
    		for (String win1 : window) 
    		{
				driver.switchTo().window(win1);
			}
    		
    		driver.findElement(By.id("search_txt")).sendKeys(searchOrgname);
    		driver.findElement(By.name("search")).click();
    		driver.findElement(By.id("1")).click();
    		
    		Set<String> window1 = driver.getWindowHandles();
    		for (String win2 : window1) 
    		{
				driver.switchTo().window(win2);
			}
    		
    
    		WebElement el = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));		
    		WebDriverWait wait=new WebDriverWait(driver, 20);
    		wait.until(ExpectedConditions.visibilityOf(el));
    		Actions act = new Actions(driver);
    		act.moveToElement(el).perform();
    		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
    		
    		driver.quit();

    }
}
