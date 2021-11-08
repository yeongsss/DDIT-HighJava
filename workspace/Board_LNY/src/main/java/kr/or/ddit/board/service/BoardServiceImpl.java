package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService{

	private IBoardDao dao;
	
	private static BoardServiceImpl service;
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service == null) service = new BoardServiceImpl();
		
		return service;
	}
	
	
	
	@Override
	public int insertBoard(BoardVO bvo) {
		return dao.insertBoard(bvo);
	}

	@Override
	public int deletBoard(int boardNo) {
		return dao.deletBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO bvo) {
		return dao.updateBoard(bvo);
	}

	@Override
	public List<BoardVO> getAllBoardList() {
		return dao.getAllBoardList();
	}

	@Override
	public List<BoardVO> searchBoardList(String boardTitle) {
		return dao.searchBoardList(boardTitle);
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		return dao.getBoard(boardNo);
	}

	@Override
	public int boardTitleCount(String title) {
		return dao.boardTitleCount(title);
	}

}
