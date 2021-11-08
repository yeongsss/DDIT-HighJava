<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 쿠키 정보 가져오기

	String cookieUserId = "";
	String chk = "";	// 체크박스의 체크용
	
	Cookie[] cookieArr = request.getCookies();
	if(cookieArr!=null && cookieArr.length >0){
		for(Cookie cookie : cookieArr) {
			// checkbox처리에 관련된 쿠키변수 찾기
			if(cookie.getName().equals("id")){
				cookieUserId = cookie.getValue();	// 쿠키값 가져오기
				chk = "checked";
			}
		}
	}

%>
	
<form method=post action="<%=request.getContextPath()%>/cookieLoginServlet.do">
	<table style="margin: auto auto;">
	<tr>
		<td>ID : </td>
		<td><input type="text" name="id" placeholder="ID를 입력하세요." value="<%=cookieUserId %>" size="20"></td>
	</tr>
	<tr>
		<td>PASS : </td>
		<td><input type="text" name="pass" placeholder="PassWord 입력하세요." size="20"></td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="checkbox" name="check" value="check" <%=chk %>>Id 기억하기
		</td>
	</tr>
	<tr>
		<td colspan="2" ><input type="submit" value="Login"></td>
	</tr>
	
<!-- 	ID : <input type="text" name="id" placeholder="ID를 입력하세요." size="20"><br> -->
<!-- 	PASS : <input type="text" name="pass" placeholder="PassWord 입력하세요." size="20"><br> -->
<!-- 	<input type="checkbox" name="check" > id 기억하기 <br> -->
<!-- 	<input type="submit" value="Login">  -->
	
	</table>
</form>	


</body>
</html>