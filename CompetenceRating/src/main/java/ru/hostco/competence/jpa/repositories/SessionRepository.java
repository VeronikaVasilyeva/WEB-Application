package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Session;

import java.util.List;

@Repository("SessionRepository")
public interface SessionRepository extends BaseRepository<Session, String> {

    @Query("SELECT ses FROM Session ses WHERE ses.isActive = '1' AND ses.sysUser.id = :userId AND ses.dateClosed IS NULL")
    Session findOpenSessionByUserId(@Param("userId") String userId);

    @Query("SELECT DISTINCT ses FROM Session ses WHERE ses.isActive = '1' AND ses.sysUser.id = :userId AND ses.dateClosed IS NOT NULL ORDER BY ses.dateClosed DESC ")
    List<Session> findClosedSessionsByUserId(@Param("userId") String userId);
}
