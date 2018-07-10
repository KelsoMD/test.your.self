package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class CreateTestActionImpl implements BaseAction{
	
	private TestService testService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		Test test = (Test) request.getSession().getAttribute(SESSION_PARAM_TEST);
		testService.createTest(test);
		return REDIRECT_URL_SEARCH_PAGE_CLOUD;
	}

}
