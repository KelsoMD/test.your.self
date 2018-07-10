package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class StartModeratorActionImpl implements BaseAction{
	
	private StartService startService;
	
	public void setStartService(StartService startService) {
		this.startService = startService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_NEW_QUESTIONS_COUNT, startService.getNewQuestionsCount());
		request.setAttribute(REQUEST_PARAM_NEW_TESTS_COUNT, startService.getNewTestsCount());
		request.setAttribute(REQUEST_PARAM_NEW_THEME_COUNT, startService.getNewThemeCount());
		return PAGE_MODERATOR_MAIN;
	}

}
