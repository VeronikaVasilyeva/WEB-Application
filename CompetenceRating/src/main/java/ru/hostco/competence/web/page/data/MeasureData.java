package ru.hostco.competence.web.page.data;

//FIXME: если эта штука нигде не используется, надо бы удалить. Хотел добавить ее как ключ в HashMap с оценками в классе CompetenceData, но там возникли траблы с сериализацией\десериализацией в Json.
public class MeasureData {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MeasureData() {

    }

    public MeasureData(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
