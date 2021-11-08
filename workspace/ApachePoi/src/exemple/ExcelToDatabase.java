package exemple;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDatabase {
	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","APACHEPOI","java");
		Statement stmt = con.createStatement();
		
//		String sql = "CREATE TABLE TEAM ("
//				   + "    NAME VARCHAR2(20),"
//				   + "    PART VARCHAR2(20),"
//				   + "    FAVORITE VARCHAR2(20) )";
//		stmt.execute(sql);
//		
		// 엑셀
		FileInputStream fis = new FileInputStream("c:/users/leeny/team.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Team Data");
		
		int rows = sheet.getLastRowNum();
		
		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			String name = row.getCell(0).getStringCellValue();
			String part = row.getCell(1).getStringCellValue();
			String favorite = row.getCell(2).getStringCellValue();
			
			String sql = "INSERT INTO TEAM(NAME, PART, FAVORITE)"
				+ "    VALUES('"+ name +"','"+part+"','"+ favorite +"' )";
			
			stmt.execute(sql);
			stmt.execute("COMMIT");
					
		}
		workbook.close();
		fis.close();
		con.close();
	}
}
