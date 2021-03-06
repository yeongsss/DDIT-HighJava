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
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="http://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@200&display=swap"
      rel="stylesheet" />
<link rel="stylesheet" href="../css/board.css">

<script src="../js/moment.js"></script>

<script src="../js/jquery-3.6.0.min.js"></script>  
<link rel="stylesheet" href="../summernote/summernote-lite.css">
<script src="../summernote/summernote-lite.js"></script>
<script src="../summernote/lang/summernote-ko-KR.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>

<link href="../css/mainPage.css" rel="stylesheet" type="text/css" media="all" />
<link href="../css/fonts.css" rel="stylesheet" type="text/css" media="all" />

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
int select_memNo = 0;
%>

<body>
<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img id="mainPageBtn" onclick="goMain();" src="../images/logo3.JPG" alt="" />
			<h1><a onclick="goMain();" href="#">Na's Company</a></h1>
			<span>I can do it! <a href="" rel="nofollow">You Can do it!</a></span><br><br>
			<span id="logout"><a>??????????????? ?????? ???????????????</a></span>
		</div>
		<div id="menu">
			<ul>
<!-- 				<li class="current_page_item"><a href="#" accesskey="1" title="">Main Page</a></li> -->
				<li><a id='staffintroduce' accesskey="2" title="">????????? ??????</a></li>
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
				<img src="../images/main2.JPG" alt="" class="image-full" />
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
<input type="hidden" class="memNo" value="">
<script type="text/javascript">

//???????????????	
$('#staffintroduce').on('click',function(){
	   let code1 ="<div id='featured-none'>";
	   code1 +="   <div class='title-none'></div>";
	   code1 +="   <div class='content-none'></div>";
	   code1 +="   </div>";
	   
	   $('#featured').html(code1);

// 	   let code2 ="	<div class='banner-none'></div>";	
// 	   $('#banner').html(code2);
	   
	   
	   let code = "";
	   code += "<img src='../images/staff.jpg' style='width:700px; height:450px;'>";
	   code += "";
	   
	   $('#welcome').html(code);
	});




$('#calendarBtn').on('click', function(){ 
    location.href='<%=request.getContextPath()%>/calendarController.do?mem_no='+<%=mem_no%>;
 });
 
 $('#chatBtn').on('click', function(){
    location.href='<%=request.getContextPath()%>/chatController.do?mem_no='+<%=mem_no%>;
 });


//?????????===================================================================

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
  	   str += "<div id='banner'>";
	   str += "<div class='title'>";
	   str += "<h2>My page</h2>";
	   str += "</div><br><br>";
  
       str += "<table class='table table-hover table-bordered text-center' style='border: 1px solid #dddddd;'>";
       str += "<tr><td>????????????</td>";
       str += "<td>" + res.mem_no + "</td></tr>";
//        str += "<tr><td>????????????</td>";
//        str += "<td>" + res.dept_no + "</td></tr>";
//        str += "<tr><td>????????????</td>";
//        str += "<td>" + res.posi_no + "</td></tr>";
       
       str += "<tr><td>?????????</td>";
       str += "<td>" + res.dept_nm + "</td></tr>";
       str += "<tr><td>?????????</td>";
       str += "<td>" + res.posi_nm + "</td></tr>";

       
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
       str += "<td>" + res.hire.substring(0,10) + "</td></tr>";

       
       str += "<tr><td colspan='12' style='text-align: center;'>";
       str += "<input type='button' id='updateBtn' class='btn btn-outline-info' value='??????'/>";
//        str += "<input type='button' id='deleteBtn' value='??????'/>";
       str += "</tr></table>";
       
       $('#welcome').html(str);
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
		code += "<div id='banner'>";
		code += "<div class='title'>";
		code += "<h2>My page ??????</h2>";
		code += "</div><br><br>";
		
		code += "<p>???????????? : <input tupe='text' id='mem_addr1' autocomplete=off  ></p>";
		code += "<p>???????????? : <input tupe='text' id='mem_addr2' autocomplete=off ></p>";
		code += "<p>???????????? : <input tupe='text' id='mem_tel' autocomplete=off ></p>";
		code += "<p>???   ???  : <input tupe='text' id='mem_mail' autocomplete=off ></p>";
		
	    code += "<input id='submitBtn' type='button' class='btn btn-outline-info' value='??????'/>";
	    code += "<input type='reset' id='mem-update-cancle' class='btn btn-outline-info' value='??????'/>";
    $('#welcome').html(code);
	
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
		managerCode += "<div id='banner'>";
	    managerCode += "<div class='title'>";
	    managerCode += "<h2>????????? ?????????</h2>";
	    managerCode += "</div><br><br>";

	
	managerCode += "<div class='memBtn'><input type='button' class='button1' id='memLookUp' name='memLookUp' value='????????????'>";
	managerCode += "<input type='button' class='button1' id='manageNoticeBoard' name='manageNoticeBoard' value='??????????????????'></div>";
