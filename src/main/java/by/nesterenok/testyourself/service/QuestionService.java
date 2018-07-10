package by.nesterenok.testyourself.service;

import java.util.List;
import by.nesterenok.testyourself.domain.Question;

public interface QuestionService {

    Question readQuestion(int id);

    List<Question> readTestQuestions(int testId);

    List<Question> initializeQuestion(List<Question> questionList);

    void createQuestion(Question question);

    List<Question> returnQuestionsForTest(String theme, int lvl);

    void shuffleAnswers(Question question);

    List<Question> readNotAprooved();

    void deleteQuestion(Question question);

    void updateQuestion(Question question);
}
