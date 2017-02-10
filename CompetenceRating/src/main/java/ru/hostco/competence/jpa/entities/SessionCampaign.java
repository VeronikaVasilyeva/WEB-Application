package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the lnk_SessionCampaign database table.
 */
@Entity
@Table(name = "lnk_SessionCampaign")
@NamedQuery(name = "SessionCampaign.findAll", query = "SELECT l FROM SessionCampaign l")
public class SessionCampaign extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SessionCampaignPK id;

    @Column(name = "IsActive")
    private boolean isActive;

    //bi-directional many-to-one association to Doc_Campaign
    @ManyToOne
    @JoinColumn(name = "CampaignId", insertable = false, updatable = false)
    private Campaign docCampaign;

    //bi-directional many-to-one association to Doc_Session
    @ManyToOne
    @JoinColumn(name = "SessionId", insertable = false, updatable = false)
    private Session docSession;

    public SessionCampaign() {
    }

    public SessionCampaignPK getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (SessionCampaignPK) id;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Campaign getDocCampaign() {
        return this.docCampaign;
    }

    public void setDocCampaign(Campaign docCampaign) {
        this.docCampaign = docCampaign;
    }

    public Session getDocSession() {
        return this.docSession;
    }

    public void setDocSession(Session docSession) {
        this.docSession = docSession;
    }

}