// 	managerCode += "<div id='myDiv' class='col-lg-10' name='myDiv' > </div>";
	
	let code ="<div id='featured'>";
	code +="	<div class='title'></div>";
	code +="	<div class='content'></div>";
	code +="	</div>";
	
	$('#welcome').html(managerCode);	
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
			let authper = "";

			let str = "";
			str += "<ul class='style2'>";
			
			$.each(res, function(i,v){
				console.log(v.auth);
				if(v.auth=='1'){
					authper = '?????????';
				} else{
					authper = v.board_writer;
				}
				
				str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
				str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
				str +="<p class='writer'><a href='#'>"+v.board_no+"<b>"+ authper +"</b></a></p>";
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
			code += "<div class='sal-table'><table class='salary-table'><thead><tr><td>??????</td><td>?????????</td><td>?????????</td></tr></thead>";
			code += `<tbody>`;
			$.each(res, function(i,v){
				const n1 = v.salary;
				const option = {
				        maximumFractionDigits: 0
				      };
				const cn1 = 
				    n1.toLocaleString('ko-KR', option);
				console.log(cn1);
				code += "<tr><td>"+v.salary_nm+"</td>";
				code += "<td>"+cn1+"</td>";
				code += "<td>"+v.payday+"</td></tr>";
				
			});
			code += "<tr><td><input type='button 'class='btn btn-outline-info' value='????????????' id='salary' onclick='salary("+memNo+");'></td>"
			code += "<td colspan='2'><input type='button' class='btn btn-outline-info' value='????????????' onclick='deptMemDetail("+memNo+");'></td></tr>";
			code += `</tbody></table></div>`;
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
	code += "???????????? : <input type='text' id='salMoney'><input type='button' id='payments' class='btn btn-outline-info' name='payments' onclick='payment("+memNo+");' value='??????'>";
	code += "</div>";
	
	$('#data').html(code);
	
}

function payment(memNo) {
	let salType = $("input[name='search_type']:checked").val();
	let salMoney = $('#salMoney').val();
	
	console.log(salType);
	console.log(salMoney);
	

	$.ajax({
		url : '<%=request.getContextPath() %>/manage/manage.do',	
		type : 'post',
		data : {
			"choice" : "payments",
			"memNo" : memNo,
			"salType" : salType,
			"salMoney" : salMoney
		},
		async:false,
		success : function(res){
			console.log(res);
//				memSalary(memNo);
			deptMemDetail(memNo);
			
		},
		dataType : 'json',
		error : function(xhr){
			console.log(xhr);
		}
	});
}


// ???????????? ???????????????
function memLookUp(){					
	
			let lookCode ="";
// 			let code ="";
// 			code += "<h3>????????????</h3>";
// 			$('.title').html(code);
//				lookCode +="<div>??????????????????</div>";

	$.ajax({
		url : '<%=request.getContextPath() %>/manage/manage.do',
		type : 'post',
		data : {
			"choice" : "departList"
		},
	
		success : function(res){
			console.log(res)
			
			lookCode +="	<div class='dept-select'> <select id='sel1' class='sel1' name='sel1' onchange='departMember()'c style='width:100px;' onclick='departMember();'></div>";
			
			$.each(res, function(i,v){
				lookCode +="				<option value='"+ v.dept_no +"'>"+ v.dept_nm +"</option>";
			});
			
			lookCode +="</select>";
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
			code += "<table id='dept-mem' width='100px' class='table-wrap'>";
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
	const memNOInput = document.querySelector(".memNo");
	memNOInput.value= memNo;
	
	 let code = "<br>";
      code +="<div class='memupdate'><input type='button' class='button2' id='updateBtn' onclick='mUpdate("+memNo+");' value='?????? ??????'>";
      code +="<input type='button' class='button2' id='infoUpdateBtn' onclick='DPupdate("+memNo+");' value='??????????????? ??????'>";
      code +="<input type='button' class='button2' id='memSalary' name='memSalary' onclick='memSalary("+memNo+");' value='????????????'>";
      code += "<input type='button' class='button2' id='memberWork' name='memberWork' onclick='memWork("+memNo+");' value='????????????'></div>";
	
// 	let code = "<br>";
// 	 code +="<div class='memupdate'><input type='button' class='button2' id='updateBtn' onclick='mUpdate("+memNo+");' value='?????? ??????'>";
// 	 code +="<input type='button' class='button2' id='infoUpdateBtn' onclick='DPupdate("+memNo+");' value='??????????????? ??????'>";
// 	 code +="<input type='button' class='button2' id='memSalary' name='memSalary' onclick='memSalary("+memNo+");' value='????????????'>";
// 	 code += "<input type='button' class='button2' id='memberWork' name='memberWork' onclick='memWork("+memNo+");' value='????????????'></div>";
// 	 code += "<table border='1' id='dept-mem-detail' cellpadding='10' cellspacing='10' width='100px'>";
// 	 code += "<thead><tr><td>????????????</td><td>??????</td><td>????????????</td>";
// 	 code += "<td>??????</td><td>??????</td><td>????????????</td><td>??????</td><td>??????</td>";
// 	 code += "<td>?????? ??????</td><td>?????? ??????</td><td>?????????</td>";
// 	 code += "</tr></thead><tbody>";
	
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
				
				code += "<div class='member-info' id='memBox'><table class='table table-bordered text-center' style='border: 1px solid #dddddd;'>";
	            code += "<tr><td>????????????</td>";
	            code += "<td>"+v.mem_no+"</td></tr>";
	            code += "<tr><td>??????</td>";
	            code += "<td>"+v.mem_nm+"</td></tr>";
	            code += "<tr><td>????????????</td>";
	            code += "<td>"+v.mem_tel+"</td></tr>";
	            code += "<tr><td>??????</td>";
	            code += "<td>"+v.posi_nm+"</td></tr>";
	            code += "<tr><td>??????</td>";
	            code += "<td>"+v.dept_nm+"</td></tr>";
	            code += "<tr><td>????????????</td>";
	            code += "<td>"+v.mem_birth+"</td></tr>";
	            code += "<tr><td>??????</td>";
	            code += "<td>"+v.mem_addr1+" "+v.mem_addr2+"</td></tr>";
	            code += "<tr><td>??????</td>";
	            code += "<td>"+v.mem_mail+"</td></tr>";
	            code += "<tr><td>????????????</td>";
	            code += "<td>"+v.ch_posi_nm+"</td></tr>";
	            code += "<tr><td>????????????</td>";
	            code += "<td>"+v.ch_dept_nm+"</td></tr>";
	            code += "<tr><td>?????????</td>";
	            code += "<td>"+v.change_date+"</td></tr>";
				code +="<br><br>";
			});
			
			code += "</table></div>";
			code +="<div id='update' name='update'></div>";
			$('#data').html(code);
			
			
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
	code +=`<div class='textbox1'><input type='button' class='sendBtn' id='send' name='send' value='??????'>`;
	code +="<input type='button' class='sendBtn' id='send-cancle' name='send-cancle' onclick='deptMemDetail("+data+");' value='??????'></div>";
	
	$('#memBox').html(code);
	
}	


// 	$('#send-cancle-Btn').on('click',deptMemDetail(data));
	
// 	$('#send').on('click',function(){
	
// 		let tel = $('#telUpdate').val();
// 		let addr1 = $('#addrUpdate1').val();
// 		let addr2 = $('#addrUpdate2').val();
// 		let mail = $('#mailUpdate').val();
		
// 		$.ajax({
<%-- 			url : '<%=request.getContextPath() %>/manage/manage.do', --%>
// 			type : 'post',
// 			data : {
// 					"choice" : "update",
// 					"tel" : tel,
// 					"addr1" : addr1,
// 					"addr2" : addr2,
// 					"mail" : mail,
// 					"memNO" : data
				
// 			},
// 			success : function(res){
				
// 				if (res < 0 ) {
// 					alert('????????? ??????????????????.');
// 				}
				
// 				deptMemDetail(data);
			
// 			},
// 			dataType : 'json',
			
// 			error : function(xhr){
// 				console.log(xhr);	
// 			}
// 		});
		
// 	});
// }


function DPupdate(memNo){
	
	console.log(memNo);
	
	let code = `<table><tr>`;
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
	
	
	code += `<tr><td  colspan='2'><input type='button' id='DPUpdate' value='??????'></td></tr> `;
	
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
		    bookcode +=	"<div id='banner'>";
		    bookcode += "<div class='title'>";
		    bookcode += "<h2>????????? ??????</h2>";
		    bookcode += "</div><br><br>";
		
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
			bookcode +="	<input type='button' id='btn' class='btn btn-outline-info' value='??????' >";
			bookcode +="	<input type='button' id='btn' class='btn btn-outline-info' value='??????' onclick='showList(\"\");'></div>";
		$('#welcome').html(bookcode);	
		
		
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




$('#conferenceBtn').on('click',showList);

function showList(){
	
// 	$('#featured').hide();	
	
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
		 let code ="";
	 	 code += "<div id='banner'>";
		 code += "<div class='title'>";
		 code += "<h2>????????? ??????</h2>";
		 code += "</div><br><br>";
	 
	     code += "<table class='table table-bordered table-hover' style='text-align: center; border: 1px solid #dddddd'>";
	     code += "<thead>";
		 code += "<tr>";
		 code += "	<th>????????????</th><th>????????????</th><th>??? ???</th><th>???????????????</th><th>????????????</th><th>????????????</th>";
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
		    code += "<input type='button' class='btn btn-outline-info' id='resBtn' onclick='res();' value='????????????'></td></tr></table>"

// 		code += "</tbody></table><input type='button' id='resBtn' onclick='res();' value='????????????'>";
//			code += "</tbody></table><input type='button' id='conDelBtn' onclick='deleteRes();' value='????????????'>";
		$('#welcome').html(code);	
		console.log(res);	
	},
	error : function(xhr){
		console.log(xhr);
		console.log(xhr.status);
	},
	dataType:'json'
});
}


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






