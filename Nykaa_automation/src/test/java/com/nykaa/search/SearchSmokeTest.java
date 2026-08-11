package com.nykaa.search;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.SearchResultPage;
import com.nykaa.webdriverutility.UtilityClassObject;



public class SearchSmokeTest extends BaseClass {
	@Test
	public void searchTest() throws Throwable  {
		HomePage hp=new HomePage(driver);
		SearchResultPage srp=new SearchResultPage(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(fLib.getDataFromPropertiesFile("URL"));
		
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("URL")),"home page not displayed");
		UtilityClassObject.getTest().log(Status.INFO, "homepage displayed sucessfully");
		System.out.println("home page displayed");
		
		hp.getSearchTF().click();
		hp.getSearchTF().sendKeys(fLib.getDataFromPropertiesFile("searchData"),Keys.ENTER);
		
		Assert.assertTrue(srp.getSearchResult().getText().contains("Best Lip Makeup Online"),"search result not displayed or wrong search result displayed");
		UtilityClassObject.getTest().log(Status.INFO, "Search result displayed successfully");
		
	}
}
