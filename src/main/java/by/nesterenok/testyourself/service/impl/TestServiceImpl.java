package by.nesterenok.testyourself.service.impl;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    @Override
    public Test readTest(int id) {
        return testDao.read(id);
    }

    @Override
    public List<Test> readAll() {
        return testDao.readAll();
    }

    @Override
    public List<Test> searchTests(String theme, Integer lvl) {
        List<Test> searchedList = null;
        if (theme != null) {
            if (lvl != null) {
                searchedList = testDao.searchThemeLvl(theme, lvl);
            } else {
                searchedList = testDao.searchTheme(theme);
            }
        } else {
            if (lvl != null) {
                searchedList = testDao.searchLvl(lvl);
            } else {
                searchedList = testDao.readAll();
            }
        }
        return searchedList;
    }

    @Override
    public void createTest(Test test) {
        testDao.create(test);
    }

    @Override
    public void prepareShuffled(Test test) {
        Set<Question> list = test.getQuestions();

        for (Question question : list) {
            questionService.shuffleAnswers(question);
        }
    }
}
