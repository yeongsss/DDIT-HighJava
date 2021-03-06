package ddit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ddit.service.MemberServiceImpl;
import ddit.vo.MemberVO;

@WebServlet("/member/mypage.do")
public class mypageController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; utf-8");
      
      HttpSession session = request.getSession();

      String mem_id = (String) session.getAttribute("id");
      int mem_no = (int)session.getAttribute("memNo");
      System.out.println("mypage.do에서의 ID =>" + mem_id);
      System.out.println("mypage.do에서의 no =>" + mem_no);
      
      MemberServiceImpl service = MemberServiceImpl.getInstance();
      
      MemberVO memVo = new MemberVO();
      memVo.setMem_id(mem_id);
      memVo.setMem_no(mem_no);

      MemberVO memberInfo = service.getMember(memVo);
      
      request.setAttribute("memberInfo", memberInfo);
      
      System.out.println("setAttri 완료");
      
      System.out.println(request.getAttribute("info_name"));

      request.getRequestDispatcher("/WEB-INF/view/memberView.jsp").forward(request, response);
      
   
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
   }

}