package ru.hostco.competence.controllers.ajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.hostco.competence.service.CompetencePositionService;
import ru.hostco.competence.service.SubdivisionService;
import ru.hostco.competence.web.page.data.SubdivisionData;

import java.util.HashMap;
import java.util.List;


@RestController
public class SubdivisionPositionController {

    @Autowired
    CompetencePositionService competencePositionService;

    @Autowired
    SubdivisionService subdivisionService;

    @RequestMapping(value = "/getSubdivisions", method = RequestMethod.GET)
    @ResponseBody
    public List<SubdivisionData> getSubdivision() {
        return subdivisionService.getSubdivisions();
    }


    @RequestMapping(value = "/getPositions", method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, List<String>> getPosition(@RequestBody final String id) {
        return competencePositionService.getPositionsInSubdivision(id);
    }

}
