package com.nykaa.objectrepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PDPPage extends com.nykaa.webdriverutility.WebDriverUtility {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public PDPPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	// Search box
	@FindBy(css = "input[placeholder*='Search']")
	WebElement searchBox;

	// First product from search results
	private final By firstProductTile = By.cssSelector("a[href*='/p/']");

	// Product image
	private final By pdpImage = By.cssSelector("img[alt='product']");

	// Product name
	private final By pdpName = By.cssSelector("h1");

	// Product price
	private final By pdpPrice = By.xpath("//span[contains(text(),'₹')]");

	// Add to Bag button
	private final By addToBagButton = By.xpath("//button[.//span[contains(normalize-space(),'Add to Bag')]]");

	// Search product
	public void searchForProduct(String productName) {

		wait.until(ExpectedConditions.visibilityOf(searchBox));

		searchBox.clear();
		searchBox.sendKeys(productName);
		searchBox.submit();
	}

	// Open first product
//	public void openFirstSearchResult() {
//
//		List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(firstProductTile));
//
//		System.out.println("Products found: " + products.size());
//
//		if (products.isEmpty()) {
//			throw new IllegalStateException("No products found on search results page");
//		}
//
//		products.get(0).click();
//
//		// Wait until PDP URL is loaded
//		wait.until(ExpectedConditions.urlContains("/p/"));
//
//		System.out.println("PDP URL: " + driver.getCurrentUrl());
//	}
	
	public void openFirstSearchResult() {

	    List<WebElement> products =
	            wait.until(ExpectedConditions
	                    .presenceOfAllElementsLocatedBy(firstProductTile));

	    System.out.println("Products found: " + products.size());

	    if (products.isEmpty()) {
	        throw new IllegalStateException(
	                "No products found on search results page");
	    }

	    // Store the current window
	    String parentWindow = driver.getWindowHandle();

	    // Click first product
	    products.get(0).click();

	    // Wait for new tab/window
	    wait.until(driver -> driver.getWindowHandles().size() > 1);

	    // Switch to the new tab
	    for (String windowHandle : driver.getWindowHandles()) {

	        if (!windowHandle.equals(parentWindow)) {
	            driver.switchTo().window(windowHandle);
	            break;
	        }
	    }

	    // Wait until PDP URL is loaded
	    wait.until(ExpectedConditions.urlContains("/p/"));

	    System.out.println("PDP URL: " + driver.getCurrentUrl());
	}

	// Verify product image
	public boolean isProductImageDisplayed() {

		WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(pdpImage));

		return image.isDisplayed();
	}

	// Get product name
	public String getProductName() {

		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(pdpName));

		return name.getText();
	}

	// Verify price
	public boolean isPriceDisplayed() {

		WebElement price = wait.until(ExpectedConditions.visibilityOfElementLocated(pdpPrice));

		return price.isDisplayed() && !price.getText().trim().isEmpty();
	}

	// Verify Add to Bag button
	public boolean isAddToBagButtonPresent() {

		try {

			WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(addToBagButton));

			return button.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}
	
	public void clickAddToBag() {
		wait.until(ExpectedConditions.elementToBeClickable(addToBagButton)).click();
	}

}
