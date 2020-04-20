package utils.load.dataSource;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	public static String getExcelData(String excelPath, String sheetName, int rowNum, int colNum) {
		FileInputStream fis;
		String data = null;
		try {
			fis = new FileInputStream(excelPath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheetName);
			Row row = sh.getRow(rowNum);
			Cell c = row.getCell(colNum);
			c.setCellType(Cell.CELL_TYPE_STRING);
			data = c.getStringCellValue();
			data = data.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
