package by.nesterenok.testyourself.dao;

import by.nesterenok.testyourself.domain.Question;

import java.util.List;

public interface QuestionJPACriteriaDao extends BaseDao<Question> {

    long counter();

    List<Question> readTestQuestions(int id);

    List<Question> readQuestionsForTest(String theme, int lvl);

    List<Question> readNotAprooved();

    long newQuestionsCount();

}
