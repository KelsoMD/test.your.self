package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class SujestThemeActionImpl implements BaseAction {

	private ThemeService themeService;

	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		List<String> themeList = themeService.readThemes();
		String theme = request.getParameter(REQUEST_PARAM_THEME);
		if (themeList.contains(theme)) {
			request.setAttribute(REQUEST_PARAM_THEME_MSG, REQUEST_MSG_THEME_EXISTS);
			return PAGE_USER_CREATE_THEME;
		} else {
			themeService.createTheme(request.getParameter(REQUEST_PARAM_THEME));
			return "http://testyourself.mycloud.by/MainServlet?action=switch_search_page";
		}
		
	}

}
