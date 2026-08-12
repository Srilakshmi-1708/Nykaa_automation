package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nykaa.fileutility.ExcelUtility;
public class AddressPage {
	
	ExcelUtility elib=new ExcelUtility();
	WebDriver driver;                     //Rule 2:Object Creation
	public AddressPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[text()='ADD NEW ADDRESS']")
	private WebElement addAddressLink;
	
	@FindBy(xpath = "//input[@label='Name']")
	private WebElement nameEdt;
	
	@FindBy(xpath = "//input[@label='Mobile Number']")
	private WebElement mobileEdt;
	
	@FindBy(xpath = "//input[@label='Postal Code']")
	private WebElement pincodeEdt;
	
	@FindBy(xpath = "//input[@label='Postal Code']")
	private WebElement addressEdt;
	
	@FindBy(xpath = "//button[text()='Add Address']")
	private WebElement addAddressBtn;
	
	@FindBy(xpath = "//div[@class='css-13slnr0']/descendant::div[text()='Address added successfully']")
	private WebElement addressSuccessPopup;
	
	public WebElement getAddressSuccessPopup() {
		return addressSuccessPopup;
	}


	public WebElement getAddAddressBtn() {
		return addAddressBtn;
	}


	public WebElement getNameEdt() {
		return nameEdt;
	}


	public WebElement getMobileEdt() {
		return mobileEdt;
	}


	public WebElement getPincodeEdt() {
		return pincodeEdt;
	}


	public WebElement getAddressEdt() {
		return addressEdt;
	}


	public WebElement getAddAddressLink() {
		return addAddressLink;
	}
	 public void addAddress(String name,String mobnum,String pincode,String address) throws Throwable {
		   getAddAddressLink().click();
		   getNameEdt().sendKeys(name);
		   getMobileEdt().sendKeys(mobnum);
		   getPincodeEdt().sendKeys(pincode);
		   getAddressEdt().sendKeys(address);
		   getAddAddressBtn().click();
	   }

}
