package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cem.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	//Step 1: declaration
   @FindBy(linkText = "Organizations")
   private WebElement organizationLnk;
   
   @FindBy(linkText = "Contacts")
   private WebElement contactsLnk;
   
   @FindBy(linkText = "Opportunities")
   private WebElement opportunitiesLnk;
   
   @FindBy(linkText = "Products")
   private WebElement productsLnk;
   
   @FindBy(linkText = "More")
   private WebElement moreLnk;
   
   @FindBy(linkText = "Campaigns")
   private WebElement compaignsLnk;
   
   @FindBy(id = "qccombo")
   private WebElement quickCreateBtn;
   
   @FindBy(name = "lastname")
   private WebElement lastNameEdt;
   
   @FindBy(xpath = "//input[@title='Save [Alt+S]']")
   private WebElement newContactSaveBtn;
   
   @FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
   private WebElement administratorImg;
   
   @FindBy(linkText = "Sign Out")
   private WebElement signOutLnk;
   
   //Step 2: initialization - use constructor
   public HomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

   //Step 3: utilization - use getter
public WebElement getOrganizationLnk() {
	return organizationLnk;
}

public WebElement getLastNameEdt() {
	return lastNameEdt;
}

public WebElement getNewContactSaveBtn() {
	return newContactSaveBtn;
}

public WebElement getQuickCreateBtn() {
	return quickCreateBtn;
}

public WebElement getContactsLnk() {
	return contactsLnk;
}

public WebElement getOpportunitiesLnk() {
	return opportunitiesLnk;
}

public WebElement getProductsLnk() {
	return productsLnk;
}

public WebElement getMoreLnk() {
	return moreLnk;
}

public WebElement getCompaignsLnk() {
	return compaignsLnk;
}

public WebElement getAdministratorImg() {
	return administratorImg;
}

public WebElement getSignOutLnk() {
	return signOutLnk;
}
   
   //business Library
public void ClickOnOrgLnk()
{
	organizationLnk.click();
}
public void ClickOnContactLnk()
{
	contactsLnk.click();
}
public void ClickOnProductLnk()
{
	productsLnk.click();
}
public void ClickOnCompaignLnk()
{
	compaignsLnk.click();
}
public void ClickOnMore()
{
	moreLnk.click();
}
public void ClickOnQuickCreateDropDown(String contactname)
{
	select(contactname, quickCreateBtn);
}
public void newContactPopUp(String lastname1)
{
	lastNameEdt.sendKeys(lastname1);
}
public void newContactPopUpSaveBtn()
{
	newContactSaveBtn.click();
}
public void signOutOfApp(WebDriver driver)
{
	mouserHover(driver, administratorImg);
	signOutLnk.click();
}









}
