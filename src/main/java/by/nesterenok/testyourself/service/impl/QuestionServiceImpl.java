package by.nesterenok.testyourself.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.QuestionJPACriteriaDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionJPACriteriaDao dao;

    public QuestionServiceImpl(QuestionJPACriteriaDao dao) {
        super();
        this.dao = dao;
    }

    @Override
    public Question readQuestion(int id) {
        return dao.read(id);
    }

    @Override
    public List<Question> readTestQuestions(int testId) {
        List<Question> list = null;
        list = dao.readTestQuestions(testId);
        return list;
    }

    @Override
    public List<Question> initializeQuestion(List<Question> questionList) {
        List<Question> tempList = new ArrayList<>();
        for (Question question : questionList) {
            int questionId = question.getId();
            tempList.add(dao.read(questionId));
        }
        return tempList;
    }

    @Override
    public void createQuestion(Question question) {
        dao.create(question);
    }

    @Override
    public List<Question> returnQuestionsForTest(String theme, int lvl) {
        return dao.readQuestionsForTest(theme, lvl);
    }

    @Override
    public void shuffleAnswers(Question question) {

        List<String> qlist = new ArrayList<>();
        qlist.add(question.getCorrectAnswer());
        qlist.add(question.getAnswer1());
        qlist.add(question.getAnswer2());
        qlist.add(question.getAnswer3());
        Collections.shuffle(qlist);
        question.setShuffledAnswers(qlist);
    }

    @Override
    public List<Question> readNotAprooved() {
        return dao.readNotAprooved();
    }

    @Override
    public void deleteQuestion(Question question) {
        dao.delete(question);
    }

    @Override
    public void updateQuestion(Question question) {
        dao.update(question);
    }
}
