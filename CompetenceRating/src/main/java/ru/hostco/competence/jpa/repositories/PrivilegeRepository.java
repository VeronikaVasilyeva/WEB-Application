package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Privilege;

@Repository("PrivilegeRepository")
public interface PrivilegeRepository extends BaseRepository<Privilege, String> {

}
