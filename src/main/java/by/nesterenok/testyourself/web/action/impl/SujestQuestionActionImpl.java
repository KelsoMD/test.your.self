package by.nesterenok.testyourself.web.action.impl;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class SujestQuestionActionImpl implements BaseAction{
	
	private QuestionService questionService;
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		Question question = questionService.buildQuestion(request);
		questionService.createQuestion(question);
		return "http://testyourself.mycloud.by/MainServlet?action=switch_search_page";
	}

}
