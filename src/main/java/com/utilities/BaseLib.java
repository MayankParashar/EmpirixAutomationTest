package com.utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utils.screenshot.ScreenshotLib;

public class BaseLib {
	public WebDriver driver;
	public String inputTestDataSheet;

	@BeforeMethod
	@Parameters({ "browser", "testurl" })
	public void setUp(String browsername, String url) {
		inputTestDataSheet = System.getProperty("user.dir")
				+ "/src/main/resources/TestDataExcelFiles/EmpirixTestData.xls";

		// configure log4j properties file
		PropertyConfigurator.configure("Log4j.properties");
		try {
			if (browsername.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				Log.info("Firefox Launched");
				Reporter.log("Firefox Launched", true);
			} else if (browsername.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				Log.info("Chrome Launched");
				Reporter.log("Chrome Launched", true);

			} else if (browsername.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./src/main/resources/Drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				Log.info("IE Launched");
				Reporter.log("IE Launched", true);

			}

		} catch (WebDriverException e) {
			Log.error("Exception while Launching browser");
			Reporter.log("Exception while Launching browser", true);
			System.out.println(e.getMessage());
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);
		Log.info(url + " Url Navigated");
		Reporter.log(url + " Url Navigated", true);
	}

	@AfterMethod
	public void tearDown(ITestResult result) // ITestResult Monitor the content of each and every script
	{
		String scriptName = result.getMethod().getMethodName();
		if (result.isSuccess()) // true--> pass
		{
			Reporter.log(scriptName + " Script is passed", true);
			Log.info(scriptName + " Script is passed");
			ScreenshotLib slib = new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
		} else // false--> fail
		{
			ScreenshotLib slib = new ScreenshotLib();
			slib.takeScreenshot(driver, scriptName);
			Reporter.log("Screenshot has been taken", true);
			Log.info(scriptName + " Screenshot has been taken");
		}
		driver.close();
		Reporter.log("Browser Closed", true);
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
		Log.info("Browser closed");
		Reporter.log("Browser closed", true);
	}
}