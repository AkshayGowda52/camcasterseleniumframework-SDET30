package com.crm.OrganizationTest;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cem.GenericLibrary.BaseClass;
import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.cem.GenericLibrary.ListenersImplementationClass.class)
public class CreateOrgTest1 extends BaseClass
{
       //(retryAnalyzer = com.cem.GenericLibrary.RetryAnalyserImplementationClass.class)
	SoftAssert sa = new SoftAssert();
    @Test
    public void createorgtest() throws Throwable
    {
    	
    	//read data from excel sheet
    	String organizationname = eLib.readDtaFromExcel("Organazition", 1, 2)+"_"+jLib.getRandomNumber();
    	
    	/*Step 1: navigate to organization link*/
    	HomePage hp = new HomePage(driver);
    	hp.ClickOnOrgLnk();
    	
    	/*Step 2: click on create organization btn */
    	OrganizationsPage op = new OrganizationsPage(driver);
    	op.clickOnCreateOrgImg();
    	String expectedhesder = "Organizations";
    	String actualheader = driver.findElement(By.linkText("Organizations")).getText();
    	Assert.assertEquals(actualheader, expectedhesder);
    	Reporter.log(expectedhesder+" "+"expectedheader and actualheader are equal",true);
    	
    	/*Step 3: enter mandatory field and save*/
    	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
    	cop.createNewOrg(organizationname);
    	String expectedData = "Creating New Organization";
    	String actualData = driver.findElement(By.className("lvtHeaderText")).getText();
    	 sa.assertTrue(actualData.contains(expectedhesder));
    	
    	/* Step 4: verification*/
    	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
    	String actOrgName = oip.OrgNameInfo();
    	if(actOrgName.contains(organizationname))
    	{
    		System.out.println(actOrgName+"------> data verified");
    	}else
    	{
    		System.out.println("data invalid");
    	}
    	
    }
    @Test
    public void createOrganizationTest3()
    {
 	   System.out.println("createOrganizationTest3");
    }
}
