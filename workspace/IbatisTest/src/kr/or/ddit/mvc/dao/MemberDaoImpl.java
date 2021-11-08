package kr.or.ddit.mvc.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class MemberDaoImpl implements IMemberDao{
	private static MemberDaoImpl dao;
	
	private SqlMapClient smc; 	// ibatis용 SqlMapClient 객체 변수 선언

	// ibatis 환경설정 및 SqlMapCliendt객체 생성
	private MemberDaoImpl() {	
		smc = SqlMapClientFactory.getSqlMapClient();

//		try {
//			// 1-1. 문자 인코딩 캐릭터셋 설정
//			Charset charset = Charset.forName("UTF-8");	
//			Resources.setCharset(charset);
//			
//			// 1-2. 환경설정 파일(sqlMapConfig.xml)을 읽어온다.
//			Reader rd = 
//					Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
//			
//			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
//			// 		SQL문을 호출해서 실행할 객체를 생성한다.
//			 smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//			
//			rd.close();
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
	}
	
	
	public static MemberDaoImpl getInstance() {
		if(dao == null ) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	
	
	@Override
	public int insertMember(MemberVO memvo) {
		int cnt = 0;
		try {
			
			Object obj = smc.insert("member.insertMember", memvo);
			if (obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	
	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		
		try {
			cnt = smc.delete("member.deleteMember", memId);
			
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}
	

	@Override
	public int updateMember(MemberVO memvo) {
		int cnt = 0;
		
		try {
			
			cnt = smc.update("member.updateMember", memvo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> list = null;
		
		try {

			list = smc.queryForList("member.getAllMember");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}


	@Override
	public int getMemberCount(String memId) {
		int count = 0;
		
		try {
			
			count = (int) smc.queryForObject("member.getCountMem",memId);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {
		// key값 정보 ==> 회원ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
		int cnt = 0;
		try {
			
			cnt = smc.update("member.updateMember2", paramMap);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return cnt;
	}

}














