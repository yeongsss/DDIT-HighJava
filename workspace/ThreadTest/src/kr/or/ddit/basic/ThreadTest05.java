package kr.or.ddit.basic;

public class ThreadTest05 {
	public static void main(String[] args) {
		Thread th1 = new UpperThread();
		Thread th2 = new LowerThread();
		
		// 우선순위 변경은 start()메소드 호출 전에 설정한다.
		th1.setPriority(9);
		th2.setPriority(3);
		
		
		System.out.println("th1의 우선 순위 : "+ th1.getPriority());
		System.out.println("th2의 우선 순위 : "+ th2.getPriority());
		
		th1.start();
		th2.start();
	}
}

// 대문자를 출력하는 쓰레드
class UpperThread extends Thread {

	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c);
			for (int i = 1; i <= 1_000_000_000; i++); // 시간때우기
		}
	}

}

// 소문자를 출력하는 쓰레드
class LowerThread extends Thread {

	@Override
	public void run() {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.println(c);
			for (int i = 1; i <= 1_000_000_000; i++); // 시간때우기
		}
	}

}

