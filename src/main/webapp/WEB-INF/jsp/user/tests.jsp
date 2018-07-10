<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Данный сайт сделан с помощью конструктора Mobirise v4.6.5, https://mobiriz.store -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <title><spring:message code="tests"/></title>
    <link rel="stylesheet"
          href="assets/web/assets/mobirise-icons/mobirise-icons.css">
    <link rel="stylesheet" href="assets/tether/tether.min.css">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="assets/bootstrap/css/bootstrap-grid.min.css">
    <link rel="stylesheet"
          href="assets/bootstrap/css/bootstrap-reboot.min.css">
    <link rel="stylesheet" href="assets/socicon/css/styles.css">
    <link rel="stylesheet" href="assets/animatecss/animate.min.css">
    <link rel="stylesheet" href="assets/dropdown/css/style.css">
    <link rel="stylesheet"
          href="assets/datatables/data-tables.bootstrap4.min.css">
    <link rel="stylesheet" href="assets/theme/css/style.css">
    <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
          type="text/css">


</head>
<body>
<c:import url="header.jsp"/>
<section class="section-table cid-qR017JJDq7" id="table1-t">
    <div class="container container-table">
        <h3
                class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
            <div class="mbr-section-btn text-center pt-4">
                <a class="btn btn-sm btn-black-outline display-4"
                   href="<c:url value="/user/tests/create"/>"> <spring:message
                        code="create_test"/>
                </a> <a class="btn btn-sm btn-black-outline display-4"
                        href="<c:url value="/user/tests/create_question"/>"><spring:message
                    code="create_question"/> </a> <a
                    class="btn btn-sm btn-black-outline display-4"
                    href="<c:url value="/user/tests/create_theme"/>"> <spring:message
                    code="create_theme"/>
            </a>
            </div>
        </h3>
        <div class="table-wrapper">
            <div class="container">
                <div class="row search">
                    <div class="col-md-6"></div>
                    <div class="col-md-6">
                        <form action="<c:url value="/user/tests/search_test"/>" method="get">
                            <div class="dataTables_filter">
                                <label class="searchInfo mbr-fonts-style display-7"><spring:message
                                        code="theme"/>:</label> <select class="form-control input-sm"
                                                                        name="theme">
                                <c:forEach items="${themes}" var="theme">
                                    <option>${theme}</option>
                                </c:forEach>
                            </select> <label class="searchInfo mbr-fonts-style display-7"><spring:message
                                    code="lvl"/>
                                <spring:message code="lvl"/>:</label> <select
                                    class="form-control input-sm" name="lvl">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                                <div class="mbr-section-btn text-center pt-4">
                                    <button type="submit"
                                            class="btn btn-sm btn-black-outline display-4">
                                        <spring:message code="search"/>
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="container scroll">
                <table class="table isSearch" cellspacing="0">
                    <thead>
                    <tr class="table-heads ">
                        <th class="head-item mbr-fonts-style display-7"><spring:message
                                code="id"/></th>
                        <th class="head-item mbr-fonts-style display-7"><spring:message
                                code="theme"/></th>
                        <th class="head-item mbr-fonts-style display-7"><spring:message
                                code="lvl"/></th>
                        <th class="head-item mbr-fonts-style display-7"><spring:message
                                code="question_size"/></th>
                        <th class="head-item mbr-fonts-style display-7"><spring:message
                                code="actions"/></th>
                    </tr>
                    </thead>
                    <c:forEach items="${tests}" var="test">
                        <tbody>
                        <tr>
                            <td class="body-item mbr-fonts-style display-7">${test.getId()}</td>
                            <td class="body-item mbr-fonts-style display-7">${test.getTheme()}</td>
                            <td class="body-item mbr-fonts-style display-7">${test.getLvl()}</td>
                            <td class="body-item mbr-fonts-style display-7">${test.getQuestions().size()}</td>
                            <td class="body-item mbr-fonts-style display-7"><a
                                    class="btn btn-sm btn-black-outline display-4"
                                    href="<c:url value="/user/tests/${test.getId()}"/>"><spring:message
                                    code="start_test"/>
                            </a></td>
                        </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</section>
<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-copirayt">
                <p>
                    <a href="?lang=en">EN </a>
                    <a href="?lang=ru_RU"> RU</a>
                </p>
                <p
                        class="mbr-text mb-0 mbr-fonts-style mbr-white align-center display-7">
                    <spring:message code="mobirise"/>
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
<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
<script src="assets/dropdown/js/script.min.js"></script>
<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
<script src="assets/datatables/jquery.data-tables.min.js"></script>
<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
<script src="assets/theme/js/script.js"></script>
<input name="animation" type="hidden">
</body>
</html>