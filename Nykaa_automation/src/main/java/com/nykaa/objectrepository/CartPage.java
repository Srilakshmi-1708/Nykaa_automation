package com.nykaa.objectrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver; // Rule 2:Object Creation

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[.='Bag']")
	private WebElement title;

	@FindBy(xpath = "//*[local-name()='svg']/ancestor::button[@label='delete']")
	private WebElement deleteButton;
	
	@FindBy(xpath="//button[.='Yes']")
	private WebElement yesButton;

	@FindBy(xpath="//span[@data-test-id='product-name']")
	private WebElement productName;
	
	@FindBy(xpath="//p[.='Apply now and save extra!']")
	private WebElement couponLink;
	

	public WebElement getCouponLink() {
		return couponLink;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getYesButton() {
		return yesButton;
	}
	
	
	
	  public boolean isProductPresent(String productName) {
	  
	  List<WebElement> products = driver.findElements(
	  By.xpath("//span[@data-test-id='product-name']") );
	  
	  for (WebElement product : products) { if
	  (product.getText().contains(productName)) { return true; } }
	  
	  return false; }
	 
	  
	  public boolean isProductPresentInBag(String productName) {

		    List<WebElement> products = driver.findElements(
		            By.xpath("//span[@data-test-id='product-name']")
		    );

		    for (WebElement product : products) {

		        String actualProductName = product.getText().trim();

		      //  System.out.println("Expected: " + productName);
		       // System.out.println("Actual: " + actualProductName);

		        if (actualProductName.equalsIgnoreCase(productName.trim())) {
		            return true;
		        }
		        
		    }

		    return false;
		}
	
	
	  public void toApplyCoupon()
	  {
		  couponLink.click();
		  
	  }
	  
	  
}
