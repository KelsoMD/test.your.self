package by.nesterenok.testyourself.dao;

import java.util.List;
import by.nesterenok.testyourself.domain.Test;

public interface TestDao extends BaseDao<Test> {

    public List<Test> readLast();

    public List<Test> readSubscribed(String theme);

    public List<Test> searchTheme(String theme);

    public List<Test> searchLvl(int lvl);

    public List<Test> searchThemeLvl(String theme, int lvl);

    public List<Test> readNotAprooved();

    public int newTestsCount();
}
