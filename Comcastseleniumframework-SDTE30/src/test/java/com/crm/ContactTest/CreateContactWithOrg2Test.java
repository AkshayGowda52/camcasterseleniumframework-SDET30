package com.crm.ContactTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.BaseClass;
import com.cem.GenericLibrary.ExcelFileUtility;
import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;
import com.cem.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrg2Test extends BaseClass
{
	@Test(groups = "RegressionSuite")
    public void createcontactanyorgtest() throws Throwable
    {
    	    String conlastname = eLib.readDtaFromExcel("Contacts", 4, 2)+"_"+jLib.getRandomNumber();
    		String Orgname = eLib.readDtaFromExcel("Contacts", 4, 3)+"_"+jLib.getRandomNumber();
    		
    		
    		/* Step 5: navigation to  create organization name*/
    	    HomePage hp = new HomePage(driver);
    	    hp.ClickOnOrgLnk();
        	
        	/*Step 5: click on create organization btn */
        	OrganizationsPage op = new OrganizationsPage(driver);
        	op.clickOnCreateOrgImg();
        	
        	/*Step 6: enter mandatory field and save*/
        	CreateOrganizationPage cop = new CreateOrganizationPage(driver);
        	cop.createNewOrg(Orgname);
        	
        	/* Step 7: verification*/
        	OrganizationInfoPage oip = new OrganizationInfoPage(driver);
        	String actOrgName = oip.OrgNameInfo();
        	if(actOrgName.contains(Orgname))
        	{
        		System.out.println(actOrgName+"------> data verified");
        	}else
        	{
        		System.out.println("data invalid");
        	}
    	    
    	    /*Step 8: navigate to contact link*/
    	    hp.ClickOnContactLnk();
    	
    		/* Step 9: navigation to  create Contact*/
    	    ContactPage con = new ContactPage(driver);
    	    con.createNewCon();
    	    
    	    /*Step 10: fill all mandatory field*/
    		CreateContactPage ccp = new CreateContactPage(driver);
    		ccp.clickOnContact(driver, conlastname, Orgname);
    				
    		/*Step 11: verification*/
    		ContactInfoPage coi = new ContactInfoPage(driver);
    		String header = coi.conNameInfo();
    		if(header.contains(conlastname))
    		{
    			System.out.println(header+"----->verification is done");
    		}
    		else
    		{
    			System.out.println("verification is faild");
    		}
    	
    }
}
