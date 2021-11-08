<%@page import="ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>

</head>
<body>
<%
	MemberVO mvo = (MemberVO)request.getAttribute("memberVO");
%>
<h2>회원 정보 상세보기</h2>
<form method="post" id="memberForm" action=""></form>
<input type="hidden" name="mem_id" value="<%= %>">
<table border="1">
<tr>
	<td>회원ID</td>
	<td><%=mvo.getMem_id() %></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><%=mvo.getMem_pass() %></td>
</tr>
<tr>
	<td>회원이름</td>
	<td><%=mvo.getMem_name() %></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><%=mvo.getMem_tel() %></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><%=mvo.getMem_addr() %></td>
</tr>
<tr>
	<td colspan="2" style="text-align:center">
		<input type="button" value="수정" id="updateBtn">
		<input type="button" value="삭제" id="deleteBtn">
		<input type="button" value="회원목록" id="memListBtn">
	</td>
</tr>
</table>

<script type="text/javascript">
$(function(){
	$('#memListBtn').on('click',function(){
		location.href= "<%=request.getContextPath()%>/memberList.do"
	});
	
	$('#updateBtn').on('click', function(){
		
		
	});
	
	$('#deleteBtn').on('click', function(){
	
	});
	
	
	
	
});





</script>
</body>
</html>