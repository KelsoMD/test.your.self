package by.nesterenok.testyourself.service;

import java.util.Map;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.TaskResult;
import by.nesterenok.testyourself.domain.User;

public interface ResultService {

    public void createResult(Result resultId);

    public void createTaskResult(TaskResult taskResult);

    public Result readResult(int resultId);

    public  TaskResult readTaskResult(int taskResult);

    public Map<Question, String> getAnswerMap(String[] answers);

    public Result buildResult(int test, User user, String[] answers);

    public TaskResult buildTaskResult(int task, User user, String[] answers);
}
