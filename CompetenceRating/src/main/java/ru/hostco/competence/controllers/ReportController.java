package ru.hostco.competence.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.hostco.competence.service.UserCompetenceService;
import ru.hostco.competence.web.page.MainPageData;
import ru.hostco.competence.web.page.data.SessionPreview;
import ru.hostco.competence.web.page.data.UserInfo;

@Controller
public class ReportController {

    @Autowired
    private UserCompetenceService userCompetenceService;

    @Autowired
    @Qualifier("UserInfo")
    private UserInfo userInfo;
    @Autowired
    @Qualifier("MainPageData")
    private MainPageData mainPageData;

    //страница всех отчетов
    @RequestMapping(value = "/reports", method = RequestMethod.GET)
    public ModelAndView showReportList() {

        ModelAndView mvn = new ModelAndView();
        mvn.setViewName("reports");
        mvn.addObject("user", userInfo);
        mvn.addObject("mainPage", mainPageData);
        return mvn;
    }

    //детализация отчета
    @RequestMapping(value = "/reports/{id}")
    public ModelAndView getReportById(@PathVariable(value = "id") String id) {
        ModelAndView mvn = new ModelAndView();

        mvn.setViewName("reports");
        mvn.addObject("user", userInfo);
        mvn.addObject("mainPage", mainPageData);    //данные отсюда используются для навбара
        mvn.addObject("competences", userCompetenceService.getCompetencesForSession(id));

        SessionPreview sessionInfo = new SessionPreview();
        for (SessionPreview session : mainPageData.getPreviewReports()) {
            if (session.getId().equals(id)) sessionInfo = session;
        }

        mvn.addObject("sessionInfo", sessionInfo);
        return mvn;
    }

    //возвращает таблицу для вставки на страницу
    @RequestMapping(value = "/reports/getTableView", method = RequestMethod.GET)
    public String getTableView() {
        return "/template/DropDownPage_ReportDetalize";
    }
}
