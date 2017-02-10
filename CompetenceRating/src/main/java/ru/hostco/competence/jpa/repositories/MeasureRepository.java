package ru.hostco.competence.jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Measure;

@Repository("MeasureRepository")
public interface MeasureRepository extends BaseRepository<Measure, String> {

    @Query("SELECT DISTINCT meas FROM Measure meas WHERE meas.isActive = '1' AND meas.name = :measureName")
    Measure findByName(@Param("measureName") String measureName);
}
