package ru.hostco.competence.web.page;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.hostco.competence.web.page.data.SessionPreview;

import java.util.List;

@Component("MainPageData")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
@JsonRootName(value = "MainPage")
public class MainPageData {

    private SessionPreview openSession;
    private SessionPreview assignedCampaign;
    private List<SessionPreview> previewReports;

    public List<SessionPreview> getPreviewReports() {
        return previewReports;
    }

    public void setPreviewReports(List<SessionPreview> previewReports) {
        this.previewReports = previewReports;
    }

    public SessionPreview getAssignedCampaign() {
        return assignedCampaign;
    }

    public void setAssignedCampaign(SessionPreview sessionInfo) {
        this.assignedCampaign = sessionInfo;
    }

    public SessionPreview getOpenSession() {
        return openSession;
    }

    public void setOpenSession(SessionPreview sessionInfo) {
        this.openSession = sessionInfo;
    }
}
