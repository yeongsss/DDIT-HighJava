package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DaedeokHotel {
	Scanner scn = new Scanner(System.in);
	HashMap<Integer, Room> map;
	private String fileName = "d:/d_other/test/HotelData.dat";
	private boolean dataChange;
	
	public DaedeokHotel() {
		map = load();
		
		if (map == null) {
			map = new HashMap<Integer, Room>();
		}
		scn = new Scanner(System.in); 
	}
	
	private HashMap<Integer, Room> load(){
		HashMap<Integer, Room> hMap = null;
		
		File file = new File(fileName);
		if (!file.exists()) {
			return null;
		}
		
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(file)
							)
					);
			
			hMap = (HashMap<Integer, Room>) ois.readObject();
			
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		} finally {
			if(ois!=null)try {ois.close();} catch(IOException e) {}
		}
		return hMap;
	}
	
	public void save() {
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test/HotelData.Dat");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oos = new ObjectOutputStream(bout);
			
			for (int roomNo : map.keySet()) {
				oos.writeObject(map.get(roomNo));
			}
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		DaedeokHotel hotel = new DaedeokHotel();
		hotel.make();

		System.out.println("**********************************************************************");
		System.out.println("            호텔문을 열었습니다.   어서오십시오 :) ");
		System.out.println("**********************************************************************");

		hotel.start();
	}

	public void start() {
		room: while (true) {
			System.out.println();
			System.out.println("----------------------------------------------------------------------");
			System.out.println("어떤 업무를 하시겠습니까?");
			System.out.println("  1. 체크인    2.체크아웃     3.객실상태    4.정보저장    5.업무종료");
			System.out.println("----------------------------------------------------------------------");
			System.out.print("선택>> ");
			int input = scn.nextInt();

			switch (input) {
				case 1:
					checkIn();
					break;
				case 2:
					checkOut();
					break;
				case 3:
					roomState();
					break;
				case 4:
					save();
					break;
					
				case 5:
					close();
					break room;
			}

		}
	}

	private void close() {
		System.out.println();
		System.out.println("**********************************************************************");
		System.out.println("                     호텔문을 닫았습니다. ");
		System.out.println("**********************************************************************");

	}

	private void roomState() {
		if (map.size()==0) {
			System.out.println("예약된 객실이 없습니다.");
			return;
		}
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("            현재 객실 상태");
		System.out.println("-------------------------------------------");
		System.out.println(" 방 번호   방 종류           투숙객 이름");
		System.out.println("-------------------------------------------");
		
		for (int room : map.keySet()) {
			if (room > 400 && room < 410) {
				String value = map.get(room).toString1();
				System.out.println(value);
			} else {
				String value = map.get(room).toString2();
				System.out.println(value);
			}
		}
		System.out.println("-------------------------------------------");
	}

	private void checkOut() {
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("  체크아웃 작업");
		System.out.println("-------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요");
		System.out.print("방번호 입력 >> ");
		int roomNum = scn.nextInt();

		if (map.containsKey(roomNum)) {
			if (map.get(roomNum).getName() == "-") {
				System.out.println(roomNum + "호 객실에는 체크인 한 사람이 없습니다.");
			} else {
				String name = map.get(roomNum).getName();
				map.get(roomNum).setName("-");
				if (map.get(roomNum).getName() == "-") {
					System.out.println(roomNum + "호 객실의 " + name + "님 체크아웃을 완료하였습니다.");
				}
			}

		} else {
			System.out.println(roomNum + "호 객실은 존재하지 않습니다.");
		}
	}

	public void checkIn() {
		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("  체크인 작업");
		System.out.println("-------------------------------------------");
		System.out.println("  * 201~209 : 싱글룸");
		System.out.println("  * 301~309 : 더블룸");
		System.out.println("  * 401~409 : 스위트룸");
		System.out.println("-------------------------------------------");
		System.out.print("방 번호 입력>>");
		int roomNo = scn.nextInt();
		System.out.println();

		if (map.containsKey(roomNo)) {

			if (map.get(roomNo).getName() == "-") {
				System.out.println("누구를 체크인 하시겠습니까?");
				System.out.print("이름 입력 >> ");
				String name = scn.next();
				map.get(roomNo).setName(name);
				if (map.get(roomNo).getName() == name) {
					System.out.println("체크인이 완료되었습니다.");
				} else {
					System.out.println("체크인 실패");
				}
			} else {
				System.out.println(roomNo + "호 객실은 이미손님이 있습니다.");
			}
		} else {
			System.out.println(roomNo + "호 객실은 존재하지 않습니다.");
		}
	}

	public void make() {

		for (int i = 2; i < 5; i++) {
			for (int j = 1; j < 10; j++) {
				int num = i * 100 + j;
				if (i == 2) {
					Room room = new Room(num, "싱글룸", "-");
					map.put(num, room);
				} else if (i == 3) {
					Room room = new Room(num, "더블", "-");
					map.put(num, room);
				} else if (i == 4) {
					Room room = new Room(num, "스위트룸", "-");
					map.put(num, room);
				}

			}
		}

		ArrayList<Room> list = new ArrayList<Room>();


	}

}// class

class Room implements Serializable{
	private static final long serialVersionUID = 1L;

int roomNum;
	String roomKind;
	String name;

	public Room(int roomNum, String roomKind, String name) {
		super();
		this.roomNum = roomNum;
		this.roomKind = roomKind;
		this.name = name;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String getRoomKind() {
		return roomKind;
	}

	public void setRoomKind(String roomKind) {
		this.roomKind = roomKind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString1() {
		return roomNum + "   \t" + roomKind + "\t\t" + name;
	}

	public String toString2() {
		return roomNum + "   \t" + roomKind + "\t\t\t" + name;
	}

}
