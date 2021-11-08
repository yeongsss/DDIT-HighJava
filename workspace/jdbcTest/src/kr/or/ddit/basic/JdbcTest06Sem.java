package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


import kr.or.ddit.util.DBUtil;
import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

public class JdbcTest06Sem {
	private Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		new JdbcTest06Sem().startMember();
	}
	
	public void startMember() {
		while (true) {
			int choice = displayMenu();
			
			switch (choice) {
				case 1:			// 자료 추가
					insert(); break;
				case 2:			// 자료 삭제
					delete(); break;
				case 3:			// 자료 수정
					update(); break;
				case 4:			// 전체 자료 출력
					displayMember(); break;
				case 5:			// 자료 수정2
					update2(); break;
				case 0:
					System.out.println("작업을 마칩니다.");
					return;
				default: System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}
		
	}
	
	
	// 회원 정보를 수정하는 메소드 ==> 원하는 항목만 수정
	private void update2() {
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID : ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if (count == 0 ) {	// 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return; 
		}
// 선생님 풀이		
		int num;
		String updateField = null;  // 선택한 항목의 컬럼명이 저장될 변수
		String updateTitle = null;  // 선택한 항목의 값을 입력받을 때 나타낼 메시지가 저장될 변수
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요.");
			System.out.println("1.비밀번호  2.회원이름  3.전화번호  4.회원주소 ");
			System.out.println("---------------------------------------");
			System.out.print("수정 항목 선택 >> ");
			num = scan.nextInt();
			
			switch(num) {
				case 1 : updateField = "mem_pass"; updateTitle = "비밀번호";
					break;
				case 2 : updateField = "mem_name"; updateTitle = "회원이름";
					break;
				case 3 : updateField = "mem_tel"; updateTitle = "전화번호";
					break;
				case 4 : updateField = "mem_addr"; updateTitle = "회원주소";
					break;
				default :
					System.out.println("수정할 항목을 잘못 선택했습니다.");
					System.out.println("다시 선택하세요.");
			}
			
		}while(num<1 || num>4);
		
		System.out.println();
		// 수정할 값 입력 받기
		scan.nextLine();  // 버퍼 비우기
		System.out.print("새로운 " + updateTitle + " >> ");
		String updateData = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			
			String sql = "update mymember set " + updateField 
					+ "= ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updateData);
			pstmt.setString(2, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("수정 작업 성공~~~");
			}else {
				System.out.println("수정 작업 실패!!!");
			}
			
					
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) try { pstmt.close();  }catch(SQLException e) {}
			if(conn!=null) try { conn.close();  }catch(SQLException e) {}
		}

		
		
//	내가 만들었었던거..!!	
//		while (true) {
//			int choice = displayUpdate();
//			
//			switch (choice ) {
//				case 1:
//					System.out.print("새로운 비밀번호 : ");
//					String newPass = scan.next();
//					
//					Connection conn1 = null;
//					PreparedStatement pstmt1 = null;
//					try {
//						conn1 = DBUtil2.getConnection();
//						String sql = "update mymember set mem_pass = ? where mem_id = ? ";
//						pstmt1 = conn1.prepareStatement(sql);
//						pstmt1.setString(1, newPass);
//						pstmt1.setString(2, memId);
//						
//						int cnt = pstmt1.executeUpdate();
//						if (cnt >0 ) {
//							System.out.println(memId + "회원 비밀번호 수정 성공");
//						} else {
//							System.out.println(memId + "회원 비밀번호 수정 실패");
//						}
//						
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} finally {
//						if (pstmt1!=null) try { pstmt1.close(); } catch(SQLException e) {}
//						if (conn1!=null) try { conn1.close(); } catch(SQLException e) {}
//					}
//					
//					
//					return;
//				case 2:
//					System.out.print("새로운 회원이름 : ");
//					String newName = scan.next();
//					
//					Connection conn2 = null;
//					PreparedStatement pstmt2 = null;
//					try {
//						conn2 = DBUtil2.getConnection();
//						String sql = "update mymember set mem_name = ? where mem_id = ? ";
//						pstmt2 = conn2.prepareStatement(sql);
//						pstmt2.setString(1, newName);
//						pstmt2.setString(2, memId);
//						
//						int cnt = pstmt2.executeUpdate();
//						if (cnt >0 ) {
//							System.out.println(memId + "회원 이름 수정 성공");
//						} else {
//							System.out.println(memId + "회원 이름 수정 실패");
//						}
//						
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} finally {
//						if (pstmt2!=null) try { pstmt2.close(); } catch(SQLException e) {}
//						if (conn2!=null) try { conn2.close(); } catch(SQLException e) {}
//					}
//					
//					
//					return;
//				case 3:
//					System.out.print("새로운 전화번호 : ");
//					String newTel = scan.next();
//					
//					Connection conn3 = null;
//					PreparedStatement pstmt3 = null;
//					try {
//						conn3 = DBUtil2.getConnection();
//						String sql = "update mymember set mem_tel = ? where mem_id = ? ";
//						pstmt3 = conn3.prepareStatement(sql);
//						pstmt3.setString(1, newTel);
//						pstmt3.setString(2, memId);
//						
//						int cnt = pstmt3.executeUpdate();
//						if (cnt >0 ) {
//							System.out.println(memId + "회원 이름 수정 성공");
//						} else {
//							System.out.println(memId + "회원 이름 수정 실패");
//						}
//						
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} finally {
//						if (pstmt3!=null) try { pstmt3.close(); } catch(SQLException e) {}
//						if (conn3!=null) try { conn3.close(); } catch(SQLException e) {}
//					}
//					
//					
//					return;
//				case 4:
//					System.out.print("새로운 회원주소 : ");
//					scan.next();
//					String newAddr = scan.nextLine();
//					
//					Connection conn4 = null;
//					PreparedStatement pstmt4 = null;
//					try {
//						conn4 = DBUtil2.getConnection();
//						String sql = "update mymember set mem_addr = ? where mem_id = ? ";
//						pstmt4 = conn4.prepareStatement(sql);
//						pstmt4.setString(1, newAddr);
//						pstmt4.setString(2, memId);
//						
//						int cnt = pstmt4.executeUpdate();
//						if (cnt >0 ) {
//							System.out.println(memId + "회원 이름 수정 성공");
//						} else {
//							System.out.println(memId + "회원 이름 수정 실패");
//						}
//						
//					} catch (SQLException e) {
//						e.printStackTrace();
//					} finally {
//						if (pstmt4!=null) try { pstmt4.close(); } catch(SQLException e) {}
//						if (conn4!=null) try { conn4.close(); } catch(SQLException e) {}
//					}
//					
//					return;
//	
//				default:
//					System.out.println("잘못입력하셨습니다. 다시 입력하세요");
//			}
//		}
	}
