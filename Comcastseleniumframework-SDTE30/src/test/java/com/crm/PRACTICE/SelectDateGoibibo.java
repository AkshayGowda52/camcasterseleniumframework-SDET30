package com.crm.PRACTICE;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectDateGoibibo 
{
   @Test
   public void selectdate()
   {
	   int date=20;
	   String month = "May 2022";
	   ChromeDriver driver = new ChromeDriver();
	   driver.get("https://www.goibibo.com/");
	   
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//span[.='Departure']")).click();
	   
	   for(;;) {
	   try {
		   driver.findElement(By.xpath("//div[.='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='"+date+"']")).click();

		   driver.findElement(By.xpath("//span[.='Done']")).click();
		   driver.findElement(By.xpath("//a[.='Done']")).click();
		   break;
	} catch (Exception e) {
		// TODO: handle exception
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	}
	   
	  
   }
   }
}
