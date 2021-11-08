package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void main(String[] args) {
/*
 * 문제2) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 별명중에 
 * 		  별명의 길이가 제일 긴 별명을 출력하시오.
 * 		  (단, 별명의 길이가 같은 것을 입력할 수 있다.
*/
		Scanner scan = new Scanner(System.in);
		ArrayList<String> aliasList = new ArrayList<String>();
		System.out.println("5명의 별명을 입력하세요.");
		for (int i = 0; i < 5; i++) {
			System.out.print((i + 1) + "번째 별명 : ");
			String alias = scan.next();
			aliasList.add(alias);
			
		}
		
//		제일 긴 별명의 길이가 저장될 변수를 선언하고
//		이 변수에 첫번째 데이터의 길이를 저장한다.
		int maxLen = aliasList.get(0).length();
		
		for (int i = 0; i < aliasList.size(); i++) {
			if (maxLen < aliasList.get(i).length()) {
				maxLen = aliasList.get(i).length();						
			}
		}
		
		System.out.println("제일 긴 별명들,,,");
		for (String alias : aliasList) {
			if (maxLen == alias.length()) {
				System.out.println(alias);
			}
		}
		
		
		
	}
}




