package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest 
{
    @Test
    public void  readDataFromCmdLineTest()
    {
    	 String BROWSER = System.getProperty("browser");
    	 String URL = System.getProperty("url");
    	 String USERNAME = System.getProperty("username");
    	 String PASSWORD = System.getProperty("password");
    	 
    	 
    	 System.out.println("browser name is======>"+BROWSER);
    	 System.out.println("url name is======>"+URL);
    	 System.out.println("username name is======>"+USERNAME);
    	 System.out.println("password name is======>"+PASSWORD);
    }
}
