package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import org.omg.CORBA.PUBLIC_MEMBER;

/*
	문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
		 컴퓨터의 숫자는 난수(Set사용)를 이용하여 구한다.
		 (스트라이크 S, 볼 B로 나타낸다.)
		 
	예시)
		컴퓨터의 난수 ==> 9 5 7 
		
	실행예시)
	숫자입력 => 3 5 6
	 3 5 6  ==> 1S 0B
	숫자입력 => 7 8 9 
	 7 8 9  ==> 0S 2B
	숫자입력 => 9 7 5 
	 9 7 5  ==> 1S 2B
	숫자입력 => 9 5 7 
	 9 5 7  ==> 3S 0B
	 
	축하합니다.
	당신은 4번째만에 맞췄습니다.
	
*/

public class BaseBallTest {
	public static void main(String[] args) {
		HashSet<Integer> num = new HashSet<Integer>();
		Scanner scn = new Scanner(System.in);
		Random rnd = new Random();

		while (num.size() < 3) {
			num.add(rnd.nextInt(9) + 1);
		}
		System.out.println(num);
		ArrayList<Integer> numlist = new ArrayList<Integer>(num);
		ArrayList<Integer> list = new ArrayList<Integer>();

		int cnt = 0;

		while (true) {
			int s = 0;
			int b = 0;
			cnt++;
			System.out.println("숫자입력 ");

			while (list.size() < 3) {
				System.out.print(list.size() + 1 + " : ");
				list.add(scn.nextInt());
			}
//			System.out.println(numlist);
//			System.out.println(list);

			for (int i = 0; i < numlist.size(); i++) {
				if (numlist.get(i) == list.get(i)) {
					s++;
				}
			}
			for (int j = 0; j < list.size(); j++) {
				if (numlist.get(j) != list.get(j) && numlist.contains(list.get(j))) {
					b++;
				}
			}

			System.out.println(s + "S , " + b + "B");
			list.clear();
			if (s == 3) {
				System.out.println("축하합니다.");
				System.out.println("당신은 " + cnt + "번째만에 맞췄습니다.");
				break;
			}
		}

	}
}

//	-------------------------------------------------------------------------------------------------
//	게임이 시작되는 메소드

class BaseBallTest01 {
		ArrayList<Integer> userList;
		ArrayList<Integer> numList;
		int strike;
		int ball;
		
		Scanner scan = new Scanner(System.in);
//		
//	public static void main(String[] args) {
//		BaseBallTest01 test = new BaseBallTest01();
//		test.startGame();
//		
//		
//	}
	
	public void startGame() {
		// 난수를 만드는 메소드 호출
		getNum();
		
//		System.out.println("컴퓨터 난수 : "+ numList);
		
		int cnt =0;	// 몇번만에 맞췄는지를 저장하는 변수
		
		do {
			cnt++;	//카운트 증가
			
			// 사용자 입력 메소드 호출
			inputNum();
			
			// 볼카운트를 구하는 메소드호출
			ballCount();
			
		} while (strike!=3);	// 3스트라이크가 될때까지 반복한다.
		
		// 답을 모두 맞춘 후 결과 출력하기
		System.out.println();
		System.out.println("축하합니다.");
		System.out.println("당신은 "+ cnt+ "번째만에 맞췄습니다.");
		
	}

	// 1~9사이의 서로 다른 난수 3개를 만들어서 List에 저장하는 메소드
	// Set이용
	public void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();

		// 1~9사이의 난수 3개 만들기
		Random rnd = new Random();
		while (numSet.size() < 3) {
			numSet.add(rnd.nextInt(9) + 1);
		}
		
		// 만들어진 난수를 List에 저장하기
		ArrayList<Integer> numList = new ArrayList<Integer>(numSet);
		
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
	}
	// 사용자로부터 3개의 정수를 입력받아서 List에 저장하는 메소드
	// 입력한 정수는 중복되지 않는다.
	public void inputNum() {
		int n1,n2,n3;	// 입력한 정수가 저장될 변수 선언
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("숫자입력 => ");
			n1 = scan.nextInt();
			n2 = scan.nextInt();
			n3 = scan.nextInt();
			
			if (n1==n2 || n1==n3 || n2==n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다.");
				System.out.println("다시 입력하세요");
				
			}
			
		} while (n1==n2 || n1==n3 || n2==n3);
		
		// 입력받은 데이터를 List에 저장한다.
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
		
	}
	
	// 스트라이크와 볼을 판정하고 그 결과를 출력하는 메소드
	public void ballCount() {
		strike = 0;
		ball = 0;	// 스트라이크와 볼의 개수가 저장될 변수 초기화
		
		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				
				//값이 같은지 검사
				if (numList.get(i) == userList.get(j)) {
					if (i==j) {
						strike++;
					} else {
						ball++;
					}
				}
			} // for문 j
		} // for문 i
		
		// 볼카운트 결과를 출력
		System.out.println(userList.get(0) + ", "+userList.get(1)+ ", "+
						userList.get(2)+" ==> "+ strike +"S "+ball+"B");
		
	}
	
}










