package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.RolePrivilege;
import ru.hostco.competence.jpa.entities.RolePrivilegePK;

@Repository("RolePrivilegeRepository")
public interface RolePrivilegeRepository extends BaseRepository<RolePrivilege, RolePrivilegePK> {

}
