package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public SearchResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@id='title']")
	private WebElement searchResultTitle;
	public WebElement getSearchResult() {
		return searchResultTitle;
	}

}
