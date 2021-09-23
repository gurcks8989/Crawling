
<%@ include file="/common/inc/common.jsp"%>

<html>
<head>
<%@ include file="/common/inc/head.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body{
	padding: 30px
}
#google{
	padding-bottom: 8px;
	font-weight : 900 ; 
}

#apple{
	padding-bottom: 8px;
	font-weight : 900 ; 
}
.container{
		  min-height: 70vh ;
		  display: flex ;
		  justify-content: center ;
		  align-items: center ;
		  font-family: 'Roboto', sans-serif ;
		  padding: 12px;
}

#emailField{
	width:100%;
	margin-right: 3px
}
#pwField{
	width:100%;
	margin-left: 3px
}
.text{
	display:flex;
}
.field{
justify-content:center;
}
.register{
	display: flex;
	margin-bottom: 10px;
}

.login{
	justify-content:center;
}

#register_text{
	font-size:20px;
}

#googleLogin, #appleLogin{
width: 70%;
margin-bottom: 10px;
}
.google{
display:flex;
}

.apple {
justify-content: center;
}


</style>

<!-- Add own OAuth2.0 client ID in content-->
<meta name ="google-signin-client_id" content="757781982964-lfd3nk916jv46qmf66npttq8q0fvd296.apps.googleusercontent.com">
<!-- for using google API script -->
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

<!-- for using kakao API script -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<!-- for using naver API script -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
<script>
Kakao.init('90e74cc683cbd55148d46e0ef4f4fa6c'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단

</script>

</head>
<body>
	<%@ include file="/common/inc/loginHeader.jsp"%>
	<div class="container">
		<form action="loginOk" method="post" id="loginForm">
			<input type="hidden" name="loginApi" id="loginApi"/>
			<input type="hidden" name="userid" id="userid"/>
			<input type="hidden" name="username" id="username"/>
			<input type="hidden" name="email" id="email"/>
			<input type="hidden" name="photo" id="photo"/>
			
			<div id="register_text">Login</div>
			
			<div class ="google apple">
				<div class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="googleLogin">
					<span class="material-icons">G</span> google로 계속하기
				</div>
			</div>
			<div class ="google apple">
				<div class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" onclick="kakaoLogin()">
					<span class="material-icons">K</span> kakao로 계속하기
				</div>
			</div>
			<div class ="google apple">
				<div class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="naverIdLogin_loginButton">
					<span class="material-icons">N</span> naver로 계속하기
				</div>
			</div>
		</form>
	</div>
	<%@ include file="/common/inc/footer.jsp"%>
	
<script>
//처음 실행하는 함수
function init() {
	gapi.load('auth2', function() {
	    /* Ready. Make a call to gapi.auth2.init or some other API */
		gapi.auth2.init();
		options = new gapi.auth2.SigninOptionsBuilder();
		options.setPrompt('select_account');
        // 추가는 Oauth 승인 권한 추가 후 띄어쓰기 기준으로 추가
		options.setScope('email profile openid');
        // 인스턴스의 함수 호출 - element에 로그인 기능 추가
        // GgCustomLogin은 li태그안에 있는 ID, 위에 설정한 options와 아래 성공,실패시 실행하는 함수들
		gapi.auth2.getAuthInstance().attachClickHandler('googleLogin', options, onSignIn, connectionError);
	})
}

function onSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
    document.getElementById('loginApi').value = 'Google' ;
    document.getElementById('userid').value = profile.getId();
    document.getElementById('username').value = profile.getName() ;
    document.getElementById('email').value = profile.getEmail() ;
    document.getElementById('photo').value = profile.getImageUrl() ;

    document.getElementById('loginForm').submit();
}

function connectionError(e){		
	console.log(e);
}
</script>

<script>

//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
       	     document.getElementById('loginApi').value = 'Kakao' ;
       	     document.getElementById('userid').value = response.id;
             document.getElementById('username').value = response.properties.nickname ;
          	 document.getElementById('email').value = response.kakao_account.email ;
          	 document.getElementById('photo').value = response.properties.thumbnail_image ;

          	 document.getElementById('loginForm').submit();
          },
          fail: function (error){
        	  console.log(error) ;
          }
        }) ;
      },
      fail: function (error){
    	  console.log(error) ;
      }
    })
  }
// //카카오로그아웃  
// function kakaoLogout() {
//     if (Kakao.Auth.getAccessToken()) {
//       Kakao.API.request({
//         url: '/v1/user/unlink',
//         success: function (response) {
//         	console.log(response)
//         },
//         fail: function (error) {
//           console.log(error)
//         },
//       })
//       Kakao.Auth.setAccessToken(undefined)
//     }
//   }  
</script>

<script>

var naverLogin = new naver.LoginWithNaverId(
		{
			clientId: "uqK6tnfeBYHBfHgrPdiX", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
			callbackUrl: "http://localhost:8080/Delivery_Crew/login/login", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
			isPopup: false,
			callbackHandle: true
		}
	);	

naverLogin.init();

window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
    		
			console.log(naverLogin.user); 
    		
            if( email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				naverLogin.reprompt();
				return;
			}
		} else {
			console.log("callback 처리에 실패하였습니다.");
		}
	});
});


var testPopUp;
function openPopUp() {
    testPopUp= window.open("https://nid.naver.com/nidlogin.logout", "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,width=1,height=1");
}
function closePopUp(){
    testPopUp.close();
}

function naverLogout() {
	openPopUp();
	setTimeout(function() {
		closePopUp();
		}, 1000);
}
</script>
</body>
</html>