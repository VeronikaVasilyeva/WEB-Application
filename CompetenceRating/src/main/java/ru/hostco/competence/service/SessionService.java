package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.hostco.competence.jpa.entities.Position;
import ru.hostco.competence.jpa.entities.Session;
import ru.hostco.competence.jpa.entities.Subdivision;
import ru.hostco.competence.jpa.entities.User;
import ru.hostco.competence.jpa.repositories.SessionRepository;
import ru.hostco.competence.utils.CustomDateFormat;
import ru.hostco.competence.web.page.data.PositionData;
import ru.hostco.competence.web.page.data.SessionPreview;
import ru.hostco.competence.web.page.data.SubdivisionData;
import ru.hostco.competence.web.page.data.UserInfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component("SessionService")
public class SessionService extends BaseService {

    @Autowired
    private PositionService positionService;

    @Autowired
    private UserService userService;

    @Autowired
    private SubdivisionService subdivisionService;

    @Autowired
    public SessionService(@Qualifier("SessionRepository") final SessionRepository repo) {
        super(repo);
    }

    @Transactional
    public SessionPreview createNewSession(String subdivisionId, String userId, String positionName,
                                           String positionLevel) {
        Subdivision subdivision = (Subdivision) subdivisionService.findOne(subdivisionId);
        User user = (User) userService.findOne(userId);
        Position position = positionService.findPositionByNameAndLevel(positionName, positionLevel);

        Session session = new Session();
        Date date = new Date();
        session.setDateOpened(new Timestamp(date.getTime()));
        session.setDictSubdivision(subdivision);
        session.setSysUser(user);
        session.setDictPosition(position);
        session.setIsActive(true);

        SessionPreview sessionPreview = new SessionPreview();

        sessionPreview.setSubdivision(new SubdivisionData(subdivision.getId(), subdivision.getName()));
        sessionPreview.setPosition(new PositionData(position.getId(), position.getName(), position.getLevel()));
        sessionPreview.setStartDate(CustomDateFormat.fullDateFormat.format(date));
        sessionPreview.setFinishDate(null);

        this.save(session);

        sessionPreview.setId(session.getId());

        return sessionPreview;
    }

    public SessionPreview getOpenSessionPreview(UserInfo userInfo) {
        Session session = ((SessionRepository) this.repo).findOpenSessionByUserId(userInfo.getId());

        if (session == null) {
            return null;
        }

        SessionPreview sessionPreview = getSessionPreviewFromSession(session);

        return sessionPreview;
    }

    public List<SessionPreview> getClosedSessionPreviews(UserInfo userInfo) {
        List<Session> closedSessions = ((SessionRepository) this.repo).findClosedSessionsByUserId(userInfo.getId());
        if (closedSessions == null || closedSessions.isEmpty()) {
            return null;
        }

        List<SessionPreview> sessionPreviews = new ArrayList<>();
        for (Session session : closedSessions) {
            SessionPreview sessionPreview = getSessionPreviewFromSession(session);
            if (session.getDateClosed() != null) {
                sessionPreview.setFinishDate(CustomDateFormat.fullDateFormat.format(session.getDateClosed()));
            }

            sessionPreviews.add(sessionPreview);
        }

        return sessionPreviews;
    }

    private SessionPreview getSessionPreviewFromSession(Session session) {
        Position position = session.getDictPosition();
        PositionData positionData = new PositionData(position.getId(), position.getName(), position.getLevel());

        Subdivision subdivision = session.getDictSubdivision();
        SubdivisionData subdivisionData = new SubdivisionData(subdivision.getId(), subdivision.getName());

        SessionPreview sessionPreview = new SessionPreview();

        sessionPreview.setId(session.getId());
        sessionPreview.setPosition(positionData);
        sessionPreview.setSubdivision(subdivisionData);
        if (session.getDateOpened() != null) {
            sessionPreview.setStartDate(CustomDateFormat.fullDateFormat.format(session.getDateOpened()));
        }
        if (session.getDateUpdated() != null) {
            sessionPreview.setUpdateDate(CustomDateFormat.fullDateFormat.format(session.getDateUpdated()));
        }

        return sessionPreview;
    }

    @Transactional
    public void deleteSession(String sessionId) {
        Session session = (Session) this.findOne(sessionId);
        this.delete(session);
        //TODO: проверить правильность закрытия сессии
    }
}
