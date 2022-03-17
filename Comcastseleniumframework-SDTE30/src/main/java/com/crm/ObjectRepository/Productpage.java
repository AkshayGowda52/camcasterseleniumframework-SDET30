package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cem.GenericLibrary.WebDriverUtility;

public class Productpage extends WebDriverUtility
{
   //Step 1: declaration 
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createNewProductLookUpImg;
	
	@FindBy(xpath = "//a[.='Create Filter']")
	private WebElement createFilterLik;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "submit")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//a[.='edit']")
	private WebElement editLnk;
	
	@FindBy(xpath = "//a[.='del']")
	private WebElement deletelnk;
	
	@FindBy(name = "search_field")
	private WebElement searchFieldDropDown;
	
	//Step 2: initialization
	public Productpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   //Step 3: utilization
	public WebElement getCreateNewProductLookUpImg() {
		return createNewProductLookUpImg;
	}
	
	public WebElement getCreateFilterLik() {
		return createFilterLik;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public WebElement getEditLnk() {
		return editLnk;
	}
	public WebElement getDeletelnk() {
		return deletelnk;
	}
	
	public WebElement getSearchFieldDropDown() {
		return searchFieldDropDown;
	}
	//business library
	public void clickOnnewProduct()
	{
		createNewProductLookUpImg.click();
	}
	public  void clickOnCreateFilter() 
	{
		createFilterLik.click();
	}
	public void searchEdt(String productname1)
	{
		searchEdt.sendKeys(productname1);
	}
	public void clicOnSearchNow()
	{
		submitbtn.click();
	}
	public void clickOnDelete()
	{
		deletelnk.click();
	}
	public void clickOnSearchFieldDropDown(String productname)
	{
		searchFieldDropDown.click();
		select(searchFieldDropDown, productname);
	}
	public void clickOnEdit()
	{
		editLnk.click();
	}
}
