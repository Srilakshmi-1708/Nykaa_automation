package com.nykaa.objectrepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

    WebDriver driver;
    WebDriverWait wait;


    @FindBy(xpath = "//button[@class='css-bw48aa euw1lbv3']")
    private WebElement account;


    @FindBy(xpath = "//*[contains(text(),'My Orders') or contains(text(),'Orders')]")
    private WebElement myOrders;


    @FindBy(xpath = "//*[contains(text(),'Logout') or contains(text(),'Log out')]")
    private WebElement logout;


    public AccountPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }


    public void clickAccount() {

        wait.until(ExpectedConditions.elementToBeClickable(account));

        account.click();
    }


    public void clickMyOrders() {

        wait.until(ExpectedConditions.elementToBeClickable(myOrders));

        myOrders.click();
    }


    public void logout() {

        wait.until(ExpectedConditions.elementToBeClickable(logout));

        logout.click();
    }
}
