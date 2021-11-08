package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

//JDBC 드라이버를 로딩하고 Connection객체를 생성하는 메소드로 구성된 class만들기
//(dbinfo.properties 파일을 이용하여 설정하기)

// 방법2) ResourceBundle 객체 이용하기
public class DBUtil3 {
	// Logger 객체 생성
	static Logger logger = Logger.getLogger(DBUtil3.class);
	
	static ResourceBundle bundle; 	// ResourceBundle 객체 변수 선언
	
	
	// 정적(static) 초기화 블럭
	static {
		// 객체 생성
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		
		logger.info("ResourceBundle객체 생성 - dbinfo.properties파일 읽기");
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");	
			Class.forName(bundle.getString("driver"));	
			logger.info("DB드라이버 로딩 성공");
			
		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패~~~");
			logger.error("드라이버 로딩 실패 : " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
//			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","LNY","java");
			conn =  DriverManager.getConnection(
					bundle.getString("url"),
					bundle.getString("user"),
					bundle.getString("pass"));
			logger.info("DB서버 연결 성공");
			return conn;
			
		} catch (SQLException e) {
//			System.out.println("오라클 연결실패~~");
			logger.error("DB서버 연결 실패 : " + e.getMessage());
			return null;
		}
	}
	
}
