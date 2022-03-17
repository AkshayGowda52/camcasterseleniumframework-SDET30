package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.cem.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
   //Step 1: declaration
	@FindBy(name = "lastname")
	private WebElement conNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Step 2: initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	 //Step 3: utilization
	public WebElement getConNameEdt() {
		return conNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

		//business library
		public void clickOnContact(String conlastname)
		{
			conNameEdt.sendKeys(conlastname);
			saveBtn.click();
		}
		public void clickOnContact(WebDriver driver,String conlastname, String orgname)
		{
			conNameEdt.sendKeys(conlastname);
			orgNameLookUpImg.click();
			switchToWindow(driver, "Accounts");
			searchEdt.sendKeys(orgname);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			switchToWindow(driver, "Contacts");
			saveBtn.click();
			
		}
	
}
