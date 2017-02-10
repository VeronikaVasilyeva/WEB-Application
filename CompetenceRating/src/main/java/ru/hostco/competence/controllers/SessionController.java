package ru.hostco.competence.controllers;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hostco.competence.jpa.entities.Competence;
import ru.hostco.competence.service.CompetencePositionService;
import ru.hostco.competence.service.CompetenceService;
import ru.hostco.competence.service.SessionService;
import ru.hostco.competence.service.UserCompetenceService;
import ru.hostco.competence.utils.Utils;
import ru.hostco.competence.web.page.FillingPageData;
import ru.hostco.competence.web.page.MainPageData;
import ru.hostco.competence.web.page.data.CompetenceData;
import ru.hostco.competence.web.page.data.Node;
import ru.hostco.competence.web.page.data.SessionPreview;
import ru.hostco.competence.web.page.data.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SessionController {

    @Autowired
    private SessionService sessionService;
    @Autowired
    private CompetencePositionService competencePositionService;
    @Autowired
    private UserCompetenceService userCompetenceService;

    @Autowired
    @Qualifier("UserInfo")
    private UserInfo userInfo;
    @Autowired
    @Qualifier("SessionPreview")
    private SessionPreview sessionPreview;
    @Autowired
    @Qualifier("MainPageData")
    private MainPageData mainPageData;


    @RequestMapping(value = "/fillCompetence/session/create", method = RequestMethod.POST)
    public String createSession(@RequestParam String subdivisionId, @RequestParam String positionName, @RequestParam String positionLevel) {
        SessionPreview newSessionPreview = sessionService.createNewSession(subdivisionId, userInfo.getId(), positionName, positionLevel);

        sessionPreview.setSessionPreview(newSessionPreview);
        return "redirect:/fillCompetence/session";
    }

    @RequestMapping(value = "/fillCompetence/session", method = RequestMethod.GET)
    public ModelAndView continueSession() {
        List<Node<CompetenceData>> competenceTree = competencePositionService.getMandatoryCompetenceTreeForSubdivisionAndPosition(
                sessionPreview.getSubdivision().getId(), sessionPreview.getPosition().getId());

        if (competenceTree != null && !competenceTree.isEmpty()) {
            for (Node<CompetenceData> competenceNode : competenceTree) {
                userCompetenceService.fillCompetenceTreeWithMeasureRatings(competenceNode, sessionPreview.getId());
            }
        }
        int progress = Utils.countCompetenceFillingProgress(competenceTree);

        return buildPage(progress, competenceTree);
    }

    @RequestMapping(value = "/fillCompetence/session/delete", method = RequestMethod.GET)
    public String deleteSession() {

        sessionService.deleteSession(sessionPreview.getId());
        return "redirect:/";
    }

    @RequestMapping(value = "/fillCompetence/session/save", method = RequestMethod.GET)
    public String saveSession() {

        //TODO: что нужно записать в базу при сохранении сессии?
        return "redirect:/";
    }

    private FillingPageData fillPageData(int progress, List<Node<CompetenceData>> competenceTree) {
        FillingPageData pageData = new FillingPageData();
        pageData.setProgress((int) Math.ceil(progress));
        pageData.setSessionInfo(sessionPreview);
        pageData.setRequiredCompetences(competenceTree);

        return pageData;
    }

    private ModelAndView buildPage(int progress, List<Node<CompetenceData>> competenceTree) {
        ModelAndView mvn = new ModelAndView();
        mvn.setViewName("fillPage");
        mvn.addObject("user", userInfo);
        mvn.addObject("mainPage", mainPageData);
        //может заменяться на необязательные компетенции
        mvn.addObject("pageTitle", "Заполнение обязательных компетенций");
        mvn.addObject("fillingPage", fillPageData(progress, competenceTree));

        return mvn;
    }

	/*	DON'T REMOVE !!!

	@RequestMapping(value="/fillCompetence/campaign", method=RequestMethod.GET)
	public ModelAndView submitCampaign() throws JsonProcessingException{
		int progress = 0;

		SessionPreview sessionPreview = mainPageData.getAssignedCampaign();
		SubdivisionData subdivisionData = sessionPreview.getSubdivision();
		PositionData positionData = sessionPreview.getPosition();
		List<Node<CompetenceData>> competenceTree = competencePositionService.getMandatoryCompetenceTreeForSubdivisionAndPosition(subdivisionData.getId(), positionData.getId());

		SessionPreview newSessionPreview = sessionService.createNewSession(subdivisionData.getId(), userInfo.getId(), positionData.getName(), positionData.getLevel());
		newSessionPreview.setCampaign(sessionPreview.getCampaign());
		sessionCampaignService.createNewSessionCampaignLink(newSessionPreview.getId(), newSessionPreview.getCampaign().getId());

		return buildPage(progress, newSessionPreview, competenceTree);
	}*/
}
