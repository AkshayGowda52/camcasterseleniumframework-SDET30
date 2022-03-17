package com.crm.ObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
   //Step 1: declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	//Step 2: initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3: utilization

	public WebElement getHeaderText() {
		return headerText;
	}

	//business library
		public String OrgNameInfo()
		{
			
			String OrgInfo = headerText.getText();
			return OrgInfo;
		}
}
