package by.nesterenok.testyourself.service.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER1;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER2;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_ANSWER3;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_CORRECT_ANSWER;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_IMAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LVL;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEXT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.QuestionJPACriteriaDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.User;
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
    public Question buildQuestion(HttpServletRequest request) {
        Question question = new Question();

        question.setTheme(request.getParameter(REQUEST_PARAM_THEME));
        question.setLvl(Integer.parseInt(request.getParameter(REQUEST_PARAM_LVL)));
        question.setText(request.getParameter(REQUEST_PARAM_TEXT));
        question.setCorrectAnswer(request.getParameter(REQUEST_PARAM_CORRECT_ANSWER));
        question.setAnswer1(request.getParameter(REQUEST_PARAM_ANSWER1));
        question.setAnswer2(request.getParameter(REQUEST_PARAM_ANSWER2));
        question.setAnswer3(request.getParameter(REQUEST_PARAM_ANSWER3));
        question.setAuthor((User) request.getSession()
            .getAttribute(SESSION_PARAM_USER));
        String image = request.getParameter(REQUEST_PARAM_IMAGE);
        if (image != null) {
            question.setImage(image);
        }
        question.setAprooved(false);
        return question;
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
