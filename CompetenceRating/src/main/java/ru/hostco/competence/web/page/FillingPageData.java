package ru.hostco.competence.web.page;

import ru.hostco.competence.web.page.data.CompetenceData;
import ru.hostco.competence.web.page.data.Node;
import ru.hostco.competence.web.page.data.SessionPreview;

import java.util.List;

public class FillingPageData {

    private SessionPreview sessionInfo;
    private List<Node<CompetenceData>> requiredCompetences;

    public List<Node<CompetenceData>> getRequiredCompetences() {
        return requiredCompetences;
    }

    public void setRequiredCompetences(List<Node<CompetenceData>> requiredCompetences) {
        this.requiredCompetences = requiredCompetences;
    }

    private int progress;

    public SessionPreview getSessionInfo() {
        return sessionInfo;
    }

    public void setSessionInfo(SessionPreview session) {
        this.sessionInfo = session;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

}
