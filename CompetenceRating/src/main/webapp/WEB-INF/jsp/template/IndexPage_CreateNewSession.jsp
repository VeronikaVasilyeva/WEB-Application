<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<button type="button" name="newSession" class="btn btn-success BtnWes2 RightFloat" data-toggle="modal"
        data-target="#start" style="float: right;">Начать
</button>

<div id="start" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Новая сессия</h4>
            </div>

            <div class="modal-body">
                <div class="panel panel-success" style="border-color: #ffffff;">
                    <div class="panel-body">
                        <form class="form custom-form" role="form">
                            <div class="form-group">
                                <label class="control-label" id="subdivisionId" data-id="${user.subdivision.getId()}">Подразделение</label>
                                <div>
                                    <select class="form-control subSelect" data-width="fit">
                                        <option value="${user.subdivision.getId()}"
                                                selected="selected">${user.subdivision.getName()}</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label" id="positionName" data-id="${user.position.getName()}">Должность</label>
                                <div>
                                    <select class="form-control form-select posSelect" data-width="fit">
                                        <option value="${user.position.getName()}"
                                                selected="selected">${user.position.getName()}</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label" id="positionLevel" data-id="${user.position.getLevel()}">Проф.уровень</label>
                                <div>
                                    <select class="form-control levSelect" data-width="fit">
                                        <option value="${user.position.getLevel()}"
                                                selected="selected">${user.position.getLevel()}</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>

                <form id="form" method="POST" action="fillCompetence/session/create" class="col-sm-2" style="float: right;">
                    <input type="hidden" name="subdivisionId" value="${user.subdivision.getId()}"/>
                    <input type="hidden" name="positionName" value="${user.position.getName()}"/>
                    <input type="hidden" name="positionLevel" value="${user.position.getLevel()}"/>
                    <button id="startNext" class="btn btn-success" style="float: right;">Далее</button>
                </form>
            </div>
        </div>
    </div>
</div>

