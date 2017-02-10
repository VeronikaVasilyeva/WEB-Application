package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Position;

import java.util.List;

@Repository("PositionRepository")
public interface PositionRepository extends BaseRepository<Position, String> {

    @Query("SELECT pos FROM Position pos WHERE pos.isActive = '1' AND pos.id IN :ids")
    List<Position> findAllByIsActiveAndIdIn(@Param("ids") String[] ids);

    Position findOneByNameAndLevelAndIsActive(String name, String level, String isActive);
}
