package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 객체를 파일에 저장하는 예제	
public class ObjectIOTest {
	public static void main(String[] args) {
		// Member 객체 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "서울");
		Member mem3 = new Member("홍길남", 40, "인천");
		Member mem4 = new Member("홍길북", 50, "강릉");

		try {
			// 객체를 파일에 저장하기
			// 출력용 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/memObj.dat");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			ObjectOutputStream oos = new ObjectOutputStream(bout);

			// 객체 저장하기
			System.out.println("객체 저장하기 시작...");
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			System.out.println("객체 저장하기 끝...");
			System.out.println();
			
			oos.close();	// 스트림 닫기
			
			//-----------------------------------------------------------------------------------------
			
			// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
			// 입력용 스트림 객체 생성
			ObjectInputStream ois = new ObjectInputStream(
						new BufferedInputStream(
									new FileInputStream("d:/d_other/memObj.dat")
								)
					);
			try {
				System.out.println("객체 읽기 작업 시작..");
				Object obj; // 읽어온 데이터가 저장될 변수
				
				// readObject() 메소드는 데이터를 끝까지 다 읽어오면 EOFException(End Of File Exception)이 발생한다.
				while ((obj = ois.readObject()) != null) {
					// 읽어온 데이터를 원래의 객체형으로 형변환 후 사용한다.
					Member mem = (Member)obj;
					System.out.println("이름 : "+ mem.getName());
					System.out.println("나이 : "+ mem.getAge());
					System.out.println("주소 : "+ mem.getAddr());
					System.out.println("--------------------------------------------------");
					
				}
				
				
			} catch (EOFException e) {
				System.out.println("객체 읽기 작업 끝...");
//				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				ois.close();
				oos.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

class Member implements Serializable{
	private static final long serialVersionUID = -1096438140999733430L;
	
	// transient ==> 직렬화가 되지 않을 멤버변수에 지정한다.
	//			 ==> 직렬화가 되지 않은 멤버변수는 기본값으로 저장된다.
	//				(참조변수 ==> null, 숫자형변수 ==> 0, 논리형변수 ==> false)				
	
	private String name;
	private transient int age;
	private String addr;
	
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}






