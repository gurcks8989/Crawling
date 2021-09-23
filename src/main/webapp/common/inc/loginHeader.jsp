<%@ page contentType="text/html; charset=UTF-8"%>
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
				<div class="main_logo">
					<a target="_blank" onclick="window.location.href='../top/top'">D<span
						id="lower">elivery</span><br />C<span id="lower">rew</span></a>
				</div>
				<div class="mdl-layout-spacer"></div>
				<!-- Navigation. We hide it in small screens. -->
				<nav class="mdl-navigation">
					<div role="button" class="mdl-layout__drawer-button" onclick="window.location.href='../top/top'">
						<span class="material-icons">chevron_left</span>
					</div>
				</nav>
			</div>
		</header>
		<main class="mdl-layout__content">
			<div class="page-content">