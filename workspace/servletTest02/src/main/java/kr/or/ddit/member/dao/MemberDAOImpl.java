package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO {
	private SqlMapClient smc;
	
	private static MemberDAOImpl instance;
	
	public static MemberDAOImpl getInstance() {
		if (instance==null) instance = new MemberDAOImpl();
		
		return instance;			
	}
	
	
	public MemberDAOImpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<MemberVO> getMemberList() {
		List<MemberVO> memberList = null;
		
		try {
			memberList = smc.queryForList("member.memberList");
		} catch (SQLException e) {
			memberList = null;
			e.printStackTrace();
		}
		return memberList;
		
	}

	@Override
	public int addMember(MemberVO memvo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("member.memberAdd", memvo);
			if (obj == null) {
				cnt = 1;
			}
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}


	@Override
	public MemberVO memberInfo(String mem_id) {
		
		MemberVO memvo =null;
		
		try {
			memvo = (MemberVO)smc.queryForObject("member.memberInfo");
			System.out.println(memvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memvo;
	}


	@Override
	public int updateMember(MemberVO memvo) {
		int cnt = 0;
		try {
			Object obj = smc.update("member.updateMember", memvo);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public int deleteMember(String mem_id) {
		int cnt = 0;
		try {
			Object obj = smc.delete("member.deleteMember", mem_id);
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
}
