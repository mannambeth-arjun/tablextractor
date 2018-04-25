package com.tablextractor.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
		if (tables.size() == 0)
			System.out.println("There is no tables found in given url");
		else {
			File folder = new File(outputPath);
			for (File file : folder.listFiles())
				if (file.getName().matches("table.*"))
					file.delete();
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
