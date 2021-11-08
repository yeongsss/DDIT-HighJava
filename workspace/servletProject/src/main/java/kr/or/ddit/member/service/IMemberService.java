package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.vo.MemberVO;

public interface IMemberService {

	List<MemberVO> getList(MemberVO memberInfo);

	MemberVO getMemberInfo(MemberVO memberInfo);




}
