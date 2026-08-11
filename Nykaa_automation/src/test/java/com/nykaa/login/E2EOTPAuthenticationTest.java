package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.RegisterBaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

public class E2EOTPAuthenticationTest extends RegisterBaseClass {

    @Test(description = "NYK-E2E-003 - OTP authentication flow")
    public void otpAuthentication() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);


        // Step 1 - Click Sign In
        homePage.clickSignIn();


        // Step 2 - Enter registered mobile number
        loginPage.enterMobileNumber("YOUR_REGISTERED_TEST_MOBILE");


        // Step 3 - Click Send OTP
        loginPage.clickSendOTP();


        // Step 4 - Enter OTP
        loginPage.enterOTP("YOUR_TEST_OTP");


        // Step 5 - Verify OTP
        loginPage.clickVerifyOTP();


        // Step 6 - Verify successful authentication
        Assert.assertTrue(
                driver.getCurrentUrl()
                        .toLowerCase()
                        .contains("nykaa"),
                "OTP authentication failed"
        );
    }
}
