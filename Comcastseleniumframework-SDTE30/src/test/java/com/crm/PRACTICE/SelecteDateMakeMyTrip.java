package com.crm.PRACTICE;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class SelecteDateMakeMyTrip 
{
     @Test(enabled = false)
     public void selectDate()
     {
    	ChromeDriver driver = new ChromeDriver(); 
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.get("https://www.makemytrip.com/");
    	
    	Actions action = new Actions(driver);
    	action.moveByOffset(10, 10).click().perform();
    	
    	driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
    	
    	driver.findElement(By.xpath("//div[text()='March 2022']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='24']")).click();
     }
     
     @Test
     public void selectdatemmt()
     {
    	 int date = 20;
    	 String month = "May 2022";
    	 ChromeDriver driver = new ChromeDriver(); 
     	driver.manage().window().maximize();
     	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     	driver.get("https://www.makemytrip.com/");
     	
     	Actions action = new Actions(driver);
     	action.moveByOffset(10, 10).click().perform();
     	
     	driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
     	
     	for(;;)
     	try {
			driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();
            break;
		} catch (Exception e) {
			// TODO: handle exception
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();	
		}

     }
     
     @Test
     public void selectPrasentDate()
     {
    	 Date d = new Date();
    	 String d1 = d.toString();
    	 System.out.println(d1);
    	 String[] date = d1.split(" ");
    	 System.out.println(date);
    	 
    	 /*String day=date[1];
    	 String mon=date[2];
    	 String year=date[5];
    	// String time=date[3].replace(":", "-");
   
    	 String dateformate= day+"-"+mon+"-"+year;
    	 
    	 
    	 
    	 ChromeDriver driver = new ChromeDriver();
    	 driver.manage().window().maximize();
    	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	 driver.get("https://www.makemytrip.com/");
    	 
    	 Actions act = new Actions(driver);
    	 act.moveByOffset(10, 10).click().perform();
    	 
    	 driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
    	// driver.findElement(By.xpath("//div[.='"+mon+" "+year+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[.='"+day+"']")).click();
    	 driver.findElement(By.xpath("//div[@aria-label='"+dateformate+"']")).click();*/
		
    	 
    	 
     }
}
//div[@aria-label='Thu Mar 10 2022']