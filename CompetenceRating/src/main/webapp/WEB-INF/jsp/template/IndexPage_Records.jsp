<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container-fluid">
    <c:if test="${!empty mainPage.getOpenSession()}">
        <div class="row" id="record1">
            <div class="well center-block container-fluid">
                <div class="col-sm-10">
                    <span class="glyphicon glyphicon-chevron-right gi-1x" style="display: inline;"></span>
                    <p class="record-header">Незавершенная сессия</p>

                    <c:set var="session" scope="page" value="${mainPage.getOpenSession()}"/>

                    <div class="row">
                        <div class="container record">
                            <p style="display: inline-block;">Подразделение:
                                <small class="text-muted">${session.getSubdivision().getName()}</small>
                            </p>
                            <p style="display: inline-block;">Должность:
                                <small class="text-muted">${session.getPosition().getName()}</small>
                            </p>
                            <p style="display: inline-block;">Проф.уровень:
                                <small class="text-muted">${session.getPosition().getLevel()}</small>
                            </p>
                        </div>
                        <div class="container record">
                            <c:if test="${not empty session.getUpdateDate()}">
                                <p style="display: inline-block;">Последнее обновление:
                                    <small class="text-muted">${session.getUpdateDate()}</small>
                                </p>
                            </c:if>
                            <c:if test="${not empty session.getStartDate()}">
                                <p style="display: inline-block;">Начало заполнения:
                                    <small class="text-muted">${session.getStartDate()}</small>
                                </p>
                            </c:if>
                            <c:if test="${not empty session.getFinishDate()}">
                                <p style="display: inline-block;">Окончание заполнения:
                                    <small class="text-muted-end">${session.getFinishDate()}</small>
                                </p>
                            </c:if>
                        </div>
                    </div>
                </div>

                <form action="fillCompetence/session" method="GET" class="col-sm-2">
                    <button <%--name="id" value="${session.getId()}"--%> class="btn btn-danger BtnWes2 RightFloat"
                                                                         style="float: right;">Продолжить
                    </button>
                </form>

            </div>
        </div>
    </c:if>

    <%--  		<c:if test="${not empty mainPage.getAssignedCampaign() && empty mainPage.getOpenSession()}">
                 <div class="row" id="record2">
                    <div class="well center-block container-fluid">
                        <div class="col-sm-10">
                            <span class="glyphicon glyphicon-chevron-right gi-1x"></span>
                            <p class="record-header">Назначена  новая кампания</p>

                            <c:set var="campaign" scope="page" value="${mainPage.getAssignedCampaign()}"/>

                            <div class="row">
                                <div class="container-fluid">
                                    <p style="display: inline-block;">Подразделение: <small class="text-muted">${campaign.getSubdivision().getName()}</small></p>
                                    <p style="display: inline-block;">Должность:  <small class="text-muted">${campaign.getPosition().getName()}</small></p>
                                    <p style="display: inline-block;">Проф.уровень:  <small class="text-muted">${campaign.getPosition().getLevel()}</small></p>
                                </div>
                                <div class="container-fluid">
                                    <c:if test="${not empty campaign.getStartDate()}"><p style="display: inline-block;">Начало кампании: <small class="text-muted">${campaign.getStartDate()}</small></p></c:if>
                                    <c:if test="${not empty campaign.getFinishDate()}"><p style="display: inline-block;">Окончание кампании: <small class="text-muted-end">${campaign.getFinishDate()}</small></p></c:if><br/>
                                </div>
                            </div>
                        </div>

                        <form method="GET" action="fillCompetence/campaign" class="col-sm-2">
                            <button name="id" value="${page.getCampaign().getId()}" class="btn btn-warning BtnWes2 RightFloat" style="float: right;" >Начать</button>
                        </form>

                    </div>
                </div>
             </c:if>	 --%>


    <%--
             <c:if test="${empty mainPage.getAssignedCampaign() && empty mainPage.getOpenSession()}">
    --%>
    <c:if test="${empty mainPage.getOpenSession()}">
        <div class="row" id="record3">
            <div class="well center-block container-fluid">
                <div class="col-sm-10">
                    <span class="glyphicon glyphicon-chevron-right gi-1x" style="display: inline;"></span>
                    <p class="record-header">Новая сессия</p>
                </div>

                <form class="col-sm-2">
                    <jsp:include page="/WEB-INF/jsp/template/IndexPage_CreateNewSession.jsp"/>
                </form>
            </div>
        </div>
    </c:if>
</div>