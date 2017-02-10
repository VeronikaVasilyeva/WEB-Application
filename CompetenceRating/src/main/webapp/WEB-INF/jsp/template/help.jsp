<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<button type="button" class="btn btn-info BtnWes" data-toggle="modal" data-target="#myModal"
        style="margin-right: 10px;">Справка
</button>

<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Справка</h4>
            </div>
            <div class="modal-body">
                <p>
                    Правила заполнения компетенций:<br>
                    1. Нельзя начинать новое заполнение, если не завершено старое.
                    2. После заполнения обязательных компетенций(по умолчанию) сотрудник в праве выбрать дополнительные
                    компетенции из списка.
                    3. При самостоятельном заполнении матрицы вне кампании есть возможность выбирать другую должность и
                    подразделение.
                    <br><br>
                    Правила обновления информации компетенций: <br>
                    1. Обновление информации о новых знаниях, опыте производятся сразу по:
                    a. Окончанию соответствующих разработок;
                    b. Окончанию курсов, сдаче экзаменов, самостоятельного обучения.
                    2. Целевые знания заполняются самостоятельно на основе предпочтений сотрудника. При этом, правила
                    повышения не должны противоречить схеме (см. "Правила перехода знаний")
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
            </div>
        </div>

    </div>
</div>
