package by.nesterenok.testyourself.service;

import java.util.List;

public interface ThemeService {

	 List<String> readThemes();
	
	 void createTheme(String theme);

}
