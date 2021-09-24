<%@ page contentType="text/html; charset=UTF-8" import="com.spring.user.UserVO"%>
<!--Main Navigation-->
<!-- Loading -->

<%@ include file="/common/inc/headerStyle.jsp"%>

<div id="loading"></div>
<div id="loadingAjx">
	<div id="loading_img" class="timer-loader"></div>
	<div id="loading_message"></div>
</div>
<!-- HEADER -->
<div class="body">
<div class="outline"></div>
<div class="divice">
	<!-- 12 프로: 146.7 mm (5.78 in) H 71.5 mm (2.81 in) W 7.4 mm (0.29 in) D 1284 x 2778 PX -->
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<header class="mdl-layout__header">
			<div class="mdl-layout__header-row">
				<!-- Title -->
				<span class="mdl-layout-title mdl-layout--large-screen-only">Menu</span>
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
						<c:set var="photo" value='<%= ((UserVO)session.getAttribute("login")).getPhoto()%>'/>
						<c:choose>
  							<c:when test="${empty photo}">
								<span class="material-icons" id="user_icon">person_outline</span>
					    	</c:when>
					    	<c:otherwise>
								<img src='<%= ((UserVO)session.getAttribute("login")).getPhoto() %>' width="40px" id="photo"/>
					    	</c:otherwise>
						</c:choose>
						<%= ((UserVO)session.getAttribute("login")).getUsername() %>
					</a>
					<a class="mdl-navigation__link mdl-layout-title" href="../login/logout">Logout</a>
				</nav>
			</div>
		</header>
		<div class="mdl-layout__drawer">
			<div class="mdl-layout--small-screen-only" id="menu_user_div">
				<span class="material-icons" id="menu_user_icon">
					account_circle </span>
			</div>
			<nav class="mdl-navigation  mdl-layout--small-screen-only">
				<a class="mdl-navigation__link mdl-layout--small-screen-only"
					href="../login/login">Login</a> 
			</nav>

			<span class="mdl-layout-title">Menu</span>
			<nav class="mdl-navigation">
				<a class="mdl-navigation__link" href="../top/main">Main</a>
				<a class="mdl-navigation__link" href="../board/list">List</a> <a
					class="mdl-navigation__link" href="../login/login">Login</a>
			</nav>
		</div>

		<main class="mdl-layout__content">
			<div class="page-content">