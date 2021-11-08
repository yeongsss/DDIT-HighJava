package kr.or.ddit.basic;

import java.io.FileReader;

public class FileIOTest03 {
	public static void main(String[] args) {
		// 문자 기반의 스트림을 이용한 파일 내용 읽기

		try {
			// 파일 입력용 스트림 객체 생성
			FileReader fr = new FileReader("d:/d_other/test.txt");

			int c; // 읽어온 데이터를 저장할 변수

			while ((c = fr.read()) != -1) {
				System.out.print((char) c);
			}
			
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
