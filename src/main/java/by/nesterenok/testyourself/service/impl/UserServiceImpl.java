package by.nesterenok.testyourself.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao dao) {
        this.userDao = dao;
    }

    @Override
    public User readUser() {
        return userDao.read(4);
    }

    @Override
    public User readByLogin(String login) {
        return userDao.findByLogin(login);
//        User user = new User(1);
//        user.setLogin("Viktor");
//        user.setGroup(new HashSet<Group>());
//        return user;
    }
}
