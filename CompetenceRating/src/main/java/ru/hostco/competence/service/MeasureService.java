package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Measure;
import ru.hostco.competence.jpa.repositories.MeasureRepository;

@Component("MeasureService")
public class MeasureService extends BaseService {

    @Autowired
    public MeasureService(@Qualifier("MeasureRepository") final MeasureRepository repo) {
        super(repo);
    }

    public Measure getMeasureByName(String measureName) {
        Measure measure = ((MeasureRepository) this.repo).findByName(measureName);
        return measure;
    }
}
