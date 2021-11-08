package exemple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws IOException {
		
		String excelFilePath = "C:/Users/leeny/Apache POI/team.xlsx";
		
		FileInputStream inputStream = new FileInputStream(excelFilePath);	// new FileInputStream("불러올 파일경로/이름.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);							// 해당 엑셀파일의 시트(Sheet)수
//		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		int rows = sheet.getLastRowNum();									// 해당 시트의 마지막행 번호
//		int rows = sheet.getPhysicalNumberOfRows();							// 해당 시트의 행의 개수
		int cols = sheet.getRow(1).getLastCellNum();
//		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		
		try {
			for (int r = 0; r <= rows; r++) {
				XSSFRow row = sheet.getRow(r);
				
				for (int c = 0; c < cols; c++) {
					XSSFCell cell = row.getCell(c);
					
					switch (cell.getCellType()) {
					case STRING: System.out.print(cell.getStringCellValue());	break;
					case NUMERIC: System.out.print(cell.getNumericCellValue());	break;
					case BOOLEAN: System.out.print(cell.getBooleanCellValue());	break;

					default: break;
					}
					System.out.print("\t\t");
				}
				System.out.println();				
			}
		} catch (NullPointerException e) {
			System.out.println(" ");
		}
		inputStream.close();	
		
	}
}
