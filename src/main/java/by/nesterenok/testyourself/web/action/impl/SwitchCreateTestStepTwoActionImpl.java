package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LVL;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS_TO_CHOOSE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_TEST;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class SwitchCreateTestStepTwoActionImpl implements BaseAction{
	
	private QuestionService questionService;
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}



	@Override
	public String executeAction(HttpServletRequest request) {
		String theme = request.getParameter(REQUEST_PARAM_THEME);
		int lvl = Integer.parseInt(request.getParameter(REQUEST_PARAM_LVL));
		Test newTest = new Test();
		newTest.setTheme(theme);
		newTest.setLvl(lvl);
		User user = (User) request.getSession().getAttribute(SESSION_PARAM_USER);
		newTest.setAuthor(user);
		Set<Question> set = new HashSet<>();
		newTest.setQuestions(set);
		request.getSession().setAttribute(SESSION_PARAM_TEST, newTest);
		request.setAttribute(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(theme, lvl));
		return PAGE_USER_CREATE_TEST_ST_TWO;
	}

}
