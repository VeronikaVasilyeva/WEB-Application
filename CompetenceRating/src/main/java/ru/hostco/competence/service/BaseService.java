package ru.hostco.competence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import ru.hostco.competence.jpa.entities.BaseEntity;
import ru.hostco.competence.jpa.repositories.BaseRepository;
import ru.hostco.competence.utils.Utils;

import java.util.List;

public abstract class BaseService {

    @Autowired
    private Environment env;

    protected final BaseRepository repo;

    public BaseService(final BaseRepository repo) {
        this.repo = repo;
    }

    public Object save(BaseEntity entity) {
        Utils.setCommonEntityData(entity, env.getProperty("connection.username"));
        return repo.save(entity);
    }

    public Object findOne(Object id) {
        return repo.findByIdAndIsActive(id, "1");
    }

    public List<Object> findAll() {
        return repo.findAllByIsActive("1");
    }

    public Object delete(BaseEntity entity) {
        entity.setIsActive(false);
        return repo.save(entity);
    }
}
