package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("localhost", 7777); // 서버와 클라이언트를 내 컴퓨터에서 쓰기위해 localhost를 사용 -> 클라이언트의 아이피주소입력
			System.out.println("서버에 연결되었습니다.");
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
