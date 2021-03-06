package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	
	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}
	
	public void clientStart() {
		Socket socket = null;
		try {
			String serverIp = "192.168.43.8";
			socket = new Socket(serverIp, 7777);
			System.out.println("서버에 연결되었습니다..\n");
			
			// 메시지 전송용 쓰레드 생성
			ClientSender sender = new ClientSender(socket);
			
			// 메시지 수신용 쓰레드 생성
			ClientReceiver receiver = new ClientReceiver(socket);

			sender.start();
			receiver.start();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	} // clientStart()메소드 끝..
	
	
}

//---------------------------------------------------------------
// 메시지 전송용 쓰레드
class ClientSender extends Thread {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	private String name;
	private Scanner scan;
	
	//  생성자
	public ClientSender (Socket socket) {
		this.socket = socket;
		scan = new Scanner(System.in);
		
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			if (dos != null) {
				// 처음 클라이언트 프로그램이 시작하면 대화명을 서버로 전송,
				// 대화명의 중복여부를 feedback으로 받아서 확인한다.
				System.out.println("대화명 : ");
				String name = scan.nextLine();
				
				while (true) {
					dos.writeUTF(name);	// 대화명을 전송한다.뇨
					
					String feedback = dis.readUTF(); // 대화명의 중복 여부를 받는다.
					if(feedback.equals("이름중복")) { // 대화명이 중복될 때
						System.out.println(name + "은 이름이 중복됩니다.");
						System.out.println("다름 대화명으로 다시 입력하세요.");
						System.out.print("대화명 : ");
						name = scan.nextLine();
					} else { //  중복되지 않을 떄..
						this.name = name;
						System.out.println("[ " + name + " ]이름으로 대화방에 입장했습니다.");
						break; // 반목문 탈출
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}// 생성자 끝..
	
	@Override
	public void run() {
		try {
			while (dos != null) {
				// 키보드로 입력한 메시지를 서버로 전송한다.
				dos.writeUTF("[ "+name + " ] "+ scan.nextLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}


// 메시지 수신용 쓰레드
class ClientReceiver extends Thread {
	private Socket socket;
	private DataInputStream dis;

	public ClientReceiver(Socket socket) {
		this.socket = socket;
		try {
			dis = new DataInputStream(socket.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Override
	public void run() {
		try {
			while (dis != null) {
				// 서버로부터 받은 메시지를 화면에 출력한다.
				System.out.println(dis.readUTF());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
}
































