package kr.or.ddit.basic;

/*
	쓰레드에서 객체를 공통으로 사용하는 예제
	
	원주율을 계싼하는 쓰레드와
	계산된 원주율을 출력하는 쓰레드가 있다.
	
	원주율을 저장하는 객체가 필요하다.
	이 객체는 두 쓰레드가 공통으로 사용해서 처리한다.
	

*/
public class ThreadTest15 {
	public static void main(String[] args) {
		// 공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		
		// 쓰레드 객체를 생성하고 공통으로 사용할 객체를 쓰레드에 주입한다.
		CalcPIThread ct = new CalcPIThread();
		ct.setSd(sd);
		
		PrintPIThread pt = new PrintPIThread(sd);
		
		ct.start();
		pt.start();
			
	}
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;
	
	//공통으로 사용할 객체를 초기화한다.
	// 방법1) setter를 이용해서 초기화하기
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		if (sd == null) {
			System.out.println("원주율 계산 오류");
			return;
		}

		/*
		 * PI ==> 3.1415926~~~~ 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ....) *4; +1 -3 +5 -7
		 * +9 (2로나눈몫)0 1 2 3 4
		 */

		double sum = 0.0;
		for (int i = 1; i < 100000000; i += 2) {
			if ((i / 2) % 2 == 0) { // 짝수
				sum += (1.0 / i);
			} else {
				sum -= (1.0 / i);
			}
		}
		sd.result = sum * 4; // 계산 완료
		sd.isOk = true;
	}
	
	
}

// 계산이 완료되면 계산된 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;
	
	//공통으로 사용할 객체를 초기화한다.
	// 방법2) 생성자를 이용하여 초기화 하기
	
	public PrintPIThread(ShareData sd) {
		this.sd = sd; 
	}
	
	@Override
	public void run() {
		while (true) {
			if (sd.isOk == true) {
				break;
			}
		}
		
		System.out.println(); 
		System.out.println("계산된 원주율 : " + sd.result);
		System.out.println("PI : " + Math.PI);
		
		
	}
	
}



// 원주율을 관리하는 클래스 (공통으로 사용할 클래스)
class ShareData{
	public double result; 	// 계산된 원주율이 저장될 변수

	
	// volatile ==> CPU의 각 코어(두뇌역할)에 캐시가 있는데 이 캐시를 사용하지 않고 
	//				직접 메모리에서 데이터값을 입출력한다.
	
	// 계산이 완료되었는지를 나타내는 변소(완료되면 true가 된다)
	public volatile boolean isOk = false; 		
	
	
	
}



































