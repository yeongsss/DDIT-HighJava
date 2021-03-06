package ddit.dao;

import java.util.List;

import ddit.vo.BoardFileVO;
import ddit.vo.BoardVO;

public interface IBoardDAO {

	/**
	 * 게시판 구분명으로 공지와 자유게시판을 찾고 리스트를 조회
	 * @return
	 */
	public List<BoardVO> getBoardList(String boardNm);
	
	/**
	 * insert구문으로 필요한거 다 넣어주면 됩니다.
	 * @param bVo
	 * @return
	 */
	public int insertBoard(BoardVO bVo);
	
	/**
	 * Dynamic과 isNotEmpty 써서 해보는 것도 좋을듯 하다.
	 * @param bVo
	 * @return
	 */
	public int updateBoard(BoardVO bVo);
	
	/**
	 * 게시판을 삭제할 때 게시판 번호로 하지만 공지게시판은
	 * 지우면 안되니까 boardVO를 주고 where로 게시판 번호와
	 * and boardNM도 해준다.
	 * @param board_no
	 * @return
	 */
	public int deleteBoard(BoardVO bVo);
	
	/**
	 * 게시글 자세히보기 
	 * @param board_no	=> 보고자하는 게시글 번호
	 * @return
	 */
	public BoardVO findBoard(int board_no);
	
	/**
	 * 게시물 글쓴이를 찾는 메소드
	 * @param board_no
	 * @return int
	 */
	public int boardWriter(BoardVO bVo);
	
	/**
	 * 
	 * @param bFileVo => 게시글에 저장될 파일VO
	 * @return
	 */
	public int insertBoardFile(BoardFileVO bFileVo);
	
	/**
	 * 
	 * @param file_no => 수정하고자 하는 파일번호
	 * @return
	 */
	public int updateBoardFile(int file_no);
	
	
	public int deleteBoardFile(int file_no);
	
	
	
	
}
