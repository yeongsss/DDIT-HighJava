<%@page import="ddit.vo.SanctionDocumentVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Na's Company</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<!-- <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" /> -->
<link href="http://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@200&display=swap"
      rel="stylesheet" />
<link rel="stylesheet" href="../css/board.css">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>

<script src="./js/jquery-3.6.0.min.js"></script>
<script src="./summernote/summernote-lite.js"></script>
<script src="./summernote/lang/summernote-ko-KR.js"></script>
  <link rel="stylesheet" href="./summernote/summernote-lite.css">
<link href="./css/mainPage.css" rel="stylesheet" type="text/css" media="all" />
<link href="./css/fonts.css" rel="stylesheet" type="text/css" media="all" />
<style>
.comment:focus {
	outline : none;
}

</style>
</head>

<%
HttpSession getsession = request.getSession();
String mem_id = (String) getsession.getAttribute("id");
SanctionDocumentVO document = (SanctionDocumentVO)request.getAttribute("document");
int mem_no = (int)getsession.getAttribute("memNo");


%>

<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img id="mainPageBtn" onclick="goMain();" src="../images/logo3.JPG" alt="" />
			<h1><a onclick="goMain();" href="#">Na's Company</a></h1>
			<span>I can do it! <a href="http://templated.co" rel="nofollow">You Can do it!</a></span>
			<span id="logout"><a>??????????????? ?????? ???????????????</a></span>
		</div>
		<div id="menu">
			<ul>
<!-- 				<li class="current_page_item"><a href="#" accesskey="1" title="">Main Page</a></li> -->
<!-- 				<li><a href="#" accesskey="2" title="">????????? ??????</a></li> -->
				<li><a id="mypageBtn" href="#" accesskey="3" title="">???????????????</a></li>
				<li><a id="noticeBtn" href="#" accesskey="5" title="">????????????</a></li>
				<li id="chatBtn"><a accesskey="3" title="">??????</a></li>
				<li id="calendarBtn"><a accesskey="4" title="">Calendar</a></li>
				<li><a id="sanctionBtn" href="#" accesskey="5" title="">????????????</a></li>
				<li><a id="conferenceBtn" href="#" accesskey="9" title="">????????? ??????</a></li>
				<li><a id="freeBtn" href="#" accesskey="5" title="">???????????????</a></li>
				<li id="manager"><a>????????? ?????????</a></li>
<!-- 				<li id="conference"><a>?????????</a></li> -->
			</ul>
		</div>
	</div>
	<div id="main">
		<div id="top">
			<div id="banner">
				<img src="./images/main2.JPG" alt="" class="image-full" />
			</div>
			<div id="welcome">
				<div class="title">
					<h2>Na's Company</h2>
					<span class="byline">IT Leading Company</span>
				</div>
				<p> <strong>????????? ????????? ????????? ?????? ??????</strong> ????????? ????????? ???????????? IT?????? ??? ???????????? ????????? ????????????<a href="http://templated.co" rel="nofollow"></a> Na's Company?????????.  <a href="http://fotogrph.com/"></a> <a href="http://templated.co/license"></a> ??????????????????? Na's Company ????????? ???????????????. Na's Company??? ????????? ????????? ???????????????  ???????????? ???????????????(SI), IT???????????? ??? ????????? IT???????????? ???????????? u-Business ?????? ???????????????. Na's Company ???????????? ????????? ??????, ???????????? ????????? ????????? ???????????? ?????? ????????? ?????????????????? ????????? ???????????? ???????????? ????????????. ????????? ??????????????? ???????????? ???????????? IT ????????? ???????????? ?????? ???????????? ????????? ?????????, ??????????????? ????????? ???????????? ???????????? ???????????? ????????? ???????????? ?????????????????????. ?????? ???????????? ???????????? ????????? ????????? ??????????????????. </p>
				<ul class="actions">
					<li><a href="#" class="button">Etiam posuere</a></li>
				</ul>
			</div>
		</div>
		<div id="featured">
			<div class="title">
				<h2>What's news/Notice</h2>
				<span class="byline"> </span>
			</div>
			<div class="content">
				<ul class="style1">
					<li class="first">
						<p class="date"><a href="#">sept<b>05</b></a></p>
						<h3>11/24 ??????????????? ?????? ?????? ??????</h3>
						<p><a href="#">11/24??? ??????????????? ????????? ?????? ??????????????????.</a></p>
					</li>
					<li>
						<p class="date"><a href="#">sept<b>17</b></a></p>
						<h3>????????? ????????? ?????? ??????</h3>
						<p><a href="#">?????????-9/27, </a></p>
					</li>
					<li>
						<p class="date"><a href="#">Jan<b>01</b></a></p>
						<h3>Amet sed volutpat mauris</h3>
						<p><a href="#">Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget, tempus et, tellus. Etiam neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem semper eleifend. Etiam non felis. Donec ut ante.</a></p>
					</li>
					<li>
						<p class="date"><a href="#">Dec<b>31</b></a></p>
						<h3>Sagittis diam dolor amet</h3>
						<p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue rutrum.</a></p>
					</li>
				</ul>
			</div>
		</div>
		<div id="copyright">
			<p> Na's Company ??????: ????????? | CS center : 1588-2775</p>
			<span>&copy; ??????????????? ?????? ????????? 76 ???????????? 4??? | Fax : 042-5555-3221</span>
			<span>&copy;DESIGN BY <a href="http://templated.co" rel="nofollow">Yuri Seo</a>.</span>
		</div>
	</div>
</div>

<script type="text/javascript">




$('#calendarBtn').on('click', function(){ 
    location.href='<%=request.getContextPath()%>/calendarController.do?mem_no='+<%=mem_no%>;
 });
 
 $('#chatBtn').on('click', function(){
    location.href='<%=request.getContextPath()%>/chatController.do?mem_no='+<%=mem_no%>;
 });


//???????????? ?????????===================================================================

//??????????????? (???????????? ?????? ?????? ??????)
$('#mypageBtn').on("click",showInfo);

