package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/*
 * 문제1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 별명중에 
 * 		  별명의 길이가 제일 긴 별명을 출력하시오.
 * 		  (단, 각 별명의 길이는 모두 다르게 입력한다.)
 * 
 * 문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있을 경우에 대해 처리하시오. 
 * 
*/

public class ArrayListTest03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();

		System.out.println("5명의 별명을 입력하세요.");
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 별명 : ");
			String name = scn.next();
//			for (int j = 0; j < list.size(); j++) {
//				if (name.length() == list.get(j).length()) {
//					System.out.println((j+1)+"번째와 길이가 같습니다. 다시 입력해주세요.");
//					i--;
//					break;
//				}
//			}
			list.add(name);

		}
		
		// 가장 긴 별명 구하기
		
		String name = "";
		for (int i = 0; i < list.size(); i++) {
			int nm1 = list.get(i).length();
			for (int j = 1; j < list.size(); j++) {
				int nm2 = list.get(j).length();
				if (nm1 < nm2) {
					name = list.get(j);
				}

			}

		}
		
		System.out.println("가장 긴 별명");
		for (int i = 0; i < list.size(); i++) {
			if (name.length() == list.get(i).length()) {
				System.out.println(list.get(i));
			}
		}
		
//		String result = list.get(0);
//		for(String str : list) {
//			if(str.length() > result.length()) {
//				result = str;
//			}
//		}
//		System.out.println(result);
//		
//		
//		// 같은 길이인 별명 출력
//		for (int i = 0; i < list.size(); i++) {
//			for (int j = 0; j < i; j++) {
//				if (list.get(i).length()==list.get(j).length()) {
//					System.out.println(list.get(i)+","+list.get(j));
//					
//				}
//			}
//		}

		
//		String longname = "";
//		System.out.println();
//		for (int i = 0; i < list.size(); i++) {
//			int no1 = list.get(i).length();
//			for (int j = 1; j < list.size(); j++) {
//				int no2 = list.get(j).length();
//				if (no1 < no2) {
//					longname = list.get(j);
//				}
//			}
//		}
//		System.out.println("길이가 가장 긴 별명은 < "+ longname +" > 입니다.");
	


	//--------------------------------------------------------------------------------------	
//		String maxAlias = aliasList.get(0);
		int maxIndex =0;
		
		
	}
}















