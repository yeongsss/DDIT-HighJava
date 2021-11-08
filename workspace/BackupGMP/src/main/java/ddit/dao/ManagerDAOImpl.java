package ddit.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.config.BuildedSqlMapClient;
import ddit.vo.DepartmentVO;
import ddit.vo.MemberInfoVO;
import ddit.vo.MemberVO;
import ddit.vo.SalaryVO;
import ddit.vo.WorkManagementVO;

public class ManagerDAOImpl implements IManagerDAO{

	private static ManagerDAOImpl instance;
	private SqlMapClient smc; 
	private ManagerDAOImpl() {
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	public static ManagerDAOImpl getInstance() {
		if (instance==null) instance = new ManagerDAOImpl();
		return instance;
	}
	
	@Override
	public List<WorkManagementVO> getWorkList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMemInfo(MemberInfoVO memInfoVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemInfo(MemberInfoVO memberInfoVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMemInfo(int infoNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MemberInfoVO> getMemInfoList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberInfoVO getMemInfo(int memNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertSal(SalaryVO salVo) {
		int cnt = 0;
		
		try {
			Object obj = smc.insert("manager.insertSalary",salVo);
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
	public List<SalaryVO> getSalaryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SalaryVO getSalary(int memNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartmentVO> departmentList() {
		List<DepartmentVO> list = null;
				
		try {
			list = smc.queryForList("manager.departmentList");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> departmentMember(int memNo) {
		List<MemberVO> list = null;
		
		try {
			list = smc.queryForList("manager.departmentMemberList",memNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MemberVO> deptMemberDetail(int memNo) {
			
		List<MemberVO> list = null;
		
		try {
			list = (List<MemberVO>) smc.queryForList("manager.deptMemberDetail",memNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> departMemberInfo(int memNo) {
		
		List<MemberVO> list = null;
		
		try {
			list = (List<MemberVO>)smc.queryForList("manager.deptMemberInfo",memNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SalaryVO> getSalaryList(int memNo) {
		
		List<SalaryVO> list = null;
		
		try {
			list = smc.queryForList("manager.getSalary",memNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}












