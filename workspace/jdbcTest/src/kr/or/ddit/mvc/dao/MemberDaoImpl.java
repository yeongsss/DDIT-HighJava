package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
 import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl dao;
	
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
			String sql = "insert into mymember (mem_id, mem_pass, mem_name, mem_tel, mem_addr)"
					+ " values(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_id());
			pstmt.setString(2, memvo.getMem_pass());
			pstmt.setString(3, memvo.getMem_name());
			pstmt.setString(4, memvo.getMem_tel());
			pstmt.setString(5, memvo.getMem_addr());
			
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
	public int deleteMember(String memId) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			
			String sql = "delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
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
	public int updateMember(MemberVO memvo) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "update mymember set mem_pass = ?, mem_name = ?, mem_tel = ?, "
					+ " mem_addr = ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memvo.getMem_pass());
			pstmt.setString(2, memvo.getMem_name());
			pstmt.setString(3, memvo.getMem_tel());
			pstmt.setString(4, memvo.getMem_addr());
			pstmt.setString(5, memvo.getMem_id());
			
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
	public List<MemberVO> getAllMemberList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = "select * from mymember";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberVO memvo = new MemberVO();
				memvo.setMem_id( rs.getString("mem_id") );
				memvo.setMem_pass( rs.getString("mem_pass"));
				memvo.setMem_name( rs.getString("mem_name"));
				memvo.setMem_tel( rs.getString("mem_tel"));
				memvo.setMem_addr( rs.getString("mem_addr"));
				
				list.add(memvo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
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

}








