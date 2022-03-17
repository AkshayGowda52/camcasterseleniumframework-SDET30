package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cem.GenericLibrary.WebDriverUtility;

public class ProductNewCustomViwePage extends WebDriverUtility
{
	//Step 1: declaration
@FindBy(name = "viewName")
private WebElement viewNameEdt;
  
@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;

//Step 1: initialization
public ProductNewCustomViwePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
//Step 1: declaration
public WebElement getViewNameEdt() {
	return viewNameEdt;
}

public WebElement getSavebtn() {
	return savebtn;
}
//business library
public void viewName(String viewedproductname)
{
	viewNameEdt.sendKeys(viewedproductname);
}

public void saveviewname()
{
	savebtn.click();
}

}
