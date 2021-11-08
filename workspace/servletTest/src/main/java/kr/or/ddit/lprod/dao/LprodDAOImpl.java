package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.lprod.vo.LprodVO;

public class LprodDAOImpl implements ILprodDAO{
	
	private static LprodDAOImpl dao;
	
	private SqlMapClient smc;
	
	private LprodDAOImpl() {
//		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static LprodDAOImpl getInstance() {
		if(dao ==null) dao = new LprodDAOImpl();
		
		return dao;
	}
	
	
	@Override
	public List<LprodVO> getLprodList() {
		List<LprodVO> list = null;
		
		try {
			
			list = smc.queryForList("lprod.prodList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}











