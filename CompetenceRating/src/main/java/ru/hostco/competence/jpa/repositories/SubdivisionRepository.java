package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Subdivision;

@Repository("SubdivisionRepository")
public interface SubdivisionRepository extends BaseRepository<Subdivision, String> {

}
