package by.nesterenok.testyourself.service;

import java.util.Map;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.TaskResult;
import by.nesterenok.testyourself.domain.User;

public interface ResultService {

    void createResult(Result resultId);

    void createTaskResult(TaskResult taskResult);

    Result readResult(int resultId);

    TaskResult readTaskResult(int taskResult);

    Map<Question, String> getAnswerMap(String[] answers);

    Result buildResult(int test, User user, String[] answers);

    TaskResult buildTaskResult(int task, User user, String[] answers);
}
