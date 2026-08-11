package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
   
	@FindBy(xpath = "//input[@name='search-suggestions-nykaa']")
	private WebElement searchTF;
	public WebElement getSearchTF() {
		return searchTF;
	}
	
	@FindBy(xpath = "//nav[@id='my-menu']/descendant::a[text()='makeup']")
	private WebElement makeupMenu;
	public WebElement getMakeupMenu() {
		return makeupMenu;
	}
	
	@FindBy(xpath = "//nav[@id='my-menu']/descendant::a[text()='hair']")
	private WebElement hairMenu;
	public WebElement getHairMenu() {
		return hairMenu;
	}
	
	@FindBy(xpath = "//a[text()='brands']")
	private WebElement brandsMenu;
	public WebElement getBrandsMenu() {
		return brandsMenu;
	}


   
  
	
   
   
}



