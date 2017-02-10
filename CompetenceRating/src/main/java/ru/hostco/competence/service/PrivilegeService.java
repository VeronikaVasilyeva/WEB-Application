package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.repositories.PrivilegeRepository;

@Component("PrivilegeService")
public class PrivilegeService extends BaseService {

    @Autowired
    public PrivilegeService(@Qualifier("PrivilegeRepository") final PrivilegeRepository repo) {
        super(repo);
    }
}
