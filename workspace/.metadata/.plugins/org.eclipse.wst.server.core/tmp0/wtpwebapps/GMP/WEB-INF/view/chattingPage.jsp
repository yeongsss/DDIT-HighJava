<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900" rel="stylesheet" />
<link href="<%=request.getContextPath() %>/css/mainPage.css" rel="stylesheet" type="text/css" media="all" />
<link href="<%=request.getContextPath() %>/css/fonts.css" rel="stylesheet" type="text/css" media="all" />

<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	#chatArea {
 		display: none;
	}
	#connectArea {
		border:2px solid green;	padding: 5px; width : 430px;
		margin: 0px auto;
	}
	
	#messageTextArea{
		overflow: auto;
		width: 800px;
  		height: 400px;
  		text-align: left;
 		border: 3px solid ; 
  		border-radius: 15px;
	}
	#chatListMemList{
		overflow: auto;
		width: 800px;
  		height: 400px;
	}
	
	#messageTextArea::-webkit-scrollbar,
	#chatListMemList::-webkit-scrollbar{
	    display: none; /* Chrome, Safari, Opera*/
	}
	
	#chatRoom{
		display: none;
		margin: 0px auto;
	}
	#chatRoom2{
		margin: 0px auto;
		display: block;
	}
	
	#chatRoom select {
		width : 325px;
	}
	
	table{
		margin: 0px auto;
	}
	#messageText{
	display:inline-block;
    	width: 720px;
    	height: 35px;
    	text-align: right;
    	margin-top: 3px;
    	border: 3px solid;
    	font-size: 20px;
    	border-radius: 15px;
    	font-weight: 400;
    	float: left;
	}
 	#sendBtn,
 	#closeBtn,
 	#chatBtn,
 	.rightBtn{
	   	display: inline-block;
	    border: 3px solid;
	    border-radius: 15px;
	    width: 75px;
	    height: 45px;
	    text-align: center;
	    margin-top: 3px;
	    float: right;
	    font-weight: bold;
	}
	
	#chatRoomList {
    	display: inline-table;
    	float: left;
    	width: 100px;
   		text-align: right;
		margin-right: 10px;
   		margin-top: 10px;
   	    border: 3px solid;
	    border-radius: 15px;
	}
	
	#chatRoomMemList{
		display: inline-table;
    	float: left;
    	width: 100px;
   		text-align: right;
   		margin-top: 10px;
   	    border: 3px solid;
	    border-radius: 15px;
	}
	#chatRoomName{
		padding-top: 20px;
   	    display: inline-block;
    	border: 3px solid;
    	border-radius: 15px;
    	width: 100px;
    	height: 40px;
    	float: left;
    	padding-right: 15px;
  		padding-top: 15px;
  		padding-left: 15px;
  		margin-bottom: 3px;
	}
	#menu li:hover{
      background: #2980b9;
      color: rgba(255,255,255,1);
      cursor: pointer;
   }
   #logout{
   	cursor: pointer;
   }
   #mainPageBtn:hover{
   	cursor: pointer;
   }
   #outBtn{
   	display:none;
   }
</style>
<%
	int mem_no = (int)request.getAttribute("mem_no");
	String mem_nm = (String)request.getAttribute("mem_nm");
	System.out.println(mem_nm);
	//request.getAttribute("dept_no");

%>
  
</head>
<body>

