package com.crm.OrganizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
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

public class CreateOrgWthIndustryTypeTest 
{
    @Test
    public void creayeorgwithindustytypetest() throws Throwable
    {
    	Random ran = new Random();
    	int random = ran.nextInt(500);
    	
    	/* Step 1: read all the data*/
    	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
    	Properties pObj = new Properties();
    	pObj.load(fil);
    	String BROWSER = pObj.getProperty("Browser");
    	String URL = pObj.getProperty("Url");
    	String USERNAME = pObj.getProperty("Username");
    	String PASSWORD = pObj.getProperty("Password");
    	
    	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test data1.xlsx");
    	Workbook wb = WorkbookFactory.create(fi);
    	Sheet sh = wb.getSheet("Organazition");
    	Row ro = sh.getRow(4);
    	Cell cel = ro.getCell(2);
    	String Orgname = cel.getStringCellValue();
    	Cell ce = ro.getCell(3);
    	String IndType = ce.getStringCellValue();
    	
    	/* Step 2: Launch the browser*/
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
    	
    	/* Step 3: Login to application*/
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get(URL);
    	
    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    	driver.findElement(By.id("submitButton")).click();
    	
    	/* Step 4: navigation to organization*/
    	driver.findElement(By.linkText("Organizations")).click();
    	
    	/* Step 5: navigation to create organization*/
    	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
    	
    	/* Step 6: navigation to create organization mandatory field*/
        driver.findElement(By.name("accountname")).sendKeys(Orgname+" "+random);
    	
        /* Step 7: select the industry from drop down*/
        driver.findElement(By.name("industry")).sendKeys(IndType);

    	//WebElement ele = driver.findElement(By.name("industry"));
    	//Select sc = new Select(ele);
    	//sc.selectByValue(IndType);
    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  
    	 /* Step 8: Logout application*/
    	WebElement el = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));		
    	WebDriverWait wait=new WebDriverWait(driver, 20);
    	wait.until(ExpectedConditions.visibilityOf(el));
    	Actions act = new Actions(driver);
    	act.moveToElement(el).perform();
    	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
    	
    	
    	driver.quit();
    }
}
