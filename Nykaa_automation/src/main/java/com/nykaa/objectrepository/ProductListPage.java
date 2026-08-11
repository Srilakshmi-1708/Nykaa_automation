package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	WebDriver driver; // Rule 2:Object Creation

	public ProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='product-list-wrap']/descendant::a[1]")
	private WebElement lisptick;

	@FindBy(xpath = "//div[@id='product-list-wrap']/descendant::a[1]")
	private WebElement hairoil;

	@FindBy(xpath = "//div[@id='product-list-wrap']/descendant::a[1]")
	private WebElement fragrance;
    
	@FindBy(xpath="//div[@id='product-list-wrap']/descendant::a[1]/descendant::h2")
	private WebElement productName;
	
	public WebElement getProductName()
	{
		return productName;
	}
	
	
	public WebElement getLisptick() {
		return lisptick;
	}

	public WebElement getHairoil() {
		return hairoil;
	}

	public WebElement getFragrance() {
		return fragrance;
	}

}
