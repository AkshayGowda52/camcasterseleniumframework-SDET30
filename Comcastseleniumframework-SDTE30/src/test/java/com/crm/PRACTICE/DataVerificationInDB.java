package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDB 
{
       @Test
       public void DataVerificationInDB() throws Throwable
       {
    	  String expectedresult ="akshay";
    	   Driver driver=new Driver();
    	   DriverManager.registerDriver(driver);
    	   
    	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
    	   
    	   Statement state = con.createStatement();
    	   
    	   ResultSet result = state.executeQuery("select * from student;");
    	   
    	   while(result.next())
    	   {
    		   String name = result.getString(1);
    		   if(expectedresult.equalsIgnoreCase(name))
    		   {
    			   System.out.println(name+ " is verified");
    			   break;
    		   }
    	   }
       }
       
       
}
