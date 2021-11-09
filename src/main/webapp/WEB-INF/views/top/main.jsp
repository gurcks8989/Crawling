<%@ page contentType="text/html; charset=UTF-8" import="com.spring.user.UserVO"%>
<%@ include file="/common/inc/common.jsp"%>

<html>
<head>
<%@ include file="/common/inc/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>free board</title>
<style>
#list {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#list td, #list th {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

#list tr:nth-child(even) {
	background-color: #f2f2f2;
}

#list tr:hover {
	background-color: #ddd;
}

#list th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: center;
	background-color: #006bb3;
	color: white;
}
</style>
<script>
	function delete_ok(id) {
		var a = confirm("Ã¬Â ÂÃ«Â§ÂÃ«Â¡Â Ã¬ÂÂ­Ã¬Â ÂÃ­ÂÂÃ¬ÂÂÃªÂ²Â Ã¬ÂÂµÃ«ÂÂÃªÂ¹Â?");
		if (a)
			location.href = 'deleteok/' + id;
	}
</script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
</head>
<body>
	<form action="logout" method="post" id="userForm">
		<div>
			<!-- Title -->
			<div class="mdl-layout-spacer"></div>
			<!-- Add spacer, to align navigation to the right -->
			<div class="main_logo">
				<a target="_blank" onclick="window.location.href='../top/top'">D<span
					id="lower">elivery</span><br />C<span id="lower">rew</span></a>
				<!-- <img src="../resources/arc/image/logo.png" alt="Watch Tower" class="logo" onclick="window.location.href='../top/top'"> -->
			</div>
			<div class="mdl-layout-spacer"></div>
			<!-- Navigation. We hide it in small screens. -->
			<nav class="mdl-navigation">
				<div role="button" class="mdl-layout__drawer-button_right"
					style="display: none;">
					<span class="material-icons">menu</span>
				</div>
				<a class="mdl-navigation__link mdl-layout-title" href="#">
					<%= ((UserVO)session.getAttribute("login")).getUsername() %>
				</a>
				<div class="mdl-navigation__link mdl-layout-title" id="logout">Logout</div>
			</nav>
		</div>
	</form>
	<%@ include file="/common/inc/footer.jsp"%>
	
<script>
$(document).ready(function() {
    var logout = document.getElementById('logout');
    var frame = document.getElementById('frame');
    logout.onclick = function() {
    	var testPopUp = null ;
    	var login_api = '<%= (String)((UserVO)session.getAttribute("login")).getLoginApi() %>' ;
    	if('Naver' == login_api){
    		localStorage.removeItem("com.naver.nid.oauth.state_token") ;
    		localStorage.removeItem("com.naver.nid.access_token") ;
    	}
    	document.getElementById('userForm').submit();
	}
});

</script>
</body>
</html>