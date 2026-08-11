package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandsPage {
	WebDriver driver;                     //Rule 2:Object Creation
	public BrandsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='brandCont_Popular']/descendant::li[@class='brand-logo menu-links']/a/img[@alt='Dot & Key Logo']")
	private WebElement dotAndKeyBrandLogo;
	public WebElement getDotAndKeyBrandLogo() {
		return dotAndKeyBrandLogo;
	}
	
	@FindBy(xpath = "//div[@id='title']")
	private WebElement BrandPageTitle;
	public WebElement getBrandPageTitle() {
		return BrandPageTitle;
	}
	
	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement brandPageNextButton;
	public WebElement getBrandPageNextButton() {
		return brandPageNextButton;
	}
	
	@FindBy(xpath = "//p[text()='No More Products to Show']")
	private WebElement noMoreProductsToShowMessage;
	public WebElement getNoMoreProductsToShowMessage() {
		return noMoreProductsToShowMessage;
	}
	
	@FindBy(xpath = "//div[@id='product-list-wrap']/div[1]/descendant::h2")
	private WebElement firstProductNameOfBrandPage;
	public WebElement getFirstProductNameOfBrandPage() {
		return firstProductNameOfBrandPage;
	}

}
