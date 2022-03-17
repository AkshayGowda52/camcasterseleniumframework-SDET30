package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataFromExcelSheetTest 
{
  @Test
  public void writedatafromexcelsheet() throws Throwable
  {
	  //Step 1: open the file in the mode
	  FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\akshay.xlsx");
	  
	  Workbook wb = WorkbookFactory.create(fil);
	  Sheet sh = wb.getSheet("Sheet1");
	  Row ro = sh.getRow(0);
	  
	  //Step 5: create a cell to write new data
	  Cell ce = ro.createCell(10);
	  
	  //Step 6: set the cell value
	  ce.setCellValue("tc_1500");
	  
	  //Step 7: open file in write mode
	  FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\akshay.xlsx");
	  wb.write(fos);
  }
}
