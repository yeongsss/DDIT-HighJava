package kr.or.ddit.basic;

import java.util.Random;

/*
	3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성하기
	
*/
public class ThreadTest13 {
	public static void main(String[] args) {
		DisplayCharacter[] dis = new DisplayCharacter[] {
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("이순신"),
				new DisplayCharacter("강감찬")
				
		};
		
		for (DisplayCharacter dc : dis) {
			dc.start();
		}
		
		for (DisplayCharacter dc : dis) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.err.println();
		System.out.println("경기 결과 ");
		System.out.println("순 위 : " +DisplayCharacter.setRank);
	
	}
}


// A~Z까지 출력하는 쓰레드
class DisplayCharacter extends Thread{
	public static String setRank = "";		// 출력을 마친 순서대로 나타낸 변소
	private String name;		// 이름이 저장될 변수
	
	// 생성자
	public DisplayCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		Random rnd = new Random();
		for (char c = 'A'; c <= 'Z' ; c++) {
			System.out.println(name + "의 출력 문자 : "+ c);
			try {
				// 일시정지 시간을 난수를 이용하여 지정한다.
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) { }
		}
		System.out.println(name + " 출력 끝....");
		
		// 출력을 끝낸 순서대로 이름을 배치한다.
		setRank += name + " ";
	
	}
	
	
}




