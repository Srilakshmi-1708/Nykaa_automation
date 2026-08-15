
package com.nykaa.pdp;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.ProductDetailsPage;

public class PdpTest extends BaseClass {

	private static final double MIN_ACCEPTABLE_RATING = 4.0;

	@Test(groups = {
			"smokeTest" }, description = "Verify PDP details (image/name/price/Add to Bag) and overall rating for the same product")
	public void tc_pw_001_verifyPdpDetailsAndRating() throws Throwable {

		// Excel: ProductDetails sheet, row 1, col 1 -> SearchProduct
		String searchTerm = eLib.getDataFromExcel("ProductDetails", 1, 1);

		// Step 1: Search (search box now lives on HomePage)
		HomePage hp = new HomePage(driver);
		hp.searchForProduct(searchTerm);

		// Step 2: Open first product
		ProductDetailsPage pdp = new ProductDetailsPage(driver);
		pdp.openFirstSearchResult();

		// Step 3: Product details validation
		Assert.assertTrue(pdp.isProductImageDisplayed(), "Product image should be visible on PDP");

		String productName = pdp.getProductNameAsString();
		Assert.assertFalse(productName.trim().isEmpty(), "Product name should not be empty");

		Assert.assertTrue(pdp.isPriceDisplayed(), "Product price should be visible on PDP");
		Assert.assertTrue(pdp.isAddToBagButtonPresent(), "Add to Bag button should be present on PDP");

		System.out.println("Product: " + searchTerm);
		System.out.println("Name on PDP: " + productName);

		// Step 4: Rating validation - same PDP, same page load, no re-search
		String ratingText = pdp.getOverallRatingText();
		double ratingValue = pdp.getOverallRatingValue();

		System.out.println("Overall Rating: " + ratingText);

		Assert.assertTrue(ratingValue > 0, "Rating should be a valid positive number, got: " + ratingValue);
		Assert.assertTrue(ratingValue >= MIN_ACCEPTABLE_RATING,
				"Expected rating >= " + MIN_ACCEPTABLE_RATING + " but got " + ratingValue);
	}
}
