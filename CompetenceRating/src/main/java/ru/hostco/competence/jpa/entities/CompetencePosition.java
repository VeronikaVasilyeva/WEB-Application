package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the lnk_CompetencePosition database table.
 */
@Entity
@Table(name = "lnk_CompetencePosition")
@NamedQuery(name = "CompetencePosition.findAll", query = "SELECT l FROM CompetencePosition l")
public class CompetencePosition extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CompetencePositionPK id;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "RequiredRating")
    private short requiredRating;

    @Column(name = "Uins")
    private String uins;

    @Column(name = "Uupd")
    private String uupd;

    //bi-directional many-to-one association to Dict_Competence
    @ManyToOne
    @JoinColumn(name = "CompetenceId", insertable = false, updatable = false)
    private Competence dictCompetence;

    //bi-directional many-to-one association to Dict_Measure
    @ManyToOne
    @JoinColumn(name = "MeasureId", insertable = false, updatable = false)
    private Measure dictMeasure;

    //bi-directional many-to-one association to Dict_Position
    @ManyToOne
    @JoinColumn(name = "PositionId", insertable = false, updatable = false)
    private Position dictPosition;

    //bi-directional many-to-one association to Dict_Subdivision
    @ManyToOne
    @JoinColumn(name = "SubdivisionId", insertable = false, updatable = false)
    private Subdivision dictSubdivision;

    public CompetencePosition() {
    }

    public CompetencePositionPK getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (CompetencePositionPK) id;
    }

    public Timestamp getDins() {
        return this.dins;
    }

    public void setDins(Timestamp dins) {
        this.dins = dins;
    }

    public Timestamp getDupd() {
        return this.dupd;
    }

    public void setDupd(Timestamp dupd) {
        this.dupd = dupd;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public short getRequiredRating() {
        return this.requiredRating;
    }

    public void setRequiredRating(short requiredRating) {
        this.requiredRating = requiredRating;
    }

    public String getUins() {
        return this.uins;
    }

    public void setUins(String uins) {
        this.uins = uins;
    }

    public String getUupd() {
        return this.uupd;
    }

    public void setUupd(String uupd) {
        this.uupd = uupd;
    }

    public Competence getDictCompetence() {
        return this.dictCompetence;
    }

    public void setDictCompetence(Competence dictCompetence) {
        this.dictCompetence = dictCompetence;
    }

    public Measure getDictMeasure() {
        return this.dictMeasure;
    }

    public void setDictMeasure(Measure dictMeasure) {
        this.dictMeasure = dictMeasure;
    }

    public Position getDictPosition() {
        return this.dictPosition;
    }

    public void setDictPosition(Position dictPosition) {
        this.dictPosition = dictPosition;
    }

    public Subdivision getDictSubdivision() {
        return this.dictSubdivision;
    }

    public void setDictSubdivision(Subdivision dictSubdivision) {
        this.dictSubdivision = dictSubdivision;
    }

}