function showInfo() {
let no ='<%=getsession.getAttribute("memNo") %>';
let id ='<%=getsession.getAttribute("id") %>';

console.log(no);
console.log(id);

let code ="<div id='featured'>";
code +="	<div class='title'></div>";
code +="	<div class='content'></div>";
code +="	</div>";

$('#featured').html(code);

$.ajax({
 url : '<%=request.getContextPath()%>/member/mypage.do',
 type : 'post',
 data : {
    "no" : no,
    "id" : id
 },
 success : function (res) {
    console.log(res);
    console.log(res.mem_no);
    let str = "";
       str += "<table class='table table-hover table-bordered text-center' style='border: 1px solid #dddddd;'>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.mem_no + "</td></tr>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.dept_no + "</td></tr>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.posi_no + "</td></tr>";
       str += "<tr><td>?????????</td>";
       str += "<td>" + res.mem_nm + "</td></tr>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.mem_tel + "</td></tr>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.mem_addr1 + "</td></tr>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.mem_addr2 + "</td></tr>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.mem_birth + "</td></tr>";
       str += "<tr><td>?????????</td>";
       str += "<td>" + res.mem_id + "</td></tr>";
       str += "<tr><td>?????????</td>";
       str += "<td>" + res.mem_mail + "</td></tr>";
       str += "<tr><td>?????????</td>";
       str += "<td>" + res.hire + "</td></tr>";
       
       str += "<tr><td colspan='12' style='text-align: center;'>";
       str += "<input type='button' id='updateBtn' value='??????'/>";
//        str += "<input type='button' id='deleteBtn' value='??????'/>";
       str += "</tr></table>";
       
       $('#top').html(str);
       $('#updateBtn').on('click', infoUpdate);
//        $('#deleteBtn').on('click', infoDelete);
       
 },
 error : function(xhr) {
    console.log(xhr);
 },
 dataType : 'json'
 
});

}

//??????????????? ??????
function infoUpdate(){
	
	let code = "";
	code += "<table class='table table-hover table-bordered text-center' style='border: 1px solid #dddddd;'>";
	code += "<tr><td>???????????? : </td><td> <input tupe='text' id='mem_addr1' class='mem-update' autocomplete=off  ></td></tr>";
	code += "<tr><td>???????????? : </td><td> <input tupe='text' id='mem_addr2' class='mem-update' autocomplete=off > </td></tr>";
	code += "<tr><td>???????????? : </td><td> <input tupe='text' id='mem_tel' class='mem-update' autocomplete=off > </td></tr>";
	code += "<tr><td>????????? 	: </td><td> <input tupe='text' id='mem_mail' class='mem-update' autocomplete=off > </td></tr>";

    code += "<tr><td colspan='12' style='text-align: center;'>";
    code += "<input type='button' id='submitBtn' value='??????'>";
    code += "<input type='reset' id='mem-update-cancle' value='??????'/>";
    code += "</tr></table>";
       
       $('#top').html(code);
	
// let addr1 = "";
// let addr2 = "";
// let tel = "";
// let no = "";
	
	$('#mem-update-cancle').on('click',showInfo);
	
	$('#submitBtn').on("click",function(){
	 
		 let addr1 = $('#mem_addr1').val();
		 let addr2 = $('#mem_addr2').val();
		 let tel = $('#mem_tel').val();
		 let mail = $('#mem_mail').val();
		 let no = '<%=getsession.getAttribute("memNo") %>';
		 console.log(addr1);
		 
		 $.ajax({
		    url :'<%=request.getContextPath()%>/member/memberUpdate.do',
		    type : 'post',
		    data :{
		       "addr1" : addr1,
		       "addr2" : addr2,
		       "no" : no,
		       "tel" : tel,
		       "mail" : mail
		    },
		    success : function(res){
		       alert("???????????? ????????? ?????????????????????");
		       if(res != null){
		          returnMypage();
		       }
		    },
		    error : function(){
		       console.log(xhr);
		    },
		    dataType : 'json'
		    
		 });
	
	});
}

function returnMypage() {
	location.href = "<%=request.getContextPath()%>/member/mypage.do";
}

//??????????????? (??????)
function infoDelete() {
	no = $('mem_no').val();
	
	$.ajax({
		 url : "<%=request.getContextPath()%>/member/memberDelete.do",
		 type : 'post',
		 data : {
		    "no" : no
		 },
		 success : function (res) {
		    alert("??????????????? ?????????????????????");
		    location.href = "<%=request.getContextPath()%>/member/login.do";
		 },
		 error : function () {
		    console.log(xhr);
		 },
		 dataType : 'text'
	    
	});
}


//==================================================================??????????????? ?????????

//----------------------------------------------------------------------------?????????
$('#manager').on('click',function(){
	
	let auth = '<%=(int)getsession.getAttribute("auth") %>';
	
	if (auth == 1) {
		manager();
	}else {
		alert('???????????? ???????????????');		
	}
	
});
	
function manager(){
	let managerCode = "";
	
	managerCode += "<div class='memBtn'><input type='button' class='button1' id='memLookUp' name='memLookUp' value='????????????'>";
	managerCode += "<input type='button' class='button1' id='manageNoticeBoard' name='manageNoticeBoard' value='??????????????????'></div>";
// 	managerCode += "<div id='myDiv' class='col-lg-10' name='myDiv' > </div>";
	
	let code ="<div id='featured'>";
	code +="	<div class='title'></div>";
	code +="	<div class='content'></div>";
	code +="	</div>";
	
	$('#top').html(managerCode);	
	$('#featured').html(code);
	
	$('#memLookUp').on('click',memLookUp);
	$('#manageNoticeBoard').on('click',manageNoticeBoard);
}

