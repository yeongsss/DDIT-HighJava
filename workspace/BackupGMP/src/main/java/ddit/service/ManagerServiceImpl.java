package ddit.service;

import java.util.List;

import ddit.dao.ManagerDAOImpl;
import ddit.vo.DepartmentVO;
import ddit.vo.MemberInfoVO;
import ddit.vo.MemberVO;
import ddit.vo.SalaryVO;
import ddit.vo.WorkManagementVO;

public class ManagerServiceImpl implements IManagerService{

	private static ManagerServiceImpl instance;
	private ManagerDAOImpl dao;
	private ManagerServiceImpl() {
		dao = ManagerDAOImpl.getInstance();
	}
	
	public static ManagerServiceImpl getInstance() {
		if (instance == null) instance = new ManagerServiceImpl();
		return instance;
	}
	
	
	
	@Override
	public List<WorkManagementVO> getWorkList() {
		return dao.getWorkList();
	}

	@Override
	public int insertMemInfo(MemberInfoVO memInfoVo) {
		return dao.insertMemInfo(memInfoVo);
	}

	@Override
	public int updateMemInfo(MemberInfoVO memberInfoVo) {
		return dao.updateMemInfo(memberInfoVo);
	}

	@Override
	public int deleteMemInfo(int infoNo) {
		return dao.deleteMemInfo(infoNo);
	}

	@Override
	public List<MemberInfoVO> getMemInfoList() {
		return dao.getMemInfoList();
	}

	@Override
	public MemberInfoVO getMemInfo(int memNo) {
		return dao.getMemInfo(memNo);
	}

	@Override
	public int insertSal(SalaryVO salVo) {
		return dao.insertSal(salVo);
	}

	@Override
	public List<SalaryVO> getSalaryList() {
		return dao.getSalaryList();
	}

	@Override
	public SalaryVO getSalary(int memNo) {
		return dao.getSalary(memNo);
	}

	@Override
	public List<DepartmentVO> departmentList() {
		return dao.departmentList();
	}

	@Override
	public List<MemberVO> departmentMember(int deptNO) {
		return dao.departmentMember(deptNO);
	}

	@Override
	public List<MemberVO> deptMemberDetail(int memNo) {
		return dao.deptMemberDetail(memNo);
	}

	@Override
	public List<MemberVO> departMemberInfo(int memNo) {
		
		List<MemberVO> list = deptMemberDetail(memNo);
		
		if (list == null || list.size()==0) {
			list = dao.departMemberInfo(memNo);
		}
		return list;
	}

	@Override
	public List<SalaryVO> getSalaryList(int memNo) {
		return dao.getSalaryList(memNo);
	}
}







