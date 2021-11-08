package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO {
	
	private static MemberDAOImpl instance = null;
	private static SqlMapClient smc  = null;
	private MemberDAOImpl() {
		if (smc == null) smc = SqlMapClientFactory.getSqlMapClient();
	};
	
	public static MemberDAOImpl getInstance() {
		if (instance == null) instance = new MemberDAOImpl();
		return instance;
	}

	@Override
	public List<MemberVO> getList(MemberVO memberInfo) {
//		SqlMapClient smc = SqlMapClientFactory.getSqlMapClient();
		List<MemberVO> list = null;
		
		try {
			list = smc.queryForList("member.getList", memberInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVO getMemberInfo(String mem_id) {

		MemberVO memberInfo = null;
		
		try {
			memberInfo = (MemberVO) smc.queryForObject("member.getMemberInfo", mem_id);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberInfo;
	}
	
	

}
