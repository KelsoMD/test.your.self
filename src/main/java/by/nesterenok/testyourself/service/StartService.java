package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;

public interface StartService {

    long getQuestionCount();

    long getUserCount();

    long getTestPassedCount();

    List<Test> getStartTests();

    List<Test> getStartSubscribedTests(String theme);

    long getNewQuestionsCount();

    int getNewTestsCount();

    int getNewThemeCount();

    List<Task> getComplete4Task(User user);
}
