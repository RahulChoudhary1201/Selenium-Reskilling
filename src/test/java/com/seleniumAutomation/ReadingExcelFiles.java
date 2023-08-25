package com.seleniumAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.phptravels.ExcelReader;

public class ReadingExcelFiles {

	public Object[][] readExcelFile(String filePath, String FileName, String sheetName) throws IOException {
		DataFormatter formatter = new DataFormatter();

		File file = new File(filePath + "\\" + FileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = FileName.substring(FileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet workbookSheet = workbook.getSheet(sheetName);
		int rowCount = workbookSheet.getLastRowNum() - workbookSheet.getFirstRowNum();
		int columnCount = workbookSheet.getRow(0).getLastCellNum();
//		System.out.println(rowCount);
//		System.out.println(columnCount);
		Object[][] data = new Object[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			Row row = workbookSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				// printing excel data to console
				Cell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
				// System.out.print(row.getCell(j).getStringCellValue() + "|| ");
			}
			System.out.println();
		}
		return data;
	}

	public static void main(String[] args) throws Exception {
		ReadingExcelFiles readExcel = new ReadingExcelFiles();
		Object myData[][] = readExcel.readExcelFile(
				"C:\\Users\\2122119\\eclipse-workspace\\Selenium\\src\\test\\java\\com\\testdata",
				"sampleTestData.xlsx", "Sheet1");
		for (int i = 1; i < myData.length; i++) {
			for (int j = 0; j < myData[0].length; j++) {
				System.out.print(myData[i][j] + " ");
			}
			System.out.println();
		}
//		System.out.println(myData[1][0]);
//		System.out.println(myData[1][1]);
//		System.out.println(myData[2][0]);
//		System.out.println(myData[2][1]);
//		System.out.println(myData[3][0]);
//		System.out.println(myData[3][1]);

	}

}
