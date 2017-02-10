<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Компетенции</title>

    <link rel="shortcut icon" href="<c:url value="/resources/images/favicon.ico" />" type="image/x-icon"/>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"
            integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>

    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css"
          href="http://ajax.aspnetcdn.com/ajax/bootstrap/3.3.5/fonts/glyphicons-halflings-regular.woff2">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link href="https://fonts.googleapis.com/css?family=PT+Sans" rel="stylesheet">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/css/jasny-bootstrap.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/js/jasny-bootstrap.min.js"></script>

    <!-- Единый стиль Main.css -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>

    <!-- Модуль работы с IE8 (не работает) -->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <!-- Модуль работы с таблой -->
    <link href="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css"
          rel="stylesheet"/>
    <script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script> -->

</head>

<body style="padding-left: 300px; padding-top: 50px;">
<jsp:include page="/WEB-INF/jsp/template/navBar.jsp"/>

<div class="container-fluid" id="mainContainer" style="top:50px;">
    <jsp:include page="/WEB-INF/jsp/leftNav.jsp"/>
    <jsp:include page="/WEB-INF/jsp/rigthMenu(collapse).jsp"/>

    <div class="row">
        <div class="page-header" style="text-align: center; margin-top: 30px;">
            <h3 class="HeaderH3">${pageTitle}</h3>

            <button type="button" class="btn vertical" data-toggle="offcanvas" data-autohide="false" data-recalc="false"
                    data-target="#rightNav" data-canvas="#mainContainer"
                    style="z-index: 10;">Легенда
            </button>


            <%--               <div class="RightFloat">
                               <jsp:include page="/WEB-INF/jsp/template/help.jsp"/>
                           </div>--%>
        </div>
    </div>

    <div class="row">

        <jsp:include page="/WEB-INF/jsp/template/FillPage_FillContainer.jsp"/>
        <jsp:include page="/WEB-INF/jsp/template/FillPage_FillContainer.jsp"/>
        <jsp:include page="/WEB-INF/jsp/template/FillPage_FillContainer.jsp"/>
    </div>
</div>


</body>
</html>