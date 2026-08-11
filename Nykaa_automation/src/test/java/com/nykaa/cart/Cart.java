package com.nykaa.cart;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.CartPage;
import com.nykaa.objectrepository.CouponPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.ProductDetailsPage;
import com.nykaa.objectrepository.ProductListPage;

public class Cart extends BaseClass {

	@Test(groups = "smoke")
	public void toVerifyMultipleProductsAddedToCartTest() throws Throwable { // Login
		HomePage hp = new HomePage(driver);

		// to add first product
		hp.searchProduct("lipstick");
		ProductListPage plp = new ProductListPage(driver);
		String product1 = plp.getProductName().getText();
		plp.getLisptick().click();

		wLib.switchToTabOnTitle(driver, product1);

		ProductDetailsPage pdp = new ProductDetailsPage(driver);

		pdp.getAddToBagButton().click();
		 wLib.toWaitForElementToBeClickable(driver,pdp.getAddToBagButton());	
		 
		// add second product
		hp.searchProduct("hair oil");
		String product2 = plp.getProductName().getText();
		plp.getHairoil().click();
		wLib.switchToTabOnTitle(driver, product2);

		pdp.getAddToBagButton().click();
		 wLib.toWaitForElementToBeClickable(driver,pdp.getAddToBagButton());	

		// add third product
		hp.searchProduct("fragrance");
		String product3 = plp.getProductName().getText();
		plp.getFragrance().click();
		wLib.switchToTabOnTitle(driver, product3);

		pdp.getAddToBagButton().click();
		 wLib.toWaitForElementToBeClickable(driver,pdp.getAddToBagButton());	

		// Go to Bag icon

		hp.clickBag();

		//to verify bag page is opened successfully
		CartPage cp = new CartPage(driver);
		String actTitle = cp.getTitle().getText();
		
		
		Assert.assertEquals(actTitle, "Bag","Bag page opened succesfully");
		
		//to verify multiple product are added to bag
          
		Assert.assertTrue(cp.isProductPresentInBag(product1));
		Assert.assertTrue(cp.isProductPresentInBag(product2));
		Assert.assertTrue(cp.isProductPresentInBag(product3));
		
	}

	@Test(groups="smoke")
	public void toVerifyToRemoveProductFromCartTest() {
		HomePage hp = new HomePage(driver);

		// to add first product
		hp.searchProduct("lipstick");
		ProductListPage plp = new ProductListPage(driver);
		String product1 = plp.getProductName().getText();
		plp.getLisptick().click();

		wLib.switchToTabOnTitle(driver, product1);

		ProductDetailsPage pdp = new ProductDetailsPage(driver);

		pdp.getAddToBagButton().click();
        wLib.toWaitForElementToBeClickable(driver,pdp.getAddToBagButton());	
        // Go to Bag icon

		hp.clickBag();

		CartPage cp = new CartPage(driver);
		String actTitle = cp.getTitle().getText();
		Assert.assertEquals(actTitle, "Bag","Bag page is opened successfully");
		
		// Click on remove icon
        cp.getDeleteButton().click();
        //click remove for confirmation
        cp.getYesButton().click();
       
        Assert.assertFalse(
                cp.isProductPresent(product1)
        );
        
	}
	
	
	@Test(groups="smoke")
	public void toVerifyCouponAvailableForNonLoggedInUsersTest()
	{HomePage hp = new HomePage(driver);

	// to add first product
	hp.searchProduct("lipstick");
	ProductListPage plp = new ProductListPage(driver);
	String product1 = plp.getProductName().getText();
	plp.getLisptick().click();

	wLib.switchToTabOnTitle(driver, product1);

	ProductDetailsPage pdp = new ProductDetailsPage(driver);

	pdp.getAddToBagButton().click();
    wLib.toWaitForElementToBeClickable(driver,pdp.getAddToBagButton());	
    // Go to Bag icon

	hp.clickBag();
    //To verify bag page open successfully
	CartPage cp = new CartPage(driver);
	String actTitle = cp.getTitle().getText();
	Assert.assertEquals(actTitle, "Bag","Bag page is opened successfully");
	//to click on coupon link
	cp.toApplyCoupon();
	
	//To verify coupon & offer page is displayed
	

	CouponPage cop=new CouponPage(driver);
	wLib.switchToFrame(driver,cop.getFrameElement());
	String actT=cop.getCouponTitle().getText().trim();
	System.out.println(actT);
	
	Assert.assertEquals(actT,"Coupons & Offers");
	
	
		
	}

}
