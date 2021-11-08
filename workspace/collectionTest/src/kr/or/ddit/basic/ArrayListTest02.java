package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * 문제_) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
 * 		 이들 중 '김'씨 성의 이름을 모두 출력하시오.
 * 		(입력은 Scanner를 이용한다.)
*/
public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("5명의 이름을 입력하세요.");
		
		System.out.print("1번쨰: ");
		list.add(scanner.next());
		System.out.print("2번째: ");
		list.add(scanner.next());
		System.out.print("3번째: ");
		list.add(scanner.next());
		System.out.print("4번째: ");
		list.add(scanner.next());
		System.out.print("5번째: ");
		list.add(scanner.next());
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).indexOf("김") ==0) {
				System.out.println(list.get(i));
			}
		}
//		list.get(i).indexOf("김") => 이거는 list.get(i)번째의 이름에서 "김"이라는 글자가 몇번째에 있는지 알아낼수 있는 식!!!!
//		그래서 if(list.get(i).indexOf("김")==0 으로하면 첫번째 글자가 "김"인 이름을 찾는 것 
		
		
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			list.get(i);
			if (list.get(i).contains("김")==true) {
				System.out.println(list.get(i));
			}
		}

//		if (list.get(i).contains("김")==true) 이렇게 쓰면 list.get(i)이름에서 "김"글자가 들어가있으면 무조건 true로 나옴!!!!
		
		
//-----------------------------------------------------------------------
		ArrayList<String> nameList = new ArrayList<String>();
		Scanner scn= new Scanner(System.in);
		System.out.println("5명의 이름을 입력하세요");
		for (int i = 0; i < 5; i++) {
			System.out.print( (i+1) + "번째 이름 : ");
			String name = scn.next();
			nameList.add(name);
		}
		
		System.out.println();
		System.out.println("김씨 성을 가진 사람들,,,");
		for (int i = 0; i < nameList.size(); i++) {
			String name = nameList.get(i);
//			"김아무개"
			
//			if (name.substring(0, 1).equals("김")) {
//				System.out.println(name);
//			}
			
			
//			if (name.charAt(0) == '김') {
//				System.out.println(name);
//			}
			
			
//			if (name.indexOf("김") == 0) {
//				System.out.println(name);
//			}
			
			
			if (name.startsWith("김")) {
				System.out.println(name);
			}
		
		
		}
		
		
	}
}





























