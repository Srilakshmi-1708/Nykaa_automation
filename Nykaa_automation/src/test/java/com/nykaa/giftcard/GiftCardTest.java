package com.nykaa.giftcard;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nykaa.basetest.BaseClass;
import com.nykaa.objectrepository.GiftCardListPage;
import com.nykaa.objectrepository.GiftCardPage;
import com.nykaa.objectrepository.HomePage;

public class GiftCardTest extends BaseClass {

	@Test(groups = "smoke")
	public void toVerifyGiftCardPageOpensTest() { // to verify Gift card page opens successfully

		// click on giftcard link
		HomePage hp = new HomePage(driver);

		hp.getGiftCardLink().click();

		// switch to giftcard list page
		GiftCardListPage giftlist = new GiftCardListPage(driver);

		wLib.switchToTabOnUrl(driver, "https://www.nykaa.com/giftcard/list");

		//to verify gift card list page is successfully opened
		
		WebElement actTitle = giftlist.getEgiftcardTitle();
		String acttitle = actTitle.getText();
		Assert.assertTrue(acttitle.contains("E-Gift Card"));

	}

	@Test
	public void verifyGiftCardPurchaseTest() throws Throwable { // getting details from excel sheet
		String to = eLib.getDataFromExcel("Sheet1", 1, 0);
		String recpientEmail = eLib.getDataFromExcel("Sheet1", 1, 1);
		String message = eLib.getDataFromExcel("Sheet1", 1, 2);
		String from = eLib.getDataFromExcel("Sheet1", 1, 3);
		String senderPhone = eLib.getDataFromExcel("Sheet1", 1, 4);
		System.out.println(to);
		System.out.println(recpientEmail);
		System.out.println(message);
		System.out.println(from);
		System.out.println(senderPhone);

		// click on giftcard link
		HomePage hp = new HomePage(driver);
		hp.getGiftCardLink().click();

		// switching of tab
		GiftCardListPage giftlist = new GiftCardListPage(driver);
		wLib.switchToTabOnUrl(driver, "https://www.nykaa.com/giftcard/list");

		// scrolling to specific gift card
		wLib.scrollToElementA(driver, giftlist.getWeddingGiftCardLink());

		// click on specific gift card
		giftlist.getBirthdayGiftCardLink().click();

		// switch to gift card page for purchasing
		wLib.switchToTabOnUrl(driver, "https://www.nykaa.com/giftcard/sendgiftcard?ptype=sendgiftcard");
		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.giftCardDetails(driver, to, recpientEmail, message, from, senderPhone);

	}

}
