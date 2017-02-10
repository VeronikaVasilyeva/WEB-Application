package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.User;
import ru.hostco.competence.jpa.repositories.UserRepository;
import ru.hostco.competence.web.page.data.PositionData;
import ru.hostco.competence.web.page.data.SubdivisionData;
import ru.hostco.competence.web.page.data.UserInfo;

@Component("UserService")
public class UserService extends BaseService {

    @Autowired
    public UserService(@Qualifier("UserRepository") final UserRepository repo) {
        super(repo);
    }

    public void fillUserInfo(String userId, UserInfo userInfo) {
        User user = (User) this.findOne(userId);
        userInfo.setId(user.getId());
        userInfo.setName(user.getName());

        SubdivisionData subdivisionData = new SubdivisionData(user.getDictSubdivision().getId(),
                user.getDictSubdivision().getName());
        userInfo.setSubdivision(subdivisionData);

        PositionData positionData = new PositionData(user.getDictPosition().getId(), user.getDictPosition().getName(), user.getDictPosition().getLevel());
        userInfo.setPosition(positionData);
    }
}
