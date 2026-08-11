package com.nykaa.wishlist;
	 
	import org.testng.Assert;
	import org.testng.annotations.Test;
	 
	import com.nykaa.basetest.BaseClass;
	import com.nykaa.objectrepository.PDPPage;
	import com.nykaa.objectrepository.WishlistPage;
	 
	/**
	 * Zephyr Scale Test Case: TC_PW_002
	 * Title: Verify user can add a product to Wishlist
	 * Type: Smoke | Module: Wishlist
	 *
	 * Run as a GUEST user (login not implemented in this framework yet - see
	 * BaseClass.configBM()). Expected behavior for a guest tapping the
	 * wishlist icon is a redirect to / prompt for the Login page, not the
	 * icon activating directly.
	 *
	 * Test Data: searchProduct key in commonData.properties
	 *
	 * Steps:
	 * 1. Search for a product and open its PDP
	 * 2. Tap the wishlist/heart icon
	 *
	 * Expected Result: User is redirected to (or shown) the Login page,
	 * since wishlisting requires an authenticated session.
	 */
	public class WishlistTest extends BaseClass {
	 
		@Test(groups = { "smokeTest" }, description = "TC_PW_002 - Verify guest is redirected to Login when adding to Wishlist")
		public void tc_pw_002_verifyAddToWishlist() throws Throwable {
	 
			String url = fLib.getDataFromPropertiesFile("url");
			driver.get(url);
	 
			String searchTerm = fLib.getDataFromPropertiesFile("searchProduct");
	 
			// Step 1: Search for a product and open its PDP
			PDPPage pdp = new PDPPage(driver);
			pdp.searchForProduct(searchTerm);
			pdp.openFirstSearchResult();
	 
			// Step 2: Tap the wishlist/heart icon
			WishlistPage wishlist = new WishlistPage(driver);
			wishlist.tapWishlistIcon();
	 
			// Expected Result: guest is redirected to / shown the Login page
			Assert.assertTrue(wishlist.isRedirectedToLoginPage(),
					"Guest user should be redirected to the Login page when attempting to wishlist a product");
		}
	}

