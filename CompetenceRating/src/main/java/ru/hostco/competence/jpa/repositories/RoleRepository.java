package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.Role;

@Repository("RoleRepository")
public interface RoleRepository extends BaseRepository<Role, String> {

}
