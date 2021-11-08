package kr.or.ddit.req_resp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest reqest, HttpServletResponse response) throws ServletException, IOException {
		reqest.setCharacterEncoding("utf-8");
		
		// 입력한 숫자2개와 연산자를 받아온다
		String strNum1 = reqest.getParameter("num1");
		String strNum2 = reqest.getParameter("num2");
		String op = reqest.getParameter("op");
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		
		double result = 0.0;	// 계산될 결과가 저장될 변수
		switch (op) {
		case "+": result = num1 + num2; break;
		case "-": result = num1 - num2; break;
		case "*": result = num1 * num2; break;
		case "/": result = num1 / num2; break;
		case "%": result = num1 % num2; break;

		}
				
		
//		int num1 = Integer.parseInt(reqest.getParameter("number1"));
//		String calculation = reqest.getParameter("calculation");
//		int num2 = Integer.parseInt(reqest.getParameter("number2"));
//		int result = 0;
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
//		if (calculation.equals("+")) {
//			result = num1 + num2;
//		} else if (calculation.equals("-")) {
//			result = num1 - num2;
//		}
//		
		
		
		PrintWriter out = response.getWriter();
		
//		out.println("<!DOCTYPE html>");
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request연습-계산결과 출력</title></head>");
		out.println("<body>");
		
		out.println("<h2>계산 결과</h2><hr>");
		out.printf("%d %s %d = %f <br>", num1,op,num2, result);
//		out.println(num1  + calculation + num2 + " = " + result);
		out.println("</body></html>");
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
