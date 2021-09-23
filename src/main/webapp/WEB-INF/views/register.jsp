<%@ include file="/common/inc/common.jsp"%>

<html>
<head>
<%@ include file="/common/inc/head.jsp"%>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form > button, form > div {
	width : 100% ;
    margin-bottom: 20px !important ;
}
#google{
	padding-bottom: 8px;
	font-weight : 900 ; 
}
.container{
		  min-height: 70vh ;
		  display: flex ;
		  justify-content: center ;
		  align-items: center ;
		  font-family: 'Roboto', sans-serif ;
}
</style>
</head>
<body>
	<%@ include file="/common/inc/loginHeader.jsp"%>
	<div class="container">
		<form action="loginOk" method="post">
			<div>회원가입</div>
			<button
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
				type="submit"><span class="material-icons" id="google">G</span> google로 계속하기</button>
			<button
				class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
				type="submit">
				<span class="material-icons"> apple </span>apple로 계속하기
			</button>

			<div>
				<label>User ID:</label><input type="text" name="userid" />
			</div>
			<div>
				<label>Password:</label><input type="password" name="password" />
			</div>
			<button class="mdl-button mdl-js-button" type="submit">login</button>
			<button class="mdl-button mdl-js-button" type="submit">Register</button>
		</form>
	</div>
	<%@ include file="/common/inc/footer.jsp"%>
</body>
</html>
