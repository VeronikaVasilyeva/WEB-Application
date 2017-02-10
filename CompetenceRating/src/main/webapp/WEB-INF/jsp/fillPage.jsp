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

    <!-- Единый стиль Main.css -->
    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet"/>

    <!-- Модуль работы с IE8 (не работает) -->
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>

    <!-- Модуль работы с таблой -->
    <link href="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.css" rel="stylesheet"/>
    <script src="https://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/plug-ins/1.10.7/integration/bootstrap/3/dataTables.bootstrap.js"></script>
    <!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script> -->

    <script>
        $(document).ready(function () {
            $('a.twoLevel').click(function () {
                changeFillContainerHeader($(this));

                var id = $(this).attr("data-id");
                var name = $(this).find('> div.menuItem').text();
                addForm(id, name);
                addProgressAndButtons();
            });

            $('a.threeLevel').click(function () {
                changeFillContainerHeader($(this));

                var id = $(this).attr("data-id");
                var batchSize = 3;
                var batchNumber = 0;

                $.ajax({
                    url: '/fillCompetence/getCompetenceBatch',
                    type: 'GET',
                    contentType: "application/json; charset=utf-8",
                    dataType: 'json',
                    mimeType: 'application/json',
                    data: {batchSize: batchSize, batchNumber: batchNumber, parentCompetenceId: id},
                    success: function (data) {
                        $.each(data, function (key, value) {
                            addForm(value.id, value.name);
                        });
                        addProgressAndButtons();
                    }
                });
            });

            $( "#form" ).submit(function( event ) {
                event.preventDefault();
                console.log($('#form'));
                console.log($('input[name=knowlege]:checked', '#form').val());
                console.log($('#sel1:selected', '#form').val());
            });

        });


        function changeFillContainerHeader(item) {
            var secondLevel = item.find('> div.menuItem');
            var firstLevel = item.parent().parent().siblings();
            firstLevel = firstLevel.find('div.menuItem');
            $('#fillContainerHeader').text(firstLevel.text() + ' \\ ' + secondLevel.text());
        }

        function addForm(id, name) {
            $('#containerForm').empty();
            $.ajax({
                url: '/fillCompetence/getFormView',
                type: 'GET',
                dataType: 'html',
                success: function (data) {
                    $('#containerForm').append(data);
                    var header = $('.header').last();

                    header.text(name);
                    header.attr("data-id", id);
                }
            });

        }

        function addProgressAndButtons() {
            var html =
                '<div class="row fill-form" style="margin-bottom: 20px; margin-top: 10px;">' +
                    '<div class="fill-form">' +
                        '<div class="progress">' +
                            '<div class="progress-bar progress-bar-hostco" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" /*style="width: 20%;*/"></div>' +
                        '</div>' +

                        '<button type="submit" class="btn btn-default btn-hostco-white LeftFloat">Назад</button>' +
                        '<button type="submit" class="btn btn-primary btn-hostco RightFloat">Далее</button>' +
                    '</div>'
                '</div>';

            $('#submitForm').empty();
            $('#submitForm').append(html);
        }

    </script>

</head>

<body>
<jsp:include page="/WEB-INF/jsp/template/navBar.jsp"/>

<div class="container-fluid contNormalize" id="mainContainer">

    <div class="col-md-12" style="text-align: center; margin-top: 30px;">

        <div class="col-md-7" >
            <jsp:include page="/WEB-INF/jsp/template/FillPage_SessionInfo.jsp"/>
        </div>

        <div class="col-md-5">
            <div class="RightFloat">
                <jsp:include page="/WEB-INF/jsp/template/FillPage_SaveSession.jsp"/>
                <jsp:include page="/WEB-INF/jsp/template/FillPage_DelSession.jsp"/>
                <jsp:include page="/WEB-INF/jsp/template/help.jsp"/>
            </div>
        </div>
    </div>

    <div class="col-md-12">

        <div class="col-md-3" id="competenceTree">
            <jsp:include page="/WEB-INF/jsp/template/FillPage_LeftMenu.jsp"/>
        </div>

        <div class="col-md-6 container" id="fillContainer">
            <div class="panel panel-default panel-custom panel-color">
                <h4 class="headerMainWindow" id="fillContainerHeader">${pageTitle}</h4>

                <form class="panel-body color-custom form" id="form" action="" >
                    <div class="container-fluid"><div class="row" id="containerForm"></div></div>
                    <div class="container-fluid"><div class="row" id="submitForm"></div></div>
                </form>
            </div>
        </div>

        <div class="col-md-3" id="legends">
            <jsp:include page="/WEB-INF/jsp/template/FillPage_Legends.jsp"/>
        </div>

    </div>

</div>


</body>
</html>