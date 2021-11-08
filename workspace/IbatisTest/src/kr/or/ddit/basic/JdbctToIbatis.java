package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

// jdbc공부할 때 사용했던 jdbcTest05.java 프로그램을 ibatis용으로 변환하시오.
// (SQL문이 저장될 xml문서의 파일명은 'jdbc.xml'로 한다.)

/*
문제) LPROD테이블에 새로운 데이터를 추가하기
		Lprod_gu와 Lprod_nm은 직접 입력받아서 처리하고,
		Lprod_id는 현재의 Lprod_id중 제일 큰 값보다 1만큼 크게해서 처리한다.
		그리고 입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
*/
public class JdbctToIbatis {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();
			LprodVO lvo = new LprodVO();
			
			// 현재 Lprod_id중 제일 큰 값보다 1 크게해서 가져오기.
			int id = (int)smc.queryForObject("lprod2.getLprodId");
			System.out.println(lvo.getLprod_id());
			System.out.println();
			
			
			// lprod_gu 중복확인하기
			System.out.println("Lprod_gu 중복확인");
			System.out.print("Lprod_gu 입력 :");
			String lprodGu = scn.next();
			int cnt = (int)smc.queryForObject("lprod2.checkLprodGu", lprodGu);
			if (cnt > 0 ) {
				System.out.println("입력한 상품분류코드 "+lprodGu+ "는 이미 등록된 코드 입니다.");
			} else {
				System.out.println("중복확인 완료");
			}
			
					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
