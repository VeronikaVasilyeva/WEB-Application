package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Campaign;
import ru.hostco.competence.jpa.entities.SessionCampaign;
import ru.hostco.competence.jpa.entities.SessionCampaignPK;
import ru.hostco.competence.jpa.repositories.SessionCampaignRepository;
import ru.hostco.competence.web.page.data.CampaignData;
import ru.hostco.competence.web.page.data.SessionPreview;

@Component("SessionCampaignService")
public class SessionCampaignService extends BaseService {

    @Autowired
    public SessionCampaignService(@Qualifier("SessionCampaignRepository") final SessionCampaignRepository repo) {
        super(repo);
    }

    public void fillSessionPreviewWithCampaignData(SessionPreview sessionPreview) {

        Campaign campaign = ((SessionCampaignRepository) this.repo).findCampaignBySessionId(sessionPreview.getId());
        if (campaign != null) {
            CampaignData campaignData = new CampaignData();
            campaignData.setId(campaign.getId());
            campaignData.setStartDate(campaign.getDateStarted());
            campaignData.setFinishDate(campaign.getDateFinished());

            sessionPreview.setCampaign(campaignData);
        }
    }

    public void createNewSessionCampaignLink(String sessionId, String campaignId) {
        SessionCampaignPK key = new SessionCampaignPK();
        key.setSessionId(sessionId);
        key.setCampaignId(campaignId);

        SessionCampaign link = new SessionCampaign();
        link.setId(key);
        link.setIsActive(true);

        this.save(link);
    }
}
