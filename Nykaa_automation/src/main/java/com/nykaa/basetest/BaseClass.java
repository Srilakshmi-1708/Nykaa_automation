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
import com.nykaa.objectrepository.HomePage;
import com.nykaa.objectrepository.LoginPage;
import com.nykaa.webdriverutility.UtilityClassObject;
import com.nykaa.webdriverutility.WebDriverUtility;

public class BaseClass {
	
	
		//create Object
		//have to import database utility but no MY SQL
		public FileUtility fLib=new FileUtility();
		public ExcelUtility eLib=new ExcelUtility();
	    public WebDriverUtility wLib=new WebDriverUtility();
		
		public WebDriver driver=null;
		public static WebDriver sdriver=null;
		
		
	 	@BeforeSuite(groups= {"smokeTest","regressionTest"})
		public void configBS() throws Throwable  {
			 System.out.println("===Connect to DB,Report Config===");
			//have to connect to DB
			
			}
	 	
	   // @Parameters("BROWSER")
		@BeforeClass(groups= {"smokeTest","regressionTest"})
		public void configBC() throws Throwable {
			System.out.println("==Launch the BROWSER==");
			//String BROWSER=fLib.getDataFromPropertiesFile("browser");
			String BROWSER=System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
	          
		     if(BROWSER.equals("chrome")) {
		    	 driver=new ChromeDriver();
		     }
		     else if(BROWSER.equals("firefox")) {
		    	 driver=new FirefoxDriver(); 
		     }
		     else if(BROWSER.equals("edge")) {
		    	 driver=new EdgeDriver();
		     }
		     else {
		    	 driver=new ChromeDriver();
		     }
		    sdriver=driver;
		    UtilityClassObject.setdriver(driver);  
		} 
		
		@BeforeMethod(groups= {"smokeTest","regressionTest"})
		public void configBM() throws Throwable {
			System.out.println("=Login=");
			LoginPage lp=new LoginPage(driver);
			
			
		}
		
		@AfterMethod(groups= {"smokeTest","regressionTest"})
		public void configAM() {
			System.out.println("=Logout=");
			HomePage hp=new HomePage(driver);
			
		}
		
		@AfterClass(groups= {"smokeTest","regressionTest"})
		public void configAC() { 
			System.out.println("==Close the BROWSER==");
			driver.quit();
		}
		
		@AfterSuite(groups= {"smokeTest","regressionTest"})
		public void configAS() {
			System.out.println("===Close DB,Report backUP===");
			//close DBConnection
			
			}
		

}
