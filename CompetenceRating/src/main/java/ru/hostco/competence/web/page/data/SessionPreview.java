package ru.hostco.competence.web.page.data;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component("SessionPreview")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "session")
@JsonRootName(value = "Session")
public class SessionPreview {

    private String id;
    private String startDate;
    private String updateDate;                                //can be null if it's new campaing
    private String finishDate;                                //can be null if the session is not contained in any campaing
    private PositionData position;
    private SubdivisionData subdivision;
    private CampaignData campaign;                                //can be null if it's no campaing


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String date) {
        this.startDate = date;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String date) {
        this.updateDate = date;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String date) {
        this.finishDate = date;
    }

    public PositionData getPosition() {
        return position;
    }

    public void setPosition(PositionData position) {
        this.position = position;
    }

    public SubdivisionData getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(SubdivisionData subdivision) {
        this.subdivision = subdivision;
    }

    public CampaignData getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignData campaing) {
        this.campaign = campaing;
    }

    public void setSessionPreview(SessionPreview sessionPreview) {
        if (sessionPreview != null) {
            setId(sessionPreview.getId());
            setStartDate(sessionPreview.getStartDate());
            setUpdateDate(sessionPreview.getUpdateDate());
            setFinishDate(sessionPreview.getFinishDate());
            setPosition(sessionPreview.getPosition());
            setSubdivision(sessionPreview.getSubdivision());
        }
    }

    @Override
    public String toString() {
        return "Id: " + id +
                " Start: " + startDate +
                " Finish: " + finishDate +
                " Update: " + updateDate +
                " Position: " + position.toString() +
                " Subdivision: " + subdivision.toString() +
                " Camp: " + campaign;
    }
}











