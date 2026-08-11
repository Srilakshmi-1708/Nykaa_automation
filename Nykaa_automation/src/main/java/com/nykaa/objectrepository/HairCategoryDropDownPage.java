package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HairCategoryDropDownPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public HairCategoryDropDownPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='MegaDropdowntopWrapper']/descendant::a[text()='hair care']/ancestor::div[@class='megaDropdown']/descendant::a[text()='Shampoo']")
	private WebElement shampooDropdownLink;
	public WebElement getShampooLink() {
		return shampooDropdownLink;
	}
	
	@FindBy(xpath = "//span[@class='sort-name']")
	private WebElement sortByDropdown;
	public WebElement getSortByDropdown() {
		return sortByDropdown;
	}
	
	@FindBy(xpath = "(//div[@id='product-list-wrap']/descendant::div[@class='productWrapper css-17nge1h']/descendant::h2)[1]")
	private WebElement firstProductOfShampooCategory;
	public WebElement getFirstProductOfShampooCategory() {
		return firstProductOfShampooCategory;
	}

}
