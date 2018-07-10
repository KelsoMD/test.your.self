package by.nesterenok.testyourself.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User readUser() {
        return userDao.read(4);
    }

    @Override
    public User readByLogin(String login) {
        return userDao.findByLogin(login);
    }
}
