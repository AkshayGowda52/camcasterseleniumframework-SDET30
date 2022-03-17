package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cem.GenericLibrary.WebDriverUtility;

public class CreateNewProductPage extends WebDriverUtility
{
  //Step 1: declaration
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Step 2: initialization
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //Step 3: utilization
	public WebElement getProductNameEdt() {
		return productNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	// business library
	public void createNewProduct(String productName)
	{
		productNameEdt.sendKeys(productName);
		saveBtn.click();
	}
	
}
