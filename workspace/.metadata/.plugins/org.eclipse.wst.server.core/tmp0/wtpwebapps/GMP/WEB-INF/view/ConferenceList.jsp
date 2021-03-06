<%@page import="ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="ddit.vo.ConferenceVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회의실예약내역</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
</head>
<%
	List<ConferenceVO> list = (List<ConferenceVO>)request.getAttribute("conferenceList");
%>
<body>

<h2>회의실 예약 내역 리스트</h2>
<table class="table table bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
<thead>
<tr>
	<th>예약번호</th><th>직원번호</th><th>이 름</th><th>회의실번호</th><th>시작시간</th><th>종료시간</th>
</tr>
</thead>
<tbody>
<%
	for(ConferenceVO conVo : list){
%>
	<tr>
		<td><%=conVo.getRes_no() %></td>
		<td><%=conVo.getMem_no() %></td>
		<td><%=conVo.getMem_nm() %></td>
		<td><%=conVo.getCon_no() %></td>
		<td><%=conVo.getRes_start().toString().split(":")[0] %>:<%=conVo.getRes_start().toString().split(":")[1] %></td>
		<td><%=conVo.getRes_end().toString().split(":")[0] %>:<%=conVo.getRes_start().toString().split(":")[1] %></td>
	</tr>
<%
	}
%>		
</tbody>
	<a href="<%=request.getContextPath()%>/conference/reservation.do">예약하기</a>
</table>


</body>
</html>