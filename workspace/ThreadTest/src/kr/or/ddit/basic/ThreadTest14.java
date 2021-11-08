package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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
public class ThreadTest14 {
	public static void main(String[] args) {
		int rank=1;
		
		List<Horse> list = new ArrayList<Horse>();
		list.add(new Horse("1번 말"));
		list.add(new Horse("2번 말"));
		list.add(new Horse("3번 말"));
		list.add(new Horse("4번 말"));
		list.add(new Horse("5번 말"));
		list.add(new Horse("6번 말"));
		list.add(new Horse("7번 말"));
		list.add(new Horse("8번 말"));
		list.add(new Horse("9번 말"));
		list.add(new Horse("10번 말"));
		
		for (Horse horse : list) {
			horse.start();
		}
		
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}

			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getNow() <= 50) {
					System.out.println(list.get(i).horseName + ": \t" + list.get(i));
				}
				if (list.get(i).getNow() == 50 && list.get(i).getRank() == 0) {
					list.get(i).setRank(rank);
					rank++;
				}
			}
			System.out.println();
			if (rank == list.size()+1) {
				break;
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i+1+"등 :"+ list.get(i).getHorseName());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	String horseName;
	int now;
	int rank;

	public Horse(String name) {
		this.horseName = name;
	}
	
	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getNow() {
		return now;
	}

	public void setNow(int now) {
		this.now = now;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override
	public String toString() {
		String state = "";
		for (int i = 0; i <= 50; i++) {
			if (now == i) {
				state += ">";
			}else {
				state += "-";
			}
		}
		return state;
	}

	
	@Override
	public int compareTo(Horse o) {
		return Integer.compare(this.rank, o.rank);
	}


	@Override
	public void run() {
		Random rnd = new Random();
		while (now < 50) {
			if (rnd.nextInt(6000000) == 0) {
				this.now ++;
			}
		}
		
	}

	
	
}



//
//class DisplayHorse extends Thread {
//	private String horseName;
//	public static String setRank = "";
//
//	public DisplayHorse(String name) {
//		this.horseName = name;
//	}
//
//	@Override
//	public void run() {
//		Random rnd = new Random();
//		for (int i = 1; i <= 50; i++) {
//			System.out.print(horseName + "의 위치 : ");
//			for (int j = 1; j <= 50; j++) {
//				if (i == j) {
//					System.out.print(">");
//				} else {
//					System.out.print("-");
//				}
//			}
//			System.out.println();
//			try {
//				Thread.sleep(rnd.nextInt(500));
//			} catch (InterruptedException e) {
//			}
//		}
//		System.out.println(horseName + "출력 끝...");
//
//		setRank += horseName + " ";
//
//	}
//
//}
