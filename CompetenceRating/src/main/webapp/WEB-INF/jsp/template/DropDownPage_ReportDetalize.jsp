<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row" style="margin: 10px;">
     <button type="button" class="btn btn-default btnPos LeftFloat" onclick="goBackToTable();">Назад к таблице</button>
     <button type="button" class="btn btn-default btnPos RightFloat" onclick="showAllReport()">Показать весь отчет</button>
</div>

<table class="table table-hover" id="detalizeTable">
    <col width="400">
    <tr>
        <td></td>
        <td><h4 class="modal-title">Знания</h4></td>
        <td><h4 class="modal-title">Опыт</h4></td>
        <td><h4 class="modal-title">Период</h4></td>
        <td><h4 class="modal-title">Цель</h4></td>
    </tr>
    <tr class="blueline">
        <td><h4 class="modal-title">СУБД</h4></td>
        <td><h4 class="modal-title">5</h4></td>
        <td><h4 class="modal-title">3</h4></td>
        <td><h4 class="modal-title">2</h4></td>
        <td><h4 class="modal-title">4</h4></td>
    </tr>

    <tr class="CompName" data-toggle="collapse" data-target="#demo">
        <td><a>Oracle</a></td>
        <td>5</td>
        <td>3</td>
        <td>2</td>
        <td>4</td>
    </tr>
    <tr>
        <td colspan="5" style="padding: 0">
            <div id="demo" class="collapse">
                <table class="table table-bordered">
                    <col width="400">
                    <tr>
                        <td>Администрирование</td>
                        <td>4</td>
                        <td>3</td>
                        <td>3</td>
                        <td>5</td>
                    </tr>
                    <tr>
                        <td class="CompName2">Разработка (PL/SQL)</td>
                        <td class="rating">4</td>
                        <td class="rating">3</td>
                        <td class="rating">3</td>
                        <td class="rating">5</td>
                    </tr>
                    <tr>
                        <td class="CompName2">Использование (как пользователь)</td>
                        <td class="rating">4</td>
                        <td class="rating">3</td>
                        <td class="rating">3</td>
                        <td class="rating">5</td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>

</table>
