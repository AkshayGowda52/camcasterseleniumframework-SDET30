package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser 
{
   @Test(retryAnalyzer = com.cem.GenericLibrary.RetryAnalyserImplementationClass.class)
   public void peacticeRetryAnalyser()
   {
	   System.out.println("this is test 1");
	   Assert.fail();
	   System.out.println("this is passed");
   }
}
