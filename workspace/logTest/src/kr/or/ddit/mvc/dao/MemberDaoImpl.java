package kr.or.ddit.mvc.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import kr.or.ddit.mvc.vo.MemberVO;
 import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl dao;
	
	static Logger logger = Logger.getLogger(MemberDaoImpl.class);
	
	private MemberDaoImpl() {	}
	
	public static MemberDaoImpl getInstance() {
		if(dao == null ) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	
	
	@Override
	public int insertMember(MemberVO memvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성");

			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr)"
					+ " values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_id());
			pstmt.setString(2, memvo.getMem_pass());
			pstmt.setString(3, memvo.getMem_name());
			pstmt.setString(4, memvo.getMem_tel());
			pstmt.setString(5, memvo.getMem_addr());
			logger.info("PreparedStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용한 데이터 : ["+ memvo.getMem_id() + ", "+
			
											memvo.getMem_pass() + ", "+
											memvo.getMem_name() + ", "+
											memvo.getMem_tel() + ", "+
											memvo.getMem_addr() + "] ");
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공");
			
		} catch (SQLException e) {
			logger.error("작업 실패 : " + e);
			cnt = 0;
//			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { 
				pstmt.close(); logger.info("PreparedStatement객체 반납"); 
			} catch(SQLException e) {}
			if (conn!=null) try { 
				conn.close(); logger.info("Connection객체 반납");
			} catch(SQLException e) {}
		}
		return cnt;
	}

	
	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성");
			
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			logger.info("PreparedStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용한 데이터 : [ " + memId + " ]");
			
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공");
			
		} catch (SQLException e) {
			logger.error("작업 실패");
			cnt = 0;
//			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { 
				pstmt.close(); 
				logger.info("PrepatedStatement객체 반납 ");
			} catch(SQLException e) {}
			if (conn!=null) try { 
				conn.close();
				logger.info("Connection객체 반납");
			} catch(SQLException e) {}
		}
		return cnt;
	}
	

	@Override
	public int updateMember(MemberVO memvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			logger.info("Connection객체 생성");
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, "
					+ " mem_addr = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_pass());
			pstmt.setString(2, memvo.getMem_name());
			pstmt.setString(3, memvo.getMem_tel());
			pstmt.setString(4, memvo.getMem_addr());
			pstmt.setString(5, memvo.getMem_id());
			logger.info("PreparedStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용한 데이터 : [ " + memvo.getMem_pass() + ", " +
											   memvo.getMem_name() + ", " + 
											   memvo.getMem_tel() + ", " + 
											   memvo.getMem_addr() + ", " + 
											   memvo.getMem_id() + " ]");
			
			
			cnt = pstmt.executeUpdate();
			logger.info("작업 성공");
		} catch (SQLException e) {
			logger.error("작업 실패");
			cnt = 0;
//			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { 
				pstmt.close(); 
				logger.info("PrepatedStatement객체 반납 ");
			} catch(SQLException e) {}
			if (conn!=null) try { 
				conn.close(); 
				logger.info("Connection객체 반납");
			} catch(SQLException e) {}
		}
		return cnt;
		
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			logger.info("Connection객체 생성");
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			logger.info("PreparedStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			
			rs = pstmt.executeQuery(sql);
			logger.info("ResulteSet객체 생성");
			
			int cnt = 0;
			while (rs.next()) {
				MemberVO memvo = new MemberVO();
				memvo.setMem_id( rs.getString("mem_id") );
				memvo.setMem_pass( rs.getString("mem_pass"));
				memvo.setMem_name( rs.getString("mem_name"));
				memvo.setMem_tel( rs.getString("mem_tel"));
				memvo.setMem_addr( rs.getString("mem_addr"));
				
				cnt++;
				logger.info("VO에 담긴 데이터 [ "
						+ rs.getString("mem_id") +", " +
						rs.getString("mem_pass") +", " +
						rs.getString("mem_name") +", " +
						rs.getString("mem_tel") +", " +
						rs.getString("mem_addr") +" ] ");
				
				list.add(memvo);
				logger.info(cnt-1 + "번째 List 인덱스 생성 성공");
			}
			logger.info("작업 성공");
		} catch (SQLException e) {
			logger.error("작업 실패");
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { 
				pstmt.close(); 
				logger.info("PrepatedStatement객체 반납 ");
			} catch(SQLException e) {}
			if (conn!=null) try { 
				conn.close(); 
				logger.info("Connection객체 반납");
			} catch(SQLException e) {}
			if (rs!=null) try { 
				rs.close(); 
				logger.info("ResultSet객체 반납");
			} catch(SQLException e) {}
		}
		
		return list;

	}


	@Override
	public int getMemberCount(String memId) {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성");
			String  sql = "select count(*) cnt from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			logger.info("PreparedStatement객체 생성");
			pstmt.setString(1, memId);
			logger.info("sql문에 담긴 데이터 : "+ memId);
			rs = pstmt.executeQuery();
			logger.info("ResultSet객체 생성");
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			logger.info("작업 성공");
		} catch (SQLException e) {
			count = 0;
			logger.error("작업 실패");
//			e.printStackTrace();
		}finally {
			if (rs!=null) try { 
				rs.close(); 
				logger.info("ResultSet객체 반납 ");
			} catch(SQLException e) {}
			if (pstmt!=null) try { 
				pstmt.close(); 
				logger.info("PrepatedStatement객체 반납 ");
			} catch(SQLException e) {}
			if (conn!=null) try { 
				conn.close();
				logger.info("Connection객체 반납");
			} catch(SQLException e) {}
		}
		
		return count;
		
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// key값 정보 ==> 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set "
					+ paramMap.get("field") + " = ?"
					+ " where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memId"));
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int databaseToExcel() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		FileOutputStream fos = null;
		int r = 1;
		
		try {
			conn = DBUtil3.getConnection();
			workbook = new XSSFWorkbook();

			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sheet = workbook.createSheet("Member");
			row = sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("PASS");
			row.createCell(2).setCellValue("NAME");
			row.createCell(3).setCellValue("TEL");
			row.createCell(4).setCellValue("ADDR");
			
			while (rs.next()) {
				String id = rs.getString("mem_id");
				String pass = rs.getString("mem_pass");
				String name = rs.getString("mem_name");
				String tel = rs.getString("mem_tel");
				String addr = rs.getString("mem_addr");
				
				row = sheet.createRow(r++);
				
				row.createCell(0).setCellValue(id);
				row.createCell(1).setCellValue(pass);
				row.createCell(2).setCellValue(name);
				row.createCell(3).setCellValue(tel);
				row.createCell(4).setCellValue(addr);
				
				
			}
			
			fos = new FileOutputStream("D:\\DDIT\\3.HighJava\\Excel\\member.xlsx");
			workbook.write(fos);
			
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (workbook!=null) try { workbook.close(); } catch (IOException e) {
				e.printStackTrace();
			}
			if (fos!=null) try { rs.close(); } catch(SQLException e) {}
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return r;
	}

	@Override
	public int readeExcel() {
		String excelFile = "D:\\DDIT\\3.HighJava\\Excel\\member.xlsx";
		FileInputStream input = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		int cnt = 0;
		
		try {
			
			input = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(input);
			sheet = workbook.getSheet("Member");
			
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(1).getLastCellNum();
			
			for (int r = 0; r < rows+1; r++) {
				XSSFRow row = sheet.getRow(r);
				cnt++;
				
				for (int c = 0; c < cols+1; c++) {
					XSSFCell cell = row.getCell(c);
					
					if (cell == null ) {
						System.out.print("\t\t");
						continue;
					} else {
						switch (cell.getCellType()) {
						case STRING:
							System.out.print(cell.getStringCellValue());
							break;
						case FORMULA:
							System.out.print(cell.getCellFormula());
							break;
						case BLANK:
							System.out.print(" ");
							break;

						default: System.out.print("");
							break;
						}
					}
					System.out.print("\t");
				}
				System.out.println();
			}
			
			
			input.close();
			return cnt;
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

}




























