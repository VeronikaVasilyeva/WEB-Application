package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Campaign;

import java.sql.Timestamp;

@Repository("CampaignRepository")
public interface CampaignRepository extends BaseRepository<Campaign, String> {

    @Query("SELECT camp FROM Campaign camp WHERE camp.dictSubdivision.id = :subdivisionId AND camp.dateStarted <= :currentDate AND (camp.dateFinished IS NULL OR camp.dateFinished >= :currentDate) AND camp.isActive = '1'")
    Campaign findAssignedCampaignForSubdivision(@Param("subdivisionId") String subdivisionId, @Param("currentDate") Timestamp currentDate);
}
