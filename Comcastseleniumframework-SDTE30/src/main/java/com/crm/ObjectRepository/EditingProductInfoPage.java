package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingProductInfoPage 
{
  @FindBy(name = "productname")
  private WebElement productnameEdt;
   
  @FindBy(xpath = "//input[@title='Save [Alt+S]']")
  private WebElement saveBtn;
  
  public EditingProductInfoPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getProductnameEdt() {
	return productnameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
  //business library
public void clickOnProductNameEdt(String editproductname)
{
	productnameEdt.clear();
	productnameEdt.sendKeys(editproductname);
}
public void clickOnSave()
{
	saveBtn.click();
}

}
