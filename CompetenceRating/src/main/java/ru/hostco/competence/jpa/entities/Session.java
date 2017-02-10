package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * The persistent class for the doc_Session database table.
 */
@Entity
@Table(name = "doc_Session")
@NamedQuery(name = "Session.findAll", query = "SELECT d FROM Session d")
public class Session extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SessionId")
    private String id;

    @Column(name = "DateClosed")
    private Timestamp dateClosed;

    @Column(name = "DateOpened")
    private Timestamp dateOpened;

    @Column(name = "DateUpdated")
    private Timestamp dateUpdated;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Uins")
    private String uins;

    @Column(name = "Uupd")
    private String uupd;

    //bi-directional many-to-one association to Dict_Position
    @ManyToOne
    @JoinColumn(name = "UserId")
    private User sysUser;

    //bi-directional many-to-one association to Dict_Position
    @ManyToOne
    @JoinColumn(name = "SubdivisionId")
    private Subdivision dictSubdivision;

    //bi-directional many-to-one association to Dict_Position
    @ManyToOne
    @JoinColumn(name = "PositionId")
    private Position dictPosition;

    //bi-directional many-to-one association to Doc_UserCompetence
    @OneToMany(mappedBy = "docSession")
    private List<UserCompetence> docUserCompetences;

    //bi-directional many-to-one association to Lnk_SessionCampaign
    @OneToMany(mappedBy = "docSession")
    private List<SessionCampaign> lnkSessionCampaigns;

    public Session() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object sessionId) {
        this.id = (String) sessionId;
    }

    public Timestamp getDateClosed() {
        return this.dateClosed;
    }

    public void setDateClosed(Timestamp date_closed) {
        this.dateClosed = date_closed;
    }

    public Timestamp getDateOpened() {
        return this.dateOpened;
    }

    public void setDateOpened(Timestamp date_opened) {
        this.dateOpened = date_opened;
    }

    public Timestamp getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Timestamp dateUpdated) {
        this.dateUpdated = dateUpdated;
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

    public Position getDictPosition() {
        return this.dictPosition;
    }

    public void setDictPosition(Position dictPosition) {
        this.dictPosition = dictPosition;
    }

    public User getSysUser() {
        return sysUser;
    }

    public void setSysUser(User sysUser) {
        this.sysUser = sysUser;
    }

    public Subdivision getDictSubdivision() {
        return dictSubdivision;
    }

    public void setDictSubdivision(Subdivision dictSubdivision) {
        this.dictSubdivision = dictSubdivision;
    }

    public List<UserCompetence> getDocUserCompetences() {
        return this.docUserCompetences;
    }

    public void setDocUserCompetences(List<UserCompetence> docUserCompetences) {
        this.docUserCompetences = docUserCompetences;
    }

    public UserCompetence addDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().add(docUserCompetence);
        docUserCompetence.setDocSession(this);

        return docUserCompetence;
    }

    public UserCompetence removeDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().remove(docUserCompetence);
        docUserCompetence.setDocSession(null);

        return docUserCompetence;
    }

    public List<SessionCampaign> getLnkSessionCampaigns() {
        return this.lnkSessionCampaigns;
    }

    public void setLnkSessionCampaigns(List<SessionCampaign> lnkSessionCampaigns) {
        this.lnkSessionCampaigns = lnkSessionCampaigns;
    }

    public SessionCampaign addLnkSessionCampaign(SessionCampaign lnkSessionCampaign) {
        getLnkSessionCampaigns().add(lnkSessionCampaign);
        lnkSessionCampaign.setDocSession(this);

        return lnkSessionCampaign;
    }

    public SessionCampaign removeLnkSessionCampaign(SessionCampaign lnkSessionCampaign) {
        getLnkSessionCampaigns().remove(lnkSessionCampaign);
        lnkSessionCampaign.setDocSession(null);

        return lnkSessionCampaign;
    }

}