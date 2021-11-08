package kr.or.ddit.basic.enumTest;

import java.util.Iterator;

/*
	- enum(열거형) ==> 서로 관련있는 상수들의 집합을 나타낸다.
				   ==> 클래스처럼 보이게 하는 상수
				   ==> 열거형은 클래스처럼 독립된 java파일에 만들 수 있고,
				  		하나의 java파일의 다른 클래스와 같이 만들 수 있고,
				  		클래스 안에 내부 클래스처럼 만들 수 있다.
				  		
	- 열거형의 속성 및 메소드
		1. name() ==> 열거형 상수의 이름을 문자열로 반환한다.
		2. ordinal() ==> 열거형 상수가 정의된 순서(index값)을 반환한다.(0부터 시작)
		3. valueOf("열거형상수명") ==> 지정된 열거형에서 '열거형상수명'과 일치하는 열거형 상수를 반환한다.
		4. 열거형이름.상수명 ==> valueOf("상수명")메소드와 같다.
		
	- 열거형 선언하기
	방법1)
		enum 열거형이름 {상수명1, 상수명2, ....}
	방법2)
		enum 열거형이름 {
			상수명1(값들...), 상수명2(값들...), 상수명3(값들), ... ;
			
			// '값들'을 저장할 변수들 선언
			private 자료형이름 변수명1;
			...
			
			// 열거형의 생성자를 만든다.
			// 열거형의 생성자는 '열거형상수'에 설정된 '값들'을 변수에 초기화하는 역할을 수행한다.
			// 열거형의 생성자는 묵시적으로 private이다.
			  
			// '변수명'은 '값들'과 개수가 같고, 각각의 '값들'과 자료형이 맞아야 된다.
			private 열거형이름(자료형이름 변수명, ....){
				위에 선언된 변수들 초기화하는 작업을 수행한다...
			}
			
			// 구성된 '값들'을 외부에서 불러올 수 있도록 하기 위해서 getter메소드를 작성한다.
		}
		
*/
public class EnumTest {	
	// color,count 열거형의 상수들
	public enum Color { RED, GREEN, BLUE }
	public enum Count { ONE, TWO, THREE }
	
	public enum Season{
		봄("3월부터 5월까지"),	// 상수명(값들) 형식의 선언
		여름("6월부터 8월까지"),
		가을("9월부터 11월까지"),
		겨울("12월부터 2월까지");
		
		private String data;		// 값이 저장될 변수 선언
		
		// 생성자
		Season(String strMonth){	// private Season(String strMonth){ 와 같다.
			data = strMonth;		// 변수 초기화 
		}
		
		// getter 만들기
		public String getData() {
			return data;
		}
		
	}
	
	
	public static void main(String[] args) {
	/*
	 * System.out.println("RED : " +ConstTest.RED); 
	 * System.out.println("THREE : "+ConstTest.THREE);
	 * 
	 * if (ConstTest.RED == ConstTest.TWO) { 
	 *  System.out.println("......."); 
	 * } else {
	 *  System.out.println("******");
	 * }
	 */
		
		// 아래의 mycol1과 mycol2는 같
		Color mycol1 = Color.valueOf("GREEN");
		Color myCol2 = Color.GREEN;
		
		Count mycnt = Count.THREE;
		
		System.out.println("mycol1 : " + mycol1.name());
		System.out.println("mycnt : " + mycnt.name());
		
		System.out.println("mycol1의 ordinal : "+ mycol1.ordinal());
		System.out.println("mycnt의 ordinal : " + mycnt.ordinal());
		
		/*
		 * // 서로 다른 종류의 열거형끼리는 비교가 불가능하다. 
		 * if (Color.RED == Count.THREE) {
		 * 
		 * }
		 */
		
		// if문 비교
		if (mycol1 == Color.BLUE) {
			System.out.println("같다.");
		}else {
			System.out.println("다르다.");
		}
		
		// switch문 비교
		// switch문의 case문에 상수를 지정할 때는 열거형이름은 생략하고 
		//										상수이릅만 기술해야한다.
		switch (mycnt) {
			case ONE: System.out.println("하나");
				break;
			case TWO: System.out.println("두울");
			break;
			case THREE: System.out.println("셋");
			break;

		}
		System.out.println("---------------------------------------------------");
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : "+ ss.name());
		System.out.println("ordinal : " +ss.ordinal());
		System.out.println("data : "+ ss.getData());
		System.out.println();
		
		// 열거형이름.values(); ==> 모든 상수들을 배열로 반환한다.
		for (Season time : Season.values()) {
			System.out.println(time.name() + " == "+time + " --> " + time.getData());
		}
		System.out.println();
		
		for (Color col : Color.values()) {
			System.out.println(col.name() + " -> " + col.ordinal());
		}
		
	
	}
	
	
}



































