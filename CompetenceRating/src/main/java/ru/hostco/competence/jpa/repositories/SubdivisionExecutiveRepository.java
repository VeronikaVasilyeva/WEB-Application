package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.SubdivisionExecutive;
import ru.hostco.competence.jpa.entities.SubdivisionExecutivePK;

@Repository("SubdivisionExecutiveRepository")
public interface SubdivisionExecutiveRepository extends BaseRepository<SubdivisionExecutive, SubdivisionExecutivePK> {

}
