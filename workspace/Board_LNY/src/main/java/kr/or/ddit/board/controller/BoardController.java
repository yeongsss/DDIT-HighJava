package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

public class BoardController {
	private IBoardService service;
	private Scanner scn;
	private int boardNo;

	public int getBoardNo() {
		return boardNo;
	}
	
	// 생성자
	public BoardController() {
		service = BoardServiceImpl.getInstance();
		scn = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new BoardController().startBoard();
	}
	
	public void startBoard() {
		while (true) {
			int choice = displayBoard();
			
			switch (choice) {
			case 1:		// 새글작성
				insert();
				break;

			case 2:		// 게시글보기
				boardView();
				break;
				
			case 3:		// 검색
				searchBoard();
				break;
				
			case 0:		// 작업끝
				System.out.println("게시판 프로그램 종료...");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}
		
		
		
		
	}
	
	// 게시글 검색 메소드
	private void searchBoard() {
		int cnt = 0;
		System.out.println();
		System.out.println("검색 작업");
		System.out.println("-----------------------------------");
		System.out.print("- 검색할 제목 입력 : ");
		scn.nextLine();
		String searchTitle = scn.nextLine();
		
		cnt = service.boardTitleCount(searchTitle);
		
		if (cnt == 0) {
			System.out.println();
			System.out.println("해당 제목을 포함하는 게시글이 없습니다.");
			System.out.println();
			return;
		}
		
		if (searchTitle == "" || searchTitle == null) {
			startBoard();
		} else {
			List<BoardVO> searchBoard = service.searchBoardList(searchTitle);
			System.out.println();
			System.out.println("---------------------------------------------------");
			System.out.println(" No	        제 목            작성자 	조회수   ");
			for(BoardVO boardVO : searchBoard) {
				System.out.println(
						boardVO.getBoard_no() + "\t\t" +
						boardVO.getBoard_title() + "\t\t" +
						boardVO.getBoard_writer() + "\t\t" +
						boardVO.getBoard_cnt() );
			}
		}
		System.out.println("---------------------------------------------------");
	}

	// 게시글 보기 메소드
	private void boardView() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력 >> ");
		boardNo = scn.nextInt();
		System.out.println();
		System.out.println(boardNo + "번글 내용");
		System.out.println("-----------------------------------");

		BoardVO getboard = service.getBoard(boardNo);
		
		if (getboard == null ) {
			System.out.println("해당번호의 게시글이 없습니다.");
			startBoard();
		} else {
//			for (BoardVO boardVO : getboard) {
				System.out.println(
						"- 제  목 : "+getboard.getBoard_title() + "\n" +
						"- 작성자 : "+getboard.getBoard_writer() + "\n" +
						"- 내  용 : "+getboard.getBoard_content() + "\n" + 
						"- 작성일 : "+getboard.getBoard_date().toString().split(" ")[0]+ "\n" + 
						"- 조회수 : "+getboard.getBoard_cnt() );
//			}
		}
		System.out.println("-----------------------------------");
		
		display2();
	}

	// 게시글 수정 삭제 리스트 돌아가기
	private void display2() {
		System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
		System.out.print("작업선택 >> ");
		int no = scn.nextInt();
		
		switch (no) {
		case 1:	//수정 
			updateBoard();
			break;
		case 2:	//삭제
			deleteBoard();
			break;
		case 3:	//리스트
			startBoard();
			break;
		default:
			System.out.println("잘못입력하셨습니다. 다시 입력하세요");
		}
		
		
		
	}

	// 게시글 삭제하는 메소드
	private void deleteBoard() {
		int cnt = service.deletBoard(boardNo);
		
		if (cnt > 0 ) {
			System.out.println();
			System.out.println(boardNo + "번글이 삭제되었습니다.");
			System.out.println();
		} else {
			System.out.println();
			System.out.println(boardNo + "번글 삭제에 실패했습니다.");
			System.out.println();
		}
			
	}
	
	// 게시글 수정하는 메소드
	private void updateBoard() {
		System.out.println();
		System.out.println("수정작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		scn.nextLine();
		String title = scn.nextLine();
		System.out.print("- 내  용 : ");
		String content = scn.nextLine();
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_no(boardNo);
		bvo.setBoard_title(title);
		bvo.setBoard_content(content);
		
		int cnt = service.updateBoard(bvo);
		
		if (cnt > 0) {
			System.out.println();
			System.out.println(boardNo + "번글이 수정되었습니다. ");
			System.out.println();
		} else {
			System.out.println();
			System.out.println(boardNo + "번글 수정에 실패했습니다. ");
			System.out.println();
		}
		
	}

	// 게시글 작성하는 메소드
	private void insert() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		scn.nextLine();
		String title = scn.nextLine();
		System.out.print("- 작성자 : ");
		String writer = scn.next();
		scn.nextLine();
		System.out.print("- 내  용 : ");
		String content = scn.nextLine();
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_writer(writer);
		bvo.setBoard_content(content);
		
		int cnt = service.insertBoard(bvo);
		
		if (cnt > 0 ) {
			System.out.println();
			System.out.println("새글이 추가되었습니다.");
			System.out.println();
		} else {
			System.out.println();
			System.out.println("새글을 추가하는데에 실패했습니다.");
			System.out.println();
		}
		
		
		
	}

	private int displayBoard() {
		int input;
		List<BoardVO> boardList = service.getAllBoardList();
		System.out.println();
		System.out.println("-------------------------------------------------------------");
		System.out.println(" No	        제 목            작성자 	조회수   ");
		System.out.println("-------------------------------------------------------------");
		
		if (boardList == null || boardList.size() == 0 ) {
			System.out.println("등록된 게시글이 하나도 없습니다.");
		} else {
			for (BoardVO bvo : boardList) {
				System.out.println(
						bvo.getBoard_no() + "\t\t"+
						bvo.getBoard_title() + "\t\t" +
						bvo.getBoard_writer() + "\t\t"+
						bvo.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
		System.out.print("작업 선택 >> ");
		input = scn.nextInt();
		
		return input;
	}
	
	
	
	
	
}












