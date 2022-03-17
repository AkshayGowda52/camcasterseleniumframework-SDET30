package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.cem.GenericLibrary.JavaUtility;
import com.cem.GenericLibrary.PropertyFileUtility;


public class PractieforGenericUtils 
{
  @Test
  public void practice() throws Throwable
  {
	  JavaUtility jLib = new JavaUtility();
	  int ran = jLib.getRandomNumber();
	  String dat = jLib.getSystemDateInFromate();
	  String date = jLib.getSystemDate();
	  System.out.println(ran+date);
	  System.out.println(dat);
	  
	  PropertyFileUtility pLib=new PropertyFileUtility();
	  String brow = pLib.readDataFromPropertyFile("Browser");
	  System.out.println(brow);
  }
}
