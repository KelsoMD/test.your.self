package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.PAGE_MODERATOR_QUESTIONS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class SwitchModerateQuestionActionImpl implements BaseAction{
	
	private QuestionService questionService;
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		request.setAttribute(REQUEST_PARAM_QUESTIONS, questionService.readNotAprooved());
		return PAGE_MODERATOR_QUESTIONS;
	}

}
