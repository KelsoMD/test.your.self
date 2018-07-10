package by.nesterenok.testyourself.dao;

import java.util.List;

public interface ThemeDao {

    void create(String theme);

    List<String> readAll();

    public int newThemeCount();
}
