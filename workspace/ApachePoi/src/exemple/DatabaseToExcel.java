package exemple;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatabaseToExcel {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","APACHEPOI","java");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM TEAM");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Team Data2");
		
		XSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("NAME");
		row.createCell(1).setCellValue("PART");
		row.createCell(2).setCellValue("FAVORITE");
		
		int r = 1;
		while (rs.next()) {
			String name = rs.getString("NAME");
			String part = rs.getString("PART");
			String favorite = rs.getString("FAVORITE");
			
			row= sheet.createRow(r++);
			
			row.createCell(0).setCellValue(name);
			row.createCell(1).setCellValue(part);
			row.createCell(2).setCellValue(favorite);			
		}
		
		FileOutputStream fos = new FileOutputStream("c:/users/leeny/team2.xlsx");
		workbook.write(fos);
		
		workbook.close();
		fos.close();
		con.close();
		
		
		
	}
}
