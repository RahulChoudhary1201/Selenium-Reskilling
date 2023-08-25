package com.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static FileInputStream excelFile;
	private static String filePath;

	public static Object[][] readExcelData(String sheetName) throws Exception {
		String[][] arrayExcelData = null;
		FileInputStream file = null;

		String workingDir = System.getProperty("user.dir");
		filePath = workingDir + File.separator + "src" + File.separator + "test" + File.separator + "java"
				+ File.separator + "com" + File.separator + "testdata" + File.separator+ "PHPTravels_TestData.xlsx";
		System.out.println(filePath);
		// filePath =
		// "C:\\Users\\2122119\\eclipse-workspace\\Selenium\\src\\test\\java\\com\\testdata\\PHPTravels_TestData.xlsx";
		excelFile = new FileInputStream(filePath);
		ExcelWBook = new XSSFWorkbook(excelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		int rowcount = ExcelWSheet.getLastRowNum();
		int colCount = ExcelWSheet.getRow(0).getLastCellNum();
		arrayExcelData = new String[rowcount][colCount];
		for (int i = 0; i < rowcount; i++) {
			Row row = ExcelWSheet.getRow(i + 1);
			for (int k = 0; k < row.getLastCellNum(); k++) {
				Cell celval = row.getCell(k);
				if (celval != null) {
					arrayExcelData[i][k] = celval.getStringCellValue();
				}
			}
		}
		return arrayExcelData;
	}
}
