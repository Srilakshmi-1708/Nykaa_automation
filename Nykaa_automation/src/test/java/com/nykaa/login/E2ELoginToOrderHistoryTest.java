package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.RegisterBaseClass;
import com.nykaa.objectrepository.AccountPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;

public class E2ELoginToOrderHistoryTest extends RegisterBaseClass {

    @Test(description = "NYK-E2E-002 - Login to order history")
    public void loginToOrderHistory() {

        HomePage homePage = new HomePage(driver);

        LoginPage loginPage = new LoginPage(driver);

        AccountPage accountPage = new AccountPage(driver);


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


        // Step 6 - Open Account
        accountPage.clickAccount();


        // Step 7 - Open My Orders
        accountPage.clickMyOrders();


        // Step 8 - Verify My Orders page
        Assert.assertTrue(
                driver.getPageSource()
                        .toLowerCase()
                        .contains("order"),
                "My Orders page is not displayed"
        );


        // Step 9 - Logout
        accountPage.logout();


        // Step 10 - Verify logout
        Assert.assertTrue(
                driver.getTitle()
                        .toLowerCase()
                        .contains("nykaa"),
                "Logout was not successful"
        );
    }
}
