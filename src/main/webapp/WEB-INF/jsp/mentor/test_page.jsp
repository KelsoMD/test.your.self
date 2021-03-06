<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="generator" content="Mobirise v4.6.5, mobiriz.store">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"
          content="Бесплатный конструктор сайтов Mobirise">
    <title><spring:message code="test"/></title>
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
<c:import url="header.jsp"/>

<section class="section-table cid-qOIWRZ9j1F" id="table1-h">




    <form action="<c:url value="/mentor/tests/result"/>" method="post">
        <input type="hidden" value="${test}" name="test">
        <c:forEach items="${test_questions}" var="question">
            <div class="container container-table">
                <h2
                        class="mbr-section-title mbr-fonts-style align-center pb-3 display-2">
                        ${question.getText()}</h2>
                <c:if test="${not empty question.getImage()}">
                    <h3
                            class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
                        <img alt="image" src="${question.getImage()}" height="300px">
                    </h3>
                </c:if>
                <div class="table-wrapper">
                    <div class="container scroll">

                        <table class="table isSearch" cellspacing="0">
                            <tbody>
                            <tr>
                                <c:forEach items="${question.getShuffledAnswers()}"
                                           var="answers">
                                    <td class="body-item mbr-fonts-style display-7"><input
                                            type="checkbox" name="answer"
                                            value="${answers+='*'+=question.getId()}"/>${answers}</td>
                                </c:forEach>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </c:forEach>
        <div class="mbr-section-btn text-center pt-4">
            <button type="submit" class="btn btn-sm btn-black-outline display-4">
                <spring:message code="finish"/>
            </button>
        </div>
    </form>




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
<script src="assets/touchswipe/jquery.touch-swipe.min.js"></script>
<script src="assets/viewportchecker/jquery.viewportchecker.js"></script>
<script src="assets/datatables/jquery.data-tables.min.js"></script>
<script src="assets/datatables/data-tables.bootstrap4.min.js"></script>
<script src="assets/dropdown/js/script.min.js"></script>
<script src="assets/theme/js/script.js"></script>


<input name="animation" type="hidden">
</body>
</html>