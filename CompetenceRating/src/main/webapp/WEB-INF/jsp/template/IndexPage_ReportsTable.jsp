<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="panel panel-default" id="previewReports">
    <div class="panel-heading text-center previewReport" style="padding-top: 0; padding-bootom: 0;">Заполненные отчеты
    </div>
    <table class="table table-striped table-hover table-bordered">
        <thead>
        <tr>
            <th>#</th>
            <th>Дата</th>
            <th>Подразделение</th>
            <th>Должность</th>
            <th>Проф.уровень</th>
            <!-- 		      <th>Кампания</th>
             -->        </tr>
        </thead>
        <tbody>
        <c:forEach items="${mainPage.getPreviewReports()}" var="previewReport" varStatus="count">
            <tr class="clicableReport" data-id="${previewReport.getId()}">
                <td class="WidTab2"><c:out value="${count.count}"/></td>
                <td>${previewReport.getFinishDate()}</td>
                <td>${previewReport.getSubdivision().getName()}</td>
                <td>${previewReport.getPosition().getName()}</td>
                <td>${previewReport.getPosition().getLevel()}</td>
                    <%-- 				    <td><c:if test="${not empty previewReport.getCampaign()}">Да</c:if></td>
                     --%>                </tr>
        </c:forEach>
        </tbody>
    </table>
</div>







