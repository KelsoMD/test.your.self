<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title><spring:message code="main" /></title>
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
	<c:import url="header.jsp"></c:import>
	<section class="mbr-section article content10 cid-qPBrzx6fTJ"
		id="content10-i">
		<div class="container">
			<div class="inner-container" style="width: 83%;">
				<hr class="line" style="width: 27%;">
				<div
					class="section-text align-center mbr-white mbr-fonts-style display-5">
					<spring:message code="info_details" />
				</div>
				<hr class="line" style="width: 27%;">
			</div>
		</div>
	</section>
	<section class="counters1 counters cid-qOgRnHk59K" id="counters1-4">
		<div class="container">
			<h2
					class="mbr-section-title pb-3 align-center mbr-fonts-style display-2">
				<spring:message code="counters"/></h2>
			<div class="container pt-4 mt-2">
				<div class="media-container-row">
					<div class="card p-3 align-center col-12 col-md-6 col-lg-4">
						<div class="panel-item p-3">
							<div class="card-img pb-3">
								<span class="mbr-iconfont mbri-users"
									  style="color: rgb(35, 35, 35);"></span>
							</div>
							<div class="card-text">
								<h3 class="count pt-3 pb-3 mbr-fonts-style display-2">${user_count}</h3>
								<p class="mbr-content-text mbr-fonts-style display-7"><spring:message code="users"/>
								</p>
							</div>
						</div>
					</div>
					<div class="card p-3 align-center col-12 col-md-6 col-lg-4">
						<div class="panel-item p-3">
							<div class="card-img pb-3">
								<span class="mbr-iconfont mbri-question"
									  style="color: rgb(35, 35, 35);"></span>
							</div>
							<div class="card-text">
								<h3 class="count pt-3 pb-3 mbr-fonts-style display-2">
									${question_count}</h3>

								<p class="mbr-content-text mbr-fonts-style display-7">
									<spring:message code="question_size"/></p>
							</div>
						</div>
					</div>

					<div class="card p-3 align-center col-12 col-md-6 col-lg-4">
						<div class="panel-item p-3">
							<div class="card-img pb-3">
								<span class="mbr-iconfont mbri-like"
									  style="color: rgb(35, 35, 35);"></span>
							</div>
							<div class="card-text">
								<h3 class="count pt-3 pb-3 mbr-fonts-style display-2">${test_count}</h3>

								<p class="mbr-content-text mbr-fonts-style display-7"><spring:message code="passed_tests"/>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
		<div class="container">
			<div class="media-container-row align-center mbr-white">
				<div class="row row-copirayt">
					<p><a href="?lang=en">EN </a><a href="?lang=ru_RU"> RU</a></p>
					<p
						class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
						<spring:message code="mobirise" /></p>
				</div>
			</div>
		</div>
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