////////////////////////////////////////////////////////////////???????????? ?????????


//// ?????? ??????

$('#sanctionBtn').on('click', documentList);
// $('#docInsertBtn').on('click', docInsert);

let san_no ="";

// ???????????? ?????? ?????????
function documentList() {
	
// 	let code ="<div id='featured-none'>";
// 	code +="	<div class='title-none'></div>";
// 	code +="	<div class='content-none'></div>";
// 	code +="	</div>";
	
// 	$('#featured').html(code);
	
	
	
        let code = "";
	     code += "<div id='banner'>";
	     code += "<div class='title'>";
	     code += "<h2>?????? ??????</h2>";
	     code += "</div><br><br>";
	   $('#welcome').html(code);
	   
	   console.log('dddd');
	   
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
		         str += "<div id='banner'>";
		  	     str += "<div class='title'>";
		  	     str += "<h2>?????? ??????</h2>";
		  	     str += "</div><br><br>";
		         
	          
 			    str += "<div class='insert-btn'><button type='button' class='btn btn-outline-info' id='docConfirm' value='??????' onclick='docBtn(\"??????\")'>??????</button>&nbsp;&nbsp;";
 			    str += "<button type='button' class='btn btn-outline-info' id='docWait' value='??????' onclick='docBtn(\"??????\")'>??????</button>&nbsp;&nbsp;"
 			    str += "<button type='button' class='btn btn-outline-info' id='docRefuse' value='??????' onclick='docBtn(\"??????\")'>??????</button></div>";
		        
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
	         
	         
	         $('#welcome').html(str);
	         $('#docInsertBtn').on('click', docInsert);
	      },
	      error : function (xhr) {
	         console.log(xhr);
	      }
	   });
	   
	   let finalCode = "";
	   finalCode +=	"<div id='featured'>ddd<div>";
		
	   $('#featured').htmle(finalCode);
	   
	}
	
	
