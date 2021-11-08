package kr.or.ddit.basic;

import java.io.File;

public class FileTest04 {
	public static void main(String[] args) {
		
	}
	
	// 디렉토리 정보를 가지고 있는 File객체를 매개변수로 받아서 
	// 해당 디렉토리 안에 있는 모든 파일과 자식 디렉토리 목록을 출력하는 메소드
	public void displayFileList(File dir) {
		if (!dir.isDirectory()) {
			System.out.println("디렉토리(폴더)만 사용 가능합니다.");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용" );
		
		// 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구한다.
		File[] files = dir.listFiles();
//		String[] strFiles = dir.list();
		
		// c   
		
		
		
		
		
	}
	
	
	
}






