package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import oracle.net.aso.m;

@WebServlet("/member/memberView.do")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
//		MemberVO memberInfo = service.getMemberInfo(mem_id);
		MemberVO memberInfo = new MemberVO();
		memberInfo.setMem_id(mem_id);
		memberInfo = service.getMemberInfo(memberInfo);
		
		
		request.setAttribute("memberInfo", memberInfo);
		
		request.getRequestDispatcher("/WEB-INF/view/memberView.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