function manageNoticeBoard(){
	$.ajax({
		url : '<%=request.getContextPath()%>/board/board.do',
		type : 'post',        
		data : {
		 "choice" : "??????"
		},
		 dataType : "json",
		 success : function(res){
			console.log(res);
				
			let str = "";
			str += "<ul class='style2'>";
			
			$.each(res, function(i,v){
				str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
				str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
				str +="<p class='writer'><a href='#'>"+v.board_no+"<b>"+v.board_writer+"</b></a></p>";
				str +="<h3></h3>";
				str +="<p><a href='#'>"+ v.board_title+"</a></p>";
				str += "</li>";
			});
				str += "</ul>";
				str += "<input type='button' class='boardInsertBtn' value='????????? ??????'/>";
				
				$('.content').html(str);
				$('.boardInsertBtn').on('click', manageBoardInsert);
				
		  },
		    
		    error :function(xhr){
				console.log(xhr);
				console.log(xhr.status);
		    }
	});
}

// ???????????? ??????
function manageBoardInsert(){
	let str = "";
// 		str +="	<select name='board_nm' id='board_nm'>";
// 		str +="		<option value='??????'>??????</option>";
// 		str +="		<option value='??????'>??????</option>";
// 		str +="	</select> &nbsp; &nbsp; ";
		str += "<p class='notice-title'>?????? : &nbsp; &nbsp;&nbsp; &nbsp;";
		str += "<input type='text' placeholder='????????? ??????' id='board_title' name='board_title' autocomplete=off maxlength='20'></p>";
		str += "<textarea class='summernote' id='board_content' name='editordata'></textarea>";

		str += "<div class='manage-board'><input type='button' class='manage-board-btn' id='boardInsert' class='' value='??????'></input>";
		str += "<input type='button' class='manage-board-btn' id='manageBoardList' value='??????'></input></div>";
	
		$('.content').html(str); 
	
		$('.summernote').summernote({
			 height: 150,
			 lang: "ko-KR" 
		  });
		
		$('#manageBoardList').on('click',manageNoticeBoard);
		
		$('#boardInsert').on('click', function(){
		
			let board_title = $('#board_title').val();
			let board_content = $('#board_content').val();
		
			console.log(board_nm);

	
			$.ajax({
				url : '<%=request.getContextPath()%>/board/board.do',
			    type : 'post', 
			    data : {
			    	"choice" : "??????",
			    	"board_nm" : "??????",
			    	"board_title" : board_title,
			    	"board_content" : board_content
			    },
			    success : function(res){
			    	manageNoticeBoard(); 
				},
			    dataType : "json",
			    
				error : function(xhr){
					console.log(xhr);
				}
			});
		});
	}

function memSalary(memNo){
	
	$.ajax({
		url : '<%=request.getContextPath() %>/manage/manage.do',
		type : 'post',
		data : {
			"choice" : "salaryList",
			"memNo" : memNo
		},
		
		success : function(res){
			let code = "";
			code += "<table class='salary-table'><thead><tr><td>??????</td><td>?????????</td><td>?????????</td></tr></thead>";
			code += `<tbody>`;
			$.each(res, function(i,v){
				code += "<tr><td>"+v.salary_nm+"</td>";
				code += "<td>"+v.salary+"</td>";
				code += "<td>"+v.payday+"</td></tr>";
				
			});
			code += "<tr><td><input type='button' value='????????????' id='salary' onclick='salary("+memNo+");'></td></tr>";
			code += `</tbody></table>`;
			$('#data').html(code);
		},
		dataType : 'json',
		error : function(xhr){
			console.log(xhr);
		}
	});
}

function salary(memNo){
	let code = "";
	code += "<div>";
	code += "<label><input type='radio' name='search_type' value='??????' checked />??????</label>";
	code += "<label><input type='radio' name='search_type' value='?????????' />?????????</label><br>";
	code += "???????????? : <input type='text' id='salMoney'><input type='button' id='payments' name='payments' onclick='payment("+memNo+");' value='??????'>";
	code += "</div>";
	
	$('#data').html(code);
	
}

function payment(memNo) {
	let salType = $("input[name='search_type']:checked").val();
	let salMoney = $('#salMoney').val();

	$.ajax({
		url : '<%=request.getContextPath() %>/manage/manage.do',	
		type : 'post',
		data : {
			"choice" : "payments",
			"memNo" : memNo,
			"salType" : salType,
			"salMoney" : salMoney
		},
		sucess : function(res){
			console.log(res);
//				memSalary(memNo);
			memLookUp();
			
		},
		dataType : 'json',
		error : function(xhr){

			
			
		}
	});
}

//???????????? ???????????????
function memLookUp(){					
	
			let lookCode ="";
			let code ="";
			code += "<h3>????????????</h3>";
			$('.title').html(code);
//				lookCode +="<div>??????????????????</div>";

	$.ajax({
		url : '<%=request.getContextPath() %>/manage/manage.do',
		type : 'post',
		data : {
			"choice" : "departList"
		},
	
		success : function(res){
			console.log(res)
			
			lookCode +="	<table>";
			lookCode +="		<tbody><tr>";
			lookCode +="			<td> <select id='sel1' class='sel1' name='sel1' onchange='departMember()'c style='width:100px;' onclick='departMember();'>";
			
			$.each(res, function(i,v){
				lookCode +="				<option value='"+ v.dept_no +"'>"+ v.dept_nm +"</option>";
			});
			
			lookCode +="</td></tr>";
			lookCode +="</tbody>";
			lookCode +="</table>";
			lookCode +="<div id='bigData' class='bigData' name='bigData'>";
			lookCode +="	<div id='data' class='data' name='data'></div>";
			lookCode +="	<div id='detail' class='detail' name='detail'></div></div>";
		 			
			$('.content').html(lookCode);
			
			
			$('#memLookUp').on('click',memLookUp);
			$('#memSalary').on('click',memSalary);
// 			$('#memWork').on('click',memWork);

		},
		dataType : 'json',
		
		error : function(xhr){
			console.log(xhr);
		}
	});
}

function departMember(){
	
	let department = $("#sel1 option:selected").val();
	
	console.log(department);
	
	$.ajax({
		url :  '<%=request.getContextPath() %>/manage/manage.do',
		type : 'post',
		data : {
			"choice" : "departMember",
			"department" : department
		},
		success : function(res){
			console.log(res);		

			let code = "";
			code += "<table id='dept-mem' width='100px' >";
			code += "<thead><tr><td></td><td></td></tr></thead><tbody>";
			$.each(res, function(i,v){
				
				code += "<tr class='meminfo' ><td>"+(i+1)+"</td><td class='memNo'><a href='javascript:void(0);' class='meminfo' onclick='deptMemDetail("+v.mem_no+")'>"+v.mem_nm+"</td></tr>";
			});
			
			code += "</tbody>";
			code += "</table>";
			
			$('#data').html(code);
			
		},
		dataType : 'json',
		
		error : function(xhr){
			console.log(xhr);
		}			
	});
}

function deptMemDetail(memNo){
	console.log(memNo);
//		console.log(memNm);
	
	let code = "<br>";
	 code +="<div class='memupdate'><input type='button' class='button2' id='updateBtn' onclick='mUpdate("+memNo+");' value='?????? ??????'>";
	 code +="<input type='button' class='button2' id='infoUpdateBtn' onclick='DPupdate("+memNo+");' value='??????????????? ??????'>";
	 code +="<input type='button' class='button2' id='memSalary' name='memSalary' onclick='memSalary("+memNo+");' value='????????????'>";
	 code += "<input type='button' class='button2' id='memWork' name='memWork' onclick='memWork("+memNo+");' value='????????????'></div>";
	 code += "<table border='1' id='dept-mem-detail' cellpadding='10' cellspacing='10' width='100px'>";
	 code += "<thead><tr><td>????????????</td><td>??????</td><td>????????????</td>";
	 code += "<td>??????</td><td>??????</td><td>????????????</td><td>??????</td><td>??????</td>";
	 code += "<td>?????? ??????</td><td>?????? ??????</td><td>?????????</td>";
	 code += "</tr></thead><tbody>";
	
	 $.ajax({
		url : '<%=request.getContextPath()%>/manage/manage.do',
		type : 'post',
		async:false,
		data : {
			"choice" : "deptDetail",
			"memNo" : memNo
		},
		success : function(res){
				let dd = res;
				console.log(dd);
			
			$.each(res, function(i,v){
				
				code += "<tr><td>"+v.mem_no+"</td>";
				code += "<td>"+v.mem_nm+"</td>";
				code += "<td>"+v.mem_tel+"</td>";
				code += "<td>"+v.posi_nm+"</td>";
				code += "<td>"+v.dept_nm+"</td>";
				code += "<td>"+v.mem_birth+"</td>";
				code += "<td>"+v.mem_addr1+" "+ v.mem_addr2+"</td>";
				code += "<td>"+v.mem_mail+"</td>";
				code += "<td>"+v.ch_posi_nm+"</td>";
				code += "<td>"+v.ch_dept_nm+"</td>";
				code += "<td>"+v.change_date+"</td></tr>";

			});
			
			code += "</tbody></table>";
			code +="<div id='update' name='update'></div>";
			$('#detail').html(code);
			
			
		},
		dataType : 'json',
		error : function(xhr){
			console.log(xhr);
		}
	 });
	
}

function mUpdate(data){
	
	console.log(data);
	
	let code = "";
	code +=`<p>???????????? :&nbsp; <input type='text' class='textbox'id='telUpdate' name='telUpdate' placeholder="???????????????????????????"></p>`;
	code +=`<p>???????????? :&nbsp; <input type='text' class='textbox' id='addrUpdate1' name='addrUpdate1' placeholder="????????? ???????????? ??????"></p>`;
	code +=`<p>???????????? :&nbsp; <input type='text' class='textbox' id='addrUpdate2' name='addrUpdate2' placeholder="????????? ???????????? ??????"></p>`;
	code +=`<p>??? ??? ??? :&nbsp; <input type='text' class='textbox' id='mailUpdate' name='mailUpdate' placeholder="????????? ????????? ??????"></p>`;
	code +=`<input type='button' class='sendBtn' id='send' name='send' value='??????'>`;
	code +=`<input type='button' class='send-cancle-Btn' id='send-cancle' name='send-cancle' value='??????'>`;

	$('#data').html(code);
	
	$('#send-cancle-Btn').on('click',deptMemDetail(data));
	
	$('#send').on('click',function(){
	
		let tel = $('#telUpdate').val();
		let addr1 = $('#addrUpdate1').val();
		let addr2 = $('#addrUpdate2').val();
		let mail = $('#mailUpdate').val();
		
		$.ajax({
			url : '<%=request.getContextPath() %>/manage/manage.do',
			type : 'post',
			data : {
					"choice" : "update",
					"tel" : tel,
					"addr1" : addr1,
					"addr2" : addr2,
					"mail" : mail,
					"memNO" : data
				
			},
			success : function(res){
				
				if (res < 0 ) {
					alert('????????? ??????????????????.');
				}
				
				deptMemDetail(data);
			
			},
			dataType : 'json',
			
			error : function(xhr){
				console.log(xhr);	
			}
		});
		
	});
}


function DPupdate(memNo){
	
	console.log(memNo);
	
	let code = "<hr><hr>";
	code += `<table><tr>`;
	code += `<td>?????? ??????</td><td> <select id='deptChoice' name='deptChoice' onchange='update_cate1()' style='width:140px;' >`;
	code += `<option value='10'>?????????</option>`;
	code += `<option value='20'>?????????</option>`;
	code += `<option value='30'>?????????</option>`;
	code += `<option value='40'>????????????</option>`;
	code += `<option value='50'>?????????</option>`;
	code += `<option value='60'>????????????</option>`;
	code += `<option value='99'>?????????</option></td></tr>`;
	
	code += `<tr><td>?????? ??????</td><td> <select id='posiChoice' name='posiChoice' style='width:140px;'>`;
	code += `<option value='1'>??????</option>`;
	code += `<option value='2'>??????</option>`;
	code += `<option value='3'>??????</option>`;
	code += `<option value='4'>??????</option>`;
	code += `<option value='5'>??????</option>`;
	code += `<option value='6'>??????</option>`;
	code += `<option value='7'>??????</option>`;
	code += `<option value='8'>??????</option>`;
	code += `<option value='9'>?????????</option>`;
	code += `<option value='10'>??????</option></td></tr>`;
	
	
	code += `<tr><td><input type='button' id='DPUpdate' value='??????'></td><td></td></tr> `;
	
	$('#data').html(code);
			
	$('#DPUpdate').on('click',function(){
		
		let deptSelect = $("#deptChoice option:selected").val();
		let posiSelect = $("#posiChoice option:selected").val();
		
		console.log(deptSelect);
		console.log(posiSelect);
		
		$.ajax({
			url : '<%=request.getContextPath() %>/manage/manage.do',
			type : 'post',
			data : {
				"choice" : "DPupdate",
				"deptSelect" : deptSelect,
				"posiSelect" : posiSelect,
				"memNO"	: memNo
			},
			success : function(res){
				console.log(res);

				if (res <= 0 ) {
					alert('????????? ??????????????????.');
				}
				
				deptMemDetail(memNo);
			},
			dataType : 'json',
			error : function(xhr){
				console.log(xhr);
			}
		});
	});
	
	
}







