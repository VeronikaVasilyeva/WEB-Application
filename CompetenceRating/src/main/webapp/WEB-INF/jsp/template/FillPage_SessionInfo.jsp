<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="session" scope="page" value="${fillingPage.getSessionInfo()}"/>

<div class="container-fluid" id="sessionInfo" style="margin: 0 9px 0 9px;">
    <div class="row">
        <div class="panel panel-default usercontext">
            <div class="panel-body">
                <ul class="line-one">
                    <li>Подразделение <span class="text-muted">${session.getSubdivision().getName()}</span></li>
                    <li>Должность <span class="text-muted">${session.getPosition().getName()}</span></li>
                    <li>Проф.Уровень <span class="text-muted">${session.getPosition().getLevel()}</span></li>
                </ul>
                <ul class="line-one">
                    <c:if test="${not empty session.getUpdateDate()}">
                        <li>Последнее обновление: <span class="text-muted">${session.getUpdateDate()}</span></li>
                    </c:if>
                    <c:if test="${not empty session.getStartDate()}">
                        <li>Начало заполнения: <span class="text-muted">${session.getStartDate()}</span></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
