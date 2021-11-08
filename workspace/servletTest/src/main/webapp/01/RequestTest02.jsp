<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Request연습 Form(숫자 입력은 정수형으로 입력하세요.)</h2>
	<form name="test2Form" method="get" action="<%=request.getContextPath() %> %>/RequestTest02.do">
	<table>
	<tr>
		<td><input type="text" name="num1" size="3"></td>
		<td>
			<select name="op">
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
				<option value="%">%</option>
			</select>
		</td>
		<td><input type="text" name="num2" size="3"></td>
		<td><input type="submit" value="확인"></td>
	</tr>
	</table>	
	
		
		
<!-- 		<input type="text" size="10" name="number1"> -->
<!-- 		<select name="calculation"> -->
<!-- 			<option value="+">+</option> -->
<!-- 			<option value="-">-</option> -->
<!-- 			<option value="*">*</option> -->
<!-- 			<option value="/">/</option> -->
<!-- 			<option value="%">%</option> -->
<!-- 		</select> -->
<!-- 		<input type="text" size="10" name="number2"> -->
<!-- 		<input type="submit" value="확인"> -->
			
	
	</form>
</body>
</html>