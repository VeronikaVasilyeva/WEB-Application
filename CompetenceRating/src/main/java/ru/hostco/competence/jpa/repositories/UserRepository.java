package ru.hostco.competence.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.hostco.competence.jpa.entities.User;

@Repository("UserRepository")
public interface UserRepository extends BaseRepository<User, String> {

}
