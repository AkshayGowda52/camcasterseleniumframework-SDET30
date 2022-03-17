package com.crm.ContactTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
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
@Listeners(com.cem.GenericLibrary.ListenersImplementationClass.class)
public class CreateContact2Test extends BaseClass
{
    
	@Test(groups = "SmokeSuite")
	   public void createcontacttest() throws Throwable
	   {
	   	
	   
		String conlastname = eLib.readDtaFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomNumber();
	   
		//Step 1: navigate to contact link
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		Reporter.log("click on contact",true);
		
	
		//Step 6: Click on Create  contact link
		ContactPage co = new ContactPage(driver);
		co.createNewCon();
		Reporter.log("click on  create contact",true);
		Assert.fail();
		
		
		//step 7: Create Contact With Mandatory Fields
		CreateContactPage cop = new CreateContactPage(driver);
		cop.clickOnContact(conlastname);
		Reporter.log("eneter all mandatory fildes",true);
		
		//Step 8: verification
		ContactInfoPage coi = new ContactInfoPage(driver);
		String header = coi.conNameInfo();
		if(header.contains(conlastname))
		{
			System.out.println(header+"--------->verification is done");
		}
		else
		{
			System.out.println("verification is faild");
		}
		Reporter.log("verification done",true);
		
	   }
	
}
