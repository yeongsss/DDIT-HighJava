package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {

	public List<MemberVO> getMemberList();

	public int addMember(MemberVO memvo);
	
	public MemberVO memberInfo(String mem_id);
	
	public int updateMember(MemberVO memvo);
	
	public int deleteMember(String mem_id);
	
}
