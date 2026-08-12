
	package com.nykaa.objectrepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewsPage extends com.nykaa.webdriverutility.WebDriverUtility {

	WebDriver driver;
	WebDriverWait wait;

	public ReviewsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	// Ratings & Reviews main section
	private final By reviewsSection = By.xpath(
			"//div[@id='reviewQ&ASection']");

	// Overall rating - example: 4.8
	private final By overallRatingValue = By.xpath(
			"//div[@id='reviewQ&ASection']//strong");

	// Write Review button
	private final By writeReviewButton = By.xpath(
			"//div[@id='reviewQ&ASection']//*[self::button or self::a]"
			+ "[contains(normalize-space(),'Write Review')]");

	// Login page / login popup indicator
	private final By loginPageIndicator = By.xpath(
			"//span[contains(normalize-space(),'Login or Signup')]");

	/**
	 * Scrolls to Ratings & Reviews section.
	 */
	public void scrollToReviewsSection() {

		WebElement section = wait.until(
				ExpectedConditions.presenceOfElementLocated(reviewsSection));

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView({block:'center'});",
				section);
	}

	/**
	 * Clicks Write Review.
	 */
	public void tapWriteAReview() {

		scrollToReviewsSection();

		WebElement writeReview = wait.until(
				ExpectedConditions.elementToBeClickable(writeReviewButton));

		writeReview.click();
	}

	/**
	 * Verifies that guest user is redirected to / shown Login.
	 */
	public boolean isRedirectedToLoginPage() {

		try {

			return wait.until(
					ExpectedConditions.visibilityOfElementLocated(
							loginPageIndicator))
					.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	/**
	 * Gets overall rating.
	 *
	 * Example:
	 * 4.8
	 */
	public String getOverallRatingText() {

		scrollToReviewsSection();

		WebElement rating = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
						overallRatingValue));

		return rating.getText().trim();
	}

	/**
	 * Converts rating into double.
	 *
	 * Example:
	 * "4.8" -> 4.8
	 */
	public double getOverallRatingValue() {

		String ratingText = getOverallRatingText();

		return Double.parseDouble(ratingText);
	}
}