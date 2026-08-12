package com.nykaa.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.nykaa.basetest.BaseClass;

public class HomePage{
	
	WebDriver driver;                     //Rule 2:Object Creation
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@aria-label='Profile' and @class='css-bw48aa euw1lbv3']")
	private WebElement profileImg;
	
	@FindBy(xpath = "//span[text()='Gift Card']/ancestor::a")
	private WebElement giftCardLink;
	
	@FindBy(xpath = "//button[@class='css-1gzc5zn']")
	private WebElement signInButton;

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@id='header-bag-icon']")
	private WebElement bagIcon;

	@FindBy(xpath = "//*[contains(normalize-space(),'Account')]")
	private WebElement accountIcon;
	
	@FindBy(xpath = "//div[@id='title']")
	private WebElement searchResultTitle;
	
	@FindBy(xpath = "//input[@name='search-suggestions-nykaa']")
	private WebElement searchTF;
	
	@FindBy(xpath = "//nav[@id='my-menu']/descendant::a[text()='makeup']")
	private WebElement makeupMenu;
	
	@FindBy(xpath = "//nav[@id='my-menu']/descendant::a[text()='hair']")
	private WebElement hairMenu;

	@FindBy(xpath="//button[text()='Logout']")
	private WebElement lgtBtn;
	
	@FindBy(xpath="//div[@role='dialog']//span[text()='Logout']")
	private WebElement lgt;
	
	@FindBy(xpath = "//a[text()='brands']")
	private WebElement brandsMenu;
	
	public void logout() {
	Actions a=new Actions(driver);
	a.moveToElement(profileImg).perform();
	lgtBtn.click();
	lgt.click();
	}
	
//	// Search box
//		@FindBy(css = "input[placeholder*='Search']")
//		private WebElement searchBox;
		
		
		public void searchForProduct(String productName) {

			searchBox.clear();
			searchBox.sendKeys(productName);
			searchBox.submit();
		}
   
		
		public WebElement getSearchTF() {
			return searchTF;
		}
		
		
		public WebElement getMakeupMenu() {
			return makeupMenu;
		}
		
	
		public WebElement getHairMenu() {
			return hairMenu;
		}
		
		
		public WebElement getBrandsMenu() {
			return brandsMenu;
		}
         
		public WebElement getSearchResult() {
			return searchResultTitle;
		}

		public void clickSignIn() {
			signInButton.click();
		}

		public WebElement getGiftCardLink() {
			return giftCardLink;
		}

		public void searchProduct(String productName) {
			searchBox.click();
			searchBox.sendKeys(productName);
			searchBox.submit();
		}

		public void clickBag() {
			bagIcon.click();
		}

		public void clickAccount() {
			accountIcon.click();
		}

   
  
	
   
   
}



