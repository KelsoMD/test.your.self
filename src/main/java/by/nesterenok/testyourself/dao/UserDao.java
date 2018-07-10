package by.nesterenok.testyourself.dao;

import by.nesterenok.testyourself.domain.User;

public interface UserDao extends BaseDao<User> {

    public User findByLogin(String login);

    long counter();
}
