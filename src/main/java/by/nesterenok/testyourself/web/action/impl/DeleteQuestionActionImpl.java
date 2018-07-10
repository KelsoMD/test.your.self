package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class DeleteQuestionActionImpl implements BaseAction{
	
	private QuestionService questionService;
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		Question question = null;
		try {
			question = questionService.readQuestion(Integer.parseInt(request.getParameter(REQUEST_PARAM_QUESTIONS_ID)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Test test = (Test) request.getSession().getAttribute(SESSION_PARAM_TEST);
		test.getQuestions().remove(question);
		request.setAttribute(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
		request.setAttribute(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
		return PAGE_USER_CREATE_TEST_ST_TWO;
	}

}
