<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width initial-scale=1">
<script src="js/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bootstrap.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css">
<script src="<%=request.getContextPath() %>/js/bootstrap.js"></script>
<script type="text/javascript" src="js/moment.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<!-- 키 58d7ec0a9f82e84f098623ce4850c88d -->
<title>Na's Company</title>
<style id="text" type="text/css">
</style>
</head>
<script type="text/javascript">
</script>

<body>
	<nav class="navigation navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
 	<p class="s1">Na's Company</p>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#"></a>
    </li>
  </ul>
</nav>

   <div class="main">
   	<header class="navbar navbar-default">
      <div class="collapse navbar-collapse"
         id="bs-example-navbar-collapse-1">
         <ul class="nav navbar-nav">
            <li><a href="#">메인</a></li>
            <li><a href="#">게시판</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li class="dropdown"><a href="#" class="dropdown-toogle"
               data-toggle="dropdown" role="button" aria-haspopup="true"
               aria-expanded="false">접속하기<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li class="active"><a href="#">로그인</a></li>
                  <li><a href="#">회원가입</a></li>
               </ul></li>
         </ul>
      </div>
   </header>
   
   
   <div class="container">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
         <div class="jumbotron" style="padding-top: 20px;">
         
            <form id="form" method="post" action="<%=request.getContextPath() %>/member/login.do">
               <h3 style="text-align: center;">로그인 화면</h3>
               <div class="form-group">
                  <input type="text" class="form-control" placeholder="아이디"
                     name="mem_id" maxlength="20">
               </div>
               <div class="form-group">
                  <input type="password" class="form-control" placeholder="비밀번호"
                     name="mem_pw" maxlength="20">
               </div>
               <input type="submit" class="btn btn-primary form-control"
                  value="로그인">
                  <br><br>
               <input id="resisterBtn" type="button" class="btn btn-primary form-control"
                  value="회원가입" 
                  onClick="location.href='<%=request.getContextPath() %>/member/join2.do'">
                  <br><br>
               <div class="kakao">   
               <a id="kakao-login-btn" ></a>
               <a href="http://developers.kakao.com/logout"></a>
                     
<!--                <ul class="logout"> -->
<!--                   <li onclick="kakaoLogout();"> -->
<!--                      <a href="javascript:void(0)"><br> -->
<!--                         <span>카카오 로그아웃</span> -->
<!--                        </a> -->
<!--                   </li> -->
<!--                </ul> -->
               </div> 
            </form> 

         </div>
      </div>
      <div class="col-lg-4"></div>
   </div>
   	
   </div>   
<script>
Kakao.init('58d7ec0a9f82e84f098623ce4850c88d'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단

Kakao.Auth.createLoginButton({
   container : '#kakao-login-btn',
   success:function(res){
        Kakao.API.request({
             url: '/v2/user/me',
             success: function (res) {
                kkoLoginJava(res);
             },
             fail: function (error) {
               console.log(error)
             },
           })// Kakao.API.request
   },
   fail:function(err){
      alert( JSON.stringify(err) );
   },
});


//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
       success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
             console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })//Kakao.API.request
      }, //success function(response)
      fail: function (error) {
        console.log(error)
      },
    })
  }// kakaoLogin
  
//카카오로그아웃  
  function kakaoLogout() {
      if (Kakao.Auth.getAccessToken()) {
        Kakao.API.request({
          url: '/v1/user/unlink',
          success: function (response) {
             console.log(response)
          },
          fail: function (error) {
            console.log(error);
          },
        })
        Kakao.Auth.setAccessToken(undefined)
      }
    }  
  
  function kkoLoginJava(loginInfo){
   console.log(loginInfo);
   // false면 정보있음
   let isemail = loginInfo.kakao_account.email_needs_agreement;
   console.log(isemail);
   let email;
   
   if( !isemail ){
   email = loginInfo.kakao_account.email;
   }
   
   let isgender = loginInfo.kakao_account.gender_needs_agreement;
   console.log(isgender);
   let gender;
   
   if( !isgender ){
      gender = loginInfo.kakao_account.gender;
   }
     let nickname = loginInfo.properties.nickname;
     let id = loginInfo.id;
     console.log(loginInfo.connected_at);
     
     let start = loginInfo.connected_at;
     start = moment(start).format('YYYY-MM-DD HH:mm:ss');
     console.log(start);
  
     $.ajax({
        url : '/GMP/member/kkoLogin.do',
        type : 'post',
        data : {
           'id' : id
        },
        success:function(res){
           console.log(res);
           if(res.mem_kko ==="0"){
              alert("첫 로그인입니다 회원가입 페이지로 이동합니다.");   
           location.href ='<%=request.getContextPath() %>/member/join.do?<%="kkoId"%>='+id+'&<%="isemail"%>='+isemail+'&<%="isgender"%>='+isgender+'&<%="email"%>='+email+'&<%="gender"%>='+gender+'&<%="nickname"%>='+nickname
           } else{
               console.log(res);
               location.href ='<%=request.getContextPath() %>/member/login.do?<%="mem_id"%>='+res.mem_id+'&<%="mem_pw"%>='+res.mem_pw+'&<%="dept_no"%>='+res.dept_no+'&<%="mem_nm"%>='+res.mem_nm;
           }

        },
        error:function(error){
           console.log(error);
        },
        dataType : 'json'
        	
        
     });//ajax   
  }
</script>
</body>
</html>