<div id="page" class="container">
	<div id="header">
		<div id="logo">
			<img src="./images/logo3.JPG" alt=""  id="mainPageBtn" onclick="goMain();"/>
			<h1><a href="#">Na's Company</a></h1>
			<span>I can do it! <a href="http://templated.co" rel="nofollow">You Can do it!</a></span>
			<br><br>
			<span id="logout"><a>??????????????? ?????? ???????????????</a></span>
		</div>
		<div id="menu">
			<ul>
				<li><a id="mypageBtn" href="#" accesskey="3" title="">???????????????</a></li>
				<li><a id="noticeBtn" href="#" accesskey="5" title="">????????????</a></li>
				<li id="chattingBtn" class="current_page_item"><a accesskey="3" title="">??????</a></li>
				<li id= "calendarBtn" ><a accesskey="4" title="">Calendar</a></li>
				<li><a id="sanctionBtn" accesskey="5" title="">????????????</a></li>
				<li id="conference"><a>?????????</a></li>
				<li><a id="freeBtn" accesskey="5" title="">???????????????</a></li>
				<li id="manager"><a>????????? ?????????</a></li>
			</ul>
		</div>
	</div>
	
	<div id="main">
		<div id="top">
			<div id="banner">
			<div id="chatRoomName">??????</div>
			<div style="vertical-align: top; display: inline-block;"> <!-- ????????? -->
				<div id="chatArea">
				    <!-- ????????? ?????? ?????? -->
				    <div id="messageTextArea" >
				    
				    	<ul >
							<li id="textdiv">
							</li>
		   				</ul>
				    
				    </div>
				    
				    <!-- ?????? ????????? ??????????????? -->
				    <input type="text" id="messageText" size="40">
				    <!-- ?????? ?????? -->
				    <input id="sendBtn" type="button" value="??????" onclick="sendMessage()">
			    </div>
			</div><!-- ????????? -->
			
			</div><!-- banner -->
			
			
			
			<div id="welcome">
				<div id="chatListMemList"><!-- ????????? ??????, ???????????? -->
				<div id="chatRoom"><!-- chatRoom -->
					<input  type="button" id="chatBtn" value="????????????" onclick="popup();">
					<input id="closeBtn" type="button" value="????????????" onclick="closing()">
			    	<input class="rightBtn"  type="button" value="??? ??????" onclick="chatRoomIn()"><br><br>
			    	<input class="rightBtn"  type="button" value="??? ?????????" onclick="chatRoomOut()" id="outBtn">
					<input class="rightBtn" id="createBtn" type="button" value="??? ?????????" onclick="makeRoom()">
			    </div><!-- chatRoom -->
				<div id=chatRoom2> <!-- chatRoom2 -->
			    	<select id="chatRoomList" size="10"></select>
			    	<select id="chatRoomMemList" size="10"></select>
			    	
<!-- 			    	<div >????????? ?????? ??????</div> -->
				</div><!-- chatRoom2 -->		
			</div><!-- ????????? ??????, ????????????  -->
					<input type="text" id="newRoomName" style="display: none;"> 
			</div><!-- welcome  -->
			
			
		</div><!-- top -->
		
		<!-- ???????????? -->
		<div id="featured">
			<div class="title">
<!-- 				<h2>????????????</h2> -->
<!-- 				<span class="byline"> </span> -->
			</div>
<!-- 			<ul class="style1"> -->
<!-- 				<li class="first"> -->
<!-- 					<p class="date"><a href="#">sept<b>05</b></a></p> -->
<!-- 					<h3>11/24 ??????????????? ?????? ?????? ??????</h3> -->
<!-- 					<p><a href="#">11/24??? ??????????????? ????????? ?????? ??????????????????.</a></p> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<p class="date"><a href="#">sept<b>17</b></a></p> -->
<!-- 					<h3>????????? ????????? ?????? ??????</h3> -->
<!-- 					<p><a href="#">?????????-9/27, </a></p> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<p class="date"><a href="#">Jan<b>01</b></a></p> -->
<!-- 					<h3>Amet sed volutpat mauris</h3> -->
<!-- 					<p><a href="#">Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget, tempus et, tellus. Etiam neque. Vivamus consequat lorem at nisl. Nullam non wisi a sem semper eleifend. Etiam non felis. Donec ut ante.</a></p> -->
<!-- 				</li> -->
<!-- 				<li> -->
<!-- 					<p class="date"><a href="#">Dec<b>31</b></a></p> -->
<!-- 					<h3>Sagittis diam dolor amet</h3> -->
<!-- 					<p><a href="#">Etiam non felis. Donec ut ante. In id eros. Suspendisse lacus turpis, cursus egestas at sem. Mauris quam enim, molestie. Donec leo, vivamus fermentum nibh in augue praesent congue rutrum.</a></p> -->
<!-- 				</li> -->
<!-- 			</ul> -->
		</div>
		<div id="copyright">
			<p> Na's Company ??????: ????????? | CS center : 1588-2775</p>
			<span>&copy; ??????????????? ?????? ????????? 76 ???????????? 4??? | Fax : 042-5555-3221</span>
			<span>&copy;DESIGN BY <a href="http://templated.co" rel="nofollow">Yuri Seo</a>.</span>
		</div>
	</div>
</div>



