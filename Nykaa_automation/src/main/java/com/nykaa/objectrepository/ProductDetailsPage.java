package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver; // Rule 2:Object Creation

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[.='Add to Bag']/parent::button")
	private WebElement addToBagButton;
	
	
	public WebElement getAddToBagButton()
	{
		return addToBagButton;
	}
	
}
