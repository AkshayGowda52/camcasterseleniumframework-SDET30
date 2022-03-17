package com.crm.ContactTest;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.cem.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactPage;
import com.crm.ObjectRepository.HomePage;

public class CheckAllTheChechBoxInContactTest extends BaseClass
{
   @Test(enabled = false)
   public void checkAllTheCheckBoxInContactTest() throws InterruptedException 
   {
	   HomePage hp = new HomePage(driver);
	   hp.ClickOnContactLnk();
	   
	   List<WebElement> check = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	   
	   for (WebElement checks : check) 
	   {
		  checks.click();
		  Thread.sleep(1000);
	   }
		
	}
   
   @Test
   public void ClickOnLastCheckBoxInContactTest() throws InterruptedException
   {
	   HomePage hp = new HomePage(driver);
	   hp.ClickOnContactLnk();
	   
	   List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	   Thread.sleep(2000);
	   
	   wLib.scrollAction(driver);
	   
	   ArrayList<WebElement> arr = new ArrayList<WebElement>(ele);
	   arr.get(arr.size()-1).click();
	   Thread .sleep(2000);
   }
   
   
   @Test(enabled = false)
   public void PrintContactLatName()
   {
	   HomePage hp = new HomePage(driver);
	   hp.ClickOnContactLnk();
	   
	   List<WebElement> elem = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
	   for (WebElement element : elem) 
	   {
		String lastname = element.getText();
		System.out.println(lastname);
	}
   }
   @Test
   public void delete5thContact() throws InterruptedException
   {
	   HomePage hp = new HomePage(driver);
	   hp.ClickOnContactLnk();
	   
	   int i = 4;
	   List<WebElement> elemen = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
	   
	   ArrayList<WebElement> arra = new ArrayList<WebElement>(elemen);
	   
	   arra.get(i).click();
	   
	    List<WebElement> del = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[10]/a[.='del']"));
	   
	   ArrayList<WebElement> arr = new ArrayList<WebElement>(del);
	   arr.get(i).click();
	   
	   wLib.accetAlert(driver);
	   Thread.sleep(3000);
   }
    }
  	 
   
	   
   


