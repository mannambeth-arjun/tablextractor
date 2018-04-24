package com.tablextractor.base;

import org.openqa.selenium.WebDriver;

import com.tablextractor.utils.Xtractor;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		WebDriver driver = BaseClass.getDriver();
		driver.navigate().to("https://mvnrepository.com/artifact/org.apache.commons/commons-io/1.3.2");
		Xtractor xtractor = new Xtractor(driver);
		xtractor.xtractTables();
		BaseClass.closeDriver();
	}
}
