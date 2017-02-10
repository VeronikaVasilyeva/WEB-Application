<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="panel-body" style="border: none">
    <div class="header-fillpage">
        <h4 class="normalizeHeader header"></h4>
    </div>

    <div class="panel-body fill-form">
        <div style="display: inline-block; border: none">
            <div class="form-group card-main">
                <h4>Знания</h4>
                <div class="inner-div">
                    <div class="btn-group btn-group-sm" data-toggle="buttons" style="display: inline-block;">
                        <label class="btn btn-default active">
                            <input type="radio" name="knowlege" id="knowledge0" value="0" autocomplete="off" checked> 0
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="knowlege" id="knowledge1" value="1" autocomplete="off"> 1
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="knowlege" id="knowledge2" value="2" autocomplete="off"> 2
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="knowlege" id="knowledge3" value="3" autocomplete="off"> 3
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="knowlege" id="knowledge4" value="4" autocomplete="off"> 4
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="knowlege" id="knowledge5" value="5" autocomplete="off"> 5
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group card-main">
                <h4>Опыт</h4>
                <div class="inner-div">
                    <div class="btn-group btn-group-sm" data-toggle="buttons" style="display: inline-block;">
                        <label class="btn btn-default active">
                            <input type="radio" name="experience" id="experience0" value="0" autocomplete="off" checked> 0
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="experience" id="experience1" value="1" autocomplete="off"> 1
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="experience" id="experience2" value="2" autocomplete="off"> 2
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="experience" id="experience3" value="3" autocomplete="off"> 3
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="experience" id="experience4" value="4" autocomplete="off"> 4
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="experience" id="experience5" value="5" autocomplete="off"> 5
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group card-main">
                <h4>Цель</h4>
                <div class="inner-div">
                    <div class="btn-group btn-group-sm" data-toggle="buttons" style="display: inline-block;">
                        <label class="btn btn-default active">
                            <input type="radio" name="goal" id="goal0" value="0" autocomplete="off" checked> 0
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="goal" id="goal1" value="1" autocomplete="off"> 1
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="goal" id="goal2" value="2" autocomplete="off"> 2
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="goal" id="goal3" value="3" autocomplete="off"> 3
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="goal" id="goal4" value="4" autocomplete="off"> 4
                        </label>
                        <label class="btn btn-default">
                            <input type="radio" name="goal" id="goal5" value="5" autocomplete="off"> 5
                        </label>
                    </div>
                </div>
            </div>

            <div class="form-group card-main">
                <h4>Период</h4>
                <div class="inner-div ">
                    <select id="sel1" class="form-control select-style" data-toggle="options" data-width="fit" style="font-size: 12px;">
                        <option value="0" selected="selected">нет знаний</option>
                        <option value="1">более 4 лет назад</option>
                        <option value="2">более 2 лет назад</option>
                        <option value="3">от 1 до 2 лет назад</option>
                        <option value="4">от 6 до 12 месяцев назад</option>
                        <option value="5">менее 6 месяцев назад</option>
                    </select>
                </div>
            </div>
        </div>
    </div>
</div>