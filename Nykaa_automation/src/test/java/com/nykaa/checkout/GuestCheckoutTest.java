package com.nykaa.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.GuestCheckoutPage;
import com.nykaa.objectrepository.PDPPage;

/**
 * End-to-End guest checkout flow, built from the real flow you walked
 * through and inspected in DevTools on 11 Aug 2026:
 *
 * 1. Search for a product, open PDP, Add to Bag
 * 2. Click the Bag icon
 * 3. Verify Grand Total price is showing in the bag drawer
 * 4. Click Proceed
 * 5. Click "Continue as guest" (address form opens automatically)
 * 6. Fill Pincode, House/Flat/Office No., Road Name/Area/Colony, Name,
 *    Phone, Email
 * 7. Click "Ship to this address"
 * 8. Select "Cash on delivery"
 * 9. Verify "Place Order" button is visible
 *
 * SAFETY: this test deliberately stops at step 9 and never clicks
 * "Place Order" - doing so would place a real order on the live site.
 *
 * Test Data: e2eSearchProduct + guestPincode/guestHouseFlat/guestRoadArea/
 * guestName/guestPhone/guestEmail keys in commonData.properties.
 */
public class GuestCheckoutTest extends BaseClass {

	@Test(groups = { "smokeTest" }, description = "TC_PW_E2E_001 - Guest checkout flow through to Place Order visibility")
	public void tc_pw_e2e_001_guestCheckoutFlow() throws Throwable {

		String url = fLib.getDataFromPropertiesFile("url");
		driver.get(url);

		String searchTerm = fLib.getDataFromPropertiesFile("e2eSearchProduct");

		// Step 1: Search for a product, open PDP, Add to Bag
		PDPPage pdp = new PDPPage(driver);
		pdp.searchForProduct(searchTerm);
		pdp.openFirstSearchResult();
		pdp.clickAddToBag();

		GuestCheckoutPage checkout = new GuestCheckoutPage(driver);

		// Step 2: Click the Bag icon
		checkout.clickBagIcon();

		// Step 3: Verify Grand Total price is showing
		Assert.assertTrue(checkout.isGrandTotalDisplayed(),
				"Grand Total should be visible in the bag drawer");

		// Step 4: Click Proceed
		checkout.clickProceed();

		// Step 5: Click "Continue as guest"
		checkout.clickContinueAsGuest();

		// Step 6: Fill the address form (opens automatically after Continue as guest)
		String pincode = fLib.getDataFromPropertiesFile("guestPincode");
		String houseFlat = fLib.getDataFromPropertiesFile("guestHouseFlat");
		String roadArea = fLib.getDataFromPropertiesFile("guestRoadArea");
		String name = fLib.getDataFromPropertiesFile("guestName");
		String phone = fLib.getDataFromPropertiesFile("guestPhone");
		String email = fLib.getDataFromPropertiesFile("guestEmail");

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