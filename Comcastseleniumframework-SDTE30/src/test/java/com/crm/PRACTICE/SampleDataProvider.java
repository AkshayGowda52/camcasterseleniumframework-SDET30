package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider 
{
  @Test(dataProvider = "getData")
  public void sampleDataProvider(String name,String model,int qty)
  {
	  System.out.println(name+"----"+model+"----"+qty);
  }
  
  @DataProvider
  public Object[][] getData()
  {
	  Object[][] obj = new Object[4][3];
	  
	  obj[0][0]="Mi";
	  obj[0][1]="13 PRO max";
	  obj[0][2]=25;
	 
	  obj[1][0]="iphone";
	  obj[1][1]="11 max"; 
	  obj[1][2]=12;
	  
	  
	  obj[2][0]="vivo";
	  obj[2][1]="17 max";
	  obj[2][2]=30;
	  
	  obj[3][0]="samsung"; 
	  obj[3][1]="A80";
	  obj[3][2]=12;
	  
	  return obj;
	  
  }
  
  @DataProvider
  public Object[][] getData1()
  {
	  Object[][] obj1 = new Object[6][2];
	  
	  obj1[0][0]="orange";
	  obj1[0][1]=3;
	  
	  obj1[1][0]="apple";
	  obj1[1][1]=5;
	  
	  obj1[2][0]="banana";
	  obj1[2][1]=6;
	  
	  obj1[3][0]="pineapple";
	  obj1[3][1]=4;
	  
	  obj1[4][0]="grapes";
	  obj1[4][1]=3;
	  
	  obj1[5][0]="promogranate";
	  obj1[5][1]=7;
	  
	  return obj1;
	  
  }
	 @Test(dataProvider = "getData1",priority = -1)
	 public void readData1(String name, int qty)
	 {
		 System.out.println(name+"--"+qty);
	 }
  }


  
  
