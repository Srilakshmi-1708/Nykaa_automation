package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

/**
 * Smoke Test - NYK-LOGIN-001: Login using an already registered mobile number.
 *
 * NOTE ON OTP:
 * Live Nykaa OTP is delivered via real SMS and cannot be intercepted/automated.
 * This test therefore stops right after "Send OTP" is clicked - it asserts
 * that the OTP entry screen was successfully triggered, then hands off to a
 * tester/automation-OTP-service for the remaining manual steps.
 */
public class ExistingUserLoginSmokeTest extends BaseClass {

	@Test(priority = 1, groups = { "smokeTest" },
		  description = "NYK-LOGIN-001: Login using an already registered mobile number")
	public void existingUserLogin_enterMobileAndSendOTP() throws Throwable {

		String mobileNumber = eLib.getDataFromExcel("Login", 2, 1); // NYK-LOGIN-001

		// Step 1: Tap Sign In
		HomePage hp = new HomePage(driver);
		hp.clickSignIn();

		// Step 2: Verify the 'Login or Signup' popup is displayed
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.isLoginSignupPopupDisplayed(),
				"'Login or Signup' popup was not displayed");

		// Step 3: Enter the registered mobile number
		lp.clickMobileEmail();
		lp.enterMobileNumber(mobileNumber);

		// Step 4: Tap Continue / Send OTP
		lp.clickSendOTP();

		// Step 5 - STOPPING POINT: verify OTP screen triggered, then stop.
		Assert.assertTrue(lp.isOtpFieldDisplayed(),
				"OTP entry screen did not appear after clicking Send OTP");

		System.out.println("[NYK-LOGIN-001] OTP triggered for registered mobile number " + mobileNumber
				+ ". PASS up to Send OTP - manual OTP entry required to complete login.");
	}
}
