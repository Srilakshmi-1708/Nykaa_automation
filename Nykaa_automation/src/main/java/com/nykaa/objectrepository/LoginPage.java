package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nykaa.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility { // Rule 1: create a seperate java class

	WebDriver driver; // Rule 2:Object Creation

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(normalize-space(),'Login or Signup')]")
	private WebElement loginSignupPopup;

	@FindBy(xpath = "//button[@class='css-1na4kzg']")
	private WebElement mobileEmailOption;

	@FindBy(xpath = "//input[@class='css-1ytd58c']")
	private WebElement mobileNumberField;

	@FindBy(xpath = "//button[@class='css-15q5a8e']")
	private WebElement sendOtpButton;

	@FindBy(xpath = "//input[contains(@placeholder,'OTP') or @maxlength='6']")
	private WebElement otpField;

	@FindBy(xpath = "//button[contains(normalize-space(),'Verify') or contains(normalize-space(),'Submit') or contains(normalize-space(),'Login')]")
	private WebElement verifyOtpButton;

	public boolean isLoginSignupPopupDisplayed() {
		return loginSignupPopup.isDisplayed();
	}

	public void clickMobileEmail() {
		mobileEmailOption.click();
	}

	public void enterMobileNumber(String mobile) {
		// mobileNumberField.clear();
		mobileNumberField.sendKeys(mobile);
	}

	public void clickSendOTP() {
		sendOtpButton.click();
	}

	public void enterOTP(String otp) {
		otpField.clear();
		otpField.sendKeys(otp);
	}

	public void clickVerifyOTP() {
		verifyOtpButton.click();
	}

}
