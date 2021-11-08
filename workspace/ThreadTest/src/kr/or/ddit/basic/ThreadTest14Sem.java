package kr.or.ddit.basic;

import java.util.Arrays;
import java.util.Random;

/*
	10마리의 말들이 경주하는 프로그램을 작성하시오.
	
	말은 Horse라는 이름의 쓰레드 클S래스로 작성하는데
	이 클래스는 말이름(String), 현재위치(int), 등수(int)를 멤버변수로 갖는다.
	그리고 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다.
	(Comparable 인터페이스 구현)
	
	경기 구간은 1 ~ 50 구간으로 되어 있다.
	
	경기 중 중간 중간에 각 말들의 위치를 나타낸다.
	예) 
	01번말 ---->------------------------------------------------
	02번말 -------->--------------------------------------------
	...
	10번말 ----->-----------------------------------------------
	
	경기가 끝나면 등수 순으로 출력한다.
	
	
*/
public class ThreadTest14Sem {
	public static void main(String[] args) {
		Horse2[] horses = new Horse2[] {
			new Horse2("01번말"),	new Horse2("02번말"),	
			new Horse2("03번말"),	new Horse2("04번말"),	
			new Horse2("05번말"),	new Horse2("06번말"),	
			new Horse2("07번말"),	new Horse2("08번말"),	
			new Horse2("09번말"),	new Horse2("10번말"),	
		};
		
		GameStateThread gst = new GameStateThread(horses);
		
		for (Horse2 h : horses) {
			h.start();				// 말의 경주 시작
		}
		
		gst.start();				// 말들의 현재 위치 출력하는 쓰레드 시작
		
		try {
			for (Horse2 h : horses) {
					h.join();
			} 
			
			gst.join();
		}catch (InterruptedException e) {
				// TODO: handle exception
		}
			
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		// 등수의 오름차순으로 정렬하여 출력한다.
		Arrays.sort(horses);	// 배열 정렬하기
		
		System.out.println("경기 결과");
		for (Horse2 h : horses) {
			System.out.println(h);
		}
		
		
		
		
		
	}
}

class Horse2 extends Thread implements Comparable<Horse2>{
	public static int  currentRank = 0;	// 각각의 말이 경기가 끝나면 1씩 증가한다.
										// 즉, 말의 등수를 구하는데 사용한다.
	
	private String horseName;
	private int rank;
	private int location;
	
	public Horse2(String horseName) {
		this.horseName = horseName;
	}
	
	public String getHorseName() {
		return horseName;
	}
	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		rank = rank;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return  rank + "은 \t " + horseName  + " 입니다." ;
	}
	
	// 등수의 오름차순
	@Override
	public int compareTo(Horse2 horse) {
			return Integer.compare(rank, horse.getRank());
		}
	
	
	// 쓰레드에서 달리기 기능을 구현한다.
	// 경기 구간은 1~50구간으로 되어 있다.
	@Override
	public void run() {
		Random rnd = new Random();
		for (int i = 1; i <= 50 ; i++) {
			this.location = i;	// 말의 현재 위치를 저장한다.
			try {
				Thread.sleep(rnd.nextInt(500));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		// 한 마리의 말이 경주가 끝나면 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}
}

// 경기 중 말의 위치를 표시하는 스레드
class GameStateThread extends Thread{
	private Horse2[] horses;		// 경기에 참가한 말들을 저장할 배열
	
	public GameStateThread(Horse2[] horses) {
		this.horses = horses;
	}
	
	@Override
	public void run() {
		while (true) {
			// 모든 말들의 경기가 종료되었을 때 이 쓰레드도 종료되게 한다.
			if (Horse2.currentRank == horses.length) {
				break;
			}
			for(int i =1; i<= 10; i++) System.out.println();
			
			for (int i = 0; i < horses.length; i++) {
				System.out.print(horses[i].getHorseName() + " : ");
				for (int j = 1; j <= 50; j++) {
					if (j == horses[i].getLocation()) {
						System.out.print(">");
					}
					System.out.print("-");
				}
				System.out.println(); // 줄바꿈
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			
		}
	}
	
	
}

















