package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cem.GenericLibrary.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility
{
   //Step 1: declaration
	@FindBy(name = "accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Step 2: initialization
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
    //Step 3: utilization
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createNewOrg(String organizationname)
	{
		OrgNameEdt.sendKeys(organizationname);
		saveBtn.click();
	}
	
	public void createNewOrg(String organizationname, String industrytypename)
	{
		OrgNameEdt.sendKeys(organizationname);
		select(industryDropDown, industrytypename);
		saveBtn.click();
	}
	public void createNewOrg(String organizationname, String industrytypename, String typedropdown)
	{
		OrgNameEdt.sendKeys(organizationname);
		select(industryDropDown, industrytypename);
		select(typeDropDown, typedropdown);
		saveBtn.click();
	}
	
}
