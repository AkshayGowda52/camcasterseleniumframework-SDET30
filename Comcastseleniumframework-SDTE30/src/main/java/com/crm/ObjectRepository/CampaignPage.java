package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage 
{
   //Step 1: declaration 
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createNewCampLookUpImg;
	
	//Step 2: initialization
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step 3: utilization
	public WebElement getCreateNewCampLookUpImg() {
		return createNewCampLookUpImg;
	}
	
	//business library
	public void CreateNewCamp()
	{
		createNewCampLookUpImg.click();
	}
}
