package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the doc_UserCompetence database table.
 */
@Entity
@Table(name = "doc_UserCompetence")
@NamedQuery(name = "UserCompetence.findAll", query = "SELECT d FROM UserCompetence d")
public class UserCompetence extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserCompetencePK id;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Rating")
    private short rating;

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

    //bi-directional many-to-one association to Doc_Session
    @ManyToOne
    @JoinColumn(name = "SessionId", insertable = false, updatable = false)
    private Session docSession;

    //TODO: ID юзера теперь привязан к ID сессии, и здесь по сути просто дублируется. По хорошему, надо бы удалить отсюда.
    //bi-directional many-to-one association to Sys_User
    @ManyToOne
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    private User sysUser;

    public UserCompetence() {
    }

    public UserCompetencePK getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (UserCompetencePK) id;
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

    public short getRating() {
        return this.rating;
    }

    public void setRating(short rating) {
        this.rating = rating;
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

    public Session getDocSession() {
        return this.docSession;
    }

    public void setDocSession(Session docSession) {
        this.docSession = docSession;
    }

    public User getSysUser() {
        return this.sysUser;
    }

    public void setSysUser(User sysUser) {
        this.sysUser = sysUser;
    }

}