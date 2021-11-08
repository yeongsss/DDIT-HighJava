package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제) Lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터  큰 값 사이의 자료를 출력하시오 
*/
public class JdbcTest03 {
	public static void main(String[] args) {
		Scanner scn =  new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		System.out.print("Lprod_id값 입력1: ");
		int input1 = scn.nextInt();
		String min = null;
		
		System.out.print("Lprod_id값 입력2: ");
		int input2 = scn.nextInt();
		String max = null;
		
		int temp = 0;
		
		if (input1 > input2 ) {
			temp = input1;
			min = input2 + "";
			max = temp + "";
		}
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","poi","java");
			
//			String sql = "SELECT LPROD_ID, LPROD_GU, LPROD_NM AS NM"
//					   + " FROM LPROD"
//				       + " WHERE LPROD_ID >=  " + input1
//				       + "  AND LPROD_ID <=  " + input2 ;
//			
//			stmt = conn.createStatement();
//			
//			rs = stmt.executeQuery(sql);
//			
//			System.out.println();
//			System.out.println("============== 쿼리문 처리 결과 ==============");
//			System.out.println();
//			System.out.println("Lprod_id \tLprod-gu \tLprod_nm");
//			System.out.println();
//			while (rs.next()) {
//				System.out.println(rs.getInt("LPROD_ID")+"\t\t"+ rs.getString(2)+"\t\t"+rs.getString("NM"));
//				System.out.println("------------------------------------------------");
//			}
			
			
			String sql = "SELECT LPROD_ID, LPROD_GU, LPROD_NM AS NM"
					   + " FROM LPROD"
				       + " WHERE LPROD_ID >= ? " 
					   + "  AND LPROD_ID <= ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, min);
			pstmt.setString(2, max);
			
			rs = pstmt.executeQuery();
			
			System.out.println();
			System.out.println("============== 쿼리문 처리 결과 ==============");
			System.out.println();
			System.out.println("Lprod_id \tLprod-gu \tLprod_nm");
			System.out.println();
			while (rs.next()) {
				System.out.println(rs.getInt("LPROD_ID")+"\t\t"+ rs.getString(2)+"\t\t"+rs.getString("NM"));
				System.out.println("------------------------------------------------");
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
