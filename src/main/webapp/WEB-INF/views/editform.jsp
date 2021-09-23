
<%@ include file="/common/inc/common.jsp"%>

<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

	<%@ include file="/common/inc/header.jsp"%>
	<h1>Edit Form</h1>
	<form:form commandName="u" method="POST" action="../editok">
		<form:hidden path="seq" />
		<table>
			<tr>
				<td>Category:</td>
				<td><form:input path="category" /></td>
			</tr>
			<tr>
				<td>Title:</td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Writer:</td>
				<td><form:input path="writer" /></td>
			</tr>
			<tr>
				<td>Content:</td>
				<td><form:textarea cols="50" rows="5" path="content" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Edit Post" /> <input
					type="button" value="Cancel" onclick="history.back()" /></td>
			</tr>
		</table>
	</form:form>

	<%@ include file="/common/inc/footer.jsp"%>
</body>
</html>