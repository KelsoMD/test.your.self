<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<title>test</title>
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
		<form:form action="/testyourself/not_implemented" method="post" modelAttribute="question">
			<input type="hidden" name="question_id" value="${question_id}">
			<div class="container container-table">
				<h2
					class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
					<form:label path="text"/>
					<form:input path="text" type="text" class="form-control" value="${text}"
						required=""/>
				</h2>
				<c:if test="${not empty image}">
					<h3
						class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
						<img alt="image" src="${image}" height="300px">
					</h3>
					<form:label path="image" class="form-control-label mbr-fonts-style display-7">Ссылка</form:label>
					<form:input path="image" type="text" class="form-control" name="image_link"
						value="${image_link}"/>
				</c:if>
				<div class="table-wrapper">
					<div class="container scroll">
						<table class="table isSearch" cellspacing="0">
							<tbody>
								<tr>
									<td class="body-item mbr-fonts-style display-7"><form:label path="correctAnswer"
										class="form-control-label mbr-fonts-style display-7">Правильный
											ответ</form:label> <form:input  path="correctAnswer" type="text"
																			class="form-control" required=""
																			value="${correct_answer}"/></td>
									<td class="body-item mbr-fonts-style display-7"><form:label path="answer1"
										class="form-control-label mbr-fonts-style display-7">Доп
											1</form:label> <form:input path="answer1" type="text"
																	   class="form-control" required=""
																	   value="${answer1}"/></td>
									<td class="body-item mbr-fonts-style display-7"><form:label path="answer2"
										class="form-control-label mbr-fonts-style display-7">Доп
											2</form:label> <form:input path="answer2" type="text"
																	   class="form-control"	required="" value="${answer2}"/></td>
									<td class="body-item mbr-fonts-style display-7"><form:label path="answer3"
										class="form-control-label mbr-fonts-style display-7">Доп
											3</form:label> <form:input path="answer3" type="text"
																	   class="form-control" required=""
																	   value="${answer3}"/></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="mbr-section-btn text-center pt-4">
				<a class="btn btn-sm btn-black-outline display-4"
				   href="<c:url value="/moderator/questions/deni/${question_id}"/>"><spring:message
						code="deni"/>
				</a>
				<a class="btn btn-sm btn-black-outline display-4"
				   href="<c:url value="/moderator/questions/accept/${question_id}"/>"><spring:message
						code="accept"/>
				</a>
				<button type="submit" class="btn btn-sm btn-black-outline display-4" name="action" value="update_changes">Сохранить
					изменения</button>
			</div>
			<%--<div class="mbr-section-btn text-center pt-4">--%>
				<%--<button type="submit" class="btn btn-sm btn-black-outline display-4" name="action" value="denie_question">Отклонить</button>--%>
			<%--</div>--%>
			<%--<div class="mbr-section-btn text-center pt-4">--%>
				<%--<button type="submit" class="btn btn-sm btn-black-outline display-4" name="action" value="accept_question">Одобрить</button>--%>
			<%--</div>--%>
		</form:form>
	</section>
	<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
		<div class="container">
			<div class="media-container-row align-center mbr-white">
				<div class="row row-copirayt">
					<p><a href="?lang=en">EN </a><a href="?lang=ru_RU"> RU</a></p>
					<p
							class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
						<spring:message code="mobirise"/></p>
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