package com.phptravels;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static Object[][] excelReader(String filePath, String fileName, String sheetName) throws Exception {
		DataFormatter formatter = new DataFormatter();

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = null;

		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (fileExtensionName.equals(".xls")) {
			workbook = new HSSFWorkbook(inputStream);
		}

		Sheet workbookSheet = workbook.getSheet(sheetName);
		int rowCount = workbookSheet.getLastRowNum() - workbookSheet.getFirstRowNum();
		int columnCount = workbookSheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][columnCount];
		for (int i = 0; i < rowCount; i++) {
			Row row = workbookSheet.getRow(i + 1);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				data[i][j] = formatter.formatCellValue(cell);
			}
			System.out.println();
		}
		return data;
	}

}
