package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandsPage {
	WebDriver driver;
	public BrandsPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='brandCont_Popular']/descendant::li[@class='brand-logo menu-links']/a/img[@alt='Dot & Key Logo']")
	private WebElement dotAndKeyBrandLogo;
	public WebElement getDotAndKeyBrandLogo() {
		return dotAndKeyBrandLogo;
	}
	
	@FindBy(xpath="//div[@id='title']")
	private WebElement brandPageTitle;
	public WebElement getBrandPageTitle() {
		return brandPageTitle;
	}
	
	@FindBy(xpath = "(//div[@id='product-list-wrap']/div[@class='productWrapper css-17nge1h']/descendant::h2)[1]")
	private WebElement firstProductNameOfBrandPage;
	public WebElement getFirstProductNameOfBrandPage() {
		return firstProductNameOfBrandPage;
	}
	
	@FindBy(xpath = "//a[@aria-label='Next page']")
	private WebElement brandPageNextButton;
	public WebElement getBrandPageNextButton() {
		return brandPageNextButton;
	}

}
