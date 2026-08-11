package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;
import com.nykaa.listenerutility.ListImpClass;

@Listeners(ListImpClass.class)

public class Nykaa_Signin_SmokeTests extends BaseClass {

    @Test(groups = "smokeTest")
    public void NYK_LOGIN_001_validRegisteredMobileLogin() throws Throwable {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Click Sign In
        homePage.clickSignIn();

        // Step 2: Verify Login/Signup popup
        Assert.assertTrue(
                loginPage.isLoginSignupPopupDisplayed(),
                "Login/Signup popup is not displayed"
        );

        // Step 3: Click Sign in with Mobile / Email
        loginPage.clickMobileEmail();

        // Step 4: Enter registered mobile number
        loginPage.enterMobileNumber(
                fLib.getDataFromPropertiesFile("registeredMobile")
        );

        // Step 5: Click Send OTP
        loginPage.clickSendOTP();
        
        Thread.sleep(8000);

        // Step 6: Enter valid OTP
      //  loginPage.enterOTP(
           //     fLib.getDataFromPropertiesFile("otp")
     //   );

        // Step 7: Verify OTP
        loginPage.clickVerifyOTP();

        // Step 8: Verify successful login
        Assert.assertTrue(
                driver.getCurrentUrl().contains("nykaa"),
                "User is not logged in successfully"
        );
    }
}
