package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Competence;
import ru.hostco.competence.jpa.entities.CompetencePosition;
import ru.hostco.competence.jpa.entities.CompetencePositionPK;
import ru.hostco.competence.jpa.entities.Position;

import java.util.List;

@Repository("CompetencePositionRepository")
public interface CompetencePositionRepository extends BaseRepository<CompetencePosition, CompetencePositionPK> {

    @Query(value = "SELECT DISTINCT [PositionId] FROM [lnk_CompetencePosition] WHERE [IsActive] = '1' AND [SubdivisionId] = ?1", nativeQuery = true)
    List<String> findDistinctBySubdivisionId(String subdivisionId);

    @Query("SELECT DISTINCT compPos.dictCompetence FROM CompetencePosition compPos WHERE compPos.isActive = '1' AND compPos.dictSubdivision.id = :subdivisionId AND compPos.dictPosition.id = :positionId")
    List<Competence> findDistinctBySubdivisionIdAndPositionId(@Param("subdivisionId") String subdivisionId, @Param("positionId") String positionId);

    @Query("SELECT DISTINCT compPos.dictPosition FROM CompetencePosition compPos WHERE compPos.isActive = '1' AND compPos.dictSubdivision.id = :subdivisionId")
    List<Position> findPositionsBySubdivisionId(@Param("subdivisionId") String subdivisionId);

    @Query("SELECT DISTINCT compPos.dictCompetence FROM CompetencePosition compPos " +
            "WHERE compPos.isActive = '1' AND compPos.dictSubdivision.id = :subdivisionId AND compPos.dictPosition.id = :positionId AND compPos.dictCompetence.dictCompetence.id = :parentId")
    List<Competence> findAssignedCompetencesByParentId(@Param("subdivisionId") String subdivisionID, @Param("positionId") String positionID, @Param("parentId") String parentCompetenceId);
}
