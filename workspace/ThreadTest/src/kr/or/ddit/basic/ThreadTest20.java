package kr.or.ddit.basic;

/*
	wait(), notify()메소드를 이용해서 두 쓰레드가 번갈아 한번씩 실행하는 예제
	
	wait(), notify(), notifyAll()메소드는 동기화 영역에서만 사용가능하다.
*/
public class ThreadTest20 {
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}
}

// 공통으로 사용할 객체
class WorkObject{
	public synchronized void methodA() {
		System.out.println("methodA() 메소드 실행 중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

	public synchronized void methodB() {
		System.out.println("methodB() 메소드 작업 중...");

		notify();

		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}	
}


// WorkObject의 methodA()메소드만 호출하는 쓰레드
class ThreadA extends Thread {
	private WorkObject workObj;

	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObj.methodA();
		}
		synchronized (workObj) {
			workObj.notify();	//이것만쓰면 동기화 영역이 아니라 에러가 나기때문에 synchronized 안에 넣어준다.
		}
	}
}

// WorkObject에서 methodB()메소드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;

	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			workObj.methodB();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
	
}
































