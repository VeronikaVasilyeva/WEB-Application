package ru.hostco.competence.controllers.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import ru.hostco.competence.service.CompetencePositionService;
import ru.hostco.competence.service.UserCompetenceService;
import ru.hostco.competence.web.page.MainPageData;
import ru.hostco.competence.web.page.data.UserInfo;

/**
 * Created by vasilyeva on 11.01.2017.
 */

@RestController
public class RatingController {

    @Autowired
    private UserCompetenceService userCompetenceService;

    @Autowired
    @Qualifier("UserInfo")
    private UserInfo userInfo;
    @Autowired
    @Qualifier("MainPageData")
    private MainPageData mainPageData;

    @Autowired
    CompetencePositionService competencePositionService;

/*    @RequestMapping(value = "/getRatings/{id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SubdivisionData> getRatingsByCompetenceId(@PathVariable String competenceId) {
        return subdivisionService.getSubdivisions();
    }*/


/*    @RequestMapping(value = "/getPositions", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, List<String>> getPosition(@RequestBody final String id) {
        return competencePositionService.getPositionsInSubdivision(id);
    }*/
}