//-------------------------------------------------------------------------------------?????????
function deleteRes(resNo){
	
	if(!confirm("?????? ????????? ?????????????????????????")){
		return false;
	}
	
	
	$.ajax({
		url : '<%=request.getContextPath()%>/conference/conferenceList.do',
		type : 'post',
		data : {
			"choice" : "delete",
			"resNo" : resNo
		},
		success : function(res){
			if (res > 0) {
				alert("?????? ??????");
			} else {
				alert("????????? ????????? ???????????? ????????????.!!!");
			}
			showList();
		}, 
		
		dateType : 'json',
		
		error : function(xhr){
			console.log(xhr);
		}
		
	});

}
			
function res(){
	$('#resBtn').on('click',function(){
		let bookcode = "";
		bookcode +="	<input type='datetime-local' id='startTime' name='startTime'><br>";
		bookcode +="	<input type='datetime-local' id='endTime' name='endTime'><br>";
		bookcode +="	<select name='conferenceRoom' id='conferenceRoom'>";
		bookcode +="		<option value='1'>?????????1</option>";
		bookcode +="		<option value='2'>?????????2</option>";
		bookcode +="		<option value='3'>?????????3</option>";
		bookcode +="		<option value='4'>?????????4</option>";
		bookcode +="		<option value='5'>?????????5</option>";
		bookcode +="		<option value='6'>?????????6</option>";
		bookcode +="		<option value='7'>?????????7</option>";
		bookcode +="	</select>";
		bookcode +="	<hr>";
		bookcode +="	<input type='button' id='btn' value='??????' >";
		$('#top').html(bookcode);	
		
		
		$('#btn').on('click', function(){
			
			let startTime = $('#startTime').val();
			let endTime = $('#endTime').val();
			let conference = $("#conferenceRoom option:selected").val();
			console.log(startTime);
			console.log(endTime);
			console.log(conference);
			
			$.ajax({
				url : '<%=request.getContextPath() %>/conference/conferenceList.do',
				type : 'post',
				data : {
					"choice" : "reserve",
					"startTime" : startTime,
					"endTime" : endTime,
					"conferenceRoom" : conference
				},
				success : function(res){
					
					if (res == 0) {
						alert('?????? ???????????? ??????????????????.!!!!');
					}
					
					showList();		
					
				},
				dataType : "json",
				
				error : function(xhr){
					console.log(xhr);
				}
				
			});
		});
	});
}


//????????? ????????????
$('#conferenceBtn').on('click',showList);

function showList(){
	
	
	let code ="<div id='featured'>";
	code +="	<div class='title'></div>";
	code +="	<div class='content'></div>";
	code +="	</div>";
	
	$('#featured').html(code);
	
	
	$.ajax({
		 url : '<%=request.getContextPath() %>/conference/conferenceList.do',
		 type : 'post',
		 data : {
		    "choice" : "list"
		 },
		 success : function(res){
		  	 let code = "<br>";
		     code += "<table class='table table-bordered table-hover' style='text-align: center; border: 1px solid #dddddd'>";
		     code += "<thead>";
		     code += "<tr>";
		     code += "   <th>????????????</th><th>????????????</th><th>??? ???</th><th>???????????????</th><th>????????????</th><th>????????????</th>";
		     code += "</tr>";
		     code += "</thead>";
		     code += "<tbody>";
		    
		    $.each(res, function(i,v){
		       code +="<tr><td><a href='javascript:void(0);' onclick='deleteRes("+v.res_no+");'>" + v.res_no +"</a></td>";
		       code +="<td>" + v.mem_no +"</td>";
		       code +="<td>" + v.mem_nm +"</td>";
		       code +="<td>" + v.con_no +"</td>";
		       code +="<td>" + v.res_start.toString().split(":")[0]+":"+ v.res_start.toString().split(":")[1] +"</td>";
		       code +="<td>" + v.res_end.toString().split(":")[0]+":"+ v.res_end.toString().split(":")[1]  +"</td></tr>";
		    });
		    code += "<tr><td colspan='6' style='text-align: right;'>";
		    code += "<input type='button' id='resBtn' onclick='res();' value='????????????'></td></tr></table>"

		    
		    $('#top').html(code);   
		    console.log(res);   
		 },
		 error : function(xhr){
		    console.log(xhr);
		    console.log(xhr.status);
		 },
		 dataType:'json'
	});
}

////////////////////////////////////////////////////////////////???????????? ?????????

$('#logout').on('click', function(){
			sessionStorage.clear();
			location.href ='<%=request.getContextPath() %>/loginPage.jsp';
		});
	
	$.ajax({
		url : '<%=request.getContextPath()%>/calToMain.do',
		type : 'post',
		data : {
			"mem_no" : <%=mem_no%>
		},
		async : false,
		success:function(res){
			console.log(res);
			$('#mainPageBtn').on('click', function(){
				location.href ='<%=request.getContextPath() %>/member/login.do?<%="mem_id"%>='+res.mem_id+'&<%="mem_pw"%>='+res.mem_pw+'&<%="dept_no"%>='+res.dept_no+'&<%="mem_nm"%>='+res.mem_nm;
			});
		},
		dataType : 'json'
	});

