package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ClientInfoStatus;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
	d드라이브의 d_other폴더에 있는 '스폰지밥.jpg'파일을 
	d드라이브의 d_other폴더의 하위 폴더 중에서 '연습용'폴더에
	'스폰지밥_복사본.jpg'파일로 복사하는 프로그램을 작성하시오.
*/
public class FileCopy {
	public static void main(String[] args) {
		
	
		try {

			File f = new File("d:/d_other/스폰지밥.jpg");
			FileInputStream fis = new FileInputStream(f);
			File file = new File("d:/d_other/연습용/스폰지밥_복사본.jpg");
			FileOutputStream fos = new FileOutputStream(file);
			int c;

			while ((c = fis.read()) != -1) {
				fos.write(c);
			}

			fis.close();
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
	}
	
}

















