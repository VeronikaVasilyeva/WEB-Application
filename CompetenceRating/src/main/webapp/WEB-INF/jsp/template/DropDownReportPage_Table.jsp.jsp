<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spel" uri="http://www.springframework.org/tags" %>

<script>
    $(document).ready(function () {

        //обработка события клика на меню
        $('div.childCompetence' ).click(function () {
            var id = $(this).attr("data-id");
            GetData(id);
        });

        //обработка события клика на таблице
        $('tr.clicableDropDown').click(function () {
            var id = $(this).attr("data-id");

            //разворачиваем меню
            var listItem = $('.panel-body[data-id=' + id + ']');
            listItem.parent().collapse('show');

            GetData(id);
        });
    });

    function GetData (id) {
        addTable();

        //делаем запрос на сервер - берем данные по id
        $.ajax({
            url: 'getRatings/' + id,
            type: 'GET',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            mimeType: 'application/json',
            data: JSON.stringify(id),
            success: function (data) {
                //как-то отображаем данные


            }
        });
    }

    function addTable() {
        $("#content").empty();

        $.ajax({
            url: '/reports/getTableView',
            type: 'GET',
            dataType: 'html',
            success: function (data) {
                $("#content").append(data);
            }
        });
    }

    function goBackToTable() {
        var a_href = $('#reportLink > a').attr('href');
        location.href = a_href;
    }

    function showAllReport() {
        $('.CompName').collapse('show');
/*            var listItem = $('.panel-body[data-id=' + id + ']');
        listItem.parent().collapse('show');*/
    }

</script>

<c:set var="count" value="1" scope="request"/>

<table id="report" class="table table-hover table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
    <tr class="tablhead">
        <th>Компетенция</th>
        <th>Категория компетенции</th>
        <th>Опыт</th>
        <th>Знания</th>
        <th>Период</th>
        <th>Цель</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="ParentNode" items="${competences}">
        <c:if test="${!empty ParentNode.getChilds()}">
            <c:forEach var="secondNode" items="${ParentNode.getChilds()}">
                <tr class="clicableDropDown accordion-toggle" data-id="${secondNode.getValue().getId()}"
                    data-toggle="collapse" data-target="#${count}">
                    <td class="WidTab"><a href="#">${secondNode.getValue().getName()}</a></td>
                    <td>${ParentNode.getValue().getName()}</td>
                    <td>${secondNode.getValue().getMeasureRatings().get('Опыт')}</td>
                    <td>${secondNode.getValue().getMeasureRatings().get('Знание')}</td>
                    <td>${secondNode.getValue().getMeasureRatings().get('Период')}</td>
                    <td>${secondNode.getValue().getMeasureRatings().get('Цель')}</td>
                </tr>

                <%--                    <c:if test="${!empty secondNode.getChilds()}">
                                        <c:forEach var="firdNode" items="${secondNode.getChilds()}">
                                            <tr class="clicableDropDown accordian-body collapse" data-id="${firdNode.getValue().getId()}" id="${count}" >
                                                <td class="WidTab"><a href="#">${firdNode.getValue().getName()}</a></td>
                                                <td>${secondNode.getValue().getName()}</td>
                                                <td>${firdNode.getValue().getMeasureRatings().get('Опыт')}</td>
                                                <td>${firdNode.getValue().getMeasureRatings().get('Знание')}</td>
                                                <td>${firdNode.getValue().getMeasureRatings().get('Период')}</td>
                                                <td>${firdNode.getValue().getMeasureRatings().get('Цель')}</td>
                                            </tr>
                                        </c:forEach>
                                    </c:if>--%>

                <c:set var="count" value="${count+1}" scope="request"/>

            </c:forEach>
        </c:if>

    </c:forEach>
    </tbody>
</table>


<%--
<tr>
    <td><a class="firstline" href="reports.html">MS SQL</a></td>
    <td>СУБД</td>
    <td>3</td>
    <td>3</td>
    <td>2</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">DB2</a></td>
    <td>СУБД</td>
    <td>4</td>
    <td>5</td>
    <td>2</td>
    <td>4</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">Posgresql</a></td>
    <td>СУБД</td>
    <td>3</td>
    <td>2</td>
    <td>5</td>
    <td>4</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">MongoDB</a></td>
    <td>СУБД</td>
    <td>4</td>
    <td>4</td>
    <td>2</td>
    <td>2</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">MySQL</a></td>
    <td>СУБД</td>
    <td>3</td>
    <td>5</td>
    <td>4</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">JavaScript</a></td>
    <td>Языки програмирования</td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
    <td>2</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">C++</a></td>
    <td>Языки програмирования</td>
    <td>4</td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">Java</a></td>
    <td>Языки програмирования</td>
    <td>4</td>
    <td>3</td>
    <td>5</td>
    <td>4</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">C#</a></td>
    <td>Языки програмирования</td>
    <td>4</td>
    <td>3</td>
    <td>5</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM Tivoli Monitoring</a></td>
    <td>Средства мониторинга</td>
    <td>4</td>
    <td>3</td>
    <td>5</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere Bussiness Monitor</a></td>
    <td>Средства мониторинга</td>
    <td>4</td>
    <td>3</td>
    <td>5</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere MQ</a></td>
    <td>Интеграционное ПО</td>
    <td>2</td>
    <td>3</td>
    <td>4</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere ESB</a></td>
    <td>Интеграционное ПО</td>
    <td>3</td>
    <td>3</td>
    <td>3</td>
    <td>3</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere Message Broker (Integration Bus)</a></td>
    <td>Интеграционное ПО</td>
    <td>2</td>
    <td>2</td>
    <td>2</td>
    <td>2</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere Process Server</a></td>
    <td>Интеграционное ПО</td>
    <td>1</td>
    <td>5</td>
    <td>2</td>
    <td>1</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere Process Server</a></td>
    <td>Интеграционное ПО</td>
    <td>2</td>
    <td>4</td>
    <td>4</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM BPM</a></td>
    <td>Интеграционное ПО</td>
    <td>3</td>
    <td>3</td>
    <td>1</td>
    <td>1</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">IBM WebSphere Application Server</a></td>
    <td>Интеграционное ПО</td>
    <td>2</td>
    <td>3</td>
    <td>3</td>
    <td>5</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">Bonita BPM</a></td>
    <td>Интеграционное ПО</td>
    <td>3</td>
    <td>3</td>
    <td>5</td>
    <td>4</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">Talend ESB</a></td>
    <td>Интеграционное ПО</td>
    <td>2</td>
    <td>2</td>
    <td>2</td>
    <td>2</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">Microsoft SharePoint</a></td>
    <td>ПОрталы</td>
    <td>5</td>
    <td>1</td>
    <td>2</td>
    <td>4</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">LifeRay</a></td>
    <td>Порталы</td>
    <td>4</td>
    <td>4</td>
    <td>4</td>
    <td>4</td>
</tr>
<tr>
    <td class="lineOne"><a class="firstline" href="reports.html">TrackStudio</a></td>
    <td>Баг-трекинговые системы</td>
    <td>4</td>
    <td>2</td>
    <td>3</td>
    <td>3</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">Jira</a></td>
    <td>Баг-трекинговые системы</td>
    <td>3</td>
    <td>3</td>
    <td>2</td>
    <td>2</td>
</tr>
<tr>
    <td><a class="firstline" href="reports.html">RedMine</a></td>
    <td>Баг-трекинговые системы</td>
    <td>3</td>
    <td>5</td>
    <td>5</td>
    <td>5</td>
</tr>








			
--%>