function goMain(){
	$.ajax({
		url : '<%=request.getContextPath()%>/calToMain.do',
		type : 'post',
		data : {
			"mem_no" : <%=mem_no%>
		},
		async : false,
		success:function(res){
			location.href ='<%=request.getContextPath() %>/member/login.do?<%="mem_id"%>='+res.mem_id+'&<%="mem_pw"%>='+res.mem_pw+'&<%="dept_no"%>='+res.dept_no+'&<%="mem_nm"%>='+res.mem_nm;
		},
		dataType : 'json'
	});
}



////////////////////////////////////////////////////////////////???????????? ?????????



////?????? ??????

$('#sanctionBtn').on('click', documentList);
//$('#docInsertBtn').on('click', docInsert);

let san_no ="";


function documentList() {


let code ="<div id='featured-none'>";
code +="	<div class='title-none'></div>";
code +="	<div class='content-none'></div>";
code +="	</div>";

$('#featured').html(code);

  
  $.ajax({
     url : '<%=request.getContextPath()%>/sanction/sanctionDocument.do',
     type : 'post',
     data : {
        "documentSelect" : "???????????????"
     },
     dataType : "json",
     success : function (res) {
        console.log(res);
        let str = "";
        
		 str += "<button type='button' class='btn btn-outline-info' id='docConfirm' value='??????' onclick='docBtn(\"??????\")'>??????</button>";
		 str += "<button type='button' class='btn btn-outline-info' id='docWait' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
		 str += "<button type='button' class='btn btn-outline-info' id='docRefuse' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
			
        str += "<table class='table table-hover table-bordered text-center' style='border: 1px solid #dddddd;'>";
           str += "<thead>";
           str += "<tr>";
           str += "   <th id='thName'>????????????</th><th id='thName'>????????????</th><th id='thName'>???????????????</th><th>?????????</th><th>???????????????</th><th id='thName'>??????</th><th>????????????</th><th id='thName'>????????????</th>";
           str += "</tr>";
           str += "</thead>";
           str += "<tbody>";
           
        $.each(res, function (i,v) {
           str += "<tr id='trDetail' onclick='docDetail(\""+v.san_no+"\");'><td id='tdData'>" + v.san_no + "</td>";
           str += "<td id='tdData'>" + v.san_title + "</td>";
           str += "<td id='tdData'>" + v.san_nm + "</td>";
           str += "<td id='tdData'>" + v.san_write_date + "</td>";
           str += "<td id='tdData'>" + v.san_conf_date + "</td>";
           str += "<td id='tdData'>" + v.san_content + "</td>";
           str += "<td id='tdData'>" + v.san_deadline + "</td>";
           str += "<td id='tdData'>" + v.san_status + "</td></tr>";
        });
        str += "<tr><td colspan='8' style='text-align: right;'>";
	     str += "<button type='button' class='btn btn-outline-info' id='docInsertBtn' onclick='docInsert(\"\")'>??????</td></tr></table>";
        $('#top').html(str);
        $('#docInsertBtn').on('click', docInsert);
     },
     error : function (xhr) {
        console.log(xhr);
     }
  });
  
}
function docBtn(result){
console.log(result);
$.ajax({
	url : '<%=request.getContextPath() %>/sanction/sanctionDocument.do',
	type : 'post',
	data : {
		"documentSelect" : "????????????",
		"result" : result
	},
	dataType : 'json',
	success : function(res){
		let str = "";
		str += "<button type-'button' class='btn btn-outline-info' id='docInsertBtn'>??????</button>"
		str += "<button type='button' class='btn btn-outline-info' id='docConfirm' value='??????' onclick='docBtn(\"??????\")'>??????</button>";
		str += "<button type='button' class='btn btn-outline-info' id='docWait' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
		str += "<button type='button' class='btn btn-outline-info' id='docRefuse' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
		str += "<ul>";

		$.each(res, function (i,v) {
			str += "<li onclick='docDetail(\""+v.san_no+"\");'>";
			str += "???????????? : " + v.san_no;
			str += "<br>";
			str += "???????????? : " + v.san_title;
			str += "<br>";
			str += "??????????????? : " + v.san_nm;
			str += "<br>";
			str += "????????? : " + v.san_write_date;
			str += "<br>";
			str += "??????????????? : " + v.san_conf_date;
			str += "<br>";
			str += "?????? : " + v.san_content;
			str += "<br>";
			str += "???????????? : " + v.san_deadline;
			str += "<br>";
			str += "???????????? : " + v.san_status;
			str += "<br><br>";
			str += "</li>";
		});
		str += "</ul>";
		$('#top').html(str);
	},
	error : function(xhr) {
		console.log(xhr);
	}
		
});

}

function docDetail(san_no){
console.log(san_no);

//const _data = {
//		"documentSelect" : "??????????????????",
//		"san_no": san_no
//	}
$.ajax({
	url : '<%=request.getContextPath()%>/sanction/sanctionDocument.do',
	type : 'post',
	data : {
		"documentSelect" : "??????????????????",
		"san_no": san_no
	},
	dataType : 'json',
	success : function(res) {
		console.log(res);
		let str = "";
		str += "<table border='1'>";
		str += "<thead>";
		str += "<tr><td rowspan='2' colspan='3' width='500' height='130'>"+ res.san_nm +"</td><td>?????????</td><td>??????</td><td>??????</td></tr>";
		str += "<tr><td width='110' height='120'>" + "??????" + "</td><td width='110'>??????</td><td width='110'>??????</td></tr>";
		str += "</thead>";
		str += "<tbody>";
		str += "<tr><td  width='130' height='100'>??????</td><td colspan='6'>"+ res.san_title +"</td></tr>";
		str += "<tr><td height='100'>????????????</td><td colspan='2'>"+ res.san_write_date +"</td><td>?????????</td><td colspan='2'>"+ res.dept_nm1 +"</td></tr>";
		str += "<tr><td height='100'>?????????</td><td colspan='6'>"+ res.mem_nm1 +"</td></tr>";
		str += "<tr><td height='500'>??????</td><td colspan='6'>"+ res.san_content +"</td></tr>";
		str += "</tbody>";
		str += "</table>";
		str += "";
		str += "<button type='button' class='btn btn-outline-info' onclick='documentList(\"\")'>?????? ??????</button>";
		str += "";
		
		$('#main').html(str);
		
	},
	error : function(xhr) {
		console.log(xhr);
	}
		
});
}


