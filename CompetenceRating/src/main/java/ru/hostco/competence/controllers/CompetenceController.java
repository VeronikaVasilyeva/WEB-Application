package ru.hostco.competence.controllers;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.hostco.competence.service.CompetencePositionService;
import ru.hostco.competence.service.UserCompetenceService;
import ru.hostco.competence.utils.Utils;
import ru.hostco.competence.web.page.data.CompetenceData;
import ru.hostco.competence.web.page.data.SessionPreview;
import ru.hostco.competence.web.page.data.UserInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vasilyeva on 24.01.2017.
 */
@Controller
public class CompetenceController {

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

    @RequestMapping(value = "/fillCompetence/getFormView", method = RequestMethod.GET)
    public String getFormView() {                           //возвращает форму для вставки на страницу
        return "/template/FillPage_FillForm";
    }

    @RequestMapping(value = "/fillCompetence/getCompetenceBatch", method = RequestMethod.GET)
    @ResponseBody
    public List<CompetenceData> getCompetenceBatch(@RequestParam("batchSize") int batchSize,
                                                   @RequestParam("batchNumber") int batchNumber,
                                                   @RequestParam("parentCompetenceId") String parentCompetenceId) {

        List<CompetenceData> competenceDatas = competencePositionService.getAssignedCompetencesByParentId(
                sessionPreview.getSubdivision().getId(), sessionPreview.getPosition().getId(), parentCompetenceId);

        if (competenceDatas == null || competenceDatas.isEmpty()) {
            return null;
        }

        if (batchSize < 1) {
            batchSize = 1;
        }
        if (batchSize > competenceDatas.size()) {
            batchSize = competenceDatas.size();
        }
        if (batchNumber < 1) {
            batchNumber = 1;
        }
        if (batchNumber > competenceDatas.size() / batchSize) {
            batchNumber = competenceDatas.size() / batchSize;
        }

        int fromIndex = (batchNumber - 1) * batchSize;
        int toIndex = fromIndex + batchSize;
        List<CompetenceData> competenceBatch = competenceDatas.subList(fromIndex, toIndex);

        for (CompetenceData competenceData : competenceBatch) {
            userCompetenceService.fillCompetenceDataWithMeasureRatings(competenceData, sessionPreview.getId());
        }
        return competenceBatch;
    }


    @RequestMapping(value = "/fillCompetence/session", headers = "action=saveFilledCompetences", method = RequestMethod.POST)
    @ResponseBody
    public List<CompetenceData> saveFilledCompetences(@RequestParam String sessionId, @RequestBody String competenceString,
                                                      HttpServletResponse response, HttpServletRequest req)
            throws JsonParseException, JsonMappingException, IOException {

        ObjectMapper jacksonMapper = new ObjectMapper();
        List<CompetenceData> competenceDatas = jacksonMapper.readValue(competenceString, new TypeReference<List<CompetenceData>>() {});

        for (CompetenceData competenceData : competenceDatas) {
            userCompetenceService.createAndUpdateUserCompetence(competenceData, sessionId);
        }
        return competenceDatas;
    }

}
