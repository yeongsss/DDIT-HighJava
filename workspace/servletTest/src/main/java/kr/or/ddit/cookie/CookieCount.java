package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCount.do")
public class CookieCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키변수는 'count'로 한다.
		Cookie[] cookieArr = request.getCookies();
		int count = 0;	// 카운트 값이 저장될 변수
		
		// 쿠키변수 'count'가 있는지 검사
		if(cookieArr!= null) {
			for (Cookie cookie : cookieArr) {
				String name = cookie.getName();	// 쿠키변수 구하기
				if ("count".equals(name)) {
					// 쿠키변수가 있으면 쿠키값을 읽어온다.
					String value = cookie.getValue();	
					
					// count 쿠키값을 정수형으로 변환
					count = Integer.parseInt(value);	
				}	// for문 안쪽의 if문
			}// for문
		}// if문
		count++;	// count값 증가하기
		
		// 증가된 count가 저장될 쿠키를 생성한다.
		Cookie cntCookie = new Cookie("count", String.valueOf(count));
		
		// 쿠키추가
		response.addCookie(cntCookie);
		
		
		
//		int cnt = 0;
//		String count = null;
//		
//		Cookie countCookie = new Cookie("count", String.valueOf(1));
//		response.addCookie(countCookie);
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html><head><meta charset='utf-8'>");
//		out.println("<title>Cookie 연습</title></head>");
//		out.println("<body>");
//		
//		Cookie[] readCookie = request.getCookies();
//		
//		for (Cookie cookie : readCookie) {
//			String value= cookie.getValue();
//			if ("count".equals(value)) {
//				cnt = Integer.parseInt(value);
//				
//				cnt += 1;
//
//				Cookie countCookie2 = new Cookie("count", String.valueOf(cnt));
//				response.addCookie(countCookie2);
//			}
//		}
//	
		
		// 결과 보여주기
		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키 Count 연습</title></head>");
		out.println("<body>");
		out.println("<h2>어서오세요. 당신은 "+ count +"번째 방문입니다.</h2><br><br>");
		out.println("<a href='" + request.getContextPath() +"/cookieCount.do'>카운트 증가하기  </a>");
		out.println("<a href='"+ request.getContextPath() +"/02/cookieTest02.jsp'>  시작문서로 이동하기</a>");
		out.println("</body></html>"); 
		

	}  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
