package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.BUILD_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_QUESTION_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_TEST_ONE_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_TEST_TWO_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_THEME_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.GUEST_TESTS_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MENTOR_TESTS_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_QUESTION_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_THEME_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LVL;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS_TO_CHOOSE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEMES;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_TEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.USER_TESTS_MAPPING;

import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.service.UserService;

@Controller
@RequestMapping({USER_TESTS_MAPPING, MENTOR_TESTS_MAPPING, GUEST_TESTS_MAPPING})
@SessionAttributes(SESSION_PARAM_TEST)
public class TestSwitch implements RoleProcessor {


    @Autowired
    private ThemeService themeService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = CREATE_THEME_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchCreateTheme() {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_THEME_PAGE));
        return modelAndView;
    }

    @RequestMapping(value = CREATE_QUESTION_MAPPING, method = RequestMethod.GET)
    public ModelAndView initCreateQuestion() {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_QUESTION_PAGE));
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        modelAndView.addObject(REQUEST_PARAM_QUESTION, new Question());
        return modelAndView;
    }

    @RequestMapping(value = CREATE_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchCreateTestOne() {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_TEST_ONE_PAGE));
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = BUILD_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchCreateTestTwo(@RequestParam(REQUEST_PARAM_THEME) String theme, @RequestParam(REQUEST_PARAM_LVL) int lvl,
                                            HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_TEST_TWO_PAGE));
        User user = userService.readByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        Test test = new Test();
        test.setAuthor(user);
        Set<Question> set = new HashSet<>();
        test.setQuestions(set);
        test.setTheme(theme);
        test.setLvl(lvl);
        session.setAttribute(SESSION_PARAM_TEST, test);
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE, questionService.returnQuestionsForTest(theme, lvl));
        return modelAndView;
    }
}
