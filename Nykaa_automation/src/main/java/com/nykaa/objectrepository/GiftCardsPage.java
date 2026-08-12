package com.nykaa.objectrepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardsPage {
	
	WebDriver driver;                     //Rule 2:Object Creation
	public GiftCardsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='To']")
	private WebElement toTextField;
	
	@FindBy(id="recipientEmail")
	private WebElement recipientEmailTextField;
	
	@FindBy(xpath="//textarea")
	private WebElement giftCardMessage;
	
	@FindBy(xpath="//button[text()='1000']")
	private WebElement amountField;
	
	@FindBy(xpath="//input[@id='senderName']")
	private WebElement fromTextField;
	
	@FindBy(xpath="//input[@id='senderMobile']")
	private WebElement senderPhoneTextField;
	
	@FindBy(xpath="//button[.='PROCEED TO PAY']")
	private WebElement checkoutLink;
	
	
	
	
	public void giftCardDetails(WebDriver driver,String to,String rcpemail,String message,String from,String phone )
	{
		toTextField.sendKeys(to);
		recipientEmailTextField.sendKeys(rcpemail);
		giftCardMessage.sendKeys(message);
		amountField.click();
		fromTextField.sendKeys(from);
		senderPhoneTextField.sendKeys("phone");
		checkoutLink.click();
    }

}
