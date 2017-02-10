package ru.hostco.competence.utils;

import org.springframework.beans.factory.annotation.Autowired;
import ru.hostco.competence.jpa.entities.BaseEntity;
import ru.hostco.competence.jpa.entities.Competence;
import ru.hostco.competence.service.CompetenceService;
import ru.hostco.competence.web.page.data.CompetenceData;
import ru.hostco.competence.web.page.data.Node;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static void setCommonEntityData(BaseEntity entity, String username) {
        if (entity.getDins() == null) {
            entity.setDins(new Timestamp(new Date().getTime()));
        }
        entity.setDupd(new Timestamp(new Date().getTime()));
        if (entity.getUins() == null) {
            entity.setUins(username);
        }
        entity.setUupd(username);
    }

    public static List<Node<CompetenceData>> getCompetenceTree(List<Competence> competences) {
        HashMap<String, Node<CompetenceData>> viewedItems = new HashMap<>();
        List<String> rootIds = new ArrayList<>();

        for (Competence competence : competences) {
            String competenceId = competence.getId();
            // если еще не просмотрено
            if (!viewedItems.containsKey(competenceId)) {

                CompetenceData competenceData = new CompetenceData(competenceId, competence.getName());

                Competence parentCompetence = competence.getDictCompetence();
                // проверяем наличие следующего уровня
                if (parentCompetence == null) {
                    Node<CompetenceData> rootNode = new Node<>();
                    rootNode.setValue(competenceData);

                    if (rootNode != null) {
                        // добавили в просмотренные
                        viewedItems.put(competenceId, rootNode);
                    }
                    rootIds.add(competenceId);
                } else {
                    Node<CompetenceData> childNode = new Node<>();
                    childNode.setValue(competenceData);

                    if (childNode != null) {
                        // добавили в просмотренные
                        viewedItems.put(competenceId, childNode);
                        recursivelyAttachChildToParent(parentCompetence, childNode, viewedItems, rootIds);
                    }
                }
            }
        }

        List<Node<CompetenceData>> competenceTree = new ArrayList<>();

        for (String rootId : rootIds) {
            if (viewedItems.containsKey(rootId) && viewedItems.get(rootId) != null) {
                competenceTree.add(viewedItems.get(rootId));
            }
        }

        return competenceTree;
    }

    private static void recursivelyAttachChildToParent(Competence parentCompetence, Node<CompetenceData> childNode,
                                                       HashMap<String, Node<CompetenceData>> viewedItems, List<String> rootIds) {
        String parentId = parentCompetence.getId();

        if (!viewedItems.containsKey(parentId)) {
            CompetenceData competenceData = new CompetenceData(parentId, parentCompetence.getName());

            Node<CompetenceData> parentNode = new Node<>();
            parentNode.setValueAndChild(competenceData, childNode);
            if (parentNode != null) {
                // добавили в просмотренные
                viewedItems.put(parentId, parentNode);
            }

            Competence grandparentCompetence = parentCompetence.getDictCompetence();
            if (grandparentCompetence != null) {
                recursivelyAttachChildToParent(grandparentCompetence, parentNode, viewedItems, rootIds);
            } else {
                rootIds.add(parentId);
                return;
            }
        } else {
            if (childNode != null) {
                // добавили ребенка к уже существующему родителю
                viewedItems.get(parentId).appendChild(childNode);
            }
            return;
        }
    }

    public static int countFilledCompetences(List<Node<CompetenceData>> rootNodes) {
        if (rootNodes == null || rootNodes.isEmpty()) {
            return 0;
        }
        int counter = 0;

        for (Node<CompetenceData> rootNode : rootNodes) {
            if (rootNode != null) {
                List<Node<CompetenceData>> childNodes = rootNode.getChilds();
                if (childNodes == null || childNodes.isEmpty()) {
                    CompetenceData nodeValue = rootNode.getValue();
                    if (nodeValue != null && nodeValue.getMeasureRatings() != null
                            && !nodeValue.getMeasureRatings().isEmpty() && nodeValue.getMeasureRatings().size() == 4) {
                        counter++;
                    }
                } else {
                    counter += countFilledCompetences(childNodes);
                }
            }
        }

        return counter;
    }

    public static int countTotalChildCompetences(List<Node<CompetenceData>> rootNodes) {
        if (rootNodes == null || rootNodes.isEmpty()) {
            return 0;
        }
        int counter = 0;

        for (Node<CompetenceData> rootNode : rootNodes) {
            if (rootNode.getValue() != null) {
                List<Node<CompetenceData>> childNodes = rootNode.getChilds();
                if (childNodes == null || childNodes.isEmpty()) {
                    counter++;
                } else {
                    counter += countTotalChildCompetences(childNodes);
                }

            }
        }

        return counter;
    }

    public static int countCompetenceFillingProgress(List<Node<CompetenceData>> childNodes) {
        int totalCount = countTotalChildCompetences(childNodes);
        int filledCount = countFilledCompetences(childNodes);
        int progress = Math.round(filledCount / totalCount) * 100;
        return progress;
    }
}
