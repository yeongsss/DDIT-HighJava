package ddit.service;

import java.util.List;

import ddit.dao.SanctionDocumentDAOImpl;
import ddit.vo.SanctionDocumentVO;

public class SanctionDocumentServiceImpl implements ISanctionDocumentService {
	
	private static SanctionDocumentServiceImpl instance = null;
	private SanctionDocumentDAOImpl dao = null;
	private SanctionDocumentServiceImpl() {
		if(dao==null) dao = SanctionDocumentDAOImpl.getInstance();
	}
	public static SanctionDocumentServiceImpl getInstance() {
		if(instance==null) instance = new SanctionDocumentServiceImpl();
		return instance;
	}
	@Override
	public int insertSanDoc(SanctionDocumentVO sanDocVo) {
		return dao.insertSanDoc(sanDocVo);
	}
	@Override
	public int updateSanDoc(SanctionDocumentVO sanDocVo) {
		return dao.updateSanDoc(sanDocVo);
	}
	@Override
	public int deleteSanDoc(int sanNo) {
		return dao.deleteSanDoc(sanNo);
	}
	@Override
	public List<SanctionDocumentVO> getSanDocList(String sanNm) {
		return dao.getSanDocList(sanNm);
	}
	@Override
	public List<SanctionDocumentVO> getSanDoc(SanctionDocumentVO sanDocVo) {
		return dao.getSanDoc(sanDocVo);
	}
	
	
}