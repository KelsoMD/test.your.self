package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_USER_MAIN;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LIST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TASK;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TaskService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.web.action.BaseAction;
import by.nesterenok.testyourself.web.util.ActionHelper;

public class StartUserActionImpl implements BaseAction {

	StartService ss;
	TestService ts;
	TaskService taskService;

	public void setSs(StartService ss) {
		this.ss = ss;
	}
	public void setTs(TestService ts) {
		this.ts = ts;
	}
	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	@Override
	public String executeAction(HttpServletRequest request) {
		
		User user = ActionHelper.getUser(request);
		
		request.setAttribute(REQUEST_PARAM_QUESTION_COUNT, ss.getQuestionCount());

		if (user.getTheme() != null) {
			request.setAttribute(REQUEST_PARAM_LIST, ss.getStartSubscribedTests(user.getTheme()));
		} else {
			request.setAttribute(REQUEST_PARAM_LIST, ss.getStartTests());
		}
		if (!user.getGroup().isEmpty()) {

		}
		return PAGE_USER_MAIN;
	}

}
