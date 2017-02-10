package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the doc_Campaign database table.
 */
@Entity
@Table(name = "doc_Campaign")
@NamedQuery(name = "Campaign.findAll", query = "SELECT d FROM Campaign d")
public class Campaign extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CampaignId")
    private String id;

    @Column(name = "DateFinished")
    private Timestamp dateFinished;

    @Column(name = "DateStarted")
    private Timestamp dateStarted;

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

    //bi-directional many-to-one association to Dict_Subdivision
    @ManyToOne
    @JoinColumn(name = "SubdivisionId")
    private Subdivision dictSubdivision;

    //bi-directional many-to-one association to Sys_User
    @ManyToOne
    @JoinColumn(name = "ExecutiveId")
    private User sysUser;

    //bi-directional many-to-one association to Lnk_SessionCampaign
    @OneToMany(mappedBy = "docCampaign")
    private List<SessionCampaign> lnkSessionCampaigns;

    public Campaign() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object campaignId) {
        this.id = (String) campaignId;
    }

    public Timestamp getDateFinished() {
        return this.dateFinished;
    }

    public void setDateFinished(Timestamp dateFinished) {
        this.dateFinished = dateFinished;
    }

    public Timestamp getDateStarted() {
        return this.dateStarted;
    }

    public void setDateStarted(Timestamp dateStarted) {
        this.dateStarted = dateStarted;
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

    public Subdivision getDictSubdivision() {
        return this.dictSubdivision;
    }

    public void setDictSubdivision(Subdivision dictSubdivision) {
        this.dictSubdivision = dictSubdivision;
    }

    public User getSysUser() {
        return this.sysUser;
    }

    public void setSysUser(User sysUser) {
        this.sysUser = sysUser;
    }

    public List<SessionCampaign> getLnkSessionCampaigns() {
        return this.lnkSessionCampaigns;
    }

    public void setLnkSessionCampaigns(List<SessionCampaign> lnkSessionCampaigns) {
        this.lnkSessionCampaigns = lnkSessionCampaigns;
    }

    public SessionCampaign addLnkSessionCampaign(SessionCampaign lnkSessionCampaign) {
        getLnkSessionCampaigns().add(lnkSessionCampaign);
        lnkSessionCampaign.setDocCampaign(this);

        return lnkSessionCampaign;
    }

    public SessionCampaign removeLnkSessionCampaign(SessionCampaign lnkSessionCampaign) {
        getLnkSessionCampaigns().remove(lnkSessionCampaign);
        lnkSessionCampaign.setDocCampaign(null);

        return lnkSessionCampaign;
    }

}