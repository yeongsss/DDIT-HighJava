package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.util.DBUtil3;

public class BoardDaoImpl implements IBoardDao{
	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() {	}

	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public int insertBoard(BoardVO bvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "INSERT INTO JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE,BOARD_CONTENT)"
					   + "    VALUES(BOARD_SEQ.NEXTVAL, ?, ? ,SYSDATE,? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoard_title());
			pstmt.setString(2, bvo.getBoard_writer());
			pstmt.setString(3, bvo.getBoard_content());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		return cnt;
	}

	@Override
	public int deletBoard(int boardNo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "DELETE FROM JDBC_BOARD"
					   + " WHERE BOARD_NO = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
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
	public int updateBoard(BoardVO bvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "UPDATE JDBC_BOARD"
					   + "   SET BOARD_TITLE = ? ,"
					   + "       BOARD_CONTENT = ? "
					   + " WHERE BOARD_NO = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBoard_title());
			pstmt.setString(2, bvo.getBoard_content());
			pstmt.setInt(3, bvo.getBoard_no());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) { }
			if (conn!=null) try { conn.close(); } catch(SQLException e) { }
		}
		
		return cnt;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT"
					   + " FROM JDBC_BOARD";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBoard_no(rs.getInt("BOARD_NO"));
				bvo.setBoard_title(rs.getString("BOARD_TITLE"));
				bvo.setBoard_writer(rs.getString("BOARD_WRITER"));
				bvo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				
				list.add(bvo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			
		}
		
		return list;
	}
	

	@Override
	public List<BoardVO> searchBoardList(String boardTitle) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT"
					   + " FROM JDBC_BOARD"
					   + " WHERE BOARD_TITLE LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%"+boardTitle+"%");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBoard_no(rs.getInt("BOARD_NO"));
				bvo.setBoard_title(rs.getString("BOARD_TITLE"));
				bvo.setBoard_writer(rs.getString("BOARD_WRITER"));
				bvo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				
				
				list.add(bvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return list;
	}

	@Override
	public List<BoardVO> getBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "SELECT BOARD_TITLE, BOARD_WRITER, BOARD_CONTENT, BOARD_DATE, BOARD_CNT"
					   + " FROM JDBC_BOARD"
					   + " WHERE BOARD_NO = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBoard_title(rs.getString("BOARD_TITLE"));
				bvo.setBoard_writer(rs.getString("BOARD_WRITER"));
				bvo.setBoard_content(rs.getString("BOARD_CONTENT"));
				bvo.setBoard_date(rs.getString("BOARD_DATE"));
				bvo.setBoard_cnt(rs.getInt("BOARD_CNT"));
				
				list.add(bvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		return list;
	}

	@Override
	public int boardTitleCount(String title) {
		int count = 0;  
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "SELECT COUNT(*) CNT "
					   + "  FROM JDBC_BOARD "
					   + " WHERE BOARD_TITLE LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("CNT");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null) try { rs.close(); } catch(SQLException e) {}
			if (pstmt!=null) try { pstmt.close(); } catch(SQLException e) {}
			if (conn!=null) try { conn.close(); } catch(SQLException e) {}
		}
		
		return count;
	}
	
}








