package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.UserRole;
import ru.hostco.competence.jpa.entities.UserRolePK;

@Repository("UserRoleRepository")
public interface UserRoleRepository extends BaseRepository<UserRole, UserRolePK> {

}
