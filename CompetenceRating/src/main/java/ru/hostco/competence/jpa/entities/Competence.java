package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the dict_Competence database table.
 */
@Entity
@Table(name = "dict_Competence")
@NamedQuery(name = "Competence.findAll", query = "SELECT d FROM Competence d")
public class Competence extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CompetenceId")
    private String id;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Name")
    private String name;

    @Column(name = "Uins")
    private String uins;

    @Column(name = "Uupd")
    private String uupd;

    //bi-directional many-to-one association to Dict_Competence
    @ManyToOne
    @JoinColumn(name = "ParentId")
    private Competence dictCompetence;

    //bi-directional many-to-one association to Dict_Competence
    @OneToMany(mappedBy = "dictCompetence")
    private List<Competence> dictCompetences;

    //bi-directional many-to-one association to Doc_UserCompetence
    @OneToMany(mappedBy = "dictCompetence")
    private List<UserCompetence> docUserCompetences;

    //bi-directional many-to-one association to Lnk_CompetencePosition
    @OneToMany(mappedBy = "dictCompetence")
    private List<CompetencePosition> lnkCompetencePositions;

    public Competence() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object competenceId) {
        this.id = (String) competenceId;
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Competence> getDictCompetences() {
        return this.dictCompetences;
    }

    public void setDictCompetences(List<Competence> dictCompetences) {
        this.dictCompetences = dictCompetences;
    }

    public Competence addDictCompetence(Competence dictCompetence) {
        getDictCompetences().add(dictCompetence);
        dictCompetence.setDictCompetence(this);

        return dictCompetence;
    }

    public Competence removeDictCompetence(Competence dictCompetence) {
        getDictCompetences().remove(dictCompetence);
        dictCompetence.setDictCompetence(null);

        return dictCompetence;
    }

    public List<UserCompetence> getDocUserCompetences() {
        return this.docUserCompetences;
    }

    public void setDocUserCompetences(List<UserCompetence> docUserCompetences) {
        this.docUserCompetences = docUserCompetences;
    }

    public UserCompetence addDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().add(docUserCompetence);
        docUserCompetence.setDictCompetence(this);

        return docUserCompetence;
    }

    public UserCompetence removeDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().remove(docUserCompetence);
        docUserCompetence.setDictCompetence(null);

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
        lnkCompetencePosition.setDictCompetence(this);

        return lnkCompetencePosition;
    }

    public CompetencePosition removeLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().remove(lnkCompetencePosition);
        lnkCompetencePosition.setDictCompetence(null);

        return lnkCompetencePosition;
    }

}