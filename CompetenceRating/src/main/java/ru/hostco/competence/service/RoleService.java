package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.repositories.RoleRepository;

@Component("RoleService")
public class RoleService extends BaseService {

    @Autowired
    public RoleService(@Qualifier("RoleRepository") final RoleRepository repo) {
        super(repo);
    }
}
