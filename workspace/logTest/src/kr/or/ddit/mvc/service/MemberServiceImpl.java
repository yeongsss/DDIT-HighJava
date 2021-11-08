package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;	// DAO객체가 저장될 변수 선언
	
	private static MemberServiceImpl serviceSingle;
	
	// 생성자
//	public MemberServiceImpl() {
//		dao = new MemberDaoImpl();
//	}
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();	// DAO객체 생성
	}
	
	public static MemberServiceImpl getInstance() {
		if(serviceSingle == null ) serviceSingle = new MemberServiceImpl();
		
		return serviceSingle;
	}
	

	@Override
	public int insertMember(MemberVO memvo) {
		return dao.insertMember(memvo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memvo) {
		return dao.updateMember(memvo);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return dao.getAllMemberList();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		return dao.updateMember2(paramMap);
	}

	@Override
	public int databaseToExcel( ) {
		return dao.databaseToExcel();
	}

	@Override
	public int readeExcel() {
		return dao.readeExcel();
	}

}
