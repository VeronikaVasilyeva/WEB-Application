package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Competence;
import ru.hostco.competence.jpa.entities.UserCompetence;
import ru.hostco.competence.jpa.entities.UserCompetencePK;

import java.util.List;

@Repository("UserCompetenceRepository")
public interface UserCompetenceRepository extends BaseRepository<UserCompetence, UserCompetencePK> {

    @Query("SELECT DISTINCT userComp FROM UserCompetence userComp WHERE userComp.isActive = '1' AND userComp.docSession.id = :sessionId AND userComp.dictCompetence.dictCompetence IS NULL")
    List<UserCompetence> findHighestLevelCompetencesBySessionId(@Param("sessionId") String sessionId);

    @Query("SELECT DISTINCT userComp.dictCompetence FROM UserCompetence userComp WHERE userComp.isActive = '1' AND userComp.docSession.id = :sessionId")
    List<Competence> findCompetencesBySessionId(@Param("sessionId") String sessionId);

    @Query("SELECT DISTINCT userComp FROM UserCompetence userComp WHERE userComp.isActive = '1' AND userComp.docSession.id = :sessionId AND userComp.dictCompetence.id = :competenceId")
    List<UserCompetence> findUserCompetencesBySessionIdAndCompetenceId(@Param("sessionId") String sessionId,
                                                                       @Param("competenceId") String competenceId);

    @Query("SELECT DISTINCT userComp FROM UserCompetence userComp WHERE userComp.isActive = '1' AND userComp.docSession.id = :sessionId AND userComp.dictCompetence.id = :competenceId AND userComp.dictMeasure.id = :measureId")
    UserCompetence findBySessionIdAndCompetenceIdAndMeasureId(@Param("sessionId") String sessionId,
                                                              @Param("competenceId") String competenceId, @Param("measureId") String measureId);
}
