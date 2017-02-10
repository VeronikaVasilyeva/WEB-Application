package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.repositories.SubdivisionExecutiveRepository;

@Component("SubdivisionExecutiveService")
public class SubdivisionExecutiveService extends BaseService {

    @Autowired
    public SubdivisionExecutiveService(@Qualifier("SubdivisionExecutiveRepository") final SubdivisionExecutiveRepository repo) {
        super(repo);
    }
}
