<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spel" uri="http://www.springframework.org/tags" %>

<c:set var="ParentLevel" value="${level}" scope="request"/>
<c:set var="level" value="${ParentLevel + 1}" scope="request"/>
<c:set var="count" value="${count+1}" scope="request"/>
<c:set var="href" value="collapse"/>

<ul>
    <c:forEach var="childNode" items="${node.getChilds()}">
    <c:if test="${!empty childNode.getChilds() || level == 1}">
    <c:choose>
    <c:when test="${level == 1 && !empty childNode.getChilds()}">
    <a data-toggle="collapse" href=#${href}${count} class="list-group-item list-group-item-custom threeLevel"
       data-id="${childNode.getValue().getId()}">
        </c:when>
        <c:when test="${level == 1 && empty childNode.getChilds()}">
        <a data-toggle="collapse" href=#${href}${count} class="list-group-item list-group-item-custom twoLevel"
           data-id="${childNode.getValue().getId()}">
            </c:when>
            </c:choose>

            <div class="menuItem">${childNode.getValue().getName()}</div>

                <%--��� �����? --%>
            <c:if test="${!empty childNode.getValue().getMeasureRatings()}">
                <div class="RightFloat col-md-1">
                    <span class="badge positionRounds">${childNode.getValue().getMeasureRatings()}</span>
                </div>
            </c:if>

            <spel:eval
                    var="filledCount"
                    expression="T(ru.hostco.competence.utils.Utils).countFilledCompetences(childNode.getChilds())"/>
            <spel:eval
                    var="totalCount"
                    expression="T(ru.hostco.competence.utils.Utils).countTotalChildCompetences(childNode.getChilds())"/>

            <c:choose>
                <c:when test="${!empty childNode.getChilds()}">
                    <div class="RightFloat col-md-1">
                        <span class="badge positionRounds">${filledCount}/${totalCount}</span></div>
                </c:when>
                <c:when test="${empty childNode.getChilds() && !empty childNode.getValue() && !empty childNode.getValue().getMeasureRatings()}">
                    <div class="RightFloat col-md-1"><span class="badge positionRounds">1/1</span></div>
                </c:when>
                <c:when test="${empty childNode.getChilds() && !empty childNode.getValue() && empty childNode.getValue().getMeasureRatings()}">
                    <div class="RightFloat col-md-1"><span class="badge positionRounds">0/1</span></div>
                </c:when>
            </c:choose>
        </a>

            <c:set var="node" value="${childNode}" scope="request"/>
        <c:if test="${!empty node.getChilds()}">
        <div class="panel-collapse collapse" style="border: none;" id=${href}${count}>
            <div class="panel-body" style="border: none;">
                <c:set var="ParentLevel" value="${level}" scope="request"/>
                <jsp:include page="FillPage_LeftMenuNode.jsp"/>
            </div>
        </div>
        </c:if>
        <c:if test="${level != 1}">
            <c:set var="level" value="${level-1}" scope="request"/>
        </c:if>
        </c:if>

        </c:forEach>

        <c:set var="count" value="${count+1}" scope="request"/>

</ul>
