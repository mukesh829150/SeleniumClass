package com.fb.GenericReusable;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {

	FileInputStream ExcelFile;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	
	public XlsReader(String path){
		try {
		ExcelFile=new FileInputStream(path);
		workbook=new XSSFWorkbook(ExcelFile);	
		}catch(Exception e) {
			System.out.println("File Not found");
		}		
	}
	
	public String getCellData(String sheetName, int rowNumber, int colNumber) {
		String text;
		sheet=workbook.getSheet(sheetName);	
		row=sheet.getRow(rowNumber);
		cell=row.getCell(colNumber);
		text=cell.getStringCellValue();	
		return text;
		
	}
	
	public String getCellData(String sheetName,String RowName, String ColumnName) {
		sheet=workbook.getSheet(sheetName);
		int RowNum=sheet.getLastRowNum();
		
		for(int i=1; i<RowNum;i++) {
			row=sheet.getRow(i);
			cell=row.getCell(0);
			String text=cell.getStringCellValue();
			
			
		}
		
		return null;
		
	}
}
