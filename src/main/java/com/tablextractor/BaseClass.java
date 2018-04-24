package com.tablextractor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	static WebDriver  driver = null;

	public WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.gecko.driver", "config/geckodriver");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void closeDriver() {
		driver.close();
	}
}