//
//	// 원하는 항목 선택 메소드
//		private int displayUpdate() {
//			
//			System.out.println("=======================================");
//			System.out.println("          == 항 목 선 택 ==");
//			System.out.println("          1. 비 밀 번 호 ");
//			System.out.println("          2. 회 원 이 름 ");
//			System.out.println("          3. 전 화 번 호 ");
//			System.out.println("          4. 회 원 주 소 ");
//			System.out.println("=======================================");
//			System.out.print("원하는 항목 선택 >> ");
//			int num = scan.nextInt();
//			return num;		
//		}
	
	
	// 회원 정보를 수정하는 메소드 ==> 전체 항목 수정
	private void update() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID : ");
		String memId = scan.next();
		
		int count = getMemberCount(memId);
		if (count == 0 ) {	// 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return; 
		}
		
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 비밀번호 : ");
		String newPass = scan.next();

		System.out.print("새로운 회원이름 : ");
		String newName = scan.next();
		
		System.out.print("새로운 전화번호 : ");
		String newTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 회원주소 : ");
		String newAddr = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, "
					+ " mem_addr = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPass);
			pstmt.setString(2, newName);
			pstmt.setString(3, newTel);
			pstmt.setString(4, newAddr);
			pstmt.setString(5, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if ( cnt > 0 ) {
				System.out.println(memId + " 회원 정보 수정 성공");
			} else {
				System.out.println(memId + " 회원 정보 수정 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
	}
	

	// 자료를 삭제하는 메소드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("삭제할 회원ID : ");
		String memId = scan.next();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil2.getConnection();
			
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt > 0 ) {
				System.out.println(memId + " 회원 정보를 삭제했습니다.");
			} else {
				System.out.println(memId + " 회원은 없는 회원이거나 삭제에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		
	}

	// 자료를 추가하는 메소드
	private void insert() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		int count = 0;
		String memId;
		do {
			System.out.print("회원 ID : ");
			memId = scan.next();
			count = getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		}while(count >0 );
		
		System.out.println("비밀번호 : ");
		String memPass = scan.next();
		System.out.println("회원이름 : ");
		String memName = scan.next();
		System.out.println("전화번호 : ");
		String memTel = scan.next();
		
		scan.nextLine();	// 입력 버퍼 비우기
		System.out.println("회원주소 : ");
		String memAddr = scan.nextLine();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil2.getConnection();
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr)"
					+ " values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPass);
			pstmt.setString(3, memName);
			pstmt.setString(4, memTel);
			pstmt.setString(5, memAddr);
			
			int cnt = pstmt.executeUpdate();
			
			if (cnt >0 ) {
				System.out.println(memId + " 회원 정보 추가 성공");
			} else {
				System.out.println(memId + " 회원 정보 추가 실패");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		
	}
	
	// 매개변수로 회원ID를 받아서 해당 회원ID의 개수를 반환하는 메소드
	private int getMemberCount(String memId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil2.getConnection();
			String  sql = "select count(*) cnt from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		}finally {
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		return count;
		
		
	}
	
	
	

	// 메뉴를 출력하는 메소드
	private int displayMenu() {
		System.out.println("=======================================");
		System.out.println("          == 작 업 선 택 ==");
		System.out.println("          1. 자 료 추 가 ");
		System.out.println("          2. 자 료 삭 제 ");
		System.out.println("          3. 자 료 수 정 ");
		System.out.println("          4. 전 체 자 료 출 력 ");
		System.out.println("          5. 자 료 선 택 수 정 ");
		System.out.println("          0. 작 업 끝 ");
		System.out.println("=======================================");
		System.out.print("원하는 작업 선택 >> ");
		int num = scan.nextInt();
		return num;		
	}
	
	// 전체 회원 정보를 출력하는 메소드
	private void displayMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println("------------------------------------------------");
		System.out.println(" ID    비밀번호   이름     전화번호      주소  ");
		System.out.println("------------------------------------------------");
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			int cnt = 0;
			while (rs.next()) {
				cnt++;
				String memId = rs.getString("mem_id");
				String memPass = rs.getString("mem_pass");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				System.out.println(memId + "  "+ memPass + "  "+ memName + "  " + memTel + "    "+ memAddr);
			}
			
			if (cnt==0) {
				System.out.println("    회원 정보가 하나도 없습니다.");
			}
			
			System.out.println("---------------------------------------------------");
			System.out.println("출력 끝..");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			if (stmt!=null) try { stmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		
		
	}
	
	
	
	
	
	
}







