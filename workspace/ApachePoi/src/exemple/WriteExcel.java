package exemple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void main(String[] args) throws IOException {
		File file = new File("c:/users/leeny/team.xlsx");
		
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Team Data");
		
		Object empdata[][] = { {"이름","담당파트","취미"},{"봉현민", "코딩", "독서"}, {"이나영", "발표", "산책"}, {"강주희", "ppt", "음악감상"},{"이준석","지시","술"}};
		
		int rowCount = 0;
		
		for (Object emp[] : empdata) {
			XSSFRow row = sheet.createRow(rowCount++);
			int columnCount=0;
			for (Object value : emp) {
				XSSFCell cell = row.createCell(columnCount++);
				
				if (value instanceof String) cell.setCellValue((String)value);
				if (value instanceof Integer) cell.setCellValue((Integer)value);
				if (value instanceof Boolean) cell.setCellValue((Boolean)value);
			}
		}
		
		String filePath = "c:/users/leeny/team.xlsx";
		FileOutputStream outstream = new FileOutputStream(filePath);
		workbook.write(outstream);
		
		outstream.close();
		
		
		
	}	
}
