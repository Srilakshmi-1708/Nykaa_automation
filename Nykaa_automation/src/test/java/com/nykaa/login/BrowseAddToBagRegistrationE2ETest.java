package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;
import com.nykaa.objectrepository.ProductDetailsPage;

/**
 * End-to-End Test - NYK-E2E-001: New user browses, adds a product to bag,
 * then attempts registration via mobile OTP at checkout (stops at OTP screen).
 *
 * NOTE ON OTP:
 * Live Nykaa OTP is delivered via real SMS and cannot be intercepted/automated.
 * This flow automates every step that IS possible (search, PDP, add-to-bag,
 * navigating the Sign In popup, submitting the mobile number and triggering
 * Send OTP) and stops right after the OTP screen appears.
 */
public class BrowseAddToBagRegistrationE2ETest extends BaseClass {

	@Test(priority = 1, groups = { "regressionTest", "endToEndTest" },
		  description = "NYK-E2E-001: New user browses, adds a product to bag, then attempts "
		  		+ "registration via mobile OTP at checkout (stops at OTP screen)")
	public void browseAddToBag_thenRegisterViaMobileOTP() throws Throwable {

		String mobileNumber = eLib.getDataFromExcel("Login", 3, 1); // NYK-E2E-001

		// Step 1: Search for a product as a guest
		HomePage hp = new HomePage(driver);
		hp.searchProduct("lipstick");

		// Step 2: Open the first product from the search results (PDP)
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.openFirstSearchResult();

		Assert.assertTrue(pdp.isProductImageDisplayed(), "Product image not displayed on PDP");
		Assert.assertTrue(pdp.isPriceDisplayed(), "Product price not displayed on PDP");
		Assert.assertTrue(pdp.isAddToBagButtonPresent(), "'Add to Bag' button not present on PDP");

		// Step 3: Add the product to the bag
		pdp.clickAddToBag();

		// Step 4: Proceed towards checkout, which requires signing in
		HomePage hpAfterAdd = new HomePage(driver);
		hpAfterAdd.clickSignIn();

		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.isLoginSignupPopupDisplayed(),
				"'Login or Signup' popup was not displayed");

		// Step 5: Register using a new/unregistered mobile number
		lp.clickMobileEmail();
		lp.enterMobileNumber(mobileNumber);
		lp.clickSendOTP();

		// STOPPING POINT: OTP automation is not possible on the live site.
		Assert.assertTrue(lp.isOtpFieldDisplayed(),
				"OTP entry screen did not appear after clicking Send OTP");

		System.out.println("[NYK-E2E-001] Product added to bag; OTP triggered for new registration "
				+ mobileNumber + ". Manual OTP entry required to complete registration, "
				+ "profile completion, address entry and checkout.");
	}
}
