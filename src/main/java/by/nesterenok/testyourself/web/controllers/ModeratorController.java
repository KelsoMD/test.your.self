package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.MODERATOR_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MODERATOR_PREVIEW_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MODERATOR_QUESTIONS_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.PATH_VARIABLE_QUESTION_ID;
import static by.nesterenok.testyourself.web.util.WebConstantPool.QUESTIONS_ACCEPT_QUESTION_ID_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.QUESTIONS_DENI_QUESTION_ID_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.QUESTIONS_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.QUESTIONS_QUESTION_ID_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REDIRECT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.impl.EmailService;

@Controller
@RequestMapping(value = MODERATOR_MAPPING)
public class ModeratorController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = QUESTIONS_MAPPING, method = RequestMethod.GET)
    public ModelAndView moderateQuestions() {
        ModelAndView modelAndView = new ModelAndView(MODERATOR_QUESTIONS_PAGE);
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS, questionService.readNotAprooved());
        return modelAndView;
    }

    @RequestMapping(value = QUESTIONS_QUESTION_ID_MAPPING, method = RequestMethod.GET)
    public ModelAndView initQuestions(@PathVariable(PATH_VARIABLE_QUESTION_ID) int questionId) {
        Question question = questionService.readQuestion(questionId);
        ModelAndView modelAndView = new ModelAndView(MODERATOR_PREVIEW_PAGE);
        modelAndView.addObject(REQUEST_PARAM_QUESTION, question);
        return modelAndView;
    }

    @RequestMapping(value = QUESTIONS_DENI_QUESTION_ID_MAPPING, method = RequestMethod.GET)
    public ModelAndView deni(@PathVariable(PATH_VARIABLE_QUESTION_ID) int questionId) {
        Question question = questionService.readQuestion(questionId);
        emailService.sendDeniMessage(question.getAuthor()
            .getEmail(), question);
        questionService.deleteQuestion(question);
        return new ModelAndView(REDIRECT + MODERATOR_QUESTIONS_PAGE);
    }

    @RequestMapping(value = QUESTIONS_ACCEPT_QUESTION_ID_MAPPING, method = RequestMethod.GET)
    public ModelAndView accept(@PathVariable(PATH_VARIABLE_QUESTION_ID) int questionId) {
        Question question = questionService.readQuestion(questionId);
        question.setAprooved(true);
        emailService.sendAcceptMessage(question.getAuthor()
            .getEmail(), question);
        questionService.updateQuestion(question);
        return new ModelAndView(REDIRECT + MODERATOR_QUESTIONS_PAGE);
    }
}
