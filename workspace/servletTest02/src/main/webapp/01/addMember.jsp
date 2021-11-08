<%@page import="ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 추가</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
</head>
<body>

<h2>회원 정보 입력 폼</h2>
<form id="frm" action="/memberAdd.do"></form>
<table border="1">
<tr>
	<td>회원 ID</td>
	<td><input type="text" id="userId" form="frm" name="userId" autocomplete="off"><input type="button" id="idCheck" value="중복확인"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" id="userPass" form="frm" name="userPass" autocomplete="off"></td>
</tr>
<tr>
	<td>비밀번호 확인</td>
	<td><input type="password" id="userPassCheck" form="frm"></td>
</tr>
<tr>
	<td>회원이름</td>
	<td><input type="text" id="userName" form="frm" name="userName" autocomplete="off"></td>
	
</tr>
<tr>
	<td>전화번호</td>
	<td><input type="text" id="userTel" form="frm" name="userTel" autocomplete="off"></td>
</tr>
<tr>
	<td>회원주소</td>
	<td><input type="text" id="userAddr" form="frm" name="userAddr" autocomplete="off"></td>
</tr>
<tr>
	<td>
		<input type="button" id="save" value="저장">
		<input type="reset" id="cancel" value="초기화" form="frm">
		<input type="button" id="list" value="회원목록">
	</td>
</tr>
</table>


<script type="text/javascript">
$(function(){

	$('#save').on('click', function() {
		
		$('#frm').submit()			

	});
	
	
	
});
</script>

</body>
</html>





