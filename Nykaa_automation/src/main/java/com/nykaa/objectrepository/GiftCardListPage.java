package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardListPage {
	WebDriver driver;                     //Rule 2:Object Creation
	public GiftCardListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Birthday']/ancestor::div[@class='inner']/descendant::div/descendant::span[text()='SEND']/parent::button")
	private  WebElement birthdayGiftCardLink;
	
	
	@FindBy(xpath="//div[text()='Wedding']/ancestor::div[@class='inner']/descendant::div/descendant::span[text()='SEND']/parent::button")
	private  WebElement weddingGiftCardLink;
	
	@FindBy(xpath="//p[.='E-Gift Card']")
	private WebElement egiftcardTitle;
	
	public WebElement getEgiftcardTitle() {
		return egiftcardTitle;
	}

	

	public WebElement getBirthdayGiftCardLink()
	{
		return birthdayGiftCardLink;
	}



	public WebElement getWeddingGiftCardLink() {
		return weddingGiftCardLink;
	}


}
