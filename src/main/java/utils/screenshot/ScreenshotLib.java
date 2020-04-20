package utils.screenshot;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ScreenshotLib {
	public void takeScreenshot(WebDriver driver, String scriptName) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date date = new Date();
		EventFiringWebDriver efw = new EventFiringWebDriver(driver);
		File srcFile = efw.getScreenshotAs(OutputType.FILE);

		// ./
		// for current directory will give the name passed through scriptName variable

		File destFile = new File("./src/main/resources/Screenshots/" + scriptName + dateFormat.format(date) + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
