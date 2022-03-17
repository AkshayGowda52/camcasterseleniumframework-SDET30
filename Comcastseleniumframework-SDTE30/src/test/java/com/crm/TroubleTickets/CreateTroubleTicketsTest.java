package com.crm.TroubleTickets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
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

public class CreateTroubleTicketsTest 
{
   @Test
   public void createtroubleticketstest() throws Throwable
   {
	   /*Step 1: read all the data*/
	   //read data from property file
	   FileInputStream file = new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
	   Properties pObj = new Properties();
	   pObj.load(file);
	   String BROWSER = pObj.getProperty("Browser");
	   String URL = pObj.getProperty("Url");
	   String USERNAME = pObj.getProperty("Username");
	   String PASSWORD = pObj.getProperty("Password");
	   
	   //read data from excel
	   FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\Test data1.xlsx");
	   Workbook wb = WorkbookFactory.create(fil);
	   Sheet sh = wb.getSheet("TroubleTicket");
	   Row ro = sh.getRow(1);
	   Cell cell = ro.getCell(1);
	   String troubleticket = cell.getStringCellValue();
	   

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
   	   
   	   /*Step 3: navigate to Trouble ticket*/
   	   driver.findElement(By.xpath("//td[@class='tabUnSelected']/following-sibling::td[16]")).click();
   	   
   	   /*Step 4: create trouble ticket*/
   	   driver.findElement(By.xpath("//img[@title='Create Ticket...']")).click();
   	   
   	   /*Step 5: fill the mandatory data*/
   	   driver.findElement(By.name("ticket_title")).sendKeys(troubleticket);
   	   
   	   /*Step 6: save the edited product*/
  	   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
  	 
  	   /*Step 7: logout application*/
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
