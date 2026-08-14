package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

/**
 * Smoke Test - NYK-REG-001: Register using a valid, unregistered mobile number.
 *
 * NOTE ON OTP:
 * Live Nykaa OTP is delivered via real SMS and cannot be intercepted/automated.
 * This test therefore stops right after "Send OTP" is clicked - it asserts
 * that the OTP entry screen was successfully triggered, then hands off to a
 * tester/automation-OTP-service for the remaining manual steps.
 */
public class NewUserRegistrationSmokeTest extends BaseClass {

	@Test(priority = 1, groups = { "smokeTest" },
		  description = "NYK-REG-001: Register using a valid, unregistered mobile number")
	public void newUserRegistration_enterMobileAndSendOTP() throws Throwable {

		// Test data pulled from the framework's Excel data source (Login sheet)
		String mobileNumber = eLib.getDataFromExcel("Login", 1, 1); // NYK-REG-001

		// Step 1: Tap the Sign In icon on the Home page
		HomePage hp = new HomePage(driver);
		hp.clickSignIn();

		// Step 2: Verify the 'Login or Signup' popup is displayed
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.isLoginSignupPopupDisplayed(),
				"'Login or Signup' popup was not displayed");

		// Step 3: Switch to the Mobile/Email entry option
		lp.clickMobileEmail();

		// Step 4: Enter a valid, unregistered 10-digit mobile number
		lp.enterMobileNumber(mobileNumber);

		// Step 5: Tap 'Continue' / 'Send OTP'
		lp.clickSendOTP();

		// Step 6 - STOPPING POINT: real OTP delivery can't be automated here.
		// We only verify that submitting the mobile number successfully triggered
		// the OTP screen.
		Assert.assertTrue(lp.isOtpFieldDisplayed(),
				"OTP entry screen did not appear after clicking Send OTP");

		System.out.println("[NYK-REG-001] OTP triggered for new mobile number " + mobileNumber
				+ ". PASS up to Send OTP - manual OTP entry required to complete registration.");
	}
}
