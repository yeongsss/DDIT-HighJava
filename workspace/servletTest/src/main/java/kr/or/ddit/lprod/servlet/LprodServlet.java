package kr.or.ddit.lprod.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;

@WebServlet("/lprodServlet.do")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ILprodService service;
	
	public LprodServlet() {
		service = LprodServiceImpl.getInstance();	
	}
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String choice = request.getParameter("choice");
		
		
		
		Gson gson = new Gson();
		String jsonData = null;
		switch (choice) {
		case "list":
			LprodVO vo = new LprodVO();
			System.out.println(vo);
			List<LprodVO> lprodList = service.getLprodList();
			System.out.println("아니 왜 안되는거야;;;;");

			jsonData = gson.toJson(lprodList);
			
			break;

		}
		System.out.println(choice + " : " + jsonData);
		
		out.println(jsonData);
		response.flushBuffer();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