function docInsert() {

let str = "<table border='none' align='center' width='300' height='80'>";
	str += "<tr align='center'><td colspan='2'><input type='text' id='san_per1' placeholder='1???'><input type='text' id='san_per2' placeholder='2???'><input type='text' id='san_per3' placeholder='3???'></td></tr>";
		str += "<tr><td colspan='2'>????????????&nbsp;&nbsp;<select id='san_nm'><option value='???????????????'>???????????????<option value='???????????????'>???????????????<option value='?????????????????????'>?????????????????????"
		str += "<option value='???????????????'>???????????????<option value='?????????'>?????????<option value='?????????'>?????????<option value='?????????'>?????????</td></tr>";
		str += "<tr><td>??????&nbsp;&nbsp;<input type='text' id='san_position'></td><td>??????&nbsp;&nbsp;<input type='text' id='san_dep'></td></tr>";
		str += "<tr><td>?????????&nbsp;&nbsp;<input type='text' id='san_writer'></td><td>????????????&nbsp;&nbsp;<input type='text' id='san_deadline'></td></tr>";
		str += "<tr><td colspan='2'>??????&nbsp;&nbsp;<input type='text' id='san_title'></td></tr>";
		str += "<tr><td colspan='2'>??????&nbsp;&nbsp;<input type='text' id='san_content'></td></tr>";
		
		let san_per1 = $('#san_per1').val();
		let san_per2 = $('#san_per2').val();
		let san_per3 = $('#san_per3').val();
		let san_deadline = $('#san_deadline').val();
		let san_nm = $('#san_nm').val();
		let san_title = $('#san_title').val();
		let san_content = $('#san_content').val();
		
//		str += "";
//		str += "";
	str += "</table>";
	str += "<button class='btn btn-outline-info' type='button' value='??????' id='docuInsert'>??????";
	$('#top').html(str);
	
$.ajax({
	url:'<%=request.getContextPath()%>/sanction/sanctionDocument.do',
	type: 'post',
	data: {
		"documentSelect" : "???????????????",
		"san_per1" : san_per1,		// ?????? 1(??????table)
		"san_per2" : san_per2,		// ?????? 2(??????table)
		"san_per3" : san_per3,		// ?????? 3(??????table)
		"san_deadline"   : san_deadline,		// ?????? ????????????
		"san_nm"   : san_nm,		// ?????? ?????? ??????
		"san_title": san_title,		// ??????
		"san_content": san_content	// ??????
	},
	dataType: 'json',
	success: function(res){
		console.log(res);
		
	},
	error: function(xhr) {
		console.log(xhr);
	}
});
}



//------------------------------------------------------------------
//???????????? ?????????

$('#freeBtn').on('click', freeList);
//$('#notiBtn').on('click', noticeList);
let board_noArr = new Array();

let fonts = ['?????? ??????', '??????', '??????', '??????', '?????????', '?????????', '?????? ??????', '??????', '?????????', '?????????', 'HY?????????', 'HY?????????', 'HY??????B', 'HY?????????M', 'HY????????????B', 'HY?????????', 'HY????????????M', 'HY??????L', 'HY??????M', 'HY?????????', 'HY????????????M', '???????????????', '????????????T', '???????????????', '????????????????????????', '???????????????', '????????????'];

let board_no1 = "";

function noticeList(){
$.ajax({
	url : '<%=request.getContextPath()%>/board/board.do',
	type : 'post',        
	data : {
	 "choice" : "??????"
	},
	 dataType : "json",
	 success : function(res){
		console.log(res);
			
		let str = "";
		str += "<ol>";
		$.each(res, function(i,v){
			str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
			str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
				str += "?????? : " + v.board_title;
				str += "<br>";
				str += "?????? : " + v.board_writer;
				str += "<br><hr>";
			str += "</li>";
			});
			str += "</ol>";
			str += "<input type='button' class='btn btn-outline-info' class='boardInsertBtn' value='????????? ??????'/>";
			
			$('#top').html(str);
			$('.boardInsertBtn').on('click', boardInsert);
			
	  },
	    
	    error :function(xhr){
			console.log(xhr);
			console.log(xhr.status);
	    }
});
}
/////////////////////////////////////////


//?????? ????????? ??????
function freeList(){

let code ="<div id='featured'>";
code +="	<div class='title'></div>";
code +="	<div class='content'></div>";
code +="	</div>";

$('#featured').html(code);



$.ajax({
url : '<%=request.getContextPath()%>/board/board.do',
type : 'post', 
data : {
"choice" : "??????"
},
dataType : "json",
success : function(res){
 console.log(res);
    
 let str = "";
 str += "<table class='table table-hover table-bordered text-center' style='border: 1px solid #dddddd;'>";
 str += "<thead>";
 str += "<tr>";
 str += "   <th>?????????</th><th>??????</th><th>??????</th>";
 str += "</tr>";
 str += "</thead>";
 str += "<tbody>";
 
 $.each(res, function(i,v){
 board_noArr.push( v.board_no );
//  str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
//  str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
    str += "<tr onclick='f_detail(\""+v.board_no+"\");'><td class='detail'>" + v.board_no + "</td>";
    str += "<input type='hidden' id='borNo' name='borNo' value='"+v.board_no+"'>";
    str += "<td>" + v.board_title + "</td>";
    str += "<td>" + v.board_writer + "</td></tr>";
 });
 str += "<button type='button' class='btn btn-outline-info' id='boardinsert'>???????????????";
 
 $('#top').html(str);
 $('#boardinsert').on('click', boardInsert);
 
 
},

error :function(xhr){
 console.log(xhr);
 console.log(xhr.status);
}
});
}

