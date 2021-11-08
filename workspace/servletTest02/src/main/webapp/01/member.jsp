<%@page import="ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
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
	List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
%>
<h2>회원 목록 보기</h2><br>
<table border="1">
<tr>
	<td><input type="button" id="addMember" value="회원추가"></td>
</tr>
<tr>
	<td>ID</td>
	<td>비밀번호</td>
	<td>이름</td>
	<td>전화</td>
	<td>주소</td>
</tr>

<%
for(MemberVO mvo : memberList){
%>
<tr>
	<td><a href="/memberInfo.do?id=<%=mvo.getMem_id() %>"><%=mvo.getMem_id() %></a></td>
	<td><%=mvo.getMem_pass() %></td>
	<td><%=mvo.getMem_name() %></td>
	<td><%=mvo.getMem_tel() %></td>
	<td><%=mvo.getMem_addr() %></td>
</tr>	
<%	
}
%>

</table>

<script type="text/javascript">
$(function(){
	

	$('#addMember').on('click', function(){
		
		location.href = '/01/addMember.jsp'
		
	});	
	
	
});

</script>


</body>
</html>