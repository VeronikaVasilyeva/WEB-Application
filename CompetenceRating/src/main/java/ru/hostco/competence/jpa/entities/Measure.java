package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the dict_Measure database table.
 */
@Entity
@Table(name = "dict_Measure")
@NamedQuery(name = "Measure.findAll", query = "SELECT d FROM Measure d")
public class Measure extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MeasureId")
    private String id;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Name")
    private String name;

    //bi-directional many-to-one association to Doc_UserCompetence
    @OneToMany(mappedBy = "dictMeasure")
    private List<UserCompetence> docUserCompetences;

    //bi-directional many-to-one association to Lnk_CompetencePosition
    @OneToMany(mappedBy = "dictMeasure")
    private List<CompetencePosition> lnkCompetencePositions;

    public Measure() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object measureId) {
        this.id = (String) measureId;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserCompetence> getDocUserCompetences() {
        return this.docUserCompetences;
    }

    public void setDocUserCompetences(List<UserCompetence> docUserCompetences) {
        this.docUserCompetences = docUserCompetences;
    }

    public UserCompetence addDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().add(docUserCompetence);
        docUserCompetence.setDictMeasure(this);

        return docUserCompetence;
    }

    public UserCompetence removeDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().remove(docUserCompetence);
        docUserCompetence.setDictMeasure(null);

        return docUserCompetence;
    }

    public List<CompetencePosition> getLnkCompetencePositions() {
        return this.lnkCompetencePositions;
    }

    public void setLnkCompetencePositions(List<CompetencePosition> lnkCompetencePositions) {
        this.lnkCompetencePositions = lnkCompetencePositions;
    }

    public CompetencePosition addLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().add(lnkCompetencePosition);
        lnkCompetencePosition.setDictMeasure(this);

        return lnkCompetencePosition;
    }

    public CompetencePosition removeLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().remove(lnkCompetencePosition);
        lnkCompetencePosition.setDictMeasure(null);

        return lnkCompetencePosition;
    }

}