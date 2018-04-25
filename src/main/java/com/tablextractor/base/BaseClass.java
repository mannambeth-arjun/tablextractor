package com.tablextractor.base;

 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
 /**
 * @author Arjun Mannambeth
 *
 */
public class BaseClass {
	static WebDriver driver = null;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "config/geckodriver");
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		}
		return driver;
	}

	// Close driver
	public static void closeDriver() {
		driver.close();
	}
}
