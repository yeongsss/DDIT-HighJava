package kr.or.ddit.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.If;

@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
//		Cookie[] cookieArr = request.getCookies();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String check = request.getParameter("check");
		
		// 사용자 ID를 지정한 쿠키객체 생성
		Cookie cookie = new Cookie("id", id);
//
//		if(check!=null) { // checkbox가 체크된 상태이다.
//			response.addCookie(cookie);	// 쿠키저장
//			
//		} else {	// checkbox가 해제된 상태
//			cookie.setMaxAge(0);	// 쿠키의 유효시간을 0으로 설정해서 바로 삭제되도록 한다.
//			response.addCookie(cookie);
//		}
//		
		if (check==null) {
			cookie.setMaxAge(0);
		} 
		response.addCookie(cookie);
		
		// 로그인 성공 여부 검사( id: test, password: 1234)
		if("test".equals(id) && "1234".equals(pass)) {
			response.sendRedirect(request.getContextPath() + "/02/cookieMain.jsp");
		}else {
			response.sendRedirect(request.getContextPath() + "/02/cookieLogin.jsp");
		}
		
		
		
		
		
//---------------------------------------------------------------------------------------------------------------
//		if (check.equals("check")) {
//			if (id.equals("test") && pass.equals("1234")) {
//				Cookie cookieId = new Cookie("id", id);
//				Cookie cookiePw = new Cookie("pass", pass);
//				response.addCookie(cookieId);
//				response.addCookie(cookiePw);
//				
//				response.sendRedirect(request.getContextPath() + "/02/cookieMain.jsp");
//			} else {
//				Cookie cookieId = new Cookie("id", id);
//				response.addCookie(cookieId);
//			}
//			
//			
//		}
		
		
		
		
//		if (cookieArr != null) {
//			if (check != null) {
//				Cookie checkCookie = new Cookie("check", String.valueOf(check));
//				Cookie addId = new Cookie("id", id);
//				response.addCookie(checkCookie);
//				response.addCookie(addId);
//				
//				for (Cookie cookie : cookieArr) {
//					String name = cookie.getName();
//					if ("id".equals(name)) {
//						String value = cookie.getValue();
//						if (value.equals(id)) {
//							response.sendRedirect(request.getContextPath()+"/02/cookieMain.jsp");
//						}else {
//							
//						}
//					}
//
//				}
//			}
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}








