package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePracties 
{
   @Test
   public void propartyfilepracties() throws Throwable
   {
	   //Step 1: Read The File
	   FileInputStream fil=new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
	   
	   //Step 2: Create Obj Of Properties
	   Properties pObj = new Properties();
	   pObj.load(fil);
	   
	   //Step 3: Read The Data 
	   String URL = pObj.getProperty("Username");
	   
	   //Verification
	   System.out.println(URL);
   }
}
