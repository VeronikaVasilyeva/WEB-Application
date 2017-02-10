<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spel" uri="http://www.springframework.org/tags" %>

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
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script> -->

    <!-- Инициализация таблички -->
    <script type="text/javascript">
        $(document).ready(function () {
            $('#report').DataTable({
                "paging": false,
                // "ordering": false, отключили функцию страниц
                "info": false,
                "language": {
                    "url": "https://cdn.datatables.net/plug-ins/1.10.12/i18n/Russian.json"
                }
            });
        });
    </script>
</head>

<body>

<jsp:include page="/WEB-INF/jsp/template/navBar.jsp"/>

<div class="container-fluid all" id="mainContainer">

    <div class="row" style="margin: 0px;">

        <div class="col-md-2 leftMenu">
            <jsp:include page="/WEB-INF/jsp/template/DropDownReportPage_LeftMenu.jsp"/>
        </div>

        <div class="col-md-10 content-container">
            <div class="row">
                <div class="container-fluid page-header" style="text-align: center; margin-top: 30px;padding-right: 0;">
                    <h3 class="HeaderH3">Мои компетенции</h3>

                    <div class="RightFloat">
                        <jsp:include page="/WEB-INF/jsp/template/help.jsp"/>
                    </div>
                </div>
            </div>

            <div class="row" id="content">
                <jsp:include page="/WEB-INF/jsp/template/DropDownReportPage_Table.jsp.jsp"/>
            </div>
        </div>
    </div>
</div>


<%--<footer class="footer">
    <div class="container"></div>
</footer>--%>

</body>
</html>