package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {// to do which class it import
	public static long APGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static long SCRIPT_TIMEOUT = 500;

	public Object[][] getTestData(String sheetName) {
		FileInputStream inputFileStreamObj = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;

		String Test_data_file_path = System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";
		try {
			inputFileStreamObj = new FileInputStream(Test_data_file_path);
			workbook = new XSSFWorkbook(inputFileStreamObj);
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
		}
		sheet = workbook.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

}
