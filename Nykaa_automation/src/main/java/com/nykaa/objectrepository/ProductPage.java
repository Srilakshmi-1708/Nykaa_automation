package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;                     //Rule 2:Object Creation
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@role='menubar']/descendant::a[.='makeup']")
	private WebElement makeupMenuLink;
	
	@FindBy(xpath="//ul[@role='menubar']/descendant::a[.='fragrance']")
	private WebElement fragranceMenuLink;
	
	@FindBy(xpath="//ul[@role='menubar']/descendant::a[.='hair']")
	private WebElement hairMenuLink;
	
	
	public WebElement getMakeupMenuLink() {
		return makeupMenuLink;
	}

	public WebElement getFragranceMenuLink() {
		return fragranceMenuLink;
	}

	

	public WebElement getHairMenuLink() {
		return hairMenuLink;
	}


	
	
	

     
}
