package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class DenieQuestionActionImpl implements BaseAction {

    private QuestionService questionService;

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public String executeAction(HttpServletRequest request) {
        questionService.deleteQuestion(new Question(Integer.parseInt(request.getParameter(REQUEST_PARAM_QUESTIONS_ID)
        )));
        return REDIRECT_URL_MODERATOR_QUESTIONS_CLOUD;
    }

}
