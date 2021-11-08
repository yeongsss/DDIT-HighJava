package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private static MemberServiceImpl instance = null;
	private MemberDAOImpl dao = null;
	private MemberServiceImpl() {
		if (dao == null ) dao = MemberDAOImpl.getInstance();
	};
	
	public static MemberServiceImpl getInstance() {
		if (instance == null )	instance = new MemberServiceImpl();
		return instance;
	}

	@Override
	public List<MemberVO> getList(MemberVO memberInfo) {
//		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		List<MemberVO> list = null;
		
		list = dao.getList(memberInfo);
		
		return list;
	}
	public MemberVO getMemberInfo(MemberVO memberInfo) {
//		MemberVO memberInfo = new MemberVO();
//		memberInfo = dao.getMemberInfo(mem_id);
//		return memberInfo;
	
		return dao.getList(memberInfo).get(0);
		
	
	}


	
	
}
