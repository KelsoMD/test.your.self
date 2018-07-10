package by.nesterenok.testyourself.service.impl;

import java.util.List;

import by.nesterenok.testyourself.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;

@Service
public class StartServiceImpl implements StartService {

    @Autowired
    private QuestionJPACriteriaDao questionDao;
    @Autowired
    private TestDao testDao;
    @Autowired
    private ThemeDao themeDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ResultDao resultDao;


    @Override
    public long getQuestionCount() {
        return questionDao.counter();
    }

    @Override
    public long getUserCount() {
        return userDao.counter();
    }


    @Override
    public long getTestPassedCount(){
        return resultDao.counter();
    }

    @Override
    public List<Test> getStartTests() {
        return testDao.readLast();
    }

    @Override
    public List<Test> getStartSubscribedTests(String theme) {

        return testDao.readSubscribed(theme);
    }

    @Override
    public long getNewQuestionsCount() {
        return questionDao.newQuestionsCount();
    }

    @Override
    public int getNewTestsCount() {
        return testDao.newTestsCount();
    }

    @Override
    public int getNewThemeCount() {
        return themeDao.newThemeCount();
    }

    @Override
    public List<Task> getComplete4Task(User user) {
        List<Task> tasks = taskDao.readComplete4Tasks(user);
        return tasks;
    }
}
