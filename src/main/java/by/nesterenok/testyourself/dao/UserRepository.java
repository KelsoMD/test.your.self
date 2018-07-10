package by.nesterenok.testyourself.dao;

import by.nesterenok.testyourself.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByLogin(String login);

}
