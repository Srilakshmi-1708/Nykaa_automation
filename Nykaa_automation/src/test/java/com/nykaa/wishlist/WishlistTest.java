package com.nykaa.wishlist;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.ProductDetailsPage;
import com.nykaa.objectrepository.WishlistPage;

/**
 * TC_PW_002 - Verify guest is redirected to Login when adding to Wishlist.
 *
 * Guest user (no login implemented yet). Expected behavior: tapping the
 * wishlist icon should redirect to / show the Login page, not wishlist
 * directly.
 *
 * Test Data: Wishlist sheet, row 1, col 1 -> SearchProduct
 */
public class WishlistTest extends BaseClass {

	@Test(groups = { "smokeTest" },
		  description = "TC_PW_002 - Verify guest is redirected to Login when adding to Wishlist")
	public void tc_pw_002_verifyAddToWishlist() throws Throwable {

		// Excel: Wishlist sheet, row 1, col 1 -> SearchProduct
		String searchTerm = eLib.getDataFromExcel("ProductDetails", 1, 1);

		// Step 1: Search (search box now on HomePage)
		HomePage hp = new HomePage(driver);
		hp.searchForProduct(searchTerm);

		// Step 2: Open first product -> PDP
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.openFirstSearchResult();

		// Step 3: Tap the wishlist/heart icon
		WishlistPage wishlist = new WishlistPage(driver);
		wishlist.tapWishlistIcon();

		// Expected Result: guest is redirected to / shown the Login page
		Assert.assertTrue(wishlist.isRedirectedToLoginPage(),
				"Guest user should be redirected to the Login page when attempting to wishlist a product");
	}
}