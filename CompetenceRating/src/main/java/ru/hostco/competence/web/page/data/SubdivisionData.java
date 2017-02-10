package ru.hostco.competence.web.page.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
/*
import com.sun.org.apache.xpath.internal.operations.String;
*/
//TODO: не поняла зачем этот импорт выше, так же есть в sessionPreview, пока закоментила

@JsonRootName(value = "Subdivision")
@JsonTypeName("subdivision")
public class SubdivisionData {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    public SubdivisionData(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public SubdivisionData() {
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

    @Override
    public String toString() {
        return "Id" + id + " Name " + name;
    }
}
