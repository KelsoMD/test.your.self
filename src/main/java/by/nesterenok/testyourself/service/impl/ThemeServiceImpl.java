package by.nesterenok.testyourself.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.ThemeDao;
import by.nesterenok.testyourself.service.ThemeService;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private ThemeDao themeDao;

    public void setThemeDao(ThemeDao themeDao) {
        this.themeDao = themeDao;
    }

    @Override
    public List<String> readThemes() {
        return themeDao.readAll();
    }

    @Override
    public void createTheme(String theme) {
        themeDao.create(theme);
    }
}
