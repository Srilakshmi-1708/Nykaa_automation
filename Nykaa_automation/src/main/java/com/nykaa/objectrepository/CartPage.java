package com.nykaa.objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//*[contains(text(),'Bag') or contains(text(),'Cart')]")
    WebElement bag;


    @FindBy(xpath = "//*[contains(text(),'Proceed') or contains(text(),'Checkout')]")
    WebElement proceedToCheckout;


    public CartPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    public void openBag() {

        wait.until(ExpectedConditions.elementToBeClickable(bag));

        bag.click();
    }


    public void clickProceedToCheckout() {

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));

        proceedToCheckout.click();
    }
}
