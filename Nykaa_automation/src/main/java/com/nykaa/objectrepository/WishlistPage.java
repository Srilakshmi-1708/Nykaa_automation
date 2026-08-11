package com.nykaa.objectrepository;


	 
	import java.time.Duration;
	 
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	 
	/**
	 * Object repository for the Wishlist action on the PDP.
	 * Covers Zephyr Scale test case TC_PW_002 (Smoke - Wishlist module) as a
	 * GUEST user: tapping the wishlist icon without being logged in should
	 * redirect to / prompt the Login page.
	 *
	 * NOTE ON LOCATORS: the locators below are placeholders (marked VERIFY).
	 * Inspect the real Nykaa PDP and login page (right-click -> Inspect) and
	 * update them before this test will pass.
	 */
	public class WishlistPage extends com.nykaa.webdriverutility.WebDriverUtility {
	 
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
	 
		/**
		 * Verifies the guest user was redirected to (or shown) the Login page
		 * after attempting to wishlist a product. Checks both the URL and a
		 * visible login-page element, since Nykaa may implement this as either
		 * a full page redirect or an in-page login modal - VERIFY which one
		 * the real site uses and simplify this method accordingly once known.
		 */
//		public boolean isRedirectedToLoginPage() {
//			boolean urlIndicatesLogin = false;
//			try {
//				urlIndicatesLogin = wait.until(ExpectedConditions.urlContains("login"));
//			} catch (Exception e) {
//				// URL never changed to include "login" - fall back to element check below
//			}
//	 
//			boolean loginElementVisible = driver.findElements(loginPageIndicator).size() > 0;
//	 
//			return urlIndicatesLogin || loginElementVisible;
//		}
		
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


