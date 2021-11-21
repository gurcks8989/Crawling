<%@ page contentType="text/html; charset=UTF-8" import="com.spring.user.UserVO"%>
<%@ include file="/common/inc/common.jsp"%>

<html>
<head>
<%@ include file="/common/inc/head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.indigo-pink.min.css">
<script defer src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    
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

.col-sm-1{
	width: auto;
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

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="javascript:void(0)">Crawl</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="mynavbar">
                <ul class="navbar-nav me-auto">
                    <li class="nav-item">
                        <a class="nav-link"></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"></a>
                    </li>
                </ul>
                <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.open('https://github.com/gurcks8989/Crawling')">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                        class="bi bi-github" viewBox="0 0 16 16">
                        <path
                            d="M8 0C3.58 0 0 3.58 0 8c0 3.54 2.29 6.53 5.47 7.59.4.07.55-.17.55-.38 0-.19-.01-.82-.01-1.49-2.01.37-2.53-.49-2.69-.94-.09-.23-.48-.94-.82-1.13-.28-.15-.68-.52-.01-.53.63-.01 1.08.58 1.23.82.72 1.21 1.87.87 2.33.66.07-.52.28-.87.51-1.07-1.78-.2-3.64-.89-3.64-3.95 0-.87.31-1.59.82-2.15-.08-.2-.36-1.02.08-2.12 0 0 .67-.21 2.2.82.64-.18 1.32-.27 2-.27.68 0 1.36.09 2 .27 1.53-1.04 2.2-.82 2.2-.82.44 1.1.16 1.92.08 2.12.51.56.82 1.27.82 2.15 0 3.07-1.87 3.75-3.65 3.95.29.25.54.73.54 1.48 0 1.07-.01 1.93-.01 2.2 0 .21.15.46.55.38A8.012 8.012 0 0 0 16 8c0-4.42-3.58-8-8-8z">
                        </path>
                    </svg>
                </button>
				
				<form action="logout" method="post" id="userForm">
                	<button class="btn btn-sm btn-outline-secondary" type="button" id="logout">Logout</a>
				</form>
            </div>
        </div>
    </nav>

    <div class="container mt-3">
        <form role="form" action = "/keyword/handong/insert" method="get">
            <div class="row">    			
                <div class="col-sm-1">
                    <input type="submit" class="btn btn-outline-secondary" value="+">
            	</div>
        	</div>
        </form>
    </div>

        <div class="container mt-3">
            <ul class="nav nav-tabs nav-justified">
                <li class="nav-item">
                    <a class="nav-link active" href="#">전체공지</a>
                </li>
            </ul>
        </div>

        <div class="container mt-3">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>카테고리</th>
                        <th>제목</th>
                        <th>link</th>
                        <th>시간</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${noticeList}" var="CrawlingVO">
                         <tr>
                            <td>${CrawlingVO.noticeNum}</td>
 							<td>${CrawlingVO.category}</td>
 							<td>${CrawlingVO.title}</td>
 							<td>${CrawlingVO.link}</td>
 							<td>${CrawlingVO.ctime}</td>
                         </tr>
                     </c:forEach>
                </tbody>
            </table>
        </div>
                    
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