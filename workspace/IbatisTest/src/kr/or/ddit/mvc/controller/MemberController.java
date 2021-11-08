package kr.or.ddit.mvc.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.CryptoUtil;

/*
	데이터를 추가할 떄 회원ID는 양방향 암호화 방식으로 암호화하고,
	비밀번호는 단방향 암호화 방식으로 암호화해서 저장한다.
	
	전체 자료를 출력할 떄는 회원ID는 복호화해서 출력한다.
	
*/
public class MemberController {
	private IMemberService service; // Service 객체 변수 선언
	private Scanner scan;
	
	// 생성자
	public MemberController() {
//		service = new MemberServiceImpl();
		service = MemberServiceImpl.getInstance();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new MemberController().startMember();
	}
	
	public void startMember() {
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 자료추가
				insert();
				break;
			case 2: // 자료 삭제
				delete();
				break;
			case 3: // 자료 수정
				update();
				break;
			case 4: // 전체 자료 출력
				displayMember();
				break;
			case 5: // 자료 수정2
				update2();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요.");
			}
		}
	}

	
	// 회원 정보를 수정하는 메서드 ==> 원하는 항목만 수정
	private void update2() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID >> ");
		String memId = scan.next();

		int count = service.getMemberCount(memId);
		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		int num;
		String updateField = null; // 선택한 항목의 컬럼명이 저장될 변수
		String updateTitle = null; // 선택한 항목의 값을 입력받을 때 나타날 메세지가 저장될 변수
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요");
			System.out.println("1.비밀번호   2.회원이름   3.전화번호   4.회원주소");
			System.out.println("-------------------------------------------");
			System.out.println("수정 항목 선택 >> ");
			num = scan.nextInt();

			switch (num) {
			case 1:
				updateField = "mem_pass";
				updateTitle = "비밀번호";
				break;
			case 2:
				updateField = "mem_name";
				updateTitle = "회원이름";
				break;
			case 3:
				updateField = "mem_tel";
				updateTitle = "전화번호";
				break;
			case 4:
				updateField = "mem_addr";
				updateTitle = "회원주소";
				break;
			default:
				System.out.println("수정할 항목을 잘못 선택했습니다.");
				System.out.println("다시선택하세요");
			}
		} while (num < 1 || num > 4);

		System.out.println();
		// 수정할 값 입력 받기
		scan.nextLine(); // 버퍼비우기
		System.out.println("새로운 " + updateTitle + ">> ");
		String updateData = scan.nextLine();

		// 수정 작업에 필요한 데이터들을 Map에 저장한다.
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("memId", memId); // 회원ID 추가
		paramMap.put("field", updateField); // 수정할 컬럼명 추가
		paramMap.put("data", updateData); // 수정할 데이터 추가

		int cnt = service.updateMember2(paramMap);

		if (cnt > 0) {
			System.out.println("수정 작업 성공");
		} else {
			System.out.println("수정 작업 실패");
		}

	}

	
	
	// 회원 정보를 수정하는 메서드 ==> 전체 항목 수정
	private void update() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID >> ");
		String memId = scan.next();

		int count = service.getMemberCount(memId);
		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다.");
			System.out.println("수정 작업을 종료합니다.");
			return;
		}

		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 비밀번호 >> ");
		String newPass = scan.next();

		System.out.print("새로운 회원이름 >> ");
		String newName = scan.next();

		System.out.print("새로운 전화번호 >> ");
		String newTel = scan.next();

		scan.nextLine();
		System.out.print("새로운 회원주소 >> ");
		String newAddr = scan.nextLine();

		//입력한 데이터들을 MemberVo객체에 저장하기
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(newPass);
		memVo.setMem_name(newName);
		memVo.setMem_tel(newTel);
		memVo.setMem_addr(newAddr);
		
		int cnt = service.updateMember(memVo);
		
		if(cnt > 0) {
			System.out.println("수정작업 성공");
		}else {
			System.out.println("수정작업 실패");
		}
	}

	// 자료를 삭제하는 메서드
	private void delete() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		System.out.print("삭제할 회원ID >> ");
		String memId = scan.next();

		int cnt = service.deleteMember(memId);
		
		if(cnt > 0) {
			System.out.println("삭제 작업 성공");
		}else {
			System.out.println("삭제 작업 실패");
		}
	}

	// 자료를 추가하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");

		int count = 0;
		String memId = null; // 회원ID가 저장될 변수
		do {
			System.out.print("회원 ID >> ");
			memId = scan.next();
			count = service.getMemberCount(memId);
			if (count > 0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID 입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
		} while (count > 0);

		System.out.print("비밀번호 >> ");
		String memPass = scan.next();
		System.out.print("회원이름 >> ");
		String memName = scan.next();
		System.out.print("전화번호 >> ");
		String memTel = scan.next();

		scan.nextLine(); // 입력 버퍼 비우기
		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();

		//서비스에게 일시키기-> memvo에 객체 담기
		//입력한 데이터들을 MemberVO객체에 담는다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int cnt = service.insertMember(memVo);
		
		if(cnt > 0) {
			System.out.println("추가 작업 성공");
		}else {
			System.out.println("추가 작업 실패");
		}
		
		
		
	}

	// 메뉴를 출력하는 메서드
	private int displayMenu() {
		System.out.println("============================");
		System.out.println("     == 작 업 선 택 ==");
		System.out.println("     1. 자 료 추 가");
		System.out.println("     2. 자 료 삭 제");
		System.out.println("     3. 자 료 수 정");
		System.out.println("     4. 전 체 자 료 출 력");
		System.out.println("     5. 자 료 수 정 2");
		System.out.println("     0. 작 업 끝.");
		System.out.println("============================");
		System.out.print("원하는 작업 선택 >> ");
		int num = scan.nextInt();
		return num;
	}

	// 전체 회원 정보를 출력하는 메서드
	private void displayMember() {
		List<MemberVO> memList = service.getAllMemberList();
		String key = "a1b2c3d4e5f6g7h8";
		String id = null;
		
		System.out.println("------------------------------------------------");
		System.out.println(" ID    비밀번호     이름      전화번호       주소");
		System.out.println("------------------------------------------------");

		if(memList==null || memList.size()==0) {
			System.out.println("회원자료가 하나도 없습니다.");
		}else {
			for(MemberVO memvo : memList) {
				
				System.out.println(
						memvo.getMem_id() + " " +
						memvo.getMem_pass() + " " +
						memvo.getMem_name() + " " +
						memvo.getMem_tel() + " " +
						memvo.getMem_addr() );
			}
		}
		
			System.out.println("------------------------------------------------");
			System.out.println("출력 끝...");
	}
}
