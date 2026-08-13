package com.nykaa.objectrepository;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WishlistPage {
	
	WebDriver driver;
	WebDriverWait wait;
 
	public WishlistPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
 
	// ---- VERIFY: wishlist/heart icon on PDP ----
	private final By wishlistIcon = By.xpath("//button[contains(@aria-label,'Add to wishlist')]");
	//private final By wishlistIcon = By.cssSelector("button.wishlist-icon, div.pdp-wishlist-icon, i.icon-heart");
 
	// ---- VERIFY: an element that only appears on/inside the Login page or
	// login modal, e.g. the phone number / email input, or a "Login" heading ----
	private final By loginPageIndicator = By.xpath("//span[text()='Login or Signup']");
 
	public void tapWishlistIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(wishlistIcon)).click();
	}
	
	public boolean isRedirectedToLoginPage() {

	    try {
	        // Option 1: Check login popup button
	        boolean loginVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        		By.xpath("//span[text()='Login or Signup']")))
	        .isDisplayed();

	        return loginVisible;

	    } catch (Exception e) {
	        return false;
	    }
	}

}
