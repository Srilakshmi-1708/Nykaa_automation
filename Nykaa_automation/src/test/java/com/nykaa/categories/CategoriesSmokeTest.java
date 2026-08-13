package com.nykaa.categories;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.webdriverutility.UtilityClassObject;

public class CategoriesSmokeTest extends BaseClass {
	@Test
	public void categoriesTest() throws Throwable {
		
		HomePage hp=new HomePage(driver);
		wLib.waitForPageToLoad(driver);
		
		driver.get(fLib.getDataFromPropertiesFile("url"));
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("url")),"home page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "homepage displayed sucessfully");
		System.out.println("home page displayed");
		
		hp.getMakeupMenu().click();
		
		wLib.switchToTabOnUrl(driver, "makeup");
		
		Assert.assertTrue(driver.getCurrentUrl().contains("makeup"),"makeup category page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "makeup category page displayed sucessfully");
		System.out.println("makeup category page displayed successfully");
		
		
		
	}

}
