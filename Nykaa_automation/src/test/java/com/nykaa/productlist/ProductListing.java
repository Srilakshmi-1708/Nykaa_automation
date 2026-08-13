package com.nykaa.productlist;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.ProductDetailsPage;
import com.nykaa.webdriverutility.UtilityClassObject;

public class ProductListing extends BaseClass{
	@Test
	public void productListingTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		ProductDetailsPage pdp=new ProductDetailsPage(driver);
		wLib.waitForPageToLoad(driver);
		
		driver.get(fLib.getDataFromPropertiesFile("url"));
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("url")),"home page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "homepage displayed sucessfully");
		System.out.println("home page displayed");
		
		hp.getHairMenu().click();
		wLib.switchToTabOnUrl(driver, "hair");
		Assert.assertTrue(driver.getCurrentUrl().contains("hair"),"Hair category page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "Hair category page displayed sucessfully");
		System.out.println("hair category page displayed");
		
		wLib.mousemoveOnElement(driver, hp.getHairMenu());
		hp.getShampooLink().click();
		wLib.switchToTabOnUrl(driver, "shampoo");
		Assert.assertTrue(driver.getCurrentUrl().contains("shampoo"),"shampoo category page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "shampoo category page displayed sucessfully");
		System.out.println("shampoo category page displayed");
		
		wLib.scrollToElement(driver, pdp.getSortByDropdown());
		System.out.println("sort by dropdown is visible");
		Assert.assertTrue(pdp.getSortByDropdown().isDisplayed(),"shampoo category page sort by dropdown not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "shampoo category page sort by dropdown displayed sucessfully");
		System.out.println("sort by dropdown is visible");
		
		wLib.scrollToElement(driver, pdp.getFirstProductName());
		Assert.assertTrue(pdp.getFirstProductName().getText().contains("shampoo"),"revelent shmapoo product not displayed for shampoo category page");
		UtilityClassObject.getTest().log(Status.INFO, "revelent shmapoo product displayed sucessfully for shampoo category page");
		System.out.println("revelent shmapoo product displayed successfully for shampoo category page");
		
	}

}
