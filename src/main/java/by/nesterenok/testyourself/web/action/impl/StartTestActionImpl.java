package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_TEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST_ID;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST_QUESTIONS;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class StartTestActionImpl implements BaseAction {

	private TestService testService;
	
	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {

		int testId = Integer.parseInt(request.getParameter(REQUEST_PARAM_TEST_ID));
		Test test = testService.readTest(testId);
		testService.prepareShuffled(test);
		request.setAttribute(REQUEST_PARAM_TEST_QUESTIONS, test.getQuestions());
		request.setAttribute(REQUEST_PARAM_TEST, test.getId());
		return PAGE_TEST;
	}

}
