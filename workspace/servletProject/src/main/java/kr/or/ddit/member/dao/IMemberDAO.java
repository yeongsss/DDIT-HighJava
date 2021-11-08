package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberDAO {

	List<MemberVO> getList(MemberVO memberInfo);

	MemberVO getMemberInfo(String mem_id);
	
	
	
}
