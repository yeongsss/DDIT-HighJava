package kr.or.ddit.basic.generic;

/*
 	제네릭 클래스를 만드는 방법
 	형식) 
 	class 클래스명<제네릭타입글자>{
 			제네릭타입글자 변수명;		//변수 선언에 제네릭을 사용할 경우
 			...
 			제네릭타입글자 메소드명(매개변수들...){	//메소드의 반환값으로 사용할 경우
 			...
 			return 값;
 			}
 	
 			void 메소드명(제네릭타입글자 변수명){	//메소드의 매개변수에 사용할 경우
 			...
 			}
 	}
 	
 */
	
class MyGeneric<T>{
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}

class NonGeneric{
	private Object value;
	
	public void setV0alue(Object value) {
		this.value = value;
	}
	
	public Object getValue() {
		return value;
	}
	
	
}

public class GenericTest {

	public static void main(String[] args) {
		NonGeneric ng1 = new NonGeneric();
		ng1.setV0alue("가나다라");	// outoBoxing
		
		NonGeneric ng2 = new NonGeneric();
		ng2.setV0alue(100);	// outoBoxing
		
		String temp1 = (String)ng1.getValue();	// Object형으로 변환되어 저장되었고 꺼내질때도 Object로 꺼내진다. 
												// 부모데이터가 자식데이터에 넣을때는 자동형변환이 불가능 => 강제형변환
		System.out.println("반환값(문자열) : "+temp1);
		
		Integer temp2 = (Integer)ng2.getValue();
		System.out.println("반환값(정수형) : "+temp2);
		
//		Integer temp3 = (Integer)ng1.getValue();
//		System.out.println(temp3);
//		---------------------------------------------------------
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setValue("우리나라");
		mg2.setValue(500);
		
		String temp3 = mg1.getValue();
		Integer temp4 = mg2.getValue();
		System.out.println("제네릭 반환값(문자열) : "+temp3);
		System.out.println("제네릭 반환값(정수형) : "+temp4);
		
//		mg1.setValue(400);
//		mg2.setValue("sss");
//		
//		String ttt = mg2.getValue();
		
				
				
		
		
		
	}

}












