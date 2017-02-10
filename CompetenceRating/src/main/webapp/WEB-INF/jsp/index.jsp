<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
    <!-- 	<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>
     -->
</head>

<body>
<!-- Навбар-->
<jsp:include page="/WEB-INF/jsp/template/navBar.jsp"/>

<!-- Общий контейнер. Маржин 50 сверху (под навбар), чтобы не менять z-index. Если вертикальная прокрутка НЕ нужна, добавить к контейнеру класс contNormalize-->
<div class="container-fluid contNormalize" id="mainContainer">
    <div class="row">
        <div class="col-md-12">
            <div class="container-fluid page-header" style="text-align: center; margin-top: 30px;">
                <h3 class="HeaderH3">Стартовая страница</h3>

                <div class="RightFloat">
                    <jsp:include page="/WEB-INF/jsp/template/help.jsp"/>
                </div>
            </div>
        </div>

        <div class="col-md-12">
            <div class="container">
                <div class="row">
                    <jsp:include page="/WEB-INF/jsp/template/IndexPage_Records.jsp"/>
                </div>

                <div class="row">
                    <jsp:include page="/WEB-INF/jsp/template/IndexPage_ReportsTable.jsp"/>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
</body>

</html>