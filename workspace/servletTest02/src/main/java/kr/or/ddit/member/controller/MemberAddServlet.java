package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/memberAdd.do")
public class MemberAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	
		MemberVO mvo = new MemberVO();
		MemberDAOImpl dao = new MemberDAOImpl();
		
		mvo.setMem_id(request.getParameter("userId"));
		mvo.setMem_pass(request.getParameter("userPass"));
		mvo.setMem_passCh(request.getParameter("userPassCheck"));
		mvo.setMem_name(request.getParameter("userName"));
		mvo.setMem_tel(request.getParameter("userTel"));
		mvo.setMem_addr(request.getParameter("userAddr"));
		
		int cnt = dao.addMember(mvo);
		
		request.setAttribute("addMember", cnt);
		request.setAttribute("addMemberVO", mvo);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/memberList.do");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