<!-- ???????????? ??????????????? -->
	<div id=""> <!-- ?????? ?????????/?????? -->
		<div><!-- ????????? -->
		<div>
		
			
			
		
			
		</div>
		</div><!-- ????????? -->
		
	    <br>
	    <div id="connectArea">
	    	<!-- ????????? ?????? ??????????????? -->
		    ?????????ID : <input type="text" id="userId" size="20" value="<%=mem_nm%>">
		    <!-- ?????? ?????? -->
		    <input type="button" value="????????????" onclick="connectting()">
	    </div>
    </div> <!-- ?????? ?????????/?????? -->
  <script >
  
	var webSocket = null; // ????????? ?????? ??????
    var messageTextArea = document.getElementById("messageTextArea");
	var messageText = document.getElementById("messageText");
	var userText = document.getElementById("userId");
	var mem_nm = "<%=mem_nm%>";
	
	function connectting(arr){
		if(userText.value.trim()==""){
			alert("????????? ID??? ???????????????");
			userText.focus();
			return;
		}
			//????????? ?????????
			webSocket = new WebSocket("ws://192.168.0.8:8100/GMP/wsM.do");
        
    	// ?????? ?????? ???????????? 
			webSocket.onopen = function onOpen(event){
				document.getElementById("connectArea").style.display = "none";
				document.getElementById("chatRoom").style.display = "flex";
				document.getElementById("chatArea").style.display = "block";
				// webSocket.send(userText.value);
				console.log(arr);
				webSocket.send( createMessage("connect", "??????", userText.value) );
				// ?????? ?????? ????????? ??????
				for(let i = 0; i < arr.length; i++){
					webSocket.send( createMessage("create", arr[i], userText.value) );
			    		//createRoom(arr[i]);
			    }
			}
        
			//???????????? ?????? messageTextArea????????? ???????????? ????????????.
			webSocket.onmessage = function processMessge(message){
				//Json ??????
				var jsonData = JSON.parse(message.data);
				if(jsonData.message != null) {
					
					// ????????? ??????
					const li = document.getElementById("textdiv");
			    	const inputBtn = document.getElementById("inputBtn");
			        const messageTextArea = $('#messageTextArea');
			        const sd = document.createElement("div");
			        const md = document.createElement("div");
			        
			        let name = jsonData.message.substring(0,3);
			        let contents = jsonData.message.substring(5).trim();
			        
			        md.style.wordBreak="break-all";
					md.style.margin="5px 20px";
					md.style.border="3px solid #888";
					md.style.padding="10px";
					md.style.borderRadius="9px";
					md.style.backgroundColor="#FCFCFC";
					md.style.Color="#555";
					
					sd.style.margin="10px 20px 0 20px"; 
					sd.style.fontWeight="bold"; 
					// ?????? ????????? FAFAD2 ????????? ????????? C8FFFF
					if( mem_nm === jsonData.message.substring(0,4).trim()){
						 sd.style.textAlign="right"; 
						 md.style.textAlign="right";
						 md.style.backgroundColor = "#FAFAD2";
					}else if( '?????????' === jsonData.message.substring(0,3) ){	 
						 sd.style.textAlign="center"; 
						 md.style.textAlign="center"; 
						 name = "";	 
					 }else if(mem_nm !== jsonData.message.substring(0,4).trim()){
						 sd.style.textAlign="left";
						 md.style.textAlign="left";	 
						 md.style.backgroundColor = "#C8FFFF";
					 }	 
					sd.innerText += name + "\n";
					md.innerText += contents  + "\n";
					li.appendChild(sd);
		            li.appendChild(md);
		            
					messageTextArea.scrollTop(messageTextArea[0].scrollHeight);
					// ???????????? ????????? ??????
					
					messageTextArea.value += jsonData.message + "\n"
					messageTextArea.scrollTop = 9999999;
				};
					
				// ????????? ?????? ????????????
				if(jsonData.roomList != null){
					var jsonRoomList = JSON.parse(jsonData.roomList);
					var selElement = document.getElementById("chatRoomList");
					var strHtml = "";
					for(var i=0; i<jsonRoomList.length; i++){
						strHtml += "<option value='" + jsonRoomList[i] + "'>" + jsonRoomList[i] + "</option>";
					}
					selElement.innerHTML = strHtml;
				}
				
				if(jsonData.roomName != null){
					document.getElementById("chatRoomName").innerHTML = jsonData.roomName;
				}
            
				// ????????? ?????? ?????? ????????????
				if(jsonData.roomMemList != null){
					var jsonRoomMemList = JSON.parse(jsonData.roomMemList);
					var selElement = document.getElementById("chatRoomMemList");
					var strHtml = "";
					for(var i=0; i<jsonRoomMemList.length; i++){
						strHtml += "<option value='" + jsonRoomMemList[i] + "'>" + jsonRoomMemList[i] + "</option>";
					}
					selElement.innerHTML = strHtml;
				}
			}
        
			webSocket.onerror = function showErrorMsg(event) {
				alert("?????? : " + event.data);
			}
		
			webSocket.onclose = function(event){
				messageTextArea.value = "";
				messageText.value = "";
				userText.value = "";
				document.getElementById("connectArea").style.display = "block";
				document.getElementById("chatRoom").style.display = "none";
				document.getElementById("chatArea").style.display = "none";
			}
	}

	// ????????? ??????  {"command" : "????????????", "room" : "???????????????", "message" : "?????????" }
	// ?????? ?????? : "create" - ????????? ?????????, "change" - ????????? ??????, "message" - ????????? ??????, "connect" - ?????? ?????? 
	
	
		//????????? ?????????
		function sendMessage(){
			if(messageText.value.trim()==""){
				messageText.focus();
				return;
			}
			var room = document.getElementById("chatRoomName").innerHTML.trim();
			
			//webSocket.send('{"room" : "' + "??????" + '", "message" : "' + messageText.value + '"}' );
			webSocket.send( createMessage("message", room, messageText.value) );
			messageText.value = ""; 
		}
	
