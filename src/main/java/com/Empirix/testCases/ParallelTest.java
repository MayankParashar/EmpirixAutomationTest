package com.Empirix.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilities.Log;

public class ParallelTest {

	private WebDriver driver;

	String baseURL = "http://www.google.com/";
	

	@Parameters({ "browser" })
	@BeforeTest
	public void openBrowser(String browser) {
   
	 
	       // configure log4j properties file
	       PropertyConfigurator.configure("Log4j.properties");	
		
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "/src/main/resources/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/src/main/resources/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "/src/main/resources/Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void login_TestCase() {
		driver.navigate().to(baseURL);
		Log.startLog("login_TestCase");
		// do something
	}

	@Test
	public void search_TestCase() {
		driver.navigate().to(baseURL);
		Log.startLog("login_TestCase");
		// do something
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}