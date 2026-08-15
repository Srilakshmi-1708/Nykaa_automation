package com.nykaa.objectrepository;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class GuestCheckoutPage {
	
	
	WebDriver driver;
	WebDriverWait wait;

	public GuestCheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	// ---- CONFIRMED: bag icon in header ----
	private final By bagIcon = By.id("header-bag-icon");

	// ---- CONFIRMED: "Proceed" button in the bag drawer ----
	private final By proceedButton = By.cssSelector("button[data-test-id='footer-proceed-cta']");

	// ---- CONFIRMED: "Continue as guest" button ----
	private final By continueAsGuestButton = By.cssSelector("button[data-testid='button_continueAsGuest']");

	// ---- CONFIRMED: Pincode field ----
	private final By pincodeField = By.id("txt_pincode");

	// ---- CONFIRMED: House/Flat/Office No. field (id="txt_house") ----
	private final By houseFlatField = By.id("txt_house");

	// ---- VERIFY: remaining address form fields, pattern-matched off the
	// confirmed Pincode/House placeholder convention ----
	private final By roadAreaField = By.cssSelector("textarea[placeholder='Road Name/ Area /Colony']");
	private final By nameField = By.cssSelector("input[placeholder='Name']");
	private final By phoneField = By.cssSelector("input[placeholder='Phone']");
	private final By emailField = By.cssSelector("input[placeholder='Email']");

	// ---- VERIFY: "SHIP TO THIS ADDRESS" button (text-based) ----
	private final By shipToAddressButton = By.xpath(
			"//button[contains(translate(text(),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),'SHIP TO THIS ADDRESS')]");

	// ---- VERIFY: "Cash on delivery" payment option row (text-based) ----
	private final By cashOnDeliveryOption = By.xpath("//*[contains(text(),'Cash on delivery')]");

	// ---- VERIFY: "Place Order" button - only used to CONFIRM VISIBILITY,
	// this class intentionally has no method that clicks it ----
	private final By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");

	// ---- VERIFY: Grand Total price label in the bag drawer ----
	private final By grandTotalLabel = By.xpath("//*[contains(text(),'Grand Total')]");

	
	private void safeClick(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		try {
			element.click();
		} catch (ElementClickInterceptedException e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		}
	}

	
	private void safeType(By locator, String text) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.clear();
		element.sendKeys(text);

		String actualValue = element.getAttribute("value");
		if (actualValue == null || !actualValue.equals(text)) {
			((JavascriptExecutor) driver).executeScript(
					"var el = arguments[0]; var val = arguments[1];"
							+ "var nativeSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value')"
							+ " || Object.getOwnPropertyDescriptor(window.HTMLTextAreaElement.prototype, 'value');"
							+ "if (nativeSetter && nativeSetter.set) { nativeSetter.set.call(el, val); } else { el.value = val; }"
							+ "el.dispatchEvent(new Event('input', { bubbles: true }));"
							+ "el.dispatchEvent(new Event('change', { bubbles: true }));",
					element, text);
		}
	}

	public void clickBagIcon() {
		safeClick(bagIcon);
	}

	
	public boolean isGrandTotalDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(grandTotalLabel)).isDisplayed();
	}

	public void clickProceed() {
		safeClick(proceedButton);
	}

	public void clickContinueAsGuest() {
		safeClick(continueAsGuestButton);
	}

	public void fillAddressForm(String pincode, String houseFlat, String roadArea, String name, String phone,
			String email) {
		safeType(pincodeField, pincode);
		safeType(houseFlatField, houseFlat);
		safeType(roadAreaField, roadArea);
		safeType(nameField, name);
		safeType(phoneField, phone);
		safeType(emailField, email);
	}

	public void clickShipToThisAddress() {
		safeClick(shipToAddressButton);
	}

	
	private void switchToPaymentFrameIfPresent() {
		driver.switchTo().defaultContent();
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));
		} catch (org.openqa.selenium.TimeoutException e) {
			driver.switchTo().defaultContent();
		}
	}
	public void selectCashOnDelivery() {
		driver.switchTo().defaultContent();   // make sure we're in the main page, no iframe switch needed
		safeClick(cashOnDeliveryOption);
	}

	public boolean isPlaceOrderButtonVisible() {
		driver.switchTo().defaultContent();   // same here - Place Order is also in main DOM
		return wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton)).isDisplayed();
	}
//	public void selectCashOnDelivery() {
//		switchToPaymentFrameIfPresent();
//		safeClick(cashOnDeliveryOption);
//	}

	
//	public boolean isPlaceOrderButtonVisible() {
//		// Already inside the payment iframe from selectCashOnDelivery() -
//		// switching again here would be a no-op if still in context, but is
//		// called explicitly in case this method is ever used on its own.
//		switchToPaymentFrameIfPresent();
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderButton)).isDisplayed();
//	}

}
