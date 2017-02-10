package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Campaign;
import ru.hostco.competence.jpa.entities.SessionCampaign;
import ru.hostco.competence.jpa.entities.SessionCampaignPK;

@Repository("SessionCampaignRepository")
public interface SessionCampaignRepository extends BaseRepository<SessionCampaign, SessionCampaignPK> {

    @Query("SELECT sessionCamp.docCampaign FROM SessionCampaign sessionCamp WHERE sessionCamp.isActive = '1' AND sessionCamp.docSession.id = :sessionId")
    Campaign findCampaignBySessionId(@Param("sessionId") String sessionId);
}
