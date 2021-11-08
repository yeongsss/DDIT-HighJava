package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	
	private IMemberDAO dao;
	
	private static MemberServiceImpl service;
	
	public static MemberServiceImpl getService() {
		if (service == null ) service = new MemberServiceImpl();
		
		return service;			
	}
	
	
	@Override
	public List<MemberVO> getMemberList() {
		return dao.getMemberList();
	}

	@Override
	public int addMember(MemberVO memvo) {
		return dao.addMember(memvo);
	}

	@Override
	public MemberVO memberInfo(String mem_id) {
		return dao.memberInfo(mem_id);
	}

	@Override
	public int updateMember(MemberVO memvo) {
		return dao.updateMember(memvo);
	}

	@Override
	public int deleteMember(String mem_id) {
		return dao.deleteMember(mem_id);
	}



	
	
	
	
	
	
}
