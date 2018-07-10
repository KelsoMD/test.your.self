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
    <meta name="description" content="">
    <title><spring:message code="group_info"/></title>
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
    <link rel="stylesheet" href="assets/theme/css/style.css">
    <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css"
          type="text/css">
</head>
<body>
<c:import url="header.jsp"></c:import>
<section class="section-table cid-qR017JJDq7" id="table1-t">
    <div class="container container-table">
        <h3
                class="mbr-section-subtitle mbr-fonts-style align-center pb-5 mbr-light display-5">
            <div class="mbr-section-btn text-center pt-4">
                <a class="btn btn-sm btn-black-outline display-4"
                   href="<c:url value="/mentor/groups/group_info_tasks?group_id=${group_id}"/>"><spring:message
                        code="task_list"/> </a>
            </div>
        </h3>
        <div class="row">
            <div class="col-md-12">
                <p class="mbr-text py-5 mbr-fonts-style display-7">
                    <spring:message code="members"/>
                </p>
            </div>
        </div>
        <div class="table-wrapper">
            <div class="row">
                <div class="container scroll">
                    <table class="table isSearch" cellspacing="0">
                        <thead>
                        <tr class="table-heads ">
                            <th class="head-item mbr-fonts-style display-7"><spring:message
                                    code="login"/></th>
                            <th class="head-item mbr-fonts-style display-7"><spring:message
                                    code="name"/></th>
                            <th class="head-item mbr-fonts-style display-7"><spring:message
                                    code="actions"/></th>
                        </tr>
                        </thead>
                        <c:forEach items="${members}" var="item">
                            <tbody>
                            <tr>
                                <td class="body-item mbr-fonts-style display-7">${item.getLogin()}</td>
                                <td class="body-item mbr-fonts-style display-7">${item.getName()+=' '+=item.getSurname()}</td>
                                <td class="body-item mbr-fonts-style display-7">
                                    <form
                                            action="fire" method="post">
                                        <input type="hidden" name="member_id"
                                               value="${item.getId()}"/>
                                        <button type="submit"
                                                class="btn btn-sm btn-black-outline display-4">
                                            <spring:message code="actions"/>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <form
                action="invite" method="get">
            <button type="submit"
                    class="btn btn-sm btn-black-outline display-4">
                <spring:message code="actions"/>
            </button>
        </form>
    </div>
</section>
<section once="" class="cid-qR00R0qhid mbr-reveal" id="footer7-s">
    <div class="container">
        <div class="media-container-row align-center mbr-white">
            <div class="row row-copirayt">
                <p>
                    <a href="?lang=en">EN </a><a href="?lang=ru_RU"> RU</a>
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
<script src="assets/mbr-tabs/mbr-tabs.js"></script>
<script src="assets/theme/js/script.js"></script>
<input name="animation" type="hidden">
</body>
</html>