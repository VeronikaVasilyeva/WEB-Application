package ru.hostco.competence.web.page.data;

import java.util.HashMap;

public class CompetenceData {
    private String id;
    private String name;
    private HashMap<String, Short> measureRatings;

    public CompetenceData() {

    }

    public CompetenceData(String id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public HashMap<String, Short> getMeasureRatings() {
        return measureRatings;
    }

    public void setMeasureRatings(HashMap<String, Short> measureRatings) {
        this.measureRatings = measureRatings;
    }

}
