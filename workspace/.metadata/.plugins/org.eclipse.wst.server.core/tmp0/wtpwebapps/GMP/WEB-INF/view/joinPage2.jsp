<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> <!-- CDN방식임!! -->
   <title>Na's 회원가입</title>
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="../js/bootstrap.js"></script>
   <%
   if( request.getAttribute("kkoid") != null ){
   String kkoidd = (String)request.getAttribute("kkoid");
   }
   %>
   
   <script type="text/javascript">
   
   let reg_required = /.{1,}/;
   let reg_name1 = /^[가-힣]+$/; // 한글만
   let reg_name2 = /^[a-zA-z]+$/; // 영문만
   let reg_name3 = /^[a-z]+$/; // 영문 소문자만
   let reg_name4 = /^[A-Z]+$/; // 영문 대문자만
   let reg_name5 = /^[가-힣a-zA-Z]+$/; // 한글 + 영문만
   let reg_id1 = /^[a-z0-9_-]{4,20}$/; // 소문자 + 숫자 + 언더바/하이픈 허용 4~20자리
   let reg_id2 = /^[A-Za-z]{1}[A-Za-z0-9_-]{3,19}$/ // 반드시 영문으로 시작 숫자+언더바/하이픈 허용 4~20자리
   let reg_pw1 = /^[a-z0-9_-]{6,18}$/; // 단순 6~18자리
   let reg_pw2 = /(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{6,24}/; // 문자와 특수문자 조합의 6~24 자리
   let reg_pw3 = /(?=.*\d)(?=.*[a-zA-ZS]).{8,}/; // 문자, 숫자 1개이상 포함, 8자리 이상
   let reg_email =/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; // 길이까지 확실한 검증
   let reg_num = /^[0-9]{8,13}$/; // 전화번호 숫자만
   let reg_mobile = /^\d{3}-\d{3,4}-\d{4}$/; // 휴대폰 번호
   let reg_tel = /^\d{2,3}-\d{3,4}-\d{4}$/; // 일반 전화 번호
//    let reg_num = /([0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[1,2][0-9]|3[0,1]))/;

   
   function idCheck(){
       let checkId = $('#mem_id').val();
       console.log(checkId);
    
       $.ajax({
          url : '<%=request.getContextPath()%>/member/idCheckController.do',
          data : {
        	  "choice" : "id체크",
             'checkId' : checkId
          },
          type : 'post',
          success : function(res){
             console.log(res);
			 if(checkId.trim()==""){
            	 res=1;
                 alert("빈 공백입니다.");
			 }else if(!reg_id2.test(checkId)){
			 	res=1;
// 			    alert('error!');
             } else {
            	 res=0;
             }
             if(res === 1){
            	 let str = "<span style='color : red'>사용불가&nbsp;&nbsp;<span>";
            	 $('#Availability').html(str);
            	 
             }else{
            	 let str = "<span style='color : blue'>사용가능&nbsp;&nbsp;<span>";
            	 $('#Availability').html(str);
             }
          },
          error : function(xhr){
        	  console.log(xhr);
          },
          dataType : 'json'
       })// ajax   
    };
    
    $(function(){
    	let mem_pw = $('#mem_pw').val;
    	
    	
        $('#mem_pw').keyup(function(){
	    	if(!reg_pw1.test(mem_pw)){
	                $('#passCheck').html('6-18자리를 맞춰주세요 <br><br>');
	                $('#passCheck').css('color', '#f82a2aa3');
	    	} else {
	        	if($('#mem_pw').val() != $('#userPassword2').val()){
	                $('#passCheck').html('비밀번호 일치하지 않음<br><br>');
	                $('#passCheck').css('color', '#f82a2aa3');
	              } else{
	                $('#passCheck').html('비밀번호 일치함<br><br>');
	                $('#passCheck').css('color', '#199894b3');
	              }
	    	}
        });

        $('#userPassword2').keyup(function(){

        	
            if($('#mem_pw').val() != $('#userPassword2').val()){
              $('#passCheck').html('비밀번호 일치하지 않음<br><br>');
              $('#passCheck').css('color', '#f82a2aa3');
            } else{
              $('#passCheck').html('비밀번호 일치함<br><br>');
              $('#passCheck').css('color', '#199894b3');
            }

        });
        
	    $('#mem_tel').keyup(function(){
	    	if(!reg_mobile.test($('#mem_tel').val())){
	              $('#telCheck').html('올바른 번호가 아닙니다.<br><br>');
	              $('#telCheck').css('color', '#199894b3');
	    		
	    	} else {
	              $('#telCheck').html('사용가능<br><br>');
	              $('#telCheck').css('color', '#199894b3');
	    	}
	    });
	    	
        
    });
    	
    	
// 		$.ajax({
<%-- 			url : '<%=request.getContextPath()%>/member/idCheckController.do', --%>
// 			data : {
// 				'choice' : '비밀번호확인'
// 				'mem_pw' : mem_pw,
// 				'pass2'	 : pass2
// 			},
// 			type: 'post',
// 			dataType : 'json',
// 			success : function(res) {
// 				if(mem_pw==pass2){
// 					alert('안녕');
// 				}else {
// 					alert('gktpdy');
// 				}
// 			},
// 		   error : function(xhr){
//         	  console.log(xhr);
//           }
// 		});
// 	});
    
    function resister1(){
    	location.href='<%=request.getContextPath()%>/member/join2.do';
    	  let id = $('#mem_id').val();
          let pw = $('#mem_pw').val();
          let name = $('#mem_nm').val();
          let birth = $('#mem_birth').val();
          let tel = $('#mem_tel').val();
          let addr1 = $('#mem_addr1').val();
          let addr2 = $('#mem_addr2').val();
          let mail = $('#mem_mail').val();
          
    }
    
    
    
    function resisterGMP(){
       let id = $('#mem_id').val();
       //console.log('resisterGMP 에서의 ', id);
       let pw = $('#mem_pw').val();
       let name = $('#mem_nm').val();
       let birth = $('#mem_birth').val();
       let tel = $('#mem_tel').val();
       let addr1 = $('#mem_addr1').val();
       let addr2 = $('#mem_addr2').val();
       let mail = $('#mem_mail').val();
       //console.log('joinPage.jsp에서의 ', id);
       //console.log('joinPage.jsp에서의 ', pw);
       $.ajax({
          url : '<%=request.getContextPath()%>/member/join2.do',
          data : {
             'mem_id' : id,
             'mem_pw' : pw,
             'mem_nm' : name,
             'mem_birth' : birth,
             'mem_tel' : tel,
             'mem_addr1' : addr1,
             'mem_addr2' : addr2,
             'mem_mail' : mail
          },
          type : 'post',
          success : function(res){
        	  if(res.trim() > 0) {
	             alert('회원가입이 완료되었습니다')
	             location.href = '<%=request.getContextPath()%>/loginPage.jsp'        		  
        	  }
          },
          error : function(xhr){
        	  console.log(xhr);
          }
       });//ajax
    }
 </script>
 
 
   
</head>
<body>
 <div class="container">
      <form method="post" action="<%=request.getContextPath() %>/member/join2.do">
         <table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
            <thead>
               <tr>
                  <th colspan="3"><h4>회원가입 양식</h4></th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td style="width: 110px;"><h5>아이디</h5></td>
                  <td><input class="form-control" type="text" id="mem_id"  maxLength="20"></td>
                  <td style="width: 160px;"><span id="Availability">id 입력 &nbsp;&nbsp;</span><button class="btn btn-primary" onclick="idCheck();" type="button">중복체크</button></td>   
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>비밀번호</h5></td>
                  <td colspan="2"><input class="form-control" type="password" id="mem_pw" name="mem_pw" maxLength="20"></td>
               </tr>
                
                <tr>
                  <td style="width: 110px;"><h5>비밀번호 확인</h5></td>
                  <td><input class="form-control" type="password" id="userPassword2" name="userPassword2" maxLength="20"></td>
                  <td style="width: 80px;"><span id="passCheck">비밀번호 확인</span></td>
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>이름</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="mem_nm" name="mem_nm" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>생년월일</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="mem_birth" name="mem_birth" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>전화번호</h5></td>
                  <td><input class="form-control" type="text" id="mem_tel" name="mem_tel" maxLength="20"></td>
                  <td style="width: 80px;"><span id="telCheck">-를 붙여주세요</span></td>
                  
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>기본주소</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="mem_addr1" name="mem_addr1" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>상세주소</h5></td>
                  <td colspan="2"><input class="form-control" type="text" id="mem_addr2" name="mem_addr2" maxLength="20"></td>
               </tr>
               <tr>
                  <td style="width: 110px;"><h5>이메일</h5></td>
                  <td colspan="2"><input class="form-control" type="email" id="mem_mail" name="mem_mail" maxLength="20"></td>
                  
               </tr>
               <tr>
                  <td style="text-align: left" colspan="3"><input id="joinBtn" class="btn btn-primary pull-right" type="button" value="회원가입" onclick="resisterGMP();"></td>
               </tr>      
            </tbody>
         </table>
      </form>
      
      
   </div> 
</body>
</html>