//function documentList() {
//// 	let docConfirm = $('#docConfirm').val();
//// 	let docWait = $('#docWait').val();
//// 	let docRefuse = $('#docRefuse').val();
	
//	$.ajax({
<%-- 		url : '<%=request.getContextPath()%>/sanction/sanctionDocument.do', --%>
//		type : 'post',
//		data : {
//			"documentSelect" : "???????????????"
//		},
//		dataType : "json",
//		success : function (res) {
//			console.log(res);
//// 			console.log(res[0].san_status);

//			let str = "";
//			str += "<button type-'button' id='docInsertBtn' onclick='docInsert(\"\")'>??????</button>"
//			str += "<button type='button' id='docConfirm' value='??????' onclick='docBtn(\"??????\")'>??????</button>";
//			str += "<button type='button' id='docWait' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
//			str += "<button type='button' id='docRefuse' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
//			str += "<ul>";
	
//			$.each(res, function (i,v) {
//				str += "<li onclick='docDetail(\""+v.san_no+"\");'>";
//				str += "???????????? : " + v.san_no;
//				str += "<br>";
//				str += "???????????? : " + v.san_title;
//				str += "<br>";
//				str += "??????????????? : " + v.san_nm;
//				str += "<br>";
//				str += "????????? : " + v.san_write_date;
//				str += "<br>";
//				str += "??????????????? : " + v.san_conf_date;
//				str += "<br>";
//				str += "?????? : " + v.san_content;
//				str += "<br>";
//				str += "???????????? : " + v.san_deadline;
//				str += "<br>";
//				str += "???????????? : " + v.san_status;
//				str += "<br><br>";
//				str += "</li>";
//			});
//			str += "</ul>";
//			$('#top').html(str);
			
//// 			console.log($('#docConfirm').val());
//// 			console.log(docWait);
//// 			console.log(docRefuse);
//		},
//		error : function (xhr) {
//			console.log(xhr);
//		}
//	});
	
