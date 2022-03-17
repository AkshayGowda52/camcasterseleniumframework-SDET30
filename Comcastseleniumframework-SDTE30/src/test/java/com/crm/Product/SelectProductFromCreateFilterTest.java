package com.crm.Product;

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

public class SelectProductFromCreateFilterTest 
{
   @Test
   public void selectproductfromcreatefilter() throws Throwable
   {
	   Random ron = new Random();
   	int random = ron.nextInt(500);
   	
   	/*Step 1: read the all the data*/
   	//read data from property file
   	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
   	Properties pObj = new Properties();
   	pObj.load(file);
   	String BROWSER = pObj.getProperty("Browser");
   	String URL = pObj.getProperty("Url");
   	String USERNAME = pObj.getProperty("Username");
   	String PASSWORD = pObj.getProperty("Password");
   	
   	//read data from excel sheet
   	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\Test data1.xlsx");
   	Workbook wb =  WorkbookFactory.create(fil);
   	Sheet sh = wb.getSheet("products");
   	Row ro = sh.getRow(13);
   	Cell cel = ro.getCell(2);
   	String viewedname1 = cel.getStringCellValue();
   	String viewednameran1 = viewedname1+" "+random;
   	
   	Cell cell = ro.getCell(3);
   	String salestartdata = cell.getStringCellValue();
   	
   	Cell cel2 = ro.getCell(4);
   	String today = cel2.getStringCellValue();
   	
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
	
	/*Step 3: login to application*/
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

	/* Step 4: navigate to product*/
	driver.findElement(By.xpath("//a[.='Products']")).click();
	
	/*Step 5: click on create filter*/
	driver.findElement(By.xpath("//a[.='Create Filter']")).click();
	
	/*Step 6: pass viewed product name*/
	driver.findElement(By.name("viewName")).sendKeys(viewednameran1);
	
	/*Step 7: select the sale start data*/
    WebElement ele = driver.findElement(By.name("stdDateFilterField"));
    Select sel = new Select(ele);
    sel.selectByVisibleText(salestartdata);
    
    WebElement ele1 = driver.findElement(By.name("stdDateFilter"));
    Select sel1 = new Select(ele1);
    sel1.selectByVisibleText(today);
    
    /*Step 8: save the edited product*/
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
