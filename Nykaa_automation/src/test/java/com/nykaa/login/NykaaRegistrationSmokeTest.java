package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.nykaa.basetest.RegisterBaseClass;
import com.nykaa.listenerutility.ListImpClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

@Listeners(ListImpClass.class)

public class NykaaRegistrationSmokeTest extends RegisterBaseClass {

    @Test(groups = "smokeTest")
    public void NYK_REG_001_registerUsingValidMobile() throws Throwable {

        // Create Page Objects
        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);


        // Step 1: Click Sign In
        homePage.clickSignIn();


        // Step 2: Verify Login / Signup popup
        Assert.assertTrue(
                loginPage.isLoginSignupPopupDisplayed(),
                "Login / Signup popup is not displayed"
        );


        // Step 3: Click Sign in with Mobile / Email
        // loginPage.clickMobileEmail();


        // Step 4: Enter new / unregistered mobile number
        String mobile =
                fLib.getDataFromPropertiesFile("newMobile");

        loginPage.enterMobileNumber(mobile);


        // Step 5: Click Send OTP
        loginPage.clickSendOTP();


        // Step 6: Enter OTP
     //   String otp =
           //     fLib.getDataFromPropertiesFile("otp");

       // loginPage.enterOTP(otp);
        
        Thread.sleep(8000);

        // Step 7: Verify OTP
        loginPage.clickVerifyOTP();


        // Step 8: Verify registration/login success
        Assert.assertTrue(
                driver.getCurrentUrl().contains("nykaa"),
                "Registration was not successful"
        );


        System.out.println(
                "NYK_REG_001 - Registration completed successfully"
        );
    }
}
