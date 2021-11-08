package kr.or.ddit.req_resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResponseForwardTest.do")
public class ResponseForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 데이터 받기
		String userName = request.getParameter("username");
		
		// setAttribute()메소드로 넘어온 데이터 받기
		String tel = (String) request.getAttribute("tel");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");  //<==써주는게 기본인데 안써줘도됨ㄴ
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>forwar 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Forward 결과</h2><hr>");
		out.println("<ul>");
		out.println("<li>이 름 : " + userName + "</li>");
		out.println("<li>전 화 : " + tel + "</li>");
		out.println("</ul>");
		out.println("</body></html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
