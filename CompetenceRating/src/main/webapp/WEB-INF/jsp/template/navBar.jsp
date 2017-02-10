<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-custom navbar-default navbar-fixed-top">
    <div class="container-fluid container-fluid-custom">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false"></button>
        </div>

        <c:set var="href" value="/reports"/>
        <c:set var="current" value="${mainPage.getPreviewReports()[0]}" scope="request"/>

        <!-- Левая часть навбара -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <img class="logo" src="<c:url value="/resources/images/Logo_Vector_White.svg"/>"/>
                <li><a href="/" class="White">Главная</a></li>
                <li id="reportLink"><a href=${href}/${current.getId()} class="White">Текущие компетенции</a></li>
                <li><a href="" class="White"> </a></li>
            </ul>

            <!-- Правая часть навбара -->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" class="White">${user.subdivision.name}</a></li>
                <li><a href="#" class="White">${user.position.name} (${user.position.level})</a></li>
                <li><a href="#" class="White" style="padding-right: 200px;">${user.name}</a></li>
                <%--                <li class="avLi">
                                    <a href=""><img src="<c:url value="/resources/images/black_Card.png"/>" alt="avatare" class="avatareMin"></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle dropdown-toggle-custom White" data-toggle="dropdown"
                                       role="button" aria-haspopup="true" aria-expanded="false"> <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Action</a></li>
                                        <li><a href="#">Another action</a></li>
                                        <li><a href="#">Something else here</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Separated link</a></li>
                                    </ul>
                                </li>--%>
            </ul>
        </div>
    </div>

</nav>