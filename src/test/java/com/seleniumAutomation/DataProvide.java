package com.seleniumAutomation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvide {

	ReadingExcelFiles read = new ReadingExcelFiles();

	@DataProvider(name = "mydata")
	public Object[][] getData() throws Exception {
//		Object[][] data = { { "rahul", "choudhary", 1 }, { "Aniket", "choudhary", 12 }, { "Arvind", "choudhary", 81 } };
		Object[][] data = read.readExcelFile(
				"C:\\Users\\2122119\\eclipse-workspace\\Selenium\\src\\test\\java\\com\\testdata",
				"SampleTestData.xlsx", "Sheet1");
		return data;
	}

	@Test(dataProvider = "mydata")
	public void testCaseDataRun(String name, String surname) {
		System.out.println(name + "|| " + surname + "|| ");
	}

}
