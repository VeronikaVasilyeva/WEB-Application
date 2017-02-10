package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Subdivision;
import ru.hostco.competence.jpa.repositories.SubdivisionRepository;
import ru.hostco.competence.web.page.data.SubdivisionData;

import java.util.ArrayList;
import java.util.List;

@Component("SubdivisionService")
public class SubdivisionService extends BaseService {

    @Autowired
    public SubdivisionService(@Qualifier("SubdivisionRepository") final SubdivisionRepository repo) {
        super(repo);
    }

    public List<SubdivisionData> getSubdivisions() {
        List<Object> subdivs = this.findAll();
        Subdivision[] subdivisions = subdivs.toArray(new Subdivision[0]);
        List<SubdivisionData> list = new ArrayList<>();

        for (Subdivision subdivision : subdivisions) {
            list.add(new SubdivisionData(subdivision.getId(), subdivision.getName()));
        }
        return list;
    }
}
