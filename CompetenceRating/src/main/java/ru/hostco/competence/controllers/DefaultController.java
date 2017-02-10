package ru.hostco.competence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.hostco.competence.service.SessionCampaignService;
import ru.hostco.competence.service.SessionService;
import ru.hostco.competence.service.UserService;
import ru.hostco.competence.web.page.MainPageData;
import ru.hostco.competence.web.page.data.SessionPreview;
import ru.hostco.competence.web.page.data.UserInfo;

import java.util.List;

@Controller
public class DefaultController {

    @Autowired
    private UserService userService;
    @Autowired
    private SessionCampaignService sessionCampaignService;
    @Autowired
    private SessionService sessionService;

    @Autowired
    @Qualifier("UserInfo")
    private UserInfo userInfo;
    @Autowired
    @Qualifier("MainPageData")
    private MainPageData mainPageData;
    @Autowired
    @Qualifier(value = "SessionPreview")
    private SessionPreview sessionPreview;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        System.out.println("start session " + new java.util.Date().toString());

        userService.fillUserInfo("cfbce87a-0dbc-47f6-9c5b-694c537474b3", userInfo);
        mainPageData.setPreviewReports(getClosedSessionPreviews());
        sessionPreview.setSessionPreview(getOpenSessionPreview());
        mainPageData.setOpenSession(getOpenSessionPreview());
        //mainPageData.setAssignedCampaign(campaignService.getAssignedCampaignPreview(userInfo));

        ModelAndView mvn = new ModelAndView();
        mvn.setViewName("index");
        mvn.addObject("user", userInfo);
        mvn.addObject("mainPage", mainPageData);

        return mvn;
    }

    private SessionPreview getOpenSessionPreview() {
        SessionPreview openSessionPreview = sessionService.getOpenSessionPreview(userInfo);
        if (openSessionPreview != null) {
            sessionCampaignService.fillSessionPreviewWithCampaignData(openSessionPreview);
        }

        return openSessionPreview;
    }

    private List<SessionPreview> getClosedSessionPreviews() {
        List<SessionPreview> closedSessionPreviews = sessionService.getClosedSessionPreviews(userInfo);
        if (closedSessionPreviews != null) {
            for (SessionPreview sessionPreview : closedSessionPreviews) {
                sessionCampaignService.fillSessionPreviewWithCampaignData(sessionPreview);
            }
        }

        return closedSessionPreviews;
    }


}
