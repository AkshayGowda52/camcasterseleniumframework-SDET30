package com.crm.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class CreateContactUsingQuickCreateTest 
{
    @Test
    public void createcontactusingquickcreatetest() throws Throwable
    {
    	Random ran = new Random();
       	int random = ran.nextInt(500);

    	/*Step 1: read all data*/
    	//read data from property file
    	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
    	Properties pObj = new Properties();
    	pObj.load(file);
    	String BROWSER = pObj.getProperty("Browser");
    	String URL = pObj.getProperty("Url");
    	String USERNAME = pObj.getProperty("Username");
    	String PASSWORD= pObj.getProperty("Password");
    	
    	//read data from excel
    	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\Test data1.xlsx");
    	Workbook wb = WorkbookFactory.create(fil);
    	Sheet sh = wb.getSheet("Contacts");
    	Row ro = sh.getRow(7);
    	Cell cell = ro.getCell(2);
    	String contactname = cell.getStringCellValue();
    	
    	Cell cel1 = ro.getCell(3);
    	String lastname = cel1.getStringCellValue();
    	String lastname1 = lastname+" "+random;
    	
    	/*Step 2: launch the browser*/
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
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(URL);
    	
    	/*Step 3: launch the browser*/
    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    	driver.findElement(By.id("submitButton")).click();
    	
    	/*Step 4: navigate to the contact*/
    	driver.findElement(By.linkText("Contacts")).click();
    	
    	/*Step 5: click on quick create*/
        WebElement ele = driver.findElement(By.id("qccombo"));
    	Select sec = new Select(ele);
    	sec.selectByValue(contactname);
    	
    	/* Step 6: fill mandatory details*/
        driver.findElement(By.name("lastname")).sendKeys(lastname1);
        
        /*Step 7: save the edited product*/
   	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    	
   	    /*Step 11: logout application*/
   	    WebElement el = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));		
        WebDriverWait wait=new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(el));
   	    Actions act = new Actions(driver);
   	    act.moveToElement(el).perform();
   	    driver.findElement(By.xpath("//a[.='Sign Out']")).click();
   	 
   	    /*Step 10: close the application*/
   	    driver.quit();

    }
}
