package com.examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CsvFileCode {

	public  Object[][] getCSVFile(String fileName) {

		Object[][] data = null;

		File file = new File(fileName); //
		FileReader fr; // 16-bit / text / character
		BufferedReader br = null;
		try {

			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			List<String[]> lines = new ArrayList<String[]>();
			while ((line = br.readLine()) != null) {
				if (!line.isEmpty())
					lines.add(line.split(","));
			}

			// convert our list to a String array.
			String[][] array = new String[lines.size()][0];

			data = lines.toArray(array);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return data;

	}
	
	public Object[][] getXLSXFile(String fileName) {
		Workbook workbook = null;
		Object[][] data = null;
		try {
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			Sheet sheet1 = workbook.getSheet("Sheet1");
			int totalRows = (sheet1.getLastRowNum() - sheet1.getFirstRowNum()) + 1;
			List<String[]> lines = new ArrayList<String[]>();
			for (int i = 0; i < totalRows; i++) {
				Row row = sheet1.getRow(i);
				int totalCols = row.getLastCellNum() - row.getFirstCellNum();
				String[] line = new String[totalCols];
				for (int j = 0; j < totalCols; j++) {
					Cell cell = row.getCell(j);
					line[j] = cell.getStringCellValue();
				}
				lines.add(line);
			}
			String[][] sdata = new String[lines.size()][0];
			data = lines.toArray(sdata);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return data;

	}
	
	
	
}
