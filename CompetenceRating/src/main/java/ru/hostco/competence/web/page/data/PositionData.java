package ru.hostco.competence.web.page.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonRootName(value = "position")
@JsonTypeName("position")
public class PositionData {

    @JsonIgnore
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("lavel")
    private String level;

    public PositionData(String id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public PositionData() {
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Id " + id + " Name " + name + " Level " + level;
    }
}