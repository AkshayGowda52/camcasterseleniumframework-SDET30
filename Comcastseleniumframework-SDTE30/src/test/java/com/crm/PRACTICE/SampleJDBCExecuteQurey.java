package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQurey 
{
    @Test
    public void SampleJDBCExecuteQuery() throws Throwable
    {
    	 Connection con=null;
    	try {
    	//step1 register to database
    	Driver driver=new Driver();
    	DriverManager.registerDriver(driver);
    	
    	//step2 get connection from database
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
        
        //step3 issue create statement
        Statement state = con.createStatement();
        
        //step4 execute query
        ResultSet result = state.executeQuery("select * from student");
        while(result.next())
        {
        	System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
        }
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    	finally 
    	{
    		   //step5 close connection
            con.close();
            System.out.println("connection is closed");
		}
    	}
    }

    
    
    

