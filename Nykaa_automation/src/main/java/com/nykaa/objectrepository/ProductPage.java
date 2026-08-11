package com.nykaa.objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "(//div[contains(@class,'product')])[1]")
    WebElement firstProduct;


    @FindBy(xpath = "(//span[text()='Add to Bag'])[1]")
    WebElement addToBag;


    public ProductPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, this);
    }


    public void selectProduct() {

        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

        firstProduct.click();
    }


    public void addProductToBag() {
     
        wait.until(ExpectedConditions.elementToBeClickable(addToBag));

        addToBag.click();
    }
}
