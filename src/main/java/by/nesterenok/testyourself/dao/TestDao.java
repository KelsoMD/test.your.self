package by.nesterenok.testyourself.dao;

import java.util.List;
import by.nesterenok.testyourself.domain.Test;

public interface TestDao extends BaseDao<Test> {

    List<Test> readLast();

    List<Test> readSubscribed(String theme);

    List<Test> searchTheme(String theme);

    List<Test> searchLvl(int lvl);

    List<Test> searchThemeLvl(String theme, int lvl);

    List<Test> readNotAprooved();

    int newTestsCount();
}
