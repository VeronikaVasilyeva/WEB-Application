package ru.hostco.competence.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the lnk_CompetencePosition database table.
 */
@Embeddable
public class CompetencePositionPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "CompetenceId")
    private String competenceId;

    @Column(name = "PositionId")
    private String positionId;

    @Column(name = "SubdivisionId")
    private String subdivisionId;

    @Column(name = "MeasureId")
    private String measureId;

    public CompetencePositionPK() {
    }

    public String getCompetenceId() {
        return this.competenceId;
    }

    public void setCompetenceId(String competenceId) {
        this.competenceId = competenceId;
    }

    public String getPositionId() {
        return this.positionId;
    }

    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    public String getSubdivisionId() {
        return this.subdivisionId;
    }

    public void setSubdivisionId(String subdivisionId) {
        this.subdivisionId = subdivisionId;
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
        if (!(other instanceof CompetencePositionPK)) {
            return false;
        }
        CompetencePositionPK castOther = (CompetencePositionPK) other;
        return
                this.competenceId.equals(castOther.competenceId)
                        && this.positionId.equals(castOther.positionId)
                        && this.subdivisionId.equals(castOther.subdivisionId)
                        && this.measureId.equals(castOther.measureId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.competenceId.hashCode();
        hash = hash * prime + this.positionId.hashCode();
        hash = hash * prime + this.subdivisionId.hashCode();
        hash = hash * prime + this.measureId.hashCode();

        return hash;
    }
}