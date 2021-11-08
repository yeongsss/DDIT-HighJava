package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDAO;
import kr.or.ddit.lprod.dao.LprodDAOImpl;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodServiceImpl implements ILprodService{
	private static LprodServiceImpl instance;
	public static LprodServiceImpl getInstance() {
		if(instance==null) instance = new LprodServiceImpl();
		return instance;
	}
	
	private ILprodDAO dao;
	
	private LprodServiceImpl() {
		dao = LprodDAOImpl.getInstance();
	}
	
	@Override
	public List<LprodVO> getLprodList() {
		return dao.getLprodList();
	}

}
