package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
   //Step 1: declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headText;
	
	//Step 2: initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3: utilization
	public WebElement getHeadText() {
		return headText;
	}
	
	//business library
	public String conNameInfo()
	{
		String coninfo = headText.getText();
		return coninfo; 
	}
	
}
