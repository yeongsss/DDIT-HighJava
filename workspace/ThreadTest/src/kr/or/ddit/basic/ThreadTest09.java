package kr.or.ddit.basic;

import java.util.Random;

import javax.print.attribute.standard.Sides;
import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램 작성하기
	
	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
	사용자의 입력는 showInputDialog()메소드를 이용해서 입력받는다.
	
	입력 시간은 5초로 제한하고 카운트 다운을 한다.
	5초안에 입력이 없으면 게임에 진것으로 처리한다.
	
	5초안에 입력이 완료되면 승패를 구해서 출력한다.
	
	결과예시)
		-- 결 과 --
		컴퓨터 : 가위
		사용자 : 바위
		결  과 : 당신이 이겼습니다.
		
	5초안에 입력을 못했을 경우
		-- 결 과 --
		시간초과로 당신이 졌습니다.
 
*/

public class ThreadTest09 {
	Random rnd = new Random();
	private static String com ="";
	
	public static void main(String[] args) {
		new ThreadTest09().computer();
		
		DataIn th1 = new DataIn();
		Count th2 = new Count();
		
		th1.start();
		th2.start();
		
	}
	
	public static String getCom() {
		return com;
	}
	
	public void computer() {
		int comNo = rnd.nextInt(3) + 1;
		switch (comNo) {
		case 1:
			com = "가위";
			break;
		case 2:
			com = "바위";
			break;
		case 3:
			com = "보";
			break;
		}
	}

}



//데이터를 입력하는 쓰레드
class DataIn extends Thread{
	public static boolean inputCheck;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("가위\t바위\t보");
		
		inputCheck = true; 	// 입력이 완료되어 값을 true로 변경한다.
		
		System.out.println("-- 결 과 --");
		System.out.println("컴퓨터 : "+ ThreadTest09.getCom());
		System.out.println("사용자 : "+ str);				

		if (str.equals(ThreadTest09.getCom())) {
			System.out.println("결 과 : 비겼습니다");
		} else if (str.equals("가위") && ThreadTest09.getCom().equals("보")
				|| str.equals("바위") && ThreadTest09.getCom().equals("가위")
				|| str.equals("보") && ThreadTest09.getCom().equals("바위")) {
			System.out.println("결 과 : 당신이 이겼습니다");
		} else {
			System.out.println("결 과 : 당신이 졌습니다");
		}
	
	
	}

}





class Count	extends Thread{
	ThreadTest09 th = new ThreadTest09();
	
	@Override
	public void run() {
		for (int i = 5; i > 0 ; i--) {

			if (DataIn.inputCheck == true) {

				return;

			}

			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
		}
		
		System.out.println("-- 결 과 --");
		System.out.println("시간초과로 당신이 졌습니다.");
		
		System.exit(0);
	}
	
	
}












































