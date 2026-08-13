package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

/**
 * End-to-End Test - NYK-E2E-002: Existing user attempts login via mobile OTP
 * prior to reviewing order history (stops at OTP screen).
 *
 * NOTE ON OTP:
 * Live Nykaa OTP is delivered via real SMS and cannot be intercepted/automated.
 * This flow stops right after the OTP screen appears, logging what would need
 * to happen manually to finish the journey (enter OTP -> My Orders -> Logout).
 */
public class ExistingUserLoginOrderHistoryE2ETest extends BaseClass {

	@Test(priority = 1, groups = { "regressionTest", "endToEndTest" },
		  description = "NYK-E2E-002: Existing user attempts login via mobile OTP prior to "
		  		+ "reviewing order history (stops at OTP screen)")
	public void existingUserLoginAttempt_forOrderHistoryReview() throws Throwable {

		String mobileNumber = eLib.getDataFromExcel("Login", 4, 1); // NYK-E2E-002

		// Step 1: Verify the user has landed on the Nykaa Home page
		Assert.assertTrue(wLib.getUrl(driver).contains("nykaa.com"),
				"Did not land on the Nykaa Home page");

		// Step 2: Tap Sign In
		HomePage hp = new HomePage(driver);
		hp.clickSignIn();

		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.isLoginSignupPopupDisplayed(),
				"'Login or Signup' popup was not displayed");

		// Step 3: Enter the registered mobile number and trigger OTP
		lp.clickMobileEmail();
		lp.enterMobileNumber(mobileNumber);
		lp.clickSendOTP();

		// STOPPING POINT: OTP automation is not possible on the live site.
		Assert.assertTrue(lp.isOtpFieldDisplayed(),
				"OTP entry screen did not appear after clicking Send OTP");

		System.out.println("[NYK-E2E-002] OTP triggered for registered mobile number " + mobileNumber
				+ ". Manual OTP entry required to log in, then continue to My Orders > "
				+ "order details > Home > Logout.");
	}
}
