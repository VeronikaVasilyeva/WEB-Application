package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Campaign;
import ru.hostco.competence.jpa.repositories.CampaignRepository;
import ru.hostco.competence.utils.CustomDateFormat;
import ru.hostco.competence.web.page.data.CampaignData;
import ru.hostco.competence.web.page.data.SessionPreview;
import ru.hostco.competence.web.page.data.UserInfo;

import java.sql.Timestamp;
import java.util.Date;

@Component("CampaignService")
public class CampaignService extends BaseService {

    @Autowired
    public CampaignService(@Qualifier("CampaignRepository") final CampaignRepository repo) {
        super(repo);
    }

    public SessionPreview getAssignedCampaignPreview(UserInfo userInfo) {
        Timestamp currentDate = new Timestamp(new Date().getTime());
        Campaign campaign = ((CampaignRepository) this.repo)
                .findAssignedCampaignForSubdivision(userInfo.getSubdivision().getId(), currentDate);

        if (campaign == null) {
            return null;
        }

        CampaignData campaignData = new CampaignData();
        campaignData.setId(campaign.getId());

        SessionPreview sessionPreview = new SessionPreview();
        sessionPreview.setCampaign(campaignData);
        sessionPreview.setSubdivision(userInfo.getSubdivision());
        sessionPreview.setPosition(userInfo.getPosition());

        sessionPreview.setStartDate(CustomDateFormat.fullDateFormat.format(campaign.getDateStarted()));
        sessionPreview.setFinishDate(CustomDateFormat.fullDateFormat.format(campaign.getDateFinished()));

        return sessionPreview;
    }
}
