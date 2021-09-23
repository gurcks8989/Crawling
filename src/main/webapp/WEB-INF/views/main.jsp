
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
		var a = confirm("ì ë§ë¡ ì­ì íìê² ìµëê¹?");
		if (a)
			location.href = 'deleteok/' + id;
	}
</script>
</head>
<body>
	<%@ include file="/common/inc/userHeader.jsp"%>
	<form method="POST">
		<div>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					한식
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					분식
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					카페
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					일식
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/chicken">
					치킨
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					피자
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					양식
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					중국집
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					족발
				</button>
			</span>
			<span class="mdl-badge mdl-badge--overlap" data-badge="1">
				<button class="mdl-button mdl-js-button mdl-button--icon" type="submit" formaction="../food/korean">
					전체
				</button>
			</span>
		</div>
	</form>
	<%@ include file="/common/inc/footer.jsp"%>
</body>
</html>