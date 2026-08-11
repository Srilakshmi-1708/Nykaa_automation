package com.nykaa.pdp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.objectrepository.PDPPage;

public class PdpTest extends com.nykaa.basetest.BaseClass {

	@Test(groups = { "smokeTest" }, description = "TC_PW_001 - Verify PDP loads successfully with all key details")
	public void tc_pw_001_verifyPdpLoadsSuccessfully() throws Throwable {

		// Open Nykaa
		driver.get("https://www.nykaa.com");

		// Get product name from properties file
		String searchTerm = fLib.getDataFromPropertiesFile("searchProduct");

		// Create PDP page object
		PDPPage pdp = new PDPPage(driver);

		// Step 1: Search for product
		pdp.searchForProduct(searchTerm);

		// Step 2: Open first product
		pdp.openFirstSearchResult();

		// Step 3: Verify product image
		Assert.assertTrue(pdp.isProductImageDisplayed(), "Product image should be visible on PDP");

		// Step 4: Verify product name
		String productName = pdp.getProductName();

		Assert.assertFalse(productName.trim().isEmpty(), "Product name should not be empty");

		// Step 5: Verify product price
		Assert.assertTrue(pdp.isPriceDisplayed(), "Product price should be visible on PDP");

		// Step 6: Verify Add to Bag button
		Assert.assertTrue(pdp.isAddToBagButtonPresent(), "Add to Bag button should be present on PDP");
	}
}
