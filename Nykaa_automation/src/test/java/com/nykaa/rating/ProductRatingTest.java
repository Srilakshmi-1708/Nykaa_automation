
	package com.nykaa.rating;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.nykaa.basetest.BaseClass;
	import com.nykaa.objectrepository.PDPPage;
	import com.nykaa.objectrepository.ReviewsPage;

	/**
	 * Verify Product Rating on PDP.
	 *
	 * Reuses the same guest search -> open PDP flow as PdpTest (TC_PW_001) and
	 * WishlistTest/ReviewsTest, since reading the rating doesn't require login.
	 *
	 * Steps:
	 * 1. Search for a product and open its PDP
	 * 2. Scroll to Ratings & Reviews, read the Overall Rating
	 * 3. Print the rating
	 * 4. Assert it meets a minimum acceptable threshold (default 4.0/5)
	 *
	 * Test Data: searchProduct key in commonData.properties
	 */
	public class ProductRatingTest extends BaseClass {

		// Minimum rating this test treats as acceptable. Adjust if your
		// product/business rule differs (e.g. change to 4.5 to match a
		// specific requirement).
		private static final double MIN_ACCEPTABLE_RATING = 4.0;

		@Test(groups = { "smokeTest" }, description = "Verify product's overall rating on PDP")
		public void tc_verifyProductRating() throws Throwable {

			String url = fLib.getDataFromPropertiesFile("url");
			driver.get(url);

			String searchTerm = fLib.getDataFromPropertiesFile("searchProduct");

			// Step 1: Search and open PDP
			PDPPage pdp = new PDPPage(driver);
			pdp.searchForProduct(searchTerm);
			pdp.openFirstSearchResult();

			// Step 2: Read rating
			ReviewsPage reviews = new ReviewsPage(driver);

			String ratingText = reviews.getOverallRatingText();
			double ratingValue = Double.parseDouble(ratingText);

			// Step 3: Print rating
			System.out.println("Product: " + searchTerm);
			System.out.println("Overall Rating: " + ratingText);

			// Step 4: Validate rating
			Assert.assertTrue(
					ratingValue > 0,
					"Rating should be a valid positive number, got: " + ratingValue);

			Assert.assertTrue(
					ratingValue >= MIN_ACCEPTABLE_RATING,
					"Expected rating >= " + MIN_ACCEPTABLE_RATING
							+ " but got " + ratingValue);
		}
	}
