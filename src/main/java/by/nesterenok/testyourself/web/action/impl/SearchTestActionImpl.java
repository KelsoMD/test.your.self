package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class SearchTestActionImpl implements BaseAction {
	
	private TestService testService;
	ThemeService themeService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		List<Test> list = testService.searchTests(request.getParameter(REQUEST_PARAM_THEME), Integer.valueOf(request.getParameter(REQUEST_PARAM_LVL)));
		request.setAttribute(REQUEST_PARAM_TESTS, list);
		request.setAttribute(REQUEST_PARAM_THEMES, themeService.readThemes());
		return PAGE_USER_CREATE_QUESTION;
	}

}
