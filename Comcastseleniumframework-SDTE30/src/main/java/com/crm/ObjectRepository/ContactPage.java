package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage 
{
    //Step 1: declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookupImg;
	
	//Step 2: initialization
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //Step 3: utilization
	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}
	
	//business library
	public void createNewCon()
	{
		createContactLookupImg.click();
	}
}
