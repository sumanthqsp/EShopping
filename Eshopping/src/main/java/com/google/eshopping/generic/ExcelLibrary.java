package com.google.eshopping.generic;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary {
	
	public static double getNumericData (File absPath,String sheetName,int row,int cell) {
		FileInputStream fin;
		try {
			fin = new FileInputStream(absPath);
			Workbook workbook = WorkbookFactory.create(fin);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getNumericCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return 0.0;
		}
			
	}
	
	public static String getStringData (File absPath,String sheetName,int row,int cell) {
		FileInputStream fin;
		try {
			fin = new FileInputStream(absPath);
			Workbook workbook = WorkbookFactory.create(fin);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static Boolean getBooleanData (File absPath,String sheetName,int row,int cell) {
		FileInputStream fin;
		try {
			fin = new FileInputStream(absPath);
			Workbook workbook = WorkbookFactory.create(fin);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getBooleanCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static LocalDateTime getLDTData (File absPath,String sheetName,int row,int cell) {
		FileInputStream fin;
		try {
			fin = new FileInputStream(absPath);
			Workbook workbook = WorkbookFactory.create(fin);
			return workbook.getSheet(sheetName).getRow(row).getCell(cell).getLocalDateTimeCellValue();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public static String [][] getMultipleDataFromExcelSheet (File absPath, String sheetName) {
		try {
			FileInputStream fin = new FileInputStream(absPath);
			Workbook workbook = WorkbookFactory.create(fin);
			int rowCount = workbook.getSheet(sheetName).getPhysicalNumberOfRows();
			int cellCount = workbook.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			
			String[][] arr = new String [rowCount-1][cellCount] ;
			for (int i=0,k=1; i<rowCount-1 ; i++,k++) {
				for (int j=0; j<cellCount; j++) {
					arr[i][j] = workbook.getSheet(sheetName).getRow(k).getCell(j).toString();
				}
			}			
			return arr;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
