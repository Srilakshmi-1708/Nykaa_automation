package com.nykaa.objectrepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CouponPage {

	WebDriver driver; // Rule 2:Object Creation

	public CouponPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[.='Coupons & Offers']")
	private WebElement couponTitle;

	@FindBy(xpath = "//iframe[@src='/coupons?root=cart']")
	private WebElement frameElement;
	
	@FindBy(xpath="//div[.='NEW15']/../button[.='Collect']")
	private WebElement coupon;
	

	public WebElement getCoupon() {
		return coupon;
	}

	
	public WebElement getFrameElement() {
		return frameElement;
	}

	public WebElement getCouponTitle() {
		return couponTitle;
	}

}