//function freeList(){
//$.ajax({
<%--   url : '<%=request.getContextPath()%>/board/board.do', --%>
//type : 'post', 
//data : {
//  "choice" : "??????"
//  },
//dataType : "json",
//success : function(res){
//	console.log(res);
		
//	let str = "";
//	str += "<ol>";
//	$.each(res, function(i,v){
//	board_noArr.push( v.board_no );
//	str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
//	str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
//		str += "?????? : " + v.board_title;
//		str += "<br>";
//		str += "?????? : " + v.board_writer;
//		str += "<br><hr>";
//	str += "</li>";
//	});
//	str += "</ol>";
//	str += "<input type='button' class='boardInsertBtn' value='????????? ??????'/>";
	
//	$('#top').html(str);
//	$('.boardInsertBtn').on('click', boardInsert);
	
	
//},

//error :function(xhr){
//	console.log(xhr);
//	console.log(xhr.status);
//}
//});
//}

function f_detail(board_no){
board_no1 = board_no;
console.log("f_detail" + board_no);
$.ajax({
url : '<%=request.getContextPath() %>/board/board.do',
   type : 'post', 
   data : {
   	"choice" : "??????",
   	"board_no"	 : board_no
   },
   dataType : "json",
   success : function(res){
   	let str = "";
		str += "<ul>";
		str += "<li>";
		str += "?????? : " + res.board_title;
		str += "<br>";
		str += "?????? : " + res.board_writer;
		str += "<br>";
		str += "?????? : " + res.board_content;
		str += "<br>";
		str += "?????? : " + res.board_date;
		str += "<br>";
		str += "<button class='btn btn-outline-info' type='button' onclick='freeList(\"\");'>??????</button>";
		str += "<br><hr>";
		str += "</li>";
		str += "</ul><br>";
		str += "<div id='boardComment'>";
		
		str += "</div><br>";
		commentList(board_no);
		str += "<input type='button' class='btn btn-outline-info' class='boardDeleteBtn' value='????????? ??????' onclick='boardDelete(\""+board_no+"\");'/></div>";
		$('#top').html(str);
		
			},
   error : function(xhr) {
   	console.log(xhr);
   	console.log(xhr.status);
   }

});
}

function commentList(board_no){
$.ajax({
url : '<%=request.getContextPath()%>/board/board.do',
   type : 'post', 
   data : {	// ??????????????? ??????????????? ????????????
   	"choice" : "???????????????",
   	"board_no" : board_no
   },
   dataType : "json",
   success : function(res){
   	console.log(res);
	 	let str = "";
		str += "<ul>";
		$.each(res, function(i,v){
			str += "<li>";
			str += "????????? - " + v.mem_nm;
			str += "<br>";
			str += "?????? - " + v.comm_time;
			str += "<br>";
			str += "?????? - " + v.comm_content;
			str += "<br>";
			str += "<input type='button' class='btn btn-outline-info' class='boardCommentDeleteBtn' value='?????? ??????' onclick='boardCommentDelete(\""+v.comm_no+"\");'/>";
			str += "</li>";
		});
		str += "</ul><br>";
		//????????? ?????????????
		str += "<textarea id='comment' class='comment' name='comment'";
			str += "  autofocus required wrap='hard' style='width: 350px; resize: none; padding:20px; height: 30px;'></textarea>";
			str += "<div><input type='button' class='btn btn-outline-info' class='boardCommentBtn' value='?????? ??????' onclick='boardCommentInsert(\""+board_no+"\");'>";
		$('#boardComment').html(str);
	},
   
	error : function(xhr){
		console.log(xhr);
	}
});


}

function boardCommentDelete(comm_no){
$.ajax({
url : '<%=request.getContextPath()%>/board/board.do',
   type : 'post', 
   data : {
   	"choice" : "????????????",
   	"comm_no" : comm_no
   },
   success : function(res){
   	f_detail(board_no1);
	},
   dataType : "json",
   
	error : function(xhr){
		console.log(xhr);
	}
});
}

function boardCommentInsert(board_no){
let board_comm = $('#comment').val();

$.ajax({
url : '<%=request.getContextPath()%>/board/board.do',
   type : 'post', 
   data : {
   	"choice" : "????????????",
   	"board_no" : board_no,
   	"board_comm" : board_comm
   },
   success : function(res){
   	f_detail(board_no);
//			window.reload();
	},
   dataType : "json",
   
	error : function(xhr){
		console.log(xhr);
	}
});


}

function boardInsert(){
let str = "";
str +="	<select name='board_nm' id='board_nm'>";
str +="		<option value='??????'>??????</option>";
str +="		<option value='??????'>??????</option>";
str +="	</select> &nbsp; &nbsp; ";
str += "<input type='text' placeholder='????????? ??????' id='board_title' name='board_title' maxlength='20'><br>";
str += "<textarea class='summernote' id='board_content' name='editordata'></textarea>";

str += "<input type='button' class='btn btn-outline-info' id='boardInsert' value='??????'></input><br>";

$('#top').html(str); 

$('.summernote').summernote({
height: 150,
lang: "ko-KR" 
});
	
$('#boardInsert').on('click', function(){
let board_nm = $('#board_nm').val();
let board_title = $('#board_title').val();
let board_content = $('#board_content').val();

console.log(board_nm);


$.ajax({
url : '<%=request.getContextPath()%>/board/board.do',
type : 'post', 
data : {
	"choice" : "??????",
	"board_nm" : board_nm,
	"board_title" : board_title,
	"board_content" : board_content
},
success : function(res){
	freeList(); 
},
dataType : "json",

error : function(xhr){
	console.log(xhr);
}
});
});
}



function boardDelete(board_no){
console.log("????????????"+board_no);
$.ajax({
url : '<%=request.getContextPath()%>/board/board.do',
type : 'post', 
data : {
	"choice" : "??????",
	"board_no" : board_no
},
dataType : "json",
success : function(res){
	console.log('????????????');
	freeList();
},

error : function(xhr){
	console.log(xhr);
}
});
}

</script>


</body>
</html>