//}
	
	
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
			str += "<div class='insert-btn'><button type='button' class='btn btn-outline-info' id='docConfirm' value='??????' onclick='docBtn(\"??????\")'>??????</button>";
			str += "<button type='button' class='btn btn-outline-info' id='docWait' value='??????' onclick='docBtn(\"??????\")'>??????</button>"
			str += "<button type='button' class='btn btn-outline-info' id='docRefuse' value='??????' onclick='docBtn(\"??????\")'>??????</button></div>"

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
         
         
         $('#welcome').html(str);
         $('#docInsertBtn').on('click', docInsert);
      },
		error : function(xhr) {
			console.log(xhr);
		}
			
	});
	
}
	
function docDetail(san_no){
	console.log(san_no);
	
// 	const _data = {
// 			"documentSelect" : "??????????????????",
// 			"san_no": san_no
// 		}
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
			
			$('#welcome').html(str);
		},
		error : function(xhr) {
			console.log(xhr);
		}
			
	});
}
	
// ?????? ?????? ?????? ?????? ?????? ?????????
function docInsert() {
	
// 	let str = "<table border='none' align='center' width='300' height='80'>";
// 		str += "<tr align='center'><td colspan='2'><input type='text' id='san_per1' placeholder='1???'><input type='text' id='san_per2' placeholder='2???'><input type='text' id='san_per3' placeholder='3???'></td></tr>";
// 			str += "<tr><td colspan='2'>????????????&nbsp;&nbsp;<select id='san_nm'><option value='???????????????'>???????????????<option value='???????????????'>???????????????<option value='?????????????????????'>?????????????????????"
// 			str += "<option value='???????????????'>???????????????<option value='?????????'>?????????<option value='?????????'>?????????<option value='?????????'>?????????</td></tr>";
// 			str += "<tr><td>??????&nbsp;&nbsp;<input type='text' id='san_position'></td><td>??????&nbsp;&nbsp;<input type='text' id='san_dep'></td></tr>";
// 			str += "<tr><td>?????????&nbsp;&nbsp;<input type='text' id='san_writer'></td><td>????????????&nbsp;&nbsp;<input type='text' id='san_deadline'></td></tr>";
// 			str += "<tr><td colspan='2'>??????&nbsp;&nbsp;<input type='text' id='san_title'></td></tr>";
// 			str += "<tr><td colspan='2'>??????&nbsp;&nbsp;<input type='text' id='san_content'></td></tr>";
	
	let str = "";
	str += "<div id='banner'>";
    str += "<div class='title'>";
    str += "<h2>???????????? ??????</h2>";
    str += "</div><br><br>";

			str += "<div class='ducument-name-select'>?????? ?????? ?????? : <select name='document-name' id='document-name' onchange='insert_document()' onclick='insert_document();'><br>";
			str += "	<option value='???????????????'>???????????????</option>";
			str += "	<option value='???????????????'>???????????????</option>";
			str += "	<option value='?????????????????????'>?????????????????????</option>";
			str += "	<option value='???????????????'>???????????????</option>";
			str += "	<option value='?????????'>?????????</option>";
			str += "	<option value='?????????'>?????????</option>";
			str += "	<option value='?????????'>?????????</option>";
			str +="</div></select>"
			str +="<div id='ducument' class='ducument' ></div>";
	
			$('#welcome').html(str);

}

