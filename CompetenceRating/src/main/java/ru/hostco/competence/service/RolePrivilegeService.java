package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.repositories.RolePrivilegeRepository;

@Component("RolePrivilegeService")
public class RolePrivilegeService extends BaseService {

    @Autowired
    public RolePrivilegeService(@Qualifier("RolePrivilegeRepository") final RolePrivilegeRepository repo) {
        super(repo);
    }
}
