package by.nesterenok.testyourself.web.action.implmvc;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping(value = "/moderator")
public class ModeratorController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public ModelAndView moderateQuestions() {
        ModelAndView modelAndView = new ModelAndView("moderator/questions");
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS, questionService.readNotAprooved());
        return modelAndView;
    }

    @RequestMapping(value = "/questions/{question_id}", method = RequestMethod.GET)
    public ModelAndView initQuestions(@PathVariable("question_id") int questionId) {
        Question question = questionService.readQuestion(questionId);
        ModelAndView modelAndView = new ModelAndView("moderator/preview");
        modelAndView.addObject("question", question);
//        request.setAttribute(REQUEST_PARAM_QUESTIONS_ID, question.getId());
//        request.setAttribute(REQUEST_PARAM_TEXT, question.getText());
//        if(question.getImage()!=null) {
//            request.setAttribute(REQUEST_PARAM_IMAGE, question.getImage());
//            request.setAttribute(REQUEST_PARAM_IMAGE_LINK, question.getImage());
//        }
//        request.setAttribute(REQUEST_PARAM_CORRECT_ANSWER, question.getCorrectAnswer());
//        request.setAttribute(REQUEST_PARAM_ANSWER1, question.getAnswer1());
//        request.setAttribute(REQUEST_PARAM_ANSWER2, question.getAnswer2());
//        request.setAttribute(REQUEST_PARAM_ANSWER3, question.getAnswer3());
        return modelAndView;
    }

    @RequestMapping(value = "/questions/deni/{question_id}", method = RequestMethod.GET)
    public ModelAndView deni(@PathVariable("question_id") int questionId) {
        Question question = questionService.readQuestion(questionId);
        emailService.sendDeniMessage(question.getAuthor().getEmail(), question);
        questionService.deleteQuestion(question);
        return new ModelAndView(REDIRECT + "/moderator/questions");
    }

    @RequestMapping(value = "/questions/accept/{question_id}", method = RequestMethod.GET)
    public ModelAndView accept(@PathVariable("question_id") int questionId) {
        Question question = questionService.readQuestion(questionId);
        question.setAprooved(true);
        emailService.sendAcceptMessage(question.getAuthor().getEmail(), question);
        questionService.updateQuestion(question);
        return new ModelAndView(REDIRECT + "/moderator/questions");
    }


}
