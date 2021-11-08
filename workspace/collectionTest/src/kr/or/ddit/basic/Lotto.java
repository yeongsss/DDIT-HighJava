package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Lotto<E> {
	ArrayList<Integer> lottoList;
	ArrayList<Integer> list;
	ArrayList<ArrayList<Integer>> totalLotto = new ArrayList<ArrayList<Integer>>();
	
	Scanner scn = new Scanner(System.in);
	Random rnd = new Random();
	int money;
	int chmoney;
	int cnt;
	
	
	
	public static void main(String[] args) {
		new Lotto().startGame();
		
		
	}
	
	public void startGame() {
		buyLotto();
		
	} // startGame메소드  
	
	
	// 1등 번호
	public void no1Num() {
		
	HashSet<Integer> result = new HashSet<Integer>();
	while (result.size()<6) {
		result.add(rnd.nextInt(45)+1);
	}
	
	list = new ArrayList<Integer>(result);
	
	Collections.sort(list);
	
	}
	
	public void buyLotto() {
		lottoList = new ArrayList<Integer>();
		list = new ArrayList<Integer>();
		totalLotto = new ArrayList<ArrayList<Integer>>();
		
		System.out.println();
		System.out.println("==================================");
		System.out.println("  Lotto 프로그램");
		System.out.println("----------------------------------");
		System.out.println("  1. Lotto 구입");
		System.out.println("  2. 프로그램 종료");
		System.out.println("==================================");
		System.out.print("메뉴 선택: ");
		int input = scn.nextInt();
		switch (input) {
		case 1:
			no1Num();
			System.out.println("  Lotto 구입 시작");
			System.out.println();
			System.out.println("(1000원에 로또번호 하나입니다.)");
			System.out.print("금액 입력 : ");
			money = scn.nextInt();
			moneyConfirm();
			break;
		case 2:
			System.out.println();
			System.out.println("감사합니다.");
			break;
		} // switch문
		
		
	}// buyLotto문
	
	
	// 구입한 금액만큼 로또번호 뽑기
	public void getNum() {
		int no =1;
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		while (cnt+1 != no) {
			HashSet<Integer> lotto = new HashSet<Integer>();
			while (lotto.size()<6) {
				lotto.add(rnd.nextInt(45)+1);
			}
			
			lottoList = new ArrayList<Integer>(lotto);
			
			Collections.sort(lottoList);
			
			
			totalLotto.add(lottoList);
			
			System.out.print("로또번호"+no +" : "+lottoList);
			System.out.println();
			no++;
		}
		numconfirm();
	}
	
	
	//구입금액확인
	public void moneyConfirm() {
		if(money <1000) {
			System.out.println();
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
		} else if (money >= 101000) {
			System.out.println();
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		} else {
			chmoney = money%1000;
			cnt = money/1000;
			System.out.println();
			System.out.println("받은 금액은 "+ money + "원이고 거스름돈은 "+chmoney+"원입니다.");
			System.out.println();
			getNum();
			
		}
		buyLotto();
		
	}
	
	public void numconfirm() {
		System.out.println("----------------------------------");
		System.out.println("당첨 확인 하시겠습니까?");
		System.out.println("----------------------------------");
		System.out.println("1. 당첨확인  2. 다시 추첨");
		System.out.print("입력 : ");
		switch (scn.nextInt()) {
		case 1:
			confirm();
			break;
		case 2:
			buyLotto();
			break;
		}
	}
	
	
	// 당첨번호 확인
	public void confirm() {
		ArrayList<Integer> winning  = new ArrayList<Integer>();
		System.out.println("1등번호: " + list);
		System.out.println();
		
		
		for (int i = 0; i < totalLotto.size(); i++) {
			int con = 0;
			for (int j = 0; j < list.size(); j++) {
				if (list.contains(totalLotto.get(i).get(j))) {
					winning.add(lottoList.get(j));
					con++;
				}
			}
				
				if (con==6) {
					System.out.println("같은 번호: "+ winning);
					System.out.println("축하합니다. 1등입니다.");
				} else if (con==5) {
					System.out.println("같은 번호: "+ winning);
					System.out.println("축하합니다. 2등입니다.");
				} else {
					System.out.println("같은번호 갯수: "+con);
					System.out.println("탈락입니다. 다음에 다시..");
					System.out.println();
				}
				
				
		}
		
				
		buyLotto();
		
		
	}
	
	
}		






