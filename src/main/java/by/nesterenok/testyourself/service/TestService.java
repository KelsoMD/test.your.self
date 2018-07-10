package by.nesterenok.testyourself.service;

import java.util.List;
import by.nesterenok.testyourself.domain.Test;

public interface TestService {

    Test readTest(int id);

    List<Test> readAll();

    List<Test> searchTests(String theme, Integer lvl);

    void createTest(Test test);

    void prepareShuffled(Test test);
}
