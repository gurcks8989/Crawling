
<%@ include file="/common/inc/common.jsp"%>

<html>
<head>
<%@ include file="/common/inc/head.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

body{
	padding: 30px ;
}

.login{
    height: 90vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.row > div{
    display: flex;
    align-items: center;
}

#title{
	margin-bottom : 10px ;
}

#register_text{
	font-size:20px;
}

#googleLogin{
    padding: 4px;
    background: #e0e0e0;
}

</style>
<!-- for using google API script -->
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>

<!-- content에 자신의 OAuth2.0 클라이언트ID를 넣습니다. -->
<meta name ="google-signin-client_id" content="312316665113-ffktkoeu66githas66n2g89uik460ebr.apps.googleusercontent.com">
 
<!-- for using naver API script -->
<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.2.js" charset="utf-8"></script>
</head>
<body>
	<div class="login">
		<form action="loginOk" method="post" id="loginForm">
			<input type="hidden" name="loginApi" id="loginApi"/>
			<input type="hidden" name="userid" id="userid"/>
			<input type="hidden" name="username" id="username"/>
			<input type="hidden" name="email" id="email"/>
			<input type="hidden" name="photo" id="photo"/>
			
			<div id="title">
				<div class="row">
					<img alt="Main Icon" src="./img/mainIcon.jpg">
				</div>
				<div class="row">
					<span id="register_text">대학 공지 키워드 알리미</span>
				</div>
			</div>
			<div class="row">
				<div id="googleLogin">
					<a id="googleLogin_loginButton" href="javascript:void(0)">
						<img class="icon" alt="Google Icon" src="./img/google.png" height="40" width="auto"><span> 구글 계정으로 계속하기</span>
					</a>
				</div>
			</div>
			<div class="row">
				<div id="naverIdLogin">
					<img class="icon" alt="Naver Icon" src="./img/naver.png"><span> 네이버 계정으로 계속하기</span>
				</div>
			</div>
		</form>
	</div>

	<%@ include file="/common/inc/footer.jsp"%>
	
<script>
//처음 실행하는 함수
function init() {
	gapi.load('auth2', function() {
	    //Ready. Make a call to gapi.auth2.init or some other API
		auth2 = gapi.auth2.init() ;
	    options = new gapi.auth2.SigninOptionsBuilder();
		options.setPrompt('select_account');
		options.setScope('email profile openid');
		gapi.auth2.getAuthInstance().attachClickHandler('googleLogin', options, onSignIn, onSignInFailure) ;
	});
}
	
function onSignIn(googleUser) {
	var profile = googleUser.getBasicProfile();
	console.log(profile) ;
    document.getElementById('loginApi').value = "Google" ;
    console.log(document.getElementById("loginApi").value);
    document.getElementById('userid').value = profile.getId();
    document.getElementById('username').value = profile.getName() ;
    document.getElementById('email').value = profile.getEmail() ;
    document.getElementById('loginForm').submit();
}

function onSignInFailure(t){		
	console.log(t);
}

</script>

<script>
var naverLogin = new naver.LoginWithNaverId(
	{
		clientId: "Rqhf62OB8KrndPR2V5CU", //내 애플리케이션 정보에 cliendId를 입력해줍니다.
		secret: "H5jdQj1fLL", //내 애플리케이션 정보에 secret를 입력해줍니다.
		callbackUrl: "http://localhost:8080/keyword/", // 내 애플리케이션 API설정의 Callback URL 을 입력해줍니다.
		isPopup: false,
		callbackHandle: true,
		loginButton: {color: "green", type: 3, height: 40} /* 로그인 버튼의 타입을 지정 */
	}
);	

naverLogin.init();

window.addEventListener('load', function () {
	naverLogin.getLoginStatus(function (status) {
		if (status) {
			var email = naverLogin.user.getEmail(); // 필수로 설정할것을 받아와 아래처럼 조건문을 줍니다.
    		
			console.log(naverLogin.user); 
    		
            if(email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				naverLogin.reprompt();
				return;
			}
            
            var profile = naverLogin.user ;

            document.getElementById('loginApi').value = "Naver" ;
            document.getElementById('userid').value = profile.getId();
            document.getElementById('username').value = profile.getName() ;
            document.getElementById('email').value = profile.getEmail() ;
            document.getElementById('loginForm').submit();
		} else {
			console.log("callback 처리에 실패하였습니다.");
		}
	});
});
</script>
</body>
</html>