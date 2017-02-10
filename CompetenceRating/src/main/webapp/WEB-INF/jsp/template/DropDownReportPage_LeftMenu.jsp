<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="panel-group" id="accordion">

    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2 blueline">
            <div class="blueline">Список компетенций</div>
        </div>

        <c:set var="count" value="1" scope="request"/>
        <c:set var="href"  value="open"/>
        <c:set var="href1" value="open"/>

        <c:forEach var="ParentNode" items="${competences}">

            <div class="panel-heading panel-heading-custom2 parentCompetence">
                <a data-toggle="collapse" data-parent="#accordion" aria-expanded="false" href=#${href}${count} data-id="${ParentNode.getValue().getId()}" >
                        ${ParentNode.getValue().getName()}
                    <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
                </a>
            </div>

            <c:if test="${!empty ParentNode.getChilds()}">
                <div class="collapse" id="${href}${count}">
                    <c:forEach var="node" items="${ParentNode.getChilds()}">
                        <div class="panel-body childCompetence" data-id="${node.getValue().getId()}">
                            <a href="#">${node.getValue().getName()}</a>
                        </div>

                        <c:if test="${!empty node.getChilds()}">
                            <div class="collapse" id="${href1}${count}">
                                <c:forEach var="node1" items="${node.getChilds()}">
                                    <div class="panel-body " data-id="${node1.getValue().getId()}">
                                        <a href="#">${node1.getValue().getName()}</a>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:if>
                    </c:forEach>
                </div>
            </c:if>

            <c:set var="count" value="${count+1}" scope="request"/>
        </c:forEach>
    </div>

</div>

<!-- Нижний (левый) профиль -->
<div class="bottomProfile" style="padding-left: 10px">
    <ul>
        <li class="TextTitle">Подразделение:<span class="inlineMin">${sessionInfo.getSubdivision().getName()}</span>
        </li>
        <li class="TextTitle">Дата отчета:<span class="inlineMin">${sessionInfo.getFinishDate()}</span></li>
        <li class="TextTitle">Должность:<span class="inlineMin">${sessionInfo.getPosition().getName()}</span></li>
    </ul>
</div>

<%--
    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2">
            <a data-toggle="collapse" data-parent="#accordion" href="#OpenLeft2">
                Языки програмирования <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
            </a>
        </div>
        <div id="OpenLeft2" class="collapse">
            <div class="panel-body"><a href="#">Java</a></div>
            <div class="panel-body"><a href="#">C#</a></div>
            <div class="panel-body"><a href="#">Javascript</a></div>
        </div>
    </div>

    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2">
            <a data-toggle="collapse" data-parent="#accordion" href="#OpenLeft3">
                Интеграционное ПО <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
            </a>
        </div>
        <div id="OpenLeft3" class="collapse">
            <div class="panel-body"><a href="#">IBM WebSphere MQ</a></div>
            <div class="panel-body"><a href="#">IBM WebSphere ESB</a></div>
            <div class="panel-body"><a href="#">IBM WebSphere Message Broker (Integration Bus)</a></div>
            <div class="panel-body"><a href="#">IBM WebSphere Process Server</a></div>
            <div class="panel-body"><a href="#">IBM BPM</a></div>
            <div class="panel-body"><a href="#">IBM WebSphere Application Server</a></div>
            <div class="panel-body"><a href="#">Bonita BPM</a></div>
            <div class="panel-body"><a href="#">Talend ESB</a></div>
        </div>
    </div>

    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2">
            <a data-toggle="collapse" data-parent="#accordion" href="#OpenLeft4">
                Порталы <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
            </a>
        </div>
        <div id="OpenLeft4" class="collapse">
            <div class="panel-body"><a href="#">Microsoft SharePoint</a></div>
            <div class="panel-body"><a href="#">LifeRay</a></div>
        </div>
    </div>

    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2">
            <a data-toggle="collapse" data-parent="#accordion" href="#OpenLeft5">
                Средства тестирования ПО <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
            </a>
        </div>
        <div id="OpenLeft5" class="collapse">
            <div class="panel-body"><a href="#">TeamCity</a></div>
            <div class="panel-body"><a href="#">SoapUI</a></div>
            <div class="panel-body"><a href="#">Selenium</a></div>
            <div class="panel-body"><a href="#">Maven</a></div>
            <div class="panel-body"><a href="#">ANT</a></div>
            <div class="panel-body"><a href="#">Rational Test Workbench</a></div>
            <div class="panel-body"><a href="#">Redmine</a></div>
        </div>
    </div>


    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2">
            <a data-toggle="collapse" data-parent="#accordion" href="#OpenLeft6">
                Методологии <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
            </a>
        </div>
        <div id="OpenLeft6" class="collapse">
            <div class="panel-body"><a href="#">TeamCity</a></div>
            <div class="panel-body"><a href="#">SoapUI</a></div>
            <div class="panel-body"><a href="#">Selenium</a></div>
            <div class="panel-body"><a href="#">Maven</a></div>
            <div class="panel-body"><a href="#">ANT</a></div>
            <div class="panel-body"><a href="#">Rational Test Workbench</a></div>
            <div class="panel-body"><a href="#">Redmine</a></div>
        </div>
    </div>


    <div class="panel panel-default panel-default-menu">
        <div class="panel-heading panel-heading-custom2">
            <a data-toggle="collapse" data-parent="#accordion" href="#OpenLeft7">
                Электронные архивы <span class="glyphicon glyphicon-chevron-down glyphiconCustom"></span>
            </a>
        </div>
        <div id="OpenLeft7" class="collapse">
            <div class="panel-body"><a href="#">FileNet</a></div>
            <div class="panel-body"><a href="#">Nuxeo</a></div>
            <div class="panel-body"><a href="#">Alfresco</a></div>
        </div>
    </div>
</div>--%>
