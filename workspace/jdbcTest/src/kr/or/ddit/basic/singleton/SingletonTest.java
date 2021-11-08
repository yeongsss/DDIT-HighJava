package kr.or.ddit.basic.singleton;

public interface SingletonTest {
	
	public static void main(String[] args) {
		// 외부에서 new명령으로 생성 불가
//		MySingleton test1 = new MySingleton();
		
		// 싱글톤 객체 생성
		MySingleton test2 = MySingleton.getInstance();
		MySingleton test3 = MySingleton.getInstance();
		
		System.out.println("test2 => "+ test2.toString());
		System.out.println("test3 => "+ test3.toString());
		
		System.out.println(test2 == test3);
		System.out.println(test3.equals(test2));
		
		test2.displayTest();
		
		
	}
	
}
