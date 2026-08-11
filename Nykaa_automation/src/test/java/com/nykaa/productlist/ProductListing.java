package com.nykaa.productlist;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HairCategoryDropDownPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.webdriverutility.UtilityClassObject;

public class ProductListing extends BaseClass{
	@Test
	public void productListingTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		wLib.waitForPageToLoad(driver);
		HairCategoryDropDownPage hcdp=new HairCategoryDropDownPage(driver);
		
		driver.get(fLib.getDataFromPropertiesFile("URL"));
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("URL")),"home page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "homepage displayed sucessfully");
		System.out.println("home page displayed");
		
		hp.getHairMenu().click();
		wLib.switchToTabOnUrl(driver, "hair");
		Assert.assertTrue(driver.getCurrentUrl().contains("hair"),"Hair category page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "Hair category page displayed sucessfully");
		System.out.println("hair category page displayed");
		
		wLib.mousemoveOnElement(driver, hp.getHairMenu());
		hcdp.getShampooLink().click();
		wLib.switchToTabOnUrl(driver, "shampoo");
		Assert.assertTrue(driver.getCurrentUrl().contains("shampoo"),"shampoo category page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "shampoo category page displayed sucessfully");
		System.out.println("shampoo category page displayed");
		
		wLib.scrollToElement(driver, hcdp.getSortByDropdown());
		System.out.println("sort by dropdown is visible");
		Assert.assertTrue(hcdp.getSortByDropdown().isDisplayed(),"shampoo category page sort by dropdown not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "shampoo category page sort by dropdown displayed sucessfully");
		System.out.println("sort by dropdown is visible");
		
		wLib.scrollToElement(driver, hcdp.getFirstProductOfShampooCategory());
		Assert.assertTrue(hcdp.getFirstProductOfShampooCategory().getText().contains("shampoo"),"revelent shmapoo product not displayed for shampoo category page");
		UtilityClassObject.getTest().log(Status.INFO, "revelent shmapoo product displayed sucessfully for shampoo category page");
		System.out.println("revelent shmapoo product displayed successfully for shampoo category page");
		
	}

}
