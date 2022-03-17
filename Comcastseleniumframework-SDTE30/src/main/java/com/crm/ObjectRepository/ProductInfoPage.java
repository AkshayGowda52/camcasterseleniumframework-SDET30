package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
   //Step 1: declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headText;
	
	//Step 2: initialization
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //Step 3: utilization
	public WebElement getProductInfo() {
		return headText;
	}
	
	//business library
	public String productNameinfo()
	{
		String productInfo = headText.getText();
		return productInfo;
	}
}
