
package com.nykaa.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.GuestCheckoutPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.ProductDetailsPage;

public class GuestCheckoutTest extends BaseClass {

	@Test(groups = {
			"smokeTest" }, description = "TC_PW_E2E_001 - Guest checkout flow through to Place Order visibility")
	public void tc_pw_e2e_001_guestCheckoutFlow() throws Throwable {

		// Excel: Address sheet, row 1
		String searchTerm = eLib.getDataFromExcel("Address", 1, 1);
		String pincode = eLib.getDataFromExcel("Address", 1, 2);
		String houseFlat = eLib.getDataFromExcel("Address", 1, 3);
		String roadArea = eLib.getDataFromExcel("Address", 1, 4);
		String name = eLib.getDataFromExcel("Address", 1, 5);
		String phone = eLib.getDataFromExcel("Address", 1, 6);
		String email = eLib.getDataFromExcel("Address", 1, 7);

		// Step 1: Search (search box now on HomePage), open PDP, Add to Bag
		HomePage hp = new HomePage(driver);
		hp.searchForProduct(searchTerm);

		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.openFirstSearchResult();
		pdp.clickAddToBag();

		GuestCheckoutPage checkout = new GuestCheckoutPage(driver);

		// Step 2: Click the Bag icon
		checkout.clickBagIcon();

		// Step 3: Verify Grand Total price is showing
		Assert.assertTrue(checkout.isGrandTotalDisplayed(), "Grand Total should be visible in the bag drawer");

		// Step 4: Click Proceed
		checkout.clickProceed();

		// Step 5: Click "Continue as guest"
		checkout.clickContinueAsGuest();

		// Step 6: Fill the address form (opens automatically after Continue as guest)
		checkout.fillAddressForm(pincode, houseFlat, roadArea, name, phone, email);

		// Step 7: Click "Ship to this address"
		checkout.clickShipToThisAddress();

		// Step 8: Select "Cash on delivery"
		checkout.selectCashOnDelivery();

		// Step 9: Verify "Place Order" button is visible - DO NOT click it
		Assert.assertTrue(checkout.isPlaceOrderButtonVisible(),
				"Place Order button should be visible after selecting Cash on Delivery");
	}
}
