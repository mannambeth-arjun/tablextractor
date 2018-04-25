package com.tablextractor.base;

import org.openqa.selenium.WebDriver;

import com.tablextractor.utils.Xtractor;

/**
 * @author Arjun Mannambeth
 *
 */
public class XtractionManager {

	public void xtractTable(String url, String path) {
		WebDriver driver = BaseClass.getDriver();
		driver.navigate().to(url);
		Xtractor xtractor = new Xtractor(driver);
		xtractor.xtractTables(path);
		BaseClass.closeDriver();
	}

	public void xtractTable(String url) {
		xtractTable(url, "target");
	}

}