// ?????? ?????? ??????
function insert_document(){
	
	let selec_document = $("#document-name option:selected").val();
	let name ='<%=getsession.getAttribute("name")%>';
	let dept = '<%=getsession.getAttribute("dept")%>';
	let dept_nm = '<%=getsession.getAttribute("deptName")%>';
	
	console.log(dept_nm);
	
		let str = "";
		$.ajax({
			url : '<%=request.getContextPath()%>/manage/manage.do',
			type : 'post',
			data : {
				"choice" : "memList"
			},
			success : function(res){
				console.log(res);	
				
				str += "<table border='1' class='sanction-box'>";
				str += "<thead >";
				str += "<tr><td rowspan='2' colspan='3' width='500' height='130'>"+ selec_document +"</td>";
				str += "<td width='15%'>?????????</td><td width='15%'>?????????1</td><td width='15%'>?????????2</td></tr>";
				str += "<tr><td width='15%' height='100'><input type='text' id='sanction-name' name='sanction-name' class='document-text' value='"+name+"'></td>";
				str += "<td width='15%'><select name='teamLeader1' id='teamLeader1' class='document-approver'>";
					$.each(res, function(i,v){
						str += "<option value='"+ v.mem_no +"'>"+v.posi_nm+"_"+ v.mem_nm +"</option>";
					});

				str += "</select></td>";
				str += "<td width='15%'><select name='teamLeader2' id='teamLeader2' class='document-approver'>";
					
					$.each(res, function(i,v){
						str += "<option value='"+ v.mem_no +"'>"+v.posi_nm+"_"+ v.mem_nm +"</option>";
					});
				
				str += "</select></td></tr>";

//					str += "<tr><td width='110' height='120'>" + "??????" + "</td><td width='110'>??????</td><td width='110'>??????</td></tr>";
				str += "</thead>";
				str += "<tbody>";
				str += "<tr><td  width='130' height='100' colspan='2'>??????</td><td colspan='4'><input type='text' id='document-title' name='document-title' class='document-text' ></td></tr>";
				str += "<tr><td height='100'>????????????</td><td colspan='2'><input type='datetime-local' id='document-deadline' name='document-deadline' style='border: none;'></td>";
				str += "<td>?????????</td><td colspan='2'>"+ dept_nm +"</td></tr>";
				str += "<tr><td height='100'>?????????</td><td colspan='6'><p id='memName'>"+ name +"</p></td></tr>";
				str += "<tr><td height='500'>??????</td><td colspan='6'><input type='text' id='document-content' name='document-content' class='document-text' ></td></tr>";
				str += "</tbody>";
				str += "</table>";

				str += "<button type='button' class='btn btn-outline-info' onclick='documentList(\"\")'>?????? ??????</button>";
	
				str += "<button type='button' class='btn btn-outline-info' onclick='real_insert_document();' value='??????' id='docuInsert'>??????";
				
				$('#ducument').html(str);	
				
			},
			dataType : 'json',
			error : function(xhr){
				console.log(xhr);
			}
			
		});
}



function real_insert_document(){
	
	let san_nm = $("#document-name option:selected").val();
	let san_content =$('#document-content').val();
		
	let san_deadline = $('#document-deadline').val();
	let san_title = $('#document-title').val();
	
	let mem_no2 =  $("#teamLeader1 option:selected").val();
	let mem_nm2 = $('#teamLeader1 option:selected').text();

	let mem_no3 = $('#teamLeader2 option:selected').val();
	let mem_nm3 = $('#teamLeader2 option:selected').text();
	console.log(mem_nm3);
	
	let mem_no = '<%=getsession.getAttribute("memNo")%>';
	let mem_nm = '<%=getsession.getAttribute("name")%>';
		console.log(mem_no);
	
	$.ajax({
		url : '<%=request.getContextPath() %>/sanction/sanctionDocument.do',
		type : 'post',
		data : {
			"documentSelect" : "??????",
			"san_nm" : san_nm,
			"san_content" : san_content,
			"san_deadline" : san_deadline,
			"san_title" : san_title,
			"mem_nm2" : mem_nm2,
			"mem_no2" : mem_no2,
			"mem_nm3" : mem_nm3,
			"mem_no3" : mem_no3,
			"mem_no" : mem_no,
			"mem_nm" : mem_nm
		},
		success : function(res){
			console.log(res);	
			
			documentList();
			
		},
		dataType : 'json',
		error : function(xhr){
			
		}
		
	});
	
	
	
	
	
	
	
	
}


//------------------------------------------------------------------
//???????????? ?????????

$('#freeBtn').on('click', freeList);
$('#noticeBtn').on('click', noticeList);
	let board_noArr = new Array();
	
	let fonts = ['?????? ??????', '??????', '??????', '??????', '?????????', '?????????', '?????? ??????', '??????', '?????????', '?????????', 'HY?????????', 'HY?????????', 'HY??????B', 'HY?????????M', 'HY????????????B', 'HY?????????', 'HY????????????M', 'HY??????L', 'HY??????M', 'HY?????????', 'HY????????????M', '???????????????', '????????????T', '???????????????', '????????????????????????', '???????????????', '????????????'];

let board_no1 = "";

