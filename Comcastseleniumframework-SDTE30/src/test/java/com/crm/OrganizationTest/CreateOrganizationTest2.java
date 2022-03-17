package com.crm.OrganizationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.BaseClass;
import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest2 extends BaseClass
{
   @Test(groups = "SmokeSuite")
   public void createOrganizationTest2() throws Throwable
   {
	 
	 		
	 		String organizationname = eLib.readDtaFromExcel("Organazition", 1, 2)+"_"+jLib.getRandomNumber();
	 		
	     	
	     	//Step 1: Navigate to Organization link
	     	HomePage hp = new HomePage(driver);
	     	hp.ClickOnOrgLnk();
	     	Reporter.log("click on organization",true);
	     	
	     	//Step 2: Click on Create Organization link
	     	OrganizationsPage op = new OrganizationsPage(driver);
	     	op.clickOnCreateOrgImg();
	     	Reporter.log("click on create organization",true);
	     	
	     	//step 3: Create org With Mandatory Fields
	     	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
	     	cop.createNewOrg(organizationname);
	     	Reporter.log("fill all mandatory fields",true);
	     	
	     	//verification
	     	OrganizationInfoPage cip = new OrganizationInfoPage(driver);
	     	String actualheader = cip.OrgNameInfo();
	     	if(actualheader.contains(organizationname))
	     	{
	     		System.out.println(actualheader+"=====>data verified");
	     	}
	     	else
	     	{
	     		System.out.println("data invalid");
	     	}
	     	Reporter.log("verification is done",true);
	     	
   }
   
}
