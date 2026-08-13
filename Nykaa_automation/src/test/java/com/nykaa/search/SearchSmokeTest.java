package com.nykaa.search;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.webdriverutility.UtilityClassObject;



public class SearchSmokeTest extends BaseClass {
	@Test
	public void searchTest() throws Throwable  {
		HomePage hp=new HomePage(driver);
		
		wLib.waitForPageToLoad(driver);
		driver.get(fLib.getDataFromPropertiesFile("url"));
		
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("url")),"home page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "homepage displayed sucessfully");
		System.out.println("home page displayed");
		
		hp.getSearchTF().click();
		hp.getSearchTF().sendKeys(eLib.getDataFromExcel("Search", 0, 0),Keys.ENTER);
		
		Assert.assertTrue(hp.getSearchResult().getText().contains("Best Lip Makeup Online"),"search result not displayed or wrong search result displayed");
		UtilityClassObject.getTest().log(Status.INFO, "Search result displayed successfully");
		
	}
}
