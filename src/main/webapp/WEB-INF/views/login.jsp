
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

.icon{
	width:20px ;
}

.row > div{
    display: flex;
    align-items: center;
}

#register_text{
	font-size:20px;
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

</head>
<body>
	<div class="login">
		<form action="loginOk" method="post" id="loginForm">
			<input type="hidden" name="loginApi" id="loginApi"/>
			<input type="hidden" name="userid" id="userid"/>
			<input type="hidden" name="username" id="username"/>
			<input type="hidden" name="email" id="email"/>
			<input type="hidden" name="photo" id="photo"/>
			
			<div class="row">
				<img alt="Main Icon" src="./img/mainIcon.jpg">
			</div>
			<div class="row">
				<span id="register_text">대학교 키워드 알리미</span>
			</div>
			<div class="row">
				<div class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="googleLogin">
					<img class="icon" alt="Google Icon" src="./img/google.png"><span> 구글 계정으로 계속하기</span>
				</div>
			</div>
			<div class="row">
				<div class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" id="naverIdLogin_loginButton">
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