package kr.or.ddit.basic.args;

import java.util.Iterator;

public class ArgsTest {
	
	// 매개변수로 받은 정수들의 합계를 구하는 메소드
	// ==> 이 정수들의 개수는 상황에 따라 다를 수 있다.
	
	// 배열을 이용하는 메소드
	// static이 없으면 ArgsTest 클래스의 인스턴스메소드
	private int sumArr(int[] data) {
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	// 가변형 인수 ==> 메소드의 인수값이 실행될때마다 다를 때 사용한다.
	// (인수: 메소드를 호출할때 쓰는 변수, 매개변수: 메소드 시작시 주어지는 변수)
	// 				- 가변형 인수는 메소드안에서는 배열로 처리된다.
	//				- 가변형 인수는 한가지 자료형만 사용할 수 있다.
	
	// 가변형 인수를 이용한 메소드
	public int sumArg(int...data) {
		int sum = 0; 	//합계가 저장될 변수 선언
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum;
	}
	
	// 가변형 인수와 일반적인 인수를 같이 사용할 경우
	// 가변형 인수를 제일 뒤쪽에 배치해야한다.
	public String sumArg2(String name, int...data) {
		int sum = 0;	// 합계가 저장될 변수 선언
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return name + "씨 합계 : " + sum;
	}
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		
		int[] nums = {100,200,300};
//		int[] ttt = new int[] {1,2,3,4,5};
//		int[] ttt;
//		ttt = new int[] {1,2,3,4,5}; 
		
		System.out.println(at.sumArr(nums));
		System.out.println(at.sumArr(new int[] {1,2,3,4,5}));
		System.out.println();
		
		System.out.println(at.sumArg(100,200,300));
		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(at.sumArg2("홍길동", 10,20,30,40,50,60));
		
		
	}
	
	
	
	
}








