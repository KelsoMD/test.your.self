<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>user_main</title>
<link rel="stylesheet"
	href="assets/web/assets/mobirise-icons/mobirise-icons.css">
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/socicon/css/styles.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<section class="menu cid-qPBrzxK6qz" once="menu" id="menu1-j">
		<nav
			class="navbar navbar-expand beta-menu navbar-dropdown align-items-center navbar-fixed-top navbar-toggleable-sm bg-color transparent">
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<div class="hamburger">
					<span></span> <span></span> <span></span> <span></span>
				</div>
			</button>
			<div class="menu-logo">
				<div class="navbar-brand">

					<span class="navbar-caption-wrap"><a
						class="navbar-caption text-white display-4">TEST YOURSELF</a></span>
				</div>
			</div>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav nav-dropdown" data-app-modern-menu="true">
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="<c:url value="/mentor"/>"><span
							class="mbri-home mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> <spring:message
							code="main" /></span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="<c:url value="/mentor/tests"/>">
							<span class="mbri-search mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> <spring:message code="tests" /></span>
					</a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="<c:url value="/mentor/info"/>"><span
							class="mbri-italic mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> <spring:message
							code="info" /></span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="<c:url value="/not_implemented"/>"><span
							class="mbri-growing-chart mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> <spring:message
							code="stats" /></span> </a></li>
					<li class="nav-item"><a
						class="nav-link link text-white display-4"
						href="<c:url value="/mentor/groups"/>"><span
							class="mbri-users mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> <spring:message code="groups" /></span> </a></li>
					<li class="nav-item"><a
							class="nav-link link text-white display-4"
							href="<c:url value="/logout"/>"><span
							class="mbri-logout mbr-iconfont mbr-iconfont-btn"
							style="color: rgb(255, 255, 255);"> <spring:message
							code="logout" /></span> </a></li>

				</ul>
			</div>
		</nav>
	</section>
	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/theme/js/script.js"></script>
	<input name="animation" type="hidden">
</body>
</html>