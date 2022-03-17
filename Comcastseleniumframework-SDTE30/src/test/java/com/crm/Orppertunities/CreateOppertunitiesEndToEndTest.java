package com.crm.Orppertunities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOppertunitiesEndToEndTest 
{
	@Test
	public void createoppertunitiesendtoendtest() throws Throwable
	{
		//Step 1:create object all the generic file
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		int random = jLib.getRandomNumber();
		
		//Step 2: Read Data From Property file and excel file
		String BROWSER = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("Url");
		String USERNAME = pLib.readDataFromPropertyFile("Username");
		String PASSWORD = pLib.readDataFromPropertyFile("Password");
		String CHILDPOPUP = pLib.readDataFromPropertyFile("childpop_upurl");
		
		 String opportunitiesname = eLib.readDtaFromExcel("Oppertunities", 1, 2);
		 String relatedOpp = eLib.readDtaFromExcel("Oppertunities", 1, 3);
		 String conlastname = eLib.readDtaFromExcel("Oppertunities", 1, 4)+random;
		 String campaignname = eLib.readDtaFromExcel("Oppertunities", 1, 5)+random;
		 
		 
		
		//Step 3: Lunch The Browser
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
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step 4: Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 5: create contact 
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(conlastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification
		String actcantactresult = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actcantactresult.contains(conlastname))
		{
			System.out.println(conlastname+"------->verification is done");
		}
		else
		{
			System.out.println("invalid verification");
		}
		
		 /* Step 6: click on more*/
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
	    
	    /* Step 7: click on campaigns*/
	    driver.findElement(By.name("Campaigns")).click();
	    
	    /* Step 8: create the campaigns*/
	    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	    driver.findElement(By.name("campaignname")).sendKeys(campaignname);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    
	    //verification
	    String actcampaignresult = driver.findElement(By.className("dvHeaderText")).getText();
		if(actcampaignresult.contains(campaignname))
		{
			System.out.println(campaignname+"-------->verification is done");
		}
		else
		{
			System.out.println("invalid verification");
		}
		
		/*Step 7: navigate to opportunities*/
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(opportunitiesname);
		driver.findElement(By.name("related_to_type")).sendKeys(relatedOpp);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		/*Step 8: handling pop up*/
		wLib.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@name='search_text' and @type='text']")).sendKeys(conlastname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[@onClick='return vtlib_setvalue_from_popup(59, \" HDFC 206\", \"related_to\")']"+random)).click();
		
		
		
		
		
		
	}
}
