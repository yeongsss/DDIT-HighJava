package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
	문제) LPROD테이블에 새로운 데이터를 추가하기
			Lprod_gu와 Lprod_nm은 직접 입력받아서 처리하고,
			Lprod_id는 현재의 Lprod_id중 제일 큰 값보다 1만큼 크게해서 처리한다.
			그리고 입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
*/

public class JdbcTest05 {
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String gu = "";
		String nm = "";
		String id = "1";
		
		
		System.out.print("Lprod_gu 입력 : ");
		gu = scn.next();
		
		System.out.print("Lprod_nm 입력 : ");
		nm = scn.next();
		
		
		
		try {
			// 프로그램 실행할때 한번만 작성해주면 됨
			Class.forName("oracle.jdbc.driver.OracleDriver");	
			
			// 이건 매번 작성해줘야한다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","poi","java");		
			
			
			String sql = "SELECT COUNT(*) "
					   + " FROM LPROD "
					   + " WHERE LPROD_GU = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gu);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				if (rs.getInt("COUNT(*)") == 1) {
					System.out.println("Lprod_gu가 중복됩니다. 다시 입력하세요 \n");
					System.out.print("Lprod_gu 입력 : ");
					gu = scn.next();

					System.out.print("Lprod_nm 입력 : ");
					nm = scn.next();

				}
				break;
			}
			
			
			sql = "SELECT MAX(LPROD_ID) AS ID "
				+ " FROM LPROD" ;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				id = rs.getInt("ID")+1+ "";
			}
			
			
			sql = "INSERT INTO LPROD "
				+ " VALUES ( ? , ? , ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
//			pstmt.executeUpdate();
			
			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("업데이트 되었습니다.");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
			if (stmt != null ) try { stmt.close(); } catch(SQLException e ) {}
			if (pstmt != null ) try { pstmt.close(); } catch(SQLException e ) {}
			if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
			
		}
		
		
	}
	
	
}





































