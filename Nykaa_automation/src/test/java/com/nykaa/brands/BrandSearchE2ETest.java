package com.nykaa.brands;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.BrandsPage;
import com.nykaa.objectrepository.HomePage;
import com.nykaa.webdriverutility.UtilityClassObject;

public class BrandSearchE2ETest extends BaseClass {
	@Test
	public void brandSearchE2ETest() throws Throwable {
		HomePage hp=new HomePage(driver);
		BrandsPage bp=new BrandsPage(driver);
		wLib.waitForPageToLoad(driver);
		
		driver.get(fLib.getDataFromPropertiesFile("url"));
		Assert.assertTrue(driver.getCurrentUrl().contains(fLib.getDataFromPropertiesFile("url")),"home page not displayed");
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
		
		Assert.assertTrue(bp.getFirstProductNameOfBrandPage().getText().contains("Dot & Key"),"relevent brand product not displayed in relevant brand page");
		UtilityClassObject.getTest().log(Status.INFO, "relevent brand product displayed sucessfully in relevant brand page");
		
		wLib.scrollToElement(driver, bp.getBrandPageNextButton());
		
		while (true) {

		    if (!driver.findElements(By.xpath("//p[text()='No More Products to Show']")).isEmpty()) {
		        break;
		    }

		    wLib.scrollToElement(driver, bp.getBrandPageNextButton());
		    bp.getBrandPageNextButton().click();
		}
		
	}

}
