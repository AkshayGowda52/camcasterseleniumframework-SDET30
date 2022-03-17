package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage 
{
  //Step 1:declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement header;
	
	//Step 2: initialization
	public CampaignInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step 3: utilization
	public WebElement getHeader() {
		return header;
	}
	
	//business library
	public String campaignNameInfo()
	{
		String campaigninfo = header.getText();
		return campaigninfo;
	}
}
