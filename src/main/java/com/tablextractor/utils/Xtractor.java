package com.tablextractor.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

public class Xtractor {
	private WebDriver driver;
	private Document doc;
	private static List<Element> tables = new ArrayList<>();

	public Xtractor(WebDriver driver) {
		this.driver = driver;
		this.doc = Jsoup.parse(driver.getPageSource());
	}

	public void xtractTables() {
		xtractTables("target");
	}

	public void xtractTables(String outputPath) {
		Elements tableElements = doc.getElementsByTag("table");
		for (Element element : tableElements) {
			getTableElements(element);
		}

		for (int i = 0; i < tables.size(); i++) {
			TableXtractor.createCsvTable(tables.get(i), outputPath + "/table" + (i + 1) + ".csv");
			System.out.println("table" + (i + 1) + " extracted");
		}
	}

	private void getTableElements(Element element) {
		Elements elementsByTag = element.getElementsByTag("table");
		if (element.getElementsByTag("table").size() == 1)
			tables.add(element);
	}
}