function noticeList(){
	let code ="<div id='featured-none'>";
	code +="	<div class='title-none'></div>";
	code +="	<div class='content-none'></div>";
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
			console.log(res[0].board_date);
			let time = res[0].board_date.toString().substring(5,7);
			console.log(time);
			
			
			let str = "";
			str += "<div class='title'>";
			str += "<h2>What's news/Notice</h2>";
			str += "<span class='byline'></span>";
			str += "</div>";
			str += "<div class='content'>";
			str += "<ul class='style1'>";
			$.each(res, function(i,v) {
// 				let time = res[0].board_date.toString().substring(8,10);
				let mon = v.board_date.toString().substring(5,7);
				if(mon=='01'){
					mon = 'Jan.';
				} else if(mon=='02') {
					mon = 'Feb.';
				} else if(mon=='03') {
					mon = 'Mar.';
				} else if(mon=='04') {
					mon = 'Apr.';
				} else if(mon=='05') {
					mon = 'May.';
				} else if(mon=='06') {
					mon = 'Jun.';
				} else if(mon=='07') {
					mon = 'Jul.';
				} else if(mon=='08') {
					mon = 'Aug.';
				} else if(mon=='09') {
					mon = 'Sep.';
				} else if(mon=='10') {
					mon = 'Oct.';
				} else if(mon=='11') {
					mon = 'Nov.';
				} else if(mon=='12') {
					mon = 'Dec.';
				}
				
				str += "<li class='first' class='detail' onclick='f_detail2(\""+v.board_no+"\");'>";
				str += "<p class='date'><a href='#'>"+ mon +"<b>"+ v.board_date.toString().substring(8,10) +"</b></a></p>";
				str += "<h3>"+ v.board_title +"</h3>";
				str += "<p><a href='#'>"+ v.board_content.substring(0,80) +"...</a></p>";
				str += "</li>";
				str += "";
			});
			str += "</ul>";
			str += "</div>";
			$('#welcome').html(str);

				
		  },
		    
		    error :function(xhr){
				console.log(xhr);
				console.log(xhr.status);
		    }
	});

}
/////////////////////////////////////////


// ?????? ????????? ??????
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
      str += "<div id='banner'>";
	  str += "<div class='title'>";
	  str += "<h2>?????? ?????????</h2>";
	  str += "</div><br><br>";
      
      str += "<table class='table table-hover table-bordered text-center' style='border: 1px solid #dddddd;'>";
      str += "<thead>";
      str += "<tr>";
      str += "   <th>?????????</th><th>??????</th><th>??????</th>";
      str += "</tr>";
      str += "</thead>";
      str += "<tbody>";
      
      $.each(res, function(i,v){
  	    board_noArr.push( v.board_no );
//       str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
//       str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
         str += "<tr onclick='f_detail(\""+v.board_no+"\");'><td class='detail'>" + v.board_no + "</td>";
         str += "<input type='hidden' id='borNo' name='borNo' value='"+v.board_no+"'>";
         str += "<td>" + v.board_title + "</td>";
         str += "<td>" + v.board_writer + "</td></tr>";
      });
    
      str += "<div class='boardAdd'><button type='button' class='btn btn-outline-info' id='boardInsertBtn'>???????????????</div>";
       
      $('#welcome').html(str);
      $('#boardInsertBtn').on('click', boardInsert);
      
      
    },
    
    error :function(xhr){
      console.log(xhr);
      console.log(xhr.status);
    }
});
}

// function freeList(){
// $.ajax({
<%--   url : '<%=request.getContextPath()%>/board/board.do', --%>
//   type : 'post', 
//   data : {
// 	  "choice" : "??????"
// 	  },
// dataType : "json",
//   success : function(res){
// 		console.log(res);
			
// 		let str = "";
// 		str += "<ol>";
// 		$.each(res, function(i,v){
// 		board_noArr.push( v.board_no );
// 		str += "<li id= li"+ v.board_no +" class='detail' onclick='f_detail(\""+v.board_no+"\");'>";
// 		str +="<input type='hidden' id='borNo' name='borNo'value='"+v.board_no+"'>";
// 			str += "?????? : " + v.board_title;
// 			str += "<br>";
// 			str += "?????? : " + v.board_writer;
// 			str += "<br><hr>";
// 		str += "</li>";
// 		});
// 		str += "</ol>";
// 		str += "<input type='button' class='boardInsertBtn' value='????????? ??????'/>";
		
// 		$('#top').html(str);
// 		$('.boardInsertBtn').on('click', boardInsert);
		
		
//     },
    
//     error :function(xhr){
// 		console.log(xhr);
// 		console.log(xhr.status);
//     }
// });
// }

