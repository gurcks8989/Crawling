
function onSignIn(profile, method){
    document.getElementById('loginApi').value = method ;
    document.getElementById('userid').value = profile.getId();
    document.getElementById('username').value = profile.getName() ;
    document.getElementById('email').value = profile.getEmail() ;

    document.getElementById('loginForm').submit();
    }

//google api
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
		gapi.auth2.getAuthInstance().attachClickHandler('googleLogin', options, onGoogleSignIn, connectionError);
	})
}

function onGoogleSignIn(googleUser) {
    var profile = googleUser.getBasicProfile();
	onSignIn(profile, 'Google') ;
}

function connectionError(e){		
	console.log(e);
}

//naver api
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
    		
            if( email == undefined || email == null) {
				alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
				naverLogin.reprompt();
				return;
			}

        	onSignIn(naverLogin.user, 'Naver') ;
            alert(naverLogin.user.getName());
            alert(naverLogin.user.getEmail());
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