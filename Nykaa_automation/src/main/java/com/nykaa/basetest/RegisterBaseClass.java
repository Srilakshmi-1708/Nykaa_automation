package com.nykaa.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.nykaa.fileutility.ExcelUtility;
import com.nykaa.fileutility.FileUtility;
import com.nykaa.webdriverutility.UtilityClassObject;
import com.nykaa.webdriverutility.WebDriverUtility;

public class RegisterBaseClass {

    public FileUtility fLib = new FileUtility();
    public ExcelUtility eLib = new ExcelUtility();
    public WebDriverUtility wLib = new WebDriverUtility();

    public WebDriver driver = null;

    public static WebDriver sdriver = null;


    @BeforeSuite(groups = {"smokeTest", "regressionTest"})
    public void configBS() {

        System.out.println("==================================");
        System.out.println("Before Suite");
        System.out.println("==================================");
    }


    @BeforeClass(groups = {"smokeTest", "regressionTest"})
    public void configBC() throws Throwable {

        System.out.println("Launching Browser");

        String browser =
                fLib.getDataFromPropertiesFile("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            throw new RuntimeException(
                    "Invalid browser name: " + browser);
        }

        sdriver = driver;

        UtilityClassObject.setdriver(driver);

        wLib.maximizeWindow(driver);

        wLib.waitForPageToLoad(driver);

        System.out.println("Browser launched successfully");
    }


    @BeforeMethod(groups = {"smokeTest", "regressionTest"})
    public void configBM() throws Throwable {

        System.out.println("Opening Nykaa Application");

        String url =
                fLib.getDataFromPropertiesFile("baseUrl");

        driver.get(url);

        wLib.waitForPageToLoad(driver);
    }


    @AfterMethod(groups = {"smokeTest", "regressionTest"})
    public void configAM() {

        System.out.println("Test Execution Completed");
    }


    @AfterClass(groups = {"smokeTest", "regressionTest"})
    public void configAC() {

        System.out.println("Closing Browser");

        if (driver != null) {

            driver.quit();
        }
    }


    @AfterSuite(groups = {"smokeTest", "regressionTest"})
    public void configAS() {

        System.out.println("After Suite");
    }
}
