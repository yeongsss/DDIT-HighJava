package kr.or.ddit.board.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient; 
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.board.vo.BoardVO;

public class BoardDaoImpl implements IBoardDao{
	private static BoardDaoImpl dao;
	
	private SqlMapClient smc;
	
	private BoardDaoImpl() {
		
		try {
			// 1-1. 문자 인코딩 캐릭터셋 설정
		 	Charset charset = Charset.forName("UTF-8");	
			Resources.setCharset(charset);
			
			// 1-2. 환경설정 파일(sqlMapConfig.xml)을 읽어온다.
			Reader rd = 
					Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경설정을 완성한 후 
			// 		SQL문을 호출해서 실행할 객체를 생성한다.
			 smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static BoardDaoImpl getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public int insertBoard(BoardVO bvo) {
		int cnt = 0;
		
		try {
			
			Object obj = smc.insert("board.insertBoard", bvo);
			
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
	public int deletBoard(int boardNo) {
		int cnt = 0;
		
		try {

			cnt = smc.delete("board.deleteBoard", boardNo);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO bvo) {
		int cnt = 0;
		
		try {
			
			cnt = smc.update("board.updateBoard", bvo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	@Override
	public List<BoardVO> getAllBoardList() {
		List<BoardVO> list = null;
		
		try {
			
			list = smc.queryForList("board.getAllBoard");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	@Override
	public List<BoardVO> searchBoardList(String boardTitle) {
		List<BoardVO> list = null;
		
		try {
			
			list = smc.queryForList("board.searchBoard", boardTitle);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		BoardVO vo = new BoardVO();
		
		try {

			int cnt = smc.update("board.viewBoard", boardNo);
			
			vo = (BoardVO)smc.queryForObject("board.getBoard", boardNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int boardTitleCount(String title) {
		int count = 0;  
		
		try {
			
			count = (int) smc.queryForObject("board.boardCount", title);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
	
}








