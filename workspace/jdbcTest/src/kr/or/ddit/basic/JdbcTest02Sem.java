package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest02Sem {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Lprod_id값 입력 : ");
		int num = scan.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","poi","java");
			
			String sql = "select * from lprod"
					+ " where lprod_id >" + num;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			System.out.println("==== 쿼리문 처리 결과 ====");
			System.out.println();
			System.out.println("Lprod_id \tLprod-gu \tLprod_nm");
			System.out.println("-------------------------------------------------------");
//			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getInt("LPROD_ID")+"\t\t"+ rs.getString("LPROD_GU")+"\t\t"+rs.getString("LPROD_NM"));
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 5. 자원 반납
			if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
			if (stmt != null ) try { stmt.close(); } catch(SQLException e ) {}
			if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
		}
		
	}
	
}
