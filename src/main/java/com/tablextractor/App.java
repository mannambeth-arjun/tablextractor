package com.tablextractor;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		WebDriver driver = new BaseClass().getDriver();
		driver.navigate().to("https://github.com/mozilla/geckodriver");
		new Scanner(System.in).next();
		BaseClass.closeDriver();
	}
}
