package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class SwitchSearchPageActionImpl implements BaseAction{
	
	TestService testService;
	ThemeService themeService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}
	
	public void setThemeService(ThemeService themeService) {
		this.themeService = themeService;
	}



	@Override
	public String executeAction(HttpServletRequest request) {
		
		request.setAttribute(REQUEST_PARAM_TESTS, testService.readAll());
		request.setAttribute(REQUEST_PARAM_THEMES, themeService.readThemes());
		
		return PAGE_USER_CREATE_QUESTION;
	}

}
