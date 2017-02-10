package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Competence;
import ru.hostco.competence.jpa.repositories.CompetenceRepository;
import ru.hostco.competence.web.page.data.CompetenceData;

import java.util.ArrayList;
import java.util.List;

@Component("CompetenceService")
public class CompetenceService extends BaseService {

    @Autowired
    public CompetenceService(@Qualifier("CompetenceRepository") final CompetenceRepository repo) {
        super(repo);
    }

    public List<CompetenceData> getChildCompetencesByParentId(String parentId) {
        List<Competence> competences = ((CompetenceRepository) this.repo).findChildCompetencesByParentId(parentId);
        if (competences == null || competences.isEmpty()) {
            return null;
        }
        List<CompetenceData> competenceDatas = new ArrayList<>();
        for (Competence competence : competences) {
            CompetenceData competenceData = new CompetenceData(competence.getId(), competence.getName());
            competenceDatas.add(competenceData);
        }
        return competenceDatas;
    }
}
