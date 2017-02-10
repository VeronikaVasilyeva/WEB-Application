package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.repositories.UserRoleRepository;

@Component("UserRoleService")
public class UserRoleService extends BaseService {

    @Autowired
    public UserRoleService(@Qualifier("UserRoleRepository") final UserRoleRepository repo) {
        super(repo);
    }
}