function f_detail2(board_no){
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
	    	str += "<div id='banner'>";
	    	str += "<div class='title'>";
	    	str += "<h2>????????? ??????</h2>";
	    	str += "</div><br><br>";

	        str += "<div class='boardDelBtn'><input type='button' class='boardDeleteBtn btn btn-outline-info' value='??????' onclick='noticeList();'/></div>";
	    	str += "<table class='table table-bordered text-center' >";
			str += "<tr><td colspan='2'><h5>??????</h5></td>";
			str += "<td colspan='2'>" + res.board_title + "</td></tr>";
			str += "<tr><td><h5>??????</h5></td>";
			str += "<td>" + res.board_writer + "</td>";
			str += "<td><h5>??????</h5></td>";
			str += "<td>" + res.board_date + "</td></tr>";
			str += "<tr><td colspan='2'><h5>??????</h5></td>";
			str += "<td colspan='2'>" + res.board_content + "</td></tr></table>";
			str += "<div id='boardComment'>";
			
			str += "</div><br>";
			commentList(board_no);
			$('#welcome').html(str);
			
				},
	    error : function(xhr) {
	    	console.log(xhr);
	    	console.log(xhr.status);
	    }

});
}

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
	    	str += "<div id='banner'>";
	    	str += "<div class='title'>";
	    	str += "<h2>????????? ??????</h2>";
	    	str += "</div><br><br>";

	        str += "<div class='boardDelBtn'><input type='button' class='boardDeleteBtn btn btn-outline-info' value='????????? ??????' onclick='boardDelete(\""+board_no+"\");'/></div>";
	    	str += "<table class='table table-bordered text-center' >";
			str += "<tr><td colspan='2'><h5>??????</h5></td>";
			str += "<td colspan='2'>" + res.board_title + "</td></tr>";
			str += "<tr><td><h5>??????</h5></td>";
			str += "<td>" + res.board_writer + "</td>";
			str += "<td><h5>??????</h5></td>";
			str += "<td>" + res.board_date + "</td></tr>";
			str += "<tr><td colspan='2'><h5>??????</h5></td>";
			str += "<td colspan='2'>" + res.board_content + "</td></tr></table>";
// 		    str += "<tr><td colspan='4' style='text-align'='right';>";
	    	
	    	
// 			str += "<ul>";
// 			str += "<li>";
// 			str += "?????? : " + res.board_title;
// 			str += "<br>";
// 			str += "?????? : " + res.board_writer;
// 			str += "<br>";
// 			str += "?????? : " + res.board_content;
// 			str += "<br>";
// 			str += "?????? : " + res.board_date;
// 			str += "<br>";
		
// 			str += "<br><hr>";
// 			str += "</li>";
// 			str += "</ul><br>";
			str += "<div id='boardComment'>";
			
			str += "</div><br>";
			commentList(board_no);
			$('#welcome').html(str);
			
// 			str += "<input type='button' class='boardDeleteBtn' value='????????? ??????' onclick='boardDelete(\""+board_no+"\");'/></div>";
// 			$('#top').html(str);
			
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
// 			str += "<ul>";
			$.each(res, function(i,v){
				str += "<div class='commentBox'><div class='commentList'>"
				str += "<div>" + v.mem_nm + "</div>";
				str += "<div>" + v.comm_content + "</div>";
				str += "<div>" + v.comm_time + "</div>";
				str += "<input type='button' class='boardCommentDeleteBtn btn btn-outline-info' value='??????' onclick='boardCommentDelete(\""+v.comm_no+"\");'/>";
				str += "</div>";
				
// 				str += "<li>";
// 				str += "????????? - " + v.mem_nm;
// 				str += "<br>";
// 				str += "?????? - " + v.comm_time;
// 				str += "<br>";
// 				str += "?????? - " + v.comm_content;
// 				str += "<br>";
// 				str += "<input type='button' class='boardCommentDeleteBtn' value='?????? ??????' onclick='boardCommentDelete(\""+v.comm_no+"\");'/>";
// 				str += "</li>";
			});
			str += "</ul><br>";
			//????????? ?????????????
				str += "<div class='commentInsert'><textarea id='comment' class='comment' name='comment'";
				str += "  autofocus required wrap='hard' style='width: 350px; resize: none; padding:20px; height: 30px;'></textarea>";
				str += "<div><input type='button' class='boardCommentBtn btn btn-outline-info' value='??????' onclick='boardCommentInsert(\""+board_no+"\");'></div></div>";
			$('#boardComment').html(str);
					
// 			str += "<textarea id='comment' class='comment' name='comment'";
// 				str += "  autofocus required wrap='hard' style='width: 350px; resize: none; padding:20px; height: 30px;'></textarea>";
// 				str += "<div><input type='button' class='boardCommentBtn' value='?????? ??????' onclick='boardCommentInsert(\""+board_no+"\");'>";
// 			$('#boardComment').html(str);
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
//				window.reload();
		},
        dataType : "json",
        
		error : function(xhr){
			console.log(xhr);
		}
	});


}

function boardInsert(){
	let str = "";
	str += "<div id='banner'>";
	str += "<div class='title'>";
	str += "<h2>?????? ????????? ??????</h2>";
	str += "</div><br><br>";

	str +="	<select name='board_nm' id='board_nm'>";
	str +="		<option value='??????'>??????</option>";
	str +="		<option value='??????'>??????</option>";
	str +="	</select> &nbsp; &nbsp; ";
	str += "<input type='text' placeholder='????????? ??????' id='board_title' name='board_title' maxlength='20'><br>";
	str += "<textarea class='summernote' id='board_content' name='editordata'></textarea>";
	
	str += "<input type='button' id='boardInsert' value='??????'></input><br>";
	
	$('#welcome').html(str); 
	
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
