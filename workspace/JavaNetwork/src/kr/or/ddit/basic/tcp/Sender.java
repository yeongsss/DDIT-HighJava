package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

// 이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당하는 쓰레드 클래스
public class Sender extends Thread {
	private Socket socket;	// 서버나 클라이언트에 연결된 소켓이 와야한다.
	private DataOutputStream dos;
	private String name;
	private Scanner scanner;
	
	// 생성자
	public Sender(Socket socket) {
		this.socket = socket;
		scanner = new Scanner(System.in);
		
		System.out.println("이름 입력: ");
		name = scanner.nextLine();
		
		try {
			// 출력용 스트림 객체 생성
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void run() {
		while (dos != null) {
			try {
				// 메시지를 입력받아 '이름'뒤에 붙여서 전송한다.
				dos.writeUTF(name + " : " + scanner.nextLine());
			} catch (Exception e) {

			}
		}

	}
	
	
}



