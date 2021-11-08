package kr.or.ddit.basic;

public class ThreadTest16 {
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();
		
		TestThread th1 = new TestThread("test1", sObj);
		TestThread th2 = new TestThread("test2", sObj);
		
		th1.start();
		th2.start();

		
	}
}

class TestThread extends Thread{
	private ShareObject sObj;

	public TestThread(String name,ShareObject sObj) {
		super(name);			// 쓰레드의 name설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			sObj.add();
		}
		
	}
	
	
	
}


// 공통 객체
class ShareObject {
	private int sum = 0;
	
	// 동기화 하기
	
	// 방법1 ==> 메서드에 동기화 설정을 한다.
//	public synchronized void add() {

	
	public void add() {
	// 방법2 ==> 동기화 블럭으로 설정한다.
		synchronized (this) {  	// ( ) 속에는 lock을 걸려는 객체를 쓴다. ==> this를 썻으니까 지금 현재 객체에 락을 걸어라는 의미	
		int n = sum;
		
		n += 10;
	
		sum = n; 
		
		System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
		}
	}
	
}

















