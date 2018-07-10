package by.nesterenok.testyourself.service;

import java.util.List;

public interface ThemeService {

	public List<String> readThemes();
	
	public void createTheme(String theme);

}
