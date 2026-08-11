package com.nykaa.brands;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.BrandsPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.webdriverutility.UtilityClassObject;

public class BrandSmokeTest extends BaseClass{
	@Test
	public void brandsSmokeTest() throws Throwable {
		HomePage hp=new HomePage(driver);
		BrandsPage bp=new BrandsPage(driver);
		wLib.waitForPageToLoad(driver);
		
		driver.get(fLib.getDataFromPropertiesFile("URL"));
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("URL")),"home page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "homepage displayed sucessfully");
		System.out.println("home page displayed");
		
		wLib.mousemoveOnElement(driver, hp.getBrandsMenu());
		bp.getDotAndKeyBrandLogo().click();
		Assert.assertTrue(driver.getCurrentUrl().contains("dot-key"),"brand page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "brand page displayed sucessfully");
		System.out.println("brand page displayed successfully");
		
		Assert.assertTrue(bp.getBrandPageTitle().getText().contains("Dot & Key"),"brand page title not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "brand page title displayed sucessfully");
		System.out.println("brand page title displayed successfully");
		
	}

}
