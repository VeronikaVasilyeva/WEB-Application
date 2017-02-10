package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Competence;
import ru.hostco.competence.jpa.entities.Position;
import ru.hostco.competence.jpa.repositories.CompetencePositionRepository;
import ru.hostco.competence.utils.Utils;
import ru.hostco.competence.web.page.data.CompetenceData;
import ru.hostco.competence.web.page.data.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component("CompetencePositionService")
public class CompetencePositionService extends BaseService {

    @Autowired
    public CompetencePositionService(
            @Qualifier("CompetencePositionRepository") final CompetencePositionRepository repo) {
        super(repo);
    }


    public List<String> getPositionIdsBySubdivionId(String subdivisionId) {
        return ((CompetencePositionRepository) this.repo).findDistinctBySubdivisionId(subdivisionId);
    }

    public List<Node<CompetenceData>> getMandatoryCompetenceTreeForSubdivisionAndPosition(String subdivisionID,
                                                                                          String positionID) {
        List<Competence> competences = ((CompetencePositionRepository) this.repo)
                .findDistinctBySubdivisionIdAndPositionId(subdivisionID, positionID);

        return Utils.getCompetenceTree(competences);
    }

    public HashMap<String, List<String>> getPositionsInSubdivision(String subdivisionId) {

        List<Position> positions = ((CompetencePositionRepository) this.repo)
                .findPositionsBySubdivisionId(subdivisionId);

        HashMap<String, List<String>> positionDatas = new HashMap<>();

        for (Position position : positions) {
            if (positionDatas.containsKey(position.getName())) {
                List<String> levels = positionDatas.get(position.getName());
                levels.add(position.getLevel());
                positionDatas.put(position.getName(), levels);
            } else {
                positionDatas.put(position.getName(), new ArrayList<String>() {
                    {
                        add(position.getLevel());
                    }
                });
            }
        }

        return positionDatas;
    }

    public List<CompetenceData> getAssignedCompetencesByParentId(String subdivisionId, String positionId, String parentCompetenceId) {

        List<Competence> competences = ((CompetencePositionRepository) this.repo)
                .findAssignedCompetencesByParentId(subdivisionId, positionId, parentCompetenceId);

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
