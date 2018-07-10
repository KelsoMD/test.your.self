package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class PreviewUserActionImpl implements BaseAction {

	private QuestionService questionService;

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		Question question = null;
		try {
			question = questionService
					.readQuestion(Integer.parseInt(request.getParameter(REQUEST_PARAM_QUESTIONS_ID)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute(REQUEST_PARAM_TEXT, question.getText());
		if(question.getImage()!=null) {
		request.setAttribute(REQUEST_PARAM_IMAGE, question.getImage());
		}
		questionService.shuffleAnswers(question);
		request.setAttribute(REQUEST_PARAM_SHUFFLED, question.getShuffledAnswers());
		return PAGE_USER_PREVIEW;
	}

}
