package ru.hostco.competence.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the lnk_SessionCampaign database table.
 */
@Embeddable
public class SessionCampaignPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "SessionId")
    private String sessionId;

    @Column(name = "CampaignId")
    private String campaignId;

    public SessionCampaignPK() {
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionCampaignPK)) {
            return false;
        }
        SessionCampaignPK castOther = (SessionCampaignPK) other;
        return
                this.sessionId.equals(castOther.sessionId)
                        && this.campaignId.equals(castOther.campaignId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.sessionId.hashCode();
        hash = hash * prime + this.campaignId.hashCode();

        return hash;
    }
}