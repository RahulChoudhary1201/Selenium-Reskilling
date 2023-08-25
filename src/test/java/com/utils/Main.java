package com.utils;

public class Main {
	public static void main(String[] args) throws Exception {
		Object[][] data = ExcelUtils.readExcelData("Sheet1");
		
		for(int i=1;i<data.length;i++) {
			for(int j=0;j<data[0].length;j++) {
				System.out.print(data[i][j]);
			}
			System.out.println();
		}
	}
}
