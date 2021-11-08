<%@page import="ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#memListBtn").on("click", function(){
		location.href = "<%=request.getContextPath()%>/member/memberList.do";
	});
	
	// 수정 버튼 클릭
	$("#updateBtn").on("click", function(){
		$("#memberForm").attr("method", "get");
		$("#memberForm").attr("action", "<%=request.getContextPath()%>/member/memberUpdate.do");
		$("#memberForm").submit();  // form데이터 전송
	});
	
	// 삭제 버튼 클릭
	$("#deleteBtn").on("click", function(){
		$("#memberForm").attr("method", "post");
		$("#memberForm").attr("action", "<%=request.getContextPath()%>/member/memberDelete.do");
		$("#memberForm").submit();  // form데이터 전송
	});
});

</script>
</head>
<body>
<%
	MemberVO memberInfo = (MemberVO)request.getAttribute("memberInfo");
%>

<h2>회원 정보 상세 보기</h2>
<form  id="memberForm" >
<input type="hidden" name="mem_id" value="<%=memberInfo.getMem_id()%>"/>
<table border="1">
<tr>
	<td>회원ID</td>
	<td><%=memberInfo.getMem_id() %></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><%=memberInfo.getMem_pass() %></td>
</tr>

<tr>
	<td>회원이름</td>
	<td><%=memberInfo.getMem_name() %></td>
</tr>
<tr>
	<td>전화번호</td>
	<td><%=memberInfo.getMem_tel() %></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><%=memberInfo.getMem_addr() %></td>
</tr>
<tr>
	<td colspan="2" style="text-align:center;">
		<input type="button" id="updateBtn" value="수정"/>
		<input type="button" id="deleteBtn" value="삭제"/>
		<input type="button" id="memListBtn" value="회원목록"/>
	</td>
</tr>
</table>
</form>
</body>
</html>