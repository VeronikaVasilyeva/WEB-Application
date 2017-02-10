package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.hostco.competence.jpa.entities.Position;
import ru.hostco.competence.jpa.repositories.PositionRepository;
import ru.hostco.competence.web.page.data.PositionData;

@Component("PositionService")
public class PositionService extends BaseService {

    @Autowired
    private CompetencePositionService competencePositionService;

    @Autowired
    public PositionService(@Qualifier("PositionRepository") final PositionRepository repo) {
        super(repo);
    }

    public Position newPosition(String name, String level) {                            // Создание новой должности
        Position pos = new Position();
        pos.setName(name);
        pos.setLevel(level);
        pos.setIsActive(true);
        return pos;
    }

    public PositionData findPositionData(String name, String level) {
        Position entity = ((PositionRepository) this.repo).findOneByNameAndLevelAndIsActive(name, level, "1");

        PositionData pos = new PositionData();
        pos.setId(entity.getId());
        pos.setLevel(entity.getLevel());
        pos.setName(entity.getName());

        return pos;
    }

    public Position getPositionById(String id) {
        Position entity = (Position) this.findOne(id);
        return entity;
    }

    public Position findPositionByNameAndLevel(String name, String level) {
        Position position = ((PositionRepository) this.repo).findOneByNameAndLevelAndIsActive(name, level, "1");
        return position;
    }
}
