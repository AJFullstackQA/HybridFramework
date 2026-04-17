package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//Method to read the Test-Data
	public String getExcelData(String sheetName, int rowNum, int colNum) throws EncryptedDocumentException, IOException {
		String data="";
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/"+sheetName+"_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		Row r = s.getRow(rowNum);
		Cell c = r.getCell(colNum);
		data = c.getStringCellValue();
		return data;
	}
	
	//Count the number of rows of Data
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		int rowCount = 0;
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/"+sheetName+"_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		rowCount = s.getLastRowNum();
		
		return rowCount;
	}

	//Write Data into the Excel file
	public void setExcelData(String sheetName, int rowNum, int colNum, String result) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/"+sheetName+"_Data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet(sheetName);
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(colNum);
		c.setCellValue(result);
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData/"+sheetName+"_Data.xlsx");
		wb.write(fos);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
