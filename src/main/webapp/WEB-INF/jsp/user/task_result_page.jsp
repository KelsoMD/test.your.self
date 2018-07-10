<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- Данный сайт сделан с помощью конструктора Mobirise v4.6.5, https://mobiriz.store -->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description"
	content="Бесплатный конструктор сайтов Mobirise">
<title><spring:message code="result" /></title>
<link rel="stylesheet"
	href="assets/web/assets/mobirise-icons/mobirise-icons.css">
<link rel="stylesheet" href="assets/tether/tether.min.css">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="assets/bootstrap/css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="assets/animatecss/animate.min.css">
<link rel="stylesheet"
	href="assets/datatables/data-tables.bootstrap4.min.css">
<link rel="stylesheet" href="assets/dropdown/css/style.css">
<link rel="stylesheet" href="assets/theme/css/style.css">
<link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
	type="text/css">



</head>
<body>
	<c:import url="header.jsp"></c:import>
	<section class="section-table cid-qOIWRZ9j1F" id="table1-h">
		<h2
			class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">${pass_msg}</h2>
		<h3
			class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
			<spring:message code="your_mark" />
			${mark}
		</h3>
		<form action="testyourself/user" method="get">
			<input type="hidden" name="task" value="${task}" /> <input
				type="hidden" name="mark" value="${mark}" />
			<c:forEach items="${answer_map}" var="entry">

				<div class="container container-table">

					<h2
						class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
						${entry.getKey().getText()}</h2>
					<c:if test="${not empty entry.getKey().getImage()}">
						<h3
							class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
							<img alt="image" src="${entry.getKey().getImage()}">
						</h3>
					</c:if>
					<div class="table-wrapper">
						<div class="container scroll">
							<table class="table isSearch" cellspacing="0">
								<thead>
									<tr class="table-heads ">
										<th class="head-item mbr-fonts-style display-7"><spring:message
												code="correct_answer" /></th>
										<th class="head-item mbr-fonts-style display-7"><spring:message
												code="your_answer" /></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td class="body-item mbr-fonts-style display-7">
											${entry.getKey().getCorrectAnswer()}</td>
										<td class="body-item mbr-fonts-style display-7">
											${entry.getValue()}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</c:forEach>
			<div class="mbr-section-btn text-center pt-4">
				<button type="submit" class="btn btn-sm btn-black-outline display-4">
					<spring:message code="exit" />
				</button>
			</div>
		</form>
	</section>
	<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
		<div class="container">
			<div class="media-container-row align-center mbr-white">
				<div class="row row-copirayt">
					<p>
						<a href="?lang=en">EN </a> <a href="?lang=ru_RU"> RU</a>
					</p>
					<p
						class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
						<spring:message code="mobirise" />
					</p>
				</div>
			</div>
		</div>
	</section>

	<script src="assets/web/assets/jquery/jquery.min.js"></script>
	<script src="assets/popper/popper.min.js"></script>
	<script src="assets/tether/tether.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/smoothscroll/smooth-scroll.js"></script>
	<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
	<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
	<script src="assets/datatables/jquery.data-tables.min.js"></script>
	<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
	<script src="assets/dropdown/js/script.min.js"></script>
	<script src="assets/theme/js/script.js"></script>


	<input name="animation" type="hidden">
</body>
</html>