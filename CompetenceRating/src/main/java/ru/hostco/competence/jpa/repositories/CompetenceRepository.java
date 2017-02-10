package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Competence;

import java.util.List;

@Repository("CompetenceRepository")
public interface CompetenceRepository extends BaseRepository<Competence, String> {

    @Query("SELECT DISTINCT comp FROM Competence comp WHERE comp.isActive = '1' AND comp.dictCompetence.id = :parentId")
    public List<Competence> findChildCompetencesByParentId(@Param("parentId") String parentId);
}
