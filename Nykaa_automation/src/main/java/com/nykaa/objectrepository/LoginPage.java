 package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nykaa.webdriverutility.WebDriverUtility;



public class LoginPage extends WebDriverUtility{ //Rule 1: create a seperate java class
	
	WebDriver driver;                     //Rule 2:Object Creation
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
     
	
      
}
