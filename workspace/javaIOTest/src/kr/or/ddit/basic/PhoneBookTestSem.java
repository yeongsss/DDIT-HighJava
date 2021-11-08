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
import java.util.HashMap;
import java.util.Scanner;


public class PhoneBookTestSem {
	private HashMap<String, Phone> phoneBookMap;
	private Scanner scan;
	private String fileName = "d:/d_other/test/phoneData.dat";
	
	// 데이터의 변경 여부를 나타내는 변수 선언
	// 이 변수 값이 true이면 데이터가 변경된것으로 한다.
	private boolean dataChange;
//	Set<String> keySet = map.keySet();
//	Iterator<String> it = keySet.iterator();

	public PhoneBookTestSem() {
		// 저장된 파일을 읽어와서 Map에 셋팅한다.
		phoneBookMap = load();
		
		if (phoneBookMap == null) { 	// 파일이 없거나 잘못되었을 때...
			phoneBookMap = new HashMap<String, Phone>();
		}
		scan = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
//		new PhoneBookTest().getData();
		new PhoneBookTestSem().start();
	}
 
	
	
	

	public void start() {
		phone : while(true) {
			System.out.println();
			System.out.println("	1. 전화번호 등록");
			System.out.println("	2. 전화번호 수정");
			System.out.println("	3. 전화번호 삭제");
			System.out.println("	4. 전화번호 검색");
			System.out.println("	5. 전화번호 전체 출력");
			System.out.println("	6. 전화번호 저장");
			System.out.println("	0. 프로그램 종료");
			System.out.println("--------------------------------------------");
			System.out.print("번호입력 >> ");
			int input = scan.nextInt();
	
			switch (input) {
				case 1:
					insert();
					break;
				case 2:
					update();
					break;
				case 3:
					delete();
					break;
				case 4:
					search();
					break;
				case 5:
					total();
					break;
				case 6:
					save();
					break;
				case 0:
					if(dataChange == true) {	// 데이터가 변경되었으면
						System.out.println("변경된 데이터를 저장합니다.");
						save();
					}
					System.out.println();
					System.out.println("종료합니다");
					break phone;
			}
		}
		
	}
	
	// 전화번호 정보가 저장된 파일을 읽어오는 메소드
	private HashMap<String, Phone> load() {
		HashMap<String, Phone> pMap = null;		// 읽어온 데이터가 저장될 변수 
		
		File file = new File(fileName);
		if(!file.exists()) { 	// 저장된 파일이 없으면,,,,
			return null;
		}
		
		ObjectInputStream ois = null;
		try {
			// 객체 입력용 스트림 객체 생성
			ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(file)
							)
					);
			pMap = (HashMap<String, Phone>) ois.readObject();
			
					
					
			
		} catch (IOException e) {
			return null;
			// e.printStackTrace();
		} catch (ClassNotFoundException e) {
			return null;
			// e.printStackTrace();
		} finally {
			// 사용했던 스트림 객체 닫기
			if (ois!= null) try { ois.close(); } catch(IOException e) { }

		}
		
		
		
		
		return pMap;
		
	}
	
	
	

//	public void getData() {
////		File file = new File("d:/d_other/test/phoneData.dat");
////		if (!file.exists()) {
////			return;
////		}
//		
//		
//		try {
//			ObjectInputStream ois = new ObjectInputStream(
//					new BufferedInputStream(
//							new FileInputStream("d:/d_other/test/phoneData.dat")
//							)
//					);
//			try {
//				
//				Object obj = ois.readObject();
//				
//				map = (HashMap<String,Phone>)obj;
//								
//				
//			} catch (EOFException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			} 
//			
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
	
	
	
	
	
	public void save() {
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test/phoneData.dat");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oos = new ObjectOutputStream(bout);
			
			for (String string : phoneBookMap.keySet()) {
				oos.writeObject(phoneBookMap.get(string));
			}
			
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public void insert() {
		Phone phone = new Phone();
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요");
		System.out.print("이름 >> ");
		String name = scan.next();
		phone.setName(name);
		
		if (phoneBookMap.containsKey(name)) {
			System.out.println();
			System.out.println("'" + name + "'은 이미 등록된 사람입니다.");
			return;
		}

		System.out.print("전화번호 >> ");
		phone.setTel(scan.next());
		
		scan.nextLine();
		System.out.print("주 소 >> ");
		phone.setAddr(scan.nextLine());

		phoneBookMap.put(phone.getName(), phone);

		System.out.println("'" + phone.getName() + "'전화번호 등록 완료!!!");
		dataChange = true;
	}//insert
	
	public void update() {
		System.out.print("이 름 >> ");
		String upName = scan.next();
		phoneBookMap.get(upName);
		System.out.print("수정할 전화번호>> ");
		phoneBookMap.get(upName).setTel(scan.next());
		
		phoneBookMap.put(upName, phoneBookMap.get(upName));
		
		System.out.println("수정완료!");
		
		dataChange = true;
		
	}//update
	
	
	public void delete() {
		System.out.print("이름 >> ");
		System.out.println();
		String delName = scan.next();
		String result = phoneBookMap.remove(delName) + "";
		
		if (result.isEmpty()) {
			System.out.println("삭제 실패");
		} else {
			System.out.println("삭제 성공");
		}
		dataChange = true;
		
	}//delete
	
	public void search() {
		System.out.print("이름 >> ");
		String srName = scan.next();
		if (phoneBookMap.containsKey(srName)) {
			Phone search = phoneBookMap.get(srName);
			System.out.println();
			System.out.println(search);
		} else {
			System.out.println("저장된 전화번호가 없습니다");
			System.out.println();
		}
		
		
	}//search
	
	public void total() {
		if (phoneBookMap.size()==0) {
			System.out.println("없어요~~~~");
			return;
		}
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("번호  \t 이름 \t 전화번호  \t\t 주소 ");
		System.out.println("-----------------------------------------------------------------------");
		int cnt =1;
		for (String string : phoneBookMap.keySet()) {
			Phone value = phoneBookMap.get(string);
			System.out.println(cnt++ + "\t" +value);
		}
		System.out.println("-----------------------------------------------------------------------");
	}
	
	
}


class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String addr;
	private String tel;

	public Phone() {}

	public Phone(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return  name + "\t\t" + addr + "\t\t" + tel;
		
	}
	
	
}





