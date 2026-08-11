package com.nykaa.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.RegisterBaseClass;
import com.nykaa.objectrepository.CartPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;
import com.nykaa.objectrepository.ProductPage;

public class E2ERegistrationToCheckoutTest extends RegisterBaseClass {

    @Test(description = "NYK-E2E-001 - New user registration to checkout")
    public void registrationToCheckout() {

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);
        // Step 1 - Click Sign In
        homePage.clickSignIn();

        // Step 2 - Enter new mobile number
        loginPage.enterMobileNumber("YOUR_NEW_MOB_NUMBER");

        // Step 3 - Click Send OTP
        loginPage.clickContinue();

        // Step 4 - Enter OTP
       loginPage.enterOTP("YOUR_TEST_OTP");

        // Step 5 - Verify OTP
        loginPage.clickVerifyOTP();

        // Step 6 - Search product
        homePage.searchProduct("Maybelline Mascara");

        // Step 7 - Select product
        productPage.selectProduct();

        // Step 8 - Add product to bag
        productPage.addProductToBag();

        // Step 9 - Open bag
        cartPage.openBag();

        // Step 10 - Proceed to checkout
        cartPage.clickProceedToCheckout();

        // Step 11 - Verify checkout/address page
        Assert.assertTrue(
                driver.getCurrentUrl().toLowerCase().contains("checkout")
                || driver.getPageSource().toLowerCase().contains("address"),
                "Checkout/Address page is not displayed"
        );
    }
 }