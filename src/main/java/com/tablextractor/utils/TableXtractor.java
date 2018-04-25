package com.tablextractor.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Arjun Mannambeth
 *
 */
public class TableXtractor {

	public static void createCsvTable(Element element, String path) {
		List<Elements> table = new ArrayList<>();
		Elements rows = element.getElementsByTag("tr");
		List<String> lines = new ArrayList<>();
		for (Element elementRow : rows) {
			Elements row = new Elements();
			if (elementRow.getElementsByTag("th").size() > 0)
				row.addAll(elementRow.getElementsByTag("th"));
			if (elementRow.getElementsByTag("td").size() > 0)
				row.addAll(elementRow.getElementsByTag("td"));
			table.add(row);
		}
		for (Elements row : table) {
			String line = "";
			for (int i = 0; i < row.size(); i++) {
				Element dataElement = row.get(i);
				if (i == 0)
					line = line + "\"" + dataElement.text() + "\"";
				else
					line = line + ",\"" + dataElement.text() + "\"";
			}

			lines.add(line);
		}

		File file = new File(path);
		try {
			FileUtils.writeLines(file, lines, "\n");
			System.out.println(file + " created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
