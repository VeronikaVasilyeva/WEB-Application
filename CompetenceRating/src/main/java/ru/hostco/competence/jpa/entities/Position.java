package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "dict_Position")
@NamedQuery(name = "Position.findAll", query = "SELECT d FROM Position d")
public class Position extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PositionId")
    private String id;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Level")
    private String level;

    @Column(name = "Name")
    private String name;

    @Column(name = "Uins")
    private String uins;

    @Column(name = "Uupd")
    private String uupd;

    //bi-directional many-to-one association to Doc_Session
    @OneToMany(mappedBy = "dictPosition")
    private List<Session> docSessions;

    //bi-directional many-to-one association to Lnk_CompetencePosition
    @OneToMany(mappedBy = "dictPosition")
    private List<CompetencePosition> lnkCompetencePositions;

    public Position() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object positionId) {
        this.id = (String) positionId;
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

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
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

    public List<Session> getDocSessions() {
        return this.docSessions;
    }

    public void setDocSessions(List<Session> docSessions) {
        this.docSessions = docSessions;
    }

    public Session addDocSession(Session docSession) {
        getDocSessions().add(docSession);
        docSession.setDictPosition(this);

        return docSession;
    }

    public Session removeDocSession(Session docSession) {
        getDocSessions().remove(docSession);
        docSession.setDictPosition(null);

        return docSession;
    }

    public List<CompetencePosition> getLnkCompetencePositions() {
        return this.lnkCompetencePositions;
    }

    public void setLnkCompetencePositions(List<CompetencePosition> lnkCompetencePositions) {
        this.lnkCompetencePositions = lnkCompetencePositions;
    }

    public CompetencePosition addLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().add(lnkCompetencePosition);
        lnkCompetencePosition.setDictPosition(this);

        return lnkCompetencePosition;
    }

    public CompetencePosition removeLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().remove(lnkCompetencePosition);
        lnkCompetencePosition.setDictPosition(null);

        return lnkCompetencePosition;
    }

}