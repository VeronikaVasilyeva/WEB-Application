package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.*;
import ru.hostco.competence.jpa.repositories.UserCompetenceRepository;
import ru.hostco.competence.utils.Utils;
import ru.hostco.competence.web.page.data.CompetenceData;
import ru.hostco.competence.web.page.data.Node;

import java.util.HashMap;
import java.util.List;

@Component("UserCompetenceService")
public class UserCompetenceService extends BaseService {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private MeasureService measureService;
    @Autowired
    private CompetenceService competenceService;
    @Autowired
    private UserService userService;

    @Autowired
    public UserCompetenceService(@Qualifier("UserCompetenceRepository") final UserCompetenceRepository repo) {
        super(repo);
    }

    public List<Node<CompetenceData>> getCompetencesForSession(String sessionId) {
        List<Competence> competences = ((UserCompetenceRepository) this.repo).findCompetencesBySessionId(sessionId);

        List<Node<CompetenceData>> competenceTree = Utils.getCompetenceTree(competences);       //формируем дерево

        if (competenceTree != null) {
            for (Node<CompetenceData> competenceNode : competenceTree) {
                fillCompetenceTreeWithMeasureRatings(competenceNode, sessionId);                //добавили оценки для каждого уровня
                //TODO: по факту нужно дерево только 2х уровневое, для дальнейшей детализации - отдельный запрос. не нужно строить все дерево за раз
            }
        }

        return competenceTree;
    }

    public void fillCompetenceTreeWithMeasureRatings(Node<CompetenceData> competenceNode, String sessionId) {
        if (competenceNode != null) {
            List<UserCompetence> userCompetenceEntries = ((UserCompetenceRepository) this.repo)
                    .findUserCompetencesBySessionIdAndCompetenceId(sessionId, competenceNode.getValue().getId());

            HashMap<String, Short> measureRatings = getMeasureRatings(userCompetenceEntries);
            competenceNode.getValue().setMeasureRatings(measureRatings);

            List<Node<CompetenceData>> children = competenceNode.getChilds();
            if (children != null && !children.isEmpty()) {
                for (Node<CompetenceData> child : children) {
                    fillCompetenceTreeWithMeasureRatings(child, sessionId);
                }
            }
        }
    }

    private HashMap<String, Short> getMeasureRatings(List<UserCompetence> userCompetenceEntries) {
        if (userCompetenceEntries == null || userCompetenceEntries.isEmpty()) {
            return null;
        }
        HashMap<String, Short> measureRatings = new HashMap<>();
        for (UserCompetence userCompetence : userCompetenceEntries) {
            measureRatings.put(userCompetence.getDictMeasure().getName(), userCompetence.getRating());
        }
        return measureRatings;
    }

    public void fillCompetenceDataWithMeasureRatings(CompetenceData competenceData, String sessionId) {
        if (competenceData != null) {
            List<UserCompetence> userCompetenceEntries = ((UserCompetenceRepository) this.repo)
                    .findUserCompetencesBySessionIdAndCompetenceId(sessionId, competenceData.getId());

            HashMap<String, Short> measureRatings = getMeasureRatings(userCompetenceEntries);
            competenceData.setMeasureRatings(measureRatings);
        }
    }

    public void createAndUpdateUserCompetence(CompetenceData competenceData, String sessionId) throws NullPointerException {
        if (competenceData != null) {
            Session session = (Session) sessionService.findOne(sessionId);
            if (session == null) {
                throw new NullPointerException(String.format("Unable to find session with id '%s'!", sessionId));
            }

            Competence competence = (Competence) competenceService.findOne(competenceData.getId());
            if (competence == null) {
                throw new NullPointerException(
                        String.format("Unable to find competence with id '%s'!", competenceData.getId()));
            }

            User user = (User) userService.findOne(session.getSysUser().getId());
            if (user == null) {
                throw new NullPointerException(
                        String.format("Unable to find user with id '%s'!", session.getSysUser().getId()));
            }

            HashMap<String, Short> measureRatings = competenceData.getMeasureRatings();
            if (measureRatings != null && !measureRatings.isEmpty()) {
                String[] measureNames = measureRatings.keySet().toArray(new String[0]);

                for (String measureName : measureNames) {
                    Measure measure = measureService.getMeasureByName(measureName);

                    if (measure == null) {
                        throw new NullPointerException(
                                String.format("Unable to find measure with name '%s'!", measureName));
                    }

                    UserCompetence userCompetence = ((UserCompetenceRepository) this.repo)
                            .findBySessionIdAndCompetenceIdAndMeasureId(sessionId, competenceData.getId(), measure.getId());

                    short rating = measureRatings.get(measureName);

                    if (userCompetence == null) {
                        userCompetence = new UserCompetence();
                        UserCompetencePK key = new UserCompetencePK();
                        key.setUserId(user.getId());
                        key.setSessionId(session.getId());
                        key.setCompetenceId(competence.getId());
                        key.setMeasureId(measure.getId());
                        userCompetence.setId(key);
                        userCompetence.setIsActive(true);
                    }
                    userCompetence.setRating(rating);
                    save(userCompetence);
                }
            }
        }
    }
}
