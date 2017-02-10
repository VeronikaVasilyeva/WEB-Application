<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spel" uri="http://www.springframework.org/tags" %>

<div class="panel-group">

    <c:set var="count" value="0" scope="request"/>
    <c:set var="href" value="collapse"/>

    <c:forEach var="ParentNode" items="${fillingPage.getRequiredCompetences()}">
        <c:set var="level" value="0" scope="request"/>

        <div class="panel panel-default panel-custom" style="border: none;">
            <div class="panel-heading-custom panel-heading">
                <h4 class="panel-title panel-title-custom">
                    <a data-toggle="collapse" data-id="${ParentNode.getValue().getId()}" href=#${href}${count} >
                        <div class="menuItem"> ${ParentNode.getValue().getName()} </div>
                        <div class="RightFloat col-md-1">
                            <c:if test="${!empty ParentNode.getChilds()}">
                                <spel:eval
                                        expression="T(ru.hostco.competence.utils.Utils).countFilledCompetences(ParentNode.getChilds())"
                                        var="filledCount"/>
                                <spel:eval
                                        expression="T(ru.hostco.competence.utils.Utils).countTotalChildCompetences(ParentNode.getChilds())"
                                        var="totalCount"/>
                                <span class="badge badge-custom">${filledCount}/${totalCount}</span>
                            </c:if>
                        </div>
                    </a>
                </h4>
            </div>

            <c:if test="${!empty ParentNode.getChilds()}">
                <c:set var="node" value="${ParentNode}" scope="request"/>

                <div class="panel-collapse collapse" style="border: none;" id=${href}${count}>
                    <jsp:include page="FillPage_LeftMenuNode.jsp"/>
                </div>
            </c:if>
        </div>
    </c:forEach>
</div>
