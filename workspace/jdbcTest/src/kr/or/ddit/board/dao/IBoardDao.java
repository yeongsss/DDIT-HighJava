package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {

	/**
	 * BoardVO에 담겨진 자료를 DB에 insert하는 메소드
	 * 
	 * @param bvo	DB에 insert할 데이터가 저장된 BoardVO객체
	 * @return		작업성공 : 1, 실패 : 0 
	 */
	public int insertBoard (BoardVO bvo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메소드
	 * @param boardNo	삭제할 게시글 번호
	 * @return			작업성공 : 1, 실패 : 0
	 */
	public int deletBoard (int boardNo); 
	
	/**
	 * BoardVO자료를 이용하여 DB의 게시글 내용을 update하는 메소드
	 * @param bvo	update할 데이터가 저장된 BoardVO객체
	 * @return		작업성공 : 1, 실패 : 0
	 */
	public int updateBoard(BoardVO bvo);
	
	/**
	 * DB의 게시글테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메소드
	 *  
	 * @return	BoardVO객체를 담고 있는 List객체	
	 */
	public List<BoardVO> getAllBoardList();
	
	/**
	 * 매개변수로 넘어온 게시글제목을 이용하여 저장된 게시글 제목 중
	 * 해당 글자를 포함하고있는 모든 게시물을 출력하는 메소드 
	 * @return
	 */
	public List<BoardVO> searchBoardList(String boardTitle);
	
	/**
	 * 매개변수로 넘어온 게시글 번호를 이용하여 게시글 내용을 출력하는 메소드
	 * @param boardNo	보려고하는 게시글 번호
	 * @return			해당 게시글의 제목,작성자,내용,작성일,조회수를 반환 
	 */
	public List<BoardVO> getBoard(int boardNo); 
	
	/**
	 * 매개변수로 넘어온 제목을 이용하여 해당 값을 포함하는 제목이 있는지 확인하는 메소드
	 * @param title		검색하고자하는 게시글 제목
	 * @return			포함되는 제목이 있으면 1, 없으면 0을 반환
	 */
	public int boardTitleCount(String title);
	
	
}




