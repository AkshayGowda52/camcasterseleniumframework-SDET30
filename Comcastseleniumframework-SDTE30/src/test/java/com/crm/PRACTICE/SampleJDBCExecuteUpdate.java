package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate 
{
    @Test
    public void Samlejdbcexecuteupdate() throws Throwable
    {
    	//step1 register to database
    	Driver driver=new Driver();
    	DriverManager.registerDriver(driver);
    	
    	//step2 get connection from database
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "root");
    	
    	//step3 issue create statement
    	Statement state = con.createStatement();
    	
    	//step4 execute query
    	int result = state.executeUpdate("insert into student values('ravi','5','Bangalore')");
    	
    	if(result==1)
    	{
    		System.out.println("data is added sucessfully");
    	}else
    	{
    		System.out.println("data is not added");
    	}
    	
    	//close database
    	con.close();
    	
    	
    	
    }
}
