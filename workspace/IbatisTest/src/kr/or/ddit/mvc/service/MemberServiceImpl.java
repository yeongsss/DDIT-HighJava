package kr.or.ddit.mvc.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;	// DAO객체가 저장될 변수 선언
	private String key = "a1b2c3d4e5f6g7h8";
	
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
		try {
			String id = memvo.getMem_id();
			String pass = memvo.getMem_pass();
			
			memvo.setMem_id(CryptoUtil.encryptAES256(id, key));
			memvo.setMem_pass(CryptoUtil.sha512(pass));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao.insertMember(memvo);
	}

	@Override
	public int deleteMember(String memId) {
		try {
			memId = CryptoUtil.encryptAES256(memId, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memvo) {
		try {
			memvo.setMem_id(CryptoUtil.encryptAES256(memvo.getMem_id(), key));
			memvo.setMem_pass(CryptoUtil.sha512(memvo.getMem_pass()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao.updateMember(memvo);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> list = dao.getAllMemberList();
		
		for (MemberVO memberVO : list) {
			try {
				String id = CryptoUtil.decryptAES256(memberVO.getMem_id(), key);
				memberVO.setMem_id(id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		try {
			memId = CryptoUtil.encryptAES256(memId, key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao.getMemberCount(memId);
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		try {
			String id = paramMap.get("memId");
			paramMap.put("memId", CryptoUtil.encryptAES256(id, key));
			
			String field = paramMap.get("field");
			if (field.equals("mem_pass")) {
				String data = paramMap.get("data");
				paramMap.put("data", CryptoUtil.sha512(data));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dao.updateMember2(paramMap);
	}

}
