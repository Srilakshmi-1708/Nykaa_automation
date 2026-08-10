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
	
	 @FindBy(xpath = "//button[@class='css-1gzc5zn']")
	    private WebElement signInButton;

	    @FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	    private WebElement searchBox;

	    @FindBy(xpath = "//*[contains(normalize-space(),'Bag')]")
	    private WebElement bagIcon;

	    @FindBy(xpath = "//*[contains(normalize-space(),'Account')]")
	    private WebElement accountIcon;

	    public void clickSignIn() {
	        signInButton.click();
	    }

	    public void searchProduct(String productName) {
	        searchBox.click();
	        searchBox.sendKeys(productName);
	        searchBox.submit();
	    }

	    public void clickBag() {
	        bagIcon.click();
	    }

	    public void clickAccount() {
	        accountIcon.click();
	    }
	}
