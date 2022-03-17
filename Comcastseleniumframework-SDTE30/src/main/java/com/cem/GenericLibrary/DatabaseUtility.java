package com.cem.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic method to read from database
 * @author aksha
 *
 */
public class DatabaseUtility 
{
	Connection con=null;
	/**
	 * This method will register the driver and establish connection with data base
	 * @throws Throwable
	 */
 public void connectToDB() throws Throwable
 {
	 Driver driver= new Driver();
	 DriverManager.registerDriver(driver);
	con = DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbusernam, IPathConstants.dbpassword);
	 
 }
 /**
  * This method will close database connection
  * @throws Throwable
  */
 public void closeDB() throws Throwable 
 {
	 con.close();
	 
 }
 public String executeQueryAndGetData(String Query,int coloumnIndex,String expData) throws Throwable
 {
	 String data=null;
	 boolean flag=false;
	 ResultSet result = con.createStatement().executeQuery(Query);
	 while(result.next())
	 {
		 data=result.getString(coloumnIndex);
				 if(data.equalsIgnoreCase(expData))
				 {
					 flag=true;//flag rising
					 break;
				 }
	 }
	 if(flag)
	 {
		 System.out.println(data+"----.data verified");
		 return expData;
	 }
	 else
	 {
		 System.out.println("data not verfied");
		 return "";
	 }
 
 }
}
