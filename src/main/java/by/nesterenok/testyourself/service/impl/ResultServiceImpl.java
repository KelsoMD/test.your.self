package by.nesterenok.testyourself.service.impl;

import static by.nesterenok.testyourself.service.util.ServiceConstantPool.PASS_PERCENT;
import static by.nesterenok.testyourself.service.util.ServiceConstantPool.REGEX;

import java.util.HashMap;
import java.util.Map;

import by.nesterenok.testyourself.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.QuestionJPACriteriaDao;
import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.dao.TaskResultDao;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.TaskResult;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ResultService;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private TaskResultDao taskResultDao;

    @Autowired
    private TestDao testDao;

    @Autowired
    private QuestionJPACriteriaDao questionDao;

    @Autowired
    private QuestionService questionService;

    public void setResultDao(ResultDao resultDao) {
        this.resultDao = resultDao;
    }

    public void setTaskResultDao(TaskResultDao taskResultDao) {
        this.taskResultDao = taskResultDao;
    }

    public void setQuestionDao(QuestionJPACriteriaDao questionDao) {
        this.questionDao = questionDao;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void createResult(Result result) {
        resultDao.create(result);
    }

    @Override
    public void createTaskResult(TaskResult taskResult) {
        taskResultDao.create(taskResult);
    }

    @Override
    public Result readResult(int resultId) {
        return resultDao.read(resultId);
    }

    @Override
    public TaskResult readTaskResult(int taskResult) {
        return taskResultDao.read(taskResult);
    }

    @Override
    public Map<Question, String> getAnswerMap(String[] answers) {
        return buildAnswerMap(answers);
    }

    @Override
    public Result buildResult(int test, User user, String[] answers) {

        Result result = new Result();
        result.setTest(testDao.read(test));
        Map<Question, String> answerMap = buildAnswerMap(answers);
        result.setMark(getMark(answerMap));
        result.setPassed(isPassed(result.getMark()));
        result.setUser(user);
        return result;
    }

    @Override
    public TaskResult buildTaskResult(int task, User user, String[] answers) {
        TaskResult result = new TaskResult();
        result.setTask(new Task(task));
        result.setAnswerMap(buildAnswerMap(answers));
        result.setMark(getMark(result.getAnswerMap()));
        result.setPassed(isPassed(result.getMark()));
        result.setMember(user);
        return result;
    }

    private Map<Question, String> buildAnswerMap(String[] answers) {
        Map<Question, String> map = new HashMap<>();
        for (int i = 0; i < answers.length; i++) {
            String[] pair = answers[i].split(REGEX);
            Question question = null;
            try {
                question = questionService.readQuestion(Integer.parseInt(pair[1]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.put(question, pair[0].trim());
        }
        return map;
    }

    private int getMark(Map<Question, String> answers) {
        int correctAnswers = 0;
        for (Map.Entry<Question, String> entry : answers.entrySet()) {
            if (entry.getKey()
                .getCorrectAnswer()
                .equals(entry.getValue())) {
                correctAnswers++;
            }
        }
        double mark = correctAnswers / (double) answers.size() * 100;
        return (int) mark;
    }

    private boolean isPassed(int mark) {
        return mark > PASS_PERCENT;
    }
}
