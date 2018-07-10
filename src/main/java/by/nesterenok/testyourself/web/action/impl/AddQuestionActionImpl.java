package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class AddQuestionActionImpl implements BaseAction{
	
	private QuestionService questionService;
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		int questionId = Integer.parseInt(request.getParameter(REQUEST_PARAM_QUESTIONS_ID));
		Test test = (Test) request.getSession().getAttribute(SESSION_PARAM_TEST);
		try {
			test.getQuestions().add(questionService.readQuestion(questionId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
		request.setAttribute(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
		return PAGE_USER_CREATE_TEST_ST_TWO;
	}

}
