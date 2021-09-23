
<%@ include file="/common/inc/common.jsp"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/common/inc/head.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/common/inc/header.jsp"%>
	<h1>Hello world!</h1>
	<P>The time on the server is ${serverTime}.</P>

	<div>
		Tomcat 서버 버전:
		<%=application.getServerInfo()%>
	</div>
	<div>
		Servlet 버전:
		<%=application.getMajorVersion()%>.<%=application.getMinorVersion()%>
	</div>
	<div>
		JSP 버전:
		<%=JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion()%>
	</div>

	<%@ include file="/common/inc/footer.jsp"%>
</body>
</html>