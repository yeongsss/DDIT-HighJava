package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.net.ssl.SNIHostName;

import kr.or.ddit.util.DBUtil;

/*
	회원을 관리하는 프로그램을 작성하시오.
	(오라클의 MYMEMBER 테이블 이용)
	
	아래 메뉴의 기능을 모두 구현하시오. (CRUD기능 구현하기)
	
	메뉴예시)
	===============================
			-- 작업 선택 --
			1. 자료 추가
			2. 자료 삭제
			3. 자료 수정
			4. 전체 자료 출력
			0. 작업 끝.
	===============================
	
	처리 조건)
	1) 자료 추가에서 '회원ID'는 중복되지 않는다. (중복되면 다시 입력 받는다.)
	2) 자료 삭제는 '회원ID'를 입력 받아서 처리한다.
	3) 자료 수정에서 '회원ID'는 변경되지 않는다.

*/
public class JdbcTest06 {
	Scanner scn ;
	
	public JdbcTest06() {
		scn = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new JdbcTest06().start();
	}

	public void start() {
		while (true) {

			System.out.println();
			System.out.println("====================================================");
			System.out.println("		-- 작업 선택 --");
			System.out.println("		1. 자료 추가");
			System.out.println("		2. 자료 삭제");
			System.out.println("		3. 자료 수정");
			System.out.println("		4. 전체 자료 출력");
			System.out.println("		0. 작업 끝.");
			System.out.println("====================================================");
			System.out.print("번호 선택 :");
			int choice = scn.nextInt();

			switch (choice) {
				case 1:
					insert(); break;
				case 2:
					delete(); break;
	
				case 3:
					update(); break;
				
				 case 4:
					 totalData(); break;
				
				 case 0:
					 System.out.println("작업을 종료합니다.");
				 return;
				
				default:
					System.out.println("번호를 잘못 입력했습니다.");
					System.out.println("다시 입력하세요.");
			}
		}
	}

	public void totalData() {
		Connection conn = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			System.out.println();
			System.out.println(">> 전체 MEMBER를 조회합니다.");
			System.out.println();
			
			String sql = "SELECT MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR "
				       + " FROM MYMEMBER";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("아이디\t이름\t\t전화번호\t주소");
			System.out.println("----------------------------------------------------");
				
			while (rs.next()) {
				System.out.println(rs.getString("MEM_ID")+ "\t" +rs.getString("MEM_NAME")+ "\t\t" + rs.getString("MEM_TEL")+ "\t\t" + rs.getString("MEM_ADDR") );
			}
			System.out.println("----------------------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
			if (stmt != null ) try { stmt.close(); } catch(SQLException e ) {}
			if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
		}
		return;
	}

	public void update() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			
			System.out.println();
			System.out.println(">> MEMBER를 수정합니다.");
			System.out.println();
			System.out.print("수정할 ID : ");
			String id = scn.next();
			
			System.out.print("비밀번호 변경 : ");
			String pw = scn.next();
			
			System.out.print("이  름   변경 : ");
			String name = scn.next();
			
			System.out.print("전화번호 변경 : ");
			String tel = scn.next();
			
			System.out.print("주   소  변경 : ");
			scn.nextLine();
			String addr = scn.nextLine();
			
			String sql = "UPDATE MYMEMBER "
					   + "   SET MEM_PASS = ? , "
					   + "       MEM_NAME = ? ,"
					   + "       MEM_TEL = ? ,"
					   + "       MEM_ADDR = ?"
					   + " WHERE MEM_ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			pstmt.setString(4, addr);
			pstmt.setString(5, id);
			
			int cnt = pstmt.executeUpdate();
			if (cnt >0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
			if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
			if (pstmt != null ) try { pstmt.close(); } catch(SQLException e ) {}
		}
		
		
		return;
		
		
		
	}

	public void delete() {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = DBUtil.getConnection();
			
			System.out.println();
			System.out.println(">> MEMBER를 삭제합니다.");
			System.out.print("삭제할 ID : ");
			String id = scn.next();
			
			// 아이디 중복확인
			String sql1 = "SELECT COUNT(*) CNT "
					   + " FROM MYMEMBER "
					   + " WHERE MEM_ID = ? ";
			
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, id);
			
			rs = pstmt1.executeQuery();
			
			while (rs.next()) {
				if (rs.getInt("CNT") == 0) {
					System.out.println();
					System.out.println("입력한 아이디 "+ id + "는 없는 아이디입니다.");
					System.out.println("다시 입력하세요.");
					System.out.print("ID : ");
					id = scn.next();
					continue;
				}
				break;
			}
			
			
			
			
			String sql2 = "DELETE FROM MYMEMBER"
					   + " WHERE MEM_ID = ?";
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, id);
			
			int cnt = pstmt2.executeUpdate();
			
			if (cnt >0 ) {
				System.out.println("삭제 성공");	
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
			if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
			if (pstmt2 != null ) try { pstmt2.close(); } catch(SQLException e ) {}
		}
		return;
		
	}

	public void insert() {		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = DBUtil.getConnection();
			System.out.println(">> MEMBER를 추가합니다.");
			System.out.print("ID : ");
			String id = scn.next();
			
			// 아이디 중복확인
			String sql1 = "SELECT COUNT(*) CNT "
					   + " FROM MYMEMBER "
					   + " WHERE MEM_ID = ? ";
			
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, id);
			
			rs = pstmt1.executeQuery();
			
			while (rs.next()) {
			
				if (rs.getInt("CNT") == 1) {
					System.out.println();
					System.out.println("입력한 아이디 "+ id + "는 이미 등록된 아이디입니다.");
					System.out.println("다시 입력하세요.");
					System.out.print("ID : ");
					id = scn.next();
					continue;
				}
				break;
			}
			
			
			
			
			
			System.out.print("PASSWORD :");
			String pw = scn.next();
			
			System.out.print("NAME :");
			String name = scn.next();
			
			System.out.print("TEL : ");
			String tel = scn.next();
			
			System.out.print("ADDR : ");
			String addr = scn.next();
			
			int count = 0;
			
			
			
			String sql2 = "INSERT INTO MYMEMBER"
					    + " VALUES (?,?,?,?,?)";
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, id);
			pstmt2.setString(2, pw);
			pstmt2.setString(3, name);
			pstmt2.setString(4, tel);
			pstmt2.setString(5, addr);
			
			int cnt = pstmt2.executeUpdate();
			if (cnt >0 ) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null ) try { conn.close(); } catch(SQLException e ) {}
			if (rs != null ) try { rs.close(); } catch(SQLException e ) {}
			if (pstmt1 != null ) try { pstmt1.close(); } catch(SQLException e ) {}
			if (pstmt2 != null ) try { pstmt2.close(); } catch(SQLException e ) {}
		}
		
		return;
		
	}
	
	
	
	
	
	
	
	
	
}

















