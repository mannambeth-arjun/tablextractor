package com.tablextractor.base;

/**
 * @author Arjun Mannambeth 
 * Sample class to use tablextractor
 */
public class App {
	public static void main(String[] args) {
		XtractionManager xtractor = new XtractionManager();
		xtractor.xtractTable("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.11.0");
	}
}
