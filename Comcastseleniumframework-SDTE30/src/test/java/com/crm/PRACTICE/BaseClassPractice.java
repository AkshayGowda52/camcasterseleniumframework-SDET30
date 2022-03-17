package com.crm.PRACTICE;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice 
{
   @BeforeSuite
   public void bsConfig()
   {
	   System.out.println("database connectivity Established");
   }
   
   @BeforeMethod
   public void bmConfig()
   {
	   System.out.println("login to app");
   }
   
   @Test
   public void actualTest()
   {
	   System.out.println("test script -1");
   }
   
   @Test
   public void actualTest1()
   {
	   System.out.println("test script -2");
   }
   
   @AfterMethod
   public void amConfig()
   {
	   System.out.println("logout of application");
   }
   
   @AfterClass
   public void acConfig()
   {
	   System.out.println("close browaser");
   }
   
   @BeforeClass
   public void bcConfig()
   {
	   System.out.println("launch the browse");
   }
   
   @AfterSuite
   public void asConfig()
   {
	   System.out.println("close db");
   }
}
