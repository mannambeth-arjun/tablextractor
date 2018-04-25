package com.tablextractor.utils;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

/**
 * @author Arjun Mannambeth
 *
 */
public class Xtractor {
	private WebDriver driver;
	private Document doc;
	private static List<Element> tables = new ArrayList<>();

	public Xtractor(WebDriver driver) {
		this.driver = driver;
		this.doc = Jsoup.parse(driver.getPageSource());
	}

	public void xtractTables(String outputPath) {
		Elements tableElements = doc.getElementsByTag("table");
		for (Element element : tableElements) {
			getTableElements(element);
		}

		for (int i = 0; i < tables.size(); i++) {
			TableXtractor.createCsvTable(tables.get(i), outputPath + "/table" + (i + 1) + ".csv");
		}
	}

	private void getTableElements(Element element) {
		if (element.getElementsByTag("table").size() == 1)
			tables.add(element);
	}
}
