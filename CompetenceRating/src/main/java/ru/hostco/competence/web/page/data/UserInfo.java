package ru.hostco.competence.web.page.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("UserInfo")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
@JsonRootName(value = "User")
public class UserInfo {

    @JsonIgnore
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("subdivision")
    private SubdivisionData subdivision;

    @JsonProperty("position")
    private PositionData position;

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

    public SubdivisionData getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(SubdivisionData subdivision) {
        this.subdivision = subdivision;
    }

    public PositionData getPosition() {
        return position;
    }

    public void setPosition(PositionData position) {
        this.position = position;
    }

}
