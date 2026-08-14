package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

/**
 * End-to-End Test - NYK-E2E-003: Full Send-OTP verification-status flow,
 * driven across every mobile number configured in the test data sheet
 * (stops at OTP screen for each row).
 *
 * NOTE ON OTP:
 * Live Nykaa OTP is delivered via real SMS and cannot be intercepted/automated.
 * For each mobile number in the "Login" sheet, this flow re-opens the Sign In
 * popup, submits the number, triggers Send OTP, and verifies the OTP screen
 * appeared - the full send-otp-status flow that can be automated end-to-end.
 */
public class FullOtpSendFlowDataDrivenE2ETest extends BaseClass {

	@Test(priority = 1, groups = { "regressionTest", "endToEndTest" },
		  description = "NYK-E2E-003: Full data-driven Send-OTP verification-status flow across "
		  		+ "every mobile number configured in the test data sheet (stops at OTP screen)")
	public void fullOtpSendFlow_dataDriven() throws Throwable {

		int rowCount = eLib.getRowCount("Login"); // last data row index (header = row 0)

		for (int i = 1; i <= rowCount; i++) {

			String mobileNumber = eLib.getDataFromExcel("Login", i, 1);

			// Reset to a fresh Home page for every iteration
			driver.navigate().refresh();
			wLib.waitForPageToLoad(driver);

			HomePage hp = new HomePage(driver);
			hp.clickSignIn();

			LoginPage lp = new LoginPage(driver);
			Assert.assertTrue(lp.isLoginSignupPopupDisplayed(),
					"'Login or Signup' popup was not displayed for row " + i);

			lp.clickMobileEmail();
			lp.enterMobileNumber(mobileNumber);
			lp.clickSendOTP();

			// STOPPING POINT: OTP automation is not possible on the live site.
			Assert.assertTrue(lp.isOtpFieldDisplayed(),
					"OTP entry screen did not appear for mobile: " + mobileNumber);

			System.out.println("[NYK-E2E-003][Row " + i + "] OTP triggered for " + mobileNumber
					+ ". Manual OTP entry required to complete verification/login for this row.");
		}
	}
}
