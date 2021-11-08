package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Vector;

public class VectorTest01 {
	// 자바고급 선생님 : 이성엽
	public static void main(String[] args) {
		//객체생성
		Vector v1 = new Vector();
		System.out.println("처음 크기 : "+ v1.size());	//처음 크기 : 0
		
		// 데이터 추가 : add(추가할 데이터) <- 데이터 = 객체
				// 컬랙션에는 객체만 저장가능
		// 반환값 : 성공(true), 실패(false)
		v1.add("aaaa");
		v1.add(new Integer(111));	// 일반데이터를 객체형으로 감싸주는것= 레퍼클래스(wrapper)
		v1.add(123);  // 오토박싱(AutoBoxing)이 이루어진다.
		v1.add('a');
		v1.add(3.14);
		boolean r = v1.add(true);
		
		System.out.println("현재 크기 : "+ v1.size());	
//		현재 크기 : 6
		System.out.println("반환값 :  "+ r);			
//		반환값 :  true
		System.out.println("v1 => "+v1);				
//		v1 => [aaaa, 111, 123, a, 3.14, true]
		System.out.println();
		
		// 데이터 추가2 : addElement(추가할 데이터)
		// ==> 이전 버전에서부터 지원하는 메소드
		// ==> 이전 버전으로 작성된 프로그램을 위해서 남겨놓은 메소드
		v1.addElement("CCCC");	
		System.out.println("v1 => "+v1);				
//		v1 => [aaaa, 111, 123, a, 3.14, true, CCCC]
		
		// 데이터 추가3 : add(index, 데이터);
		// ==> 'index'번째에 '데이터'를 끼워 넣는다.
		// ==> 'index'는 0번부터 시작한다.
		// ==> 반환값은 없다.
		v1.add(1,"kkk");
		System.out.println("v1 => "+v1);				
//		v1 => [aaaa, kkk, 111, 123, a, 3.14, true, CCCC]
		
		// 데이터 꺼내오기 : get(index);
		// ==> 'index'번째 데이터를 반환한다.
		// int data1 = v1.get(3); 	(에러) vector는 데이터를 저장할때 object타입으로 저장하기때문에 vector에 넣을때는 형변환을 안해줘도 잘 담기는데 
//										   데이터를 꺼내올때는 형변환을 해줘야한다. 조상->자식 =형변환 필수/ 자식->조상 =자동형변환
		int data = (int) v1.get(3);
		System.out.println("3번째 데이터 : "+ data);
		
		// 데이터 변경하기 : set(index, 새로운 데이터);
		// ==> 'index'번째의 데이터를 '새로운데이터'로 덮어쓴다.
		// ==> 반환값 : 원래의 데이터
		String temp = (String) v1.set(0,"ZZZZ");
		System.out.println("v1 => "+v1);				
//		v1 => [ZZZZ, kkk, 111, 123, a, 3.14, true, CCCC]
		System.out.println("반환값 : "+ temp);			
//		반환값 : aaaa
		
		// 데이터 삭제하기 : remove(index);
		// ==> 'index'번째의 데이터를 삭제한다. 
		// ==> 반환값 : 삭제된 데이터
		temp = (String) v1.remove(0);
		System.out.println("v1 => "+v1);				
//		v1 => [kkk, 111, 123, a, 3.14, true, CCCC]
		System.out.println("반환값 : "+ temp);			
//		반환값 : ZZZZ
		
		// 데이터 삭제하기2 : remove(삭제할 데이터);
		// ==> '삭제할 데이터'를 찾아 삭제한다.
		// ==> '삭제할 데이터'가 여러개이면 앞에서부터 삭제된다.
		// ==> 반환값: 삭제성공(true),  삭제실패(false)
		// ==> 삭제할 데이터가 '정수형' 이거나 'char형'일 경우에는 반드시 객체로 
		//	   변환해서 사용해야 한다.
		v1.remove("CCCC");	
		System.out.println("삭제후 : "+v1);				
//		삭제후 : [kkk, 111, 123, a, 3.14, true]		
		
		// v1.remove(123); => 런타임에러 ==> 숫자를 배열로 인식해서 123번째 배열을 삭제하려고 함  										
		v1.remove(new Integer(123));					
		System.out.println("삭제후 : "+ v1);			
//		삭제후 : [kkk, 111, a, 3.14, true]

		// v1.remove('a'); => 런타임에러 ==> 문자를 유니코드로 저장됨 
		v1.remove(new Character('a'));
		System.out.println("삭제후 : "+ v1);			
//		삭제후 : [kkk, 111, 3.14, true]
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제후 : "+ v1);		
//		삭제후 : [kkk, 111]
		
		// 전체 데이터 삭제 : clear();
		v1.clear();
		System.out.println("전체 삭제 후 : "+ v1);
//		전체 삭제 후 : []


// --------------------------------------------------------------------------------------------------------------
		/* 
		 * 제네릭 타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 외부에서 지정하는 기법
		 * ==> 객체를 선언할 때 < >안에 그 객체가 사용할 데이터의 타입을 정해주는 것을 말한다.
		 * ==> 이런식으로 객체를 선언하게 되면 다른 종류의 데이터를 저장할 수 없다.
		 * ==> 이때 제네릭으로 선언될 수 있는 데이터 타입은 클래스형이어야 한다.
		 * 		(int ==> Integer, boolean ==> Boolean,
		 * 		 char ==> Character등으로 대체해서 사용해야 한다.)
		 * ==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 떄 별도의 형변환이 필요없다.  
		 */
		Vector<String> v2 = new Vector<String>();		// String타입으로만 저장할거야~
		
		v2.add("안녕하세요");
//		v2.add(1023);	(에러): 다른 종류의 데이터를 저장할 수 없다.
		
		String temp2 = v2.get(0);	// 형변환없이 자료를 꺼내올 수 있다.

		Vector<Vector> vv = new Vector<Vector>();
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
// ------------------------------------------------------------------------------------------------------------------		
		System.out.println("----------------------------------------------------------");
		
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v3 = new Vector<String>();
		v3.add("BBB");
		v3.add("EEE");
		
		System.out.println("v2 = "+v2);
//		v2 = [AAA, BBB, CCC, DDD, EEE]
		
		System.out.println("v3 = "+v3);
//		v3 = [BBB, EEE]
		
		
//		 데이터 삭제하기 : removeAll(Collection 객체) ((Vector데이터를 넣는다생각하면됨))
//		 ==> 'Collection객체'가 가지고 있는 데이터를 찾아서 모두 삭제한다.
//		 ==> 반환값 : 삭제성공(true), 삭제실패(false)
		v2.removeAll(v3); 	// v2에 있는 데이터중에서 v3가 가지고있는 데이터를 찾아서 모두 삭제해
		System.out.println("v2 =>"+v2);
//		v2 =>[AAA, CCC, DDD]
//	-----------------------------------------------------------------------------------------------------
		System.out.println("-----------------------------------------------------------");
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
//		벡터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문 사용
//		(주로 for문 사용)
		System.out.println("일반적인 for문 사용");
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료 : "+ v2.get(i));
		}
		System.out.println("------------------------------------------------------------");
		
//		향상된 for문
		System.out.println("향상된 for문 사용");
		for(String s: v2) {
			System.out.println(s);
		}
		System.out.println("------------------------------------------------------------");
		
		

		
		
		
	}
	
}


