
package excelUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public ExcelReader(String filepath) throws IOException {
		// TODO Auto-generated constructor stub
		FileInputStream fis;
		fis = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(fis);

	}

	public String getData(int sheetnumber, int row, int cell) {
		sheet = workbook.getSheetAt(sheetnumber);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();

		return data;
	}

	public int getIntData(int sheetnumber, int row, int cell) {
		sheet = workbook.getSheetAt(sheetnumber);
		int data = (int) workbook.getSheetAt(sheetnumber).getRow(row).getCell(cell).getNumericCellValue();

		return data;
	}

	public int getRowCount(int sheetindex) {
		int rowCount = workbook.getSheetAt(sheetindex).getLastRowNum();
		rowCount = rowCount + 1;
		System.out.println("Total no of row are..." + rowCount);
		return rowCount;
	}

}
