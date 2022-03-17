package com.cem.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * this class will read the data from property file and value to user
 * @author aksha
 *
 */
public class PropertyFileUtility 
{
	/**
	 * this method will read data from property file for the key given by user and return the value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
public String readDataFromPropertyFile(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommanData.properties");
	Properties pLib=new Properties();
	pLib.load(fis);
	String value = pLib.getProperty(key);
	return value;
}
}
