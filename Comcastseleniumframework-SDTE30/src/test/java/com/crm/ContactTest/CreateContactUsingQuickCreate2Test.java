package com.crm.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.BaseClass;
import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactUsingQuickCreate2Test extends BaseClass
{
	@Test(groups = "RegressionSuite")
	   public void createcontacttest() throws Throwable
	   {
    	
    	//read data from excel
    	String contactname = eLib.readDtaFromExcel("Contacts", 7, 2);
		String lastname1 = eLib.readDtaFromExcel("Contacts", 7, 3)+" "+jLib.getRandomNumber();
		
    
    	
    	/*Step 4: navigate to the contact*/
    	HomePage hp = new HomePage(driver);
    	hp.ClickOnContactLnk();		
    	
    	/*Step 5: click on quick create*/
    	hp.ClickOnQuickCreateDropDown(contactname);
        
    	/* Step 6: fill mandatory details*/
        hp.getLastNameEdt().sendKeys(lastname1);
        hp.newContactPopUpSaveBtn();
       
   	    
    }
	   
}
