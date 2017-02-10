package ru.hostco.competence.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the lnk_SubdivisionExecutive database table.
 */
@Embeddable
public class SubdivisionExecutivePK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "SubdivisionId")
    private String subdivisionId;

    @Column(name = "UserId")
    private String userId;

    public SubdivisionExecutivePK() {
    }

    public String getSubdivisionId() {
        return this.subdivisionId;
    }

    public void setSubdivisionId(String subdivisionId) {
        this.subdivisionId = subdivisionId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubdivisionExecutivePK)) {
            return false;
        }
        SubdivisionExecutivePK castOther = (SubdivisionExecutivePK) other;
        return
                this.subdivisionId.equals(castOther.subdivisionId)
                        && this.userId.equals(castOther.userId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.subdivisionId.hashCode();
        hash = hash * prime + this.userId.hashCode();

        return hash;
    }
}