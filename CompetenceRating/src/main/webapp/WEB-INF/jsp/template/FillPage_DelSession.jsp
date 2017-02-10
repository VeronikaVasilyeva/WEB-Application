<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<button type="button" name="delSession" class="btn btn-danger BtnWes" data-toggle="modal" data-target="#deleteSession"
        style="margin-right: 10px; margin-top: 10px;margin-bottom: 10px;">Не сохранять
</button>

<div id="deleteSession" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Вы уверены, что хотите удалить сессию без сохранения?</h4>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="display: inline">Отмена
                </button>
                <form action="/fillCompetence/session/delete" method="GET" style="display: inline">
                    <button class="btn btn-success">Да</button>
                </form>
            </div>
        </div>
    </div>
</div>

