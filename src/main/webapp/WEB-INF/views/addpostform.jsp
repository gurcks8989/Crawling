<%@ include file="/common/inc/common.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/common/inc/header.jsp"%>

<h1>Add New Post</h1>
<form action="addok" method="post">
<table>
<tr><td>Category:</td><td><input type="text" name="category"/></td></tr>
<tr><td>Title:</td><td><input type="text" name="title"/></td></tr>
<tr><td>Writer:</td><td><input type="text" name="writer"/></td></tr>
<tr><td>Content:</td><td><textarea cols="50" rows="5" name="content"></textarea></td></tr>
<tr><td><a href="list">View All Records</a></td>
	<td align="right"><input type="submit" value="Add Post"/></td>
	</tr>
</table>
</form>
	<%@ include file="/common/inc/footer.jsp"%>

</body>
</html>