
<%@ include file="/common/inc/common.jsp"%>

<html>
<head>

<%@ include file="/common/inc/head.jsp"%>
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
		var a = confirm("정말로 삭제하시겠습니까?");
		if (a)
			location.href = 'deleteok/' + id;
	}
</script>
</head>
<body>
	<%@ include file="/common/inc/userHeader.jsp"%>
	<h1>자유게시판</h1>
	<table id="list" width="90%">
		<tr>
			<th>Id</th>
			<th>Category</th>
			<th>Title</th>
			<th>Writer</th>
			<th>Content</th>
			<th>Regdate</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${list}" var="u">
			<tr>
				<td>${u.seq}</td>
				<td>${u.category}</td>
				<td>${u.title}</td>
				<td>${u.writer}</td>
				<td>${u.content}</td>
				<td>${u.regdate}</td>
				<td><a href="editform/${u.seq}">Edit</a></td>
				<td><a href="javascript:delete_ok('${u.seq}')">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<br />
	<a href="add">Add New Post</a>
	<%@ include file="/common/inc/footer.jsp"%>

</body>
</html>