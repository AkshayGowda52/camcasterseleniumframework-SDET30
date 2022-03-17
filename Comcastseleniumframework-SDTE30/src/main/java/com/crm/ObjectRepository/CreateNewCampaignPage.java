package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cem.GenericLibrary.WebDriverUtility;

public class CreateNewCampaignPage extends WebDriverUtility
{
    //Step 1: declaration
	@FindBy(name = "campaignname")
	private WebElement campNameEdt;
	
	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img[@alt='Select']")
	private WebElement campaignDropDownImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Step 2: initialization
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Step 3: utilization	
	public WebElement getCampNameEdt() {
		return campNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getCampaignDropDownImg() {
		return campaignDropDownImg;
	}

	//business library
	public void createNewcampaign(String campaignName)
	{
		campNameEdt.sendKeys(campaignName);
		saveBtn.click();
	}
	public void createNewcampaign(WebDriver driver,String campaignName,String productName)
	{
		campNameEdt.sendKeys(campaignName);
		campaignDropDownImg.click();
		switchToWindow(driver, "Products");
		searchEdt.sendKeys(productName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
	}
}
