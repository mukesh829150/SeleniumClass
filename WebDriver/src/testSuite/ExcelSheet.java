package testSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelSheet {

	FileInputStream ExcelFile;
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Row row;
	Cell cell;
	
	
	@Test
	public void ReadExcel() throws IOException {
		
		ExcelFile=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//ThamesWaterFiori.xlsx");
		workbook=new XSSFWorkbook(ExcelFile);
		sheet=	workbook.getSheetAt(0);
		
		row=sheet.getRow(0);
		cell=row.getCell(0);	
		
		String cellContent=cell.getStringCellValue();
		System.out.println(cellContent);
		
	}
	
}
