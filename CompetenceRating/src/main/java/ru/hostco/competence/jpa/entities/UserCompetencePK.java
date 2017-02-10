package ru.hostco.competence.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the doc_UserCompetence database table.
 */
@Embeddable
public class UserCompetencePK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "SessionId")
    private String sessionId;

    @Column(name = "CompetenceId")
    private String competenceId;

    @Column(name = "MeasureId")
    private String measureId;

    public UserCompetencePK() {
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCompetenceId() {
        return this.competenceId;
    }

    public void setCompetenceId(String competenceId) {
        this.competenceId = competenceId;
    }

    public String getMeasureId() {
        return this.measureId;
    }

    public void setMeasureId(String measureId) {
        this.measureId = measureId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserCompetencePK)) {
            return false;
        }
        UserCompetencePK castOther = (UserCompetencePK) other;
        return
                this.userId.equals(castOther.userId)
                        && this.sessionId.equals(castOther.sessionId)
                        && this.competenceId.equals(castOther.competenceId)
                        && this.measureId.equals(castOther.measureId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.userId.hashCode();
        hash = hash * prime + this.sessionId.hashCode();
        hash = hash * prime + this.competenceId.hashCode();
        hash = hash * prime + this.measureId.hashCode();

        return hash;
    }
}