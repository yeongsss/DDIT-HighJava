package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
	문제) 이름,주소,전화번호를 멤버로 갖는 Phone클래스를 만들고 
		 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
		 (Map의 구조는 key값으로 '이름'을 사용하고 value값으로는 'Phone클래스의 인스턴스'로 한다.)
		 
		 HashMap<String, Phone> 변수명;
		 
		 
		 아래 메뉴 및 예시에 맞는 기능을 구현하시오.
		 ==> 삭제, 검색은 '이름'을 입력받아서 처리한다.
		 
실행 예시)
	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
------------------------------------
번호입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이름 >> 홍길동
전화번호 >> 010-1234-5678
주 소 >> 대전시 중구 대흥동

'홍길동'전화번호 등록 완료!!

	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
------------------------------------
번호입력 >> 1

새롭게 등록할 전화번호 정보를 입력하세요.
이름 >> 홍길동

'홍길동'은 이미 등록된 사람입니다.

	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
------------------------------------
번호입력 >> 5

---------------------------------------------------------
번호	이름		전화번호			주소
---------------------------------------------------------
1	  홍길동	 010-1234-5678  	대전시 중구 대흥동
~~~~
~~~~~
----------------------------------------------------------
출력 완료...

	1. 전화번호 등록
	2. 전화번호 수정
	3. 전화번호 삭제
	4. 전화번호 검색
	5. 전화번호 전체 출력
	0. 프로그램 종료
------------------------------------
번호입력 >> 0

프로그램을 종료합니다.



*/

public class PhoneBookTest {
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	Scanner scn = new Scanner(System.in);
	Set<String> keySet = map.keySet();
	Iterator<String> it = keySet.iterator();

	public static void main(String[] args) {
		new PhoneBookTest().start();
	}

	

	public void start() {
		
		phone : while(true) {
			System.out.println();
			System.out.println("	1. 전화번호 등록");
			System.out.println("	2. 전화번호 수정");
			System.out.println("	3. 전화번호 삭제");
			System.out.println("	4. 전화번호 검색");
			System.out.println("	5. 전화번호 전체 출력");
			System.out.println("	0. 프로그램 종료");
			System.out.println("--------------------------------------------");
			System.out.print("번호입력 >> ");
			int input = scn.nextInt();
	
			
			switch (input) {
				case 1:
					insert();
					break;
				case 2:
					update();
					break;
				case 3:
					delete();
					break;
				case 4:
					search();
					break;
				case 5:
					total();
					break;
				case 0:
					System.out.println();
					System.out.println("종료합니다");
					break phone;
			}
		}
		
	}

	public void insert() {
		Phone phone = new Phone();
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = scn.next();
		phone.setName(name);
		
		if (map.containsKey(name)) {
			System.out.println();
			System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
			return;
		}

		System.out.print("전화번호 >> ");
		phone.setTel(scn.next());
		
		scn.nextLine();
		System.out.print("주 소 >> ");
		phone.setAddr(scn.nextLine());

		map.put(phone.getName(), phone);

		System.out.println("'" + phone.getName() + "'전화번호 등록 완료!!!");

	}//insert
	
	public void update() {
		System.out.print("이 름 >> ");
		String upName = scn.next();
		map.get(upName);
		System.out.print("수정할 전화번호>> ");
		map.get(upName).setTel(scn.next());
		
		map.put(upName, map.get(upName));
		
		System.out.println("수정완료!");
		
		
	}//update
	
	
	public void delete() {
		System.out.print("이름 >> ");
		System.out.println();
		String delName = scn.next();
		String result = map.remove(delName) + "";
		
		if (result.isEmpty()) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}
		
		
	}//delete
	
	public void search() {
		System.out.print("이름 >> ");
		String srName = scn.next();
		if (map.containsKey(srName)) {
			Phone search = map.get(srName);
			System.out.println();
			System.out.println(search);
		} else {
			System.out.println("저장된 전화번호가 없습니다");
			System.out.println();
		}
		
		
	}//search
	
	public void total() {
		if (map.size()==0) {
			System.out.println("없어요~~~~");
			return;
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("번호  \t 이름 \t 전화번호  \t\t 주소 ");
		System.out.println("-----------------------------------------------------------------------");
		int cnt =1;
		for (String string : map.keySet()) {
			Phone value = map.get(string);
			System.out.println(cnt++ + "\t" +value);
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	

}// class



class Phone {

	private String name;
	private String addr;
	private String tel;

	public Phone() {}

	public Phone(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return  name + "\t\t" + addr + "\t\t" + tel;
		
	}
	
	
}