//////////////////////////////////////////////////////////////////////////////////////////////

	// ????????? ?????????
	function createRoom(roomName){
		var newRoom = document.getElementById("newRoomName");
		
		newRoom.value = roomName;
		
		if(newRoom.value==""){
			alert("????????? ???????????? ????????? ??? ???????????????.")
			newRoom.focus();
			return;
		}
		
		webSocket.send( createMessage("create", newRoom.value, null) );
		newRoom.value = ""; 
	}
	
	// ????????? ??????
	function chatRoomIn(){
		var selectRoom = document.getElementById("chatRoomList")
		if(selectRoom.selectedIndex==-1 || selectRoom.value==""){
			alert("????????? ???????????? ????????? ??? ???????????????.");
			return;
		}
		webSocket.send( createMessage("change", selectRoom.value, null) );
	}
	
	/* // ????????? ?????????  ==> ???, '??????' ??????????????? ??????
	function chatRoomOut(){
		webSocket.send( createMessage("change", "??????", null) );
	} */
	
	// ????????? ???????????? ???????????? ??????
	function createMessage(command, room, message){
		return '{"command" : "' + command + '", "room" : "' + room + '", "message" : "' + message + '"}'
	}
    
		function closing(){
			webSocket.close();
		}
		
		window.onbeforeunload = function(){
			closing();
		}
   
	function addStyle(){
		let crml = document.getElementById("chatRoomMemList");
		crml.style.paddingright="15px";
		crml.style.paddingtop="15px";
	}
    let arr = new Array();
	let channelarr = new Array();
	
    $.ajax({
    	url : '<%=request.getContextPath()%>/loadChat.do',
    	type : 'post',
    	async: false,
    	data : {
    		"mem_no" : <%=mem_no%>
    	},
    	success:function(res){
			dataFromDB(res);
    	},
    	error:function(){},
    	dataType:'json'
	    });
    
    function dataFromDB(res){
    	//channelarr.push('???????????????');
    	for(let i = 0; i < res.length; i++){
    		arr.push(res[i].chat_channel);
    	}
    }
    console.log(arr);
    //////////////////websocket/////////////////////////////////////////////
    connectting(arr);
    addStyle();
    
    $('#messageText').keypress(function(event){
	     if ( event.which == 13 ) {
	         $('#sendBtn').click();
	         return false;
	     }
	});
	
	$('#newRoomName').keypress(function(event){
	     if ( event.which == 13 ) {
	         $('#createBtn').click();
	         return false;
	     }
	});
    
	function popup(){
		let url = "https://cuddly-bullfrog-71.loca.lt";
		let name ="GMP ";
		let option = "width = 1100, height = 650, location=no";
		window.open(url, name, option);
		};
	
	function makeRoom(){
		let inputStr = prompt("????????? ?????? ??? ????????? ???????????????", "");
		createRoom(inputStr);
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
	
	$('#logout').on('click', function(){
		sessionStorage.clear();
		kakaoLogout();
     	setTimeout(() => {
			location.href ='<%=request.getContextPath() %>/loginPage.jsp';
		}, 900);
	});
	
	Kakao.init('58d7ec0a9f82e84f098623ce4850c88d');
	function kakaoLogout() {
	      if (Kakao.Auth.getAccessToken()) {
	        Kakao.API.request({
	          url: '/v1/user/unlink',
	          success: function (response) {
	             console.log(response)
	          },
	          fail: function (error) {
	            console.log(error)
	          },
	        })
	        Kakao.Auth.setAccessToken(undefined)
	      }
	    }  
	
	$('#calendarBtn').on('click', function(){ 
	    location.href='<%=request.getContextPath()%>/calendarController.do?mem_no='+<%=mem_no%>;
	 });
	
	$('#chattingBtn').on('click', function(){
		setTimeout(() => {
			window.location.reload();
		}, 700);
	 });

    </script>
</body>
</html>