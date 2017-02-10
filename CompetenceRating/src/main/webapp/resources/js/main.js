var positionObjects;

$(document).ready(function () {

    //обработка события клика на таблице отчетов (главная страница)
    $('tr.clicableReport').click(function () {
        var id = $(this).attr("data-id");
        window.location.href = "reports/" + id;
    });

    //обработка события открытия модального окна
    $('#start').on('show.bs.modal', function () {
        $(".posSelect").prop("disabled", true); 		//блокировка элемента
        $(".levSelect").prop("disabled", true); 		//блокировка элемента
        getSubdivisions();								//получаем данные о подразделениях
    });

    //обработка события закрытия модального окна
    $('#start').on('hide.bs.modal', function () {
        var id = $('#subdivisionId').attr("data-id");			//берем выбранный id
        $(".subSelect option[value!=" + id + "]").remove();
    });

    //срабатывает при выборе одного из селектов
    $('.subSelect').click(function () {
        $(".posSelect").prop("disabled", false); 		//блокировка элемента снята
        $(".levSelect").prop("disabled", true); 		//блокировка элемента
        $('#subdivisionId').attr("data-id",
            $(".subSelect option:selected").val());
        getPositions();									//получаем данные по должностям в подразделении
    });

    //срабатывает при выборе одного из селектов - изменения данных в другом селекте
    $('.posSelect').click(function () {
        $(".levSelect").prop("disabled", false); 		//блокировка элемента снята

        $('#positionName').attr("data-id",
            $(".posSelect option:selected").val());
        var name = $('#positionName').attr("data-id");

        addLevelPositionSelect(positionObjects[name], $('.levSelect'));
    });

    $('.levSelect').click(function () {
        $('#positionLevel').attr("data-id",
            $(".levSelect option:selected").val());
    });

    $('#startNext').click(function () {
        var subdivisionId = $('#subdivisionId').attr("data-id");
        var positionName = $('#positionName').attr("data-id");
        var positionLevel = $('#positionLevel').attr("data-id");
        var subdivisionName = $(".subSelect option:selected").val(subdivisionId).text();

        $("form input[name='subdivisionId']").val(subdivisionId);
        $("form input[name='subdivisionName']").val(subdivisionName);
        $("form input[name='positionName']").val(positionName);
        $("form input[name='positionLevel']").val(positionLevel);
    });

});

function getSubdivisions() {
    $.ajax({
        url: 'getSubdivisions',
        type: 'GET',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        mimeType: 'application/json',
        data: ({}),
        success: function (data) {
            addSubdivisionSelect(data, $('.subSelect'));
        }
    });
}

function getPositions() {
    var id = $('#subdivisionId').attr("data-id");					//берем выбранный id

    $.ajax({
        url: 'getPositions',
        type: 'POST',
        dataType: 'json',
        contentType: "application/json; charset=utf-8",
        mimeType: 'application/json',
        data: JSON.stringify(id),
        success: function (data) {
            $(".posSelect").empty();
            addPositionSelect(data, $('.posSelect'));
            positionObjects = data;
        }
    });
}

function addSubdivisionSelect(data, elem) {
    var id = $('#subdivisionId').attr("data-id");			//берем выбранный id

    $.each(data, function (index, value) {
        if (value.id != id) {
            elem.append($("<option></option>")
                .attr("value", value.id)
                .text(value.name));
        }
    });
}

function addPositionSelect(data, elem) {
    $.each(data, function (key, value) {
        elem.append($("<option></option>")
            .attr("value", key)
            .text(key));
    });

    $('#positionName').attr("data-id", $(".posSelect :selected").val());
    var name = $('#positionName').attr("data-id");
    addLevelPositionSelect(data[name], $('.levSelect'));
}

function addLevelPositionSelect(data, elem) {
    $(".levSelect").empty();

    $.each(data, function (index, value) {
        elem.append($("<option></option>")
            .attr("value", value)
            .text(value));
    });

    $('#positionLevel').attr("data-id",
        $(".levSelect option:selected").val());
}