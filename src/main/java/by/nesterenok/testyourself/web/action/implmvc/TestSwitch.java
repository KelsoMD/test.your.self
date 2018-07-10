package by.nesterenok.testyourself.web.action.implmvc;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_TEST_ONE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_TEST_TWO;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_USER_TESTS_CREATE_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_LVL;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTIONS_TO_CHOOSE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEME;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEMES;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_TEST;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

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
@RequestMapping({"user/tests", "mentor/tests", "guest/tests"})
@SessionAttributes(SESSION_PARAM_TEST)
public class TestSwitch implements RoleProcessor {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_THEME, method = RequestMethod.GET)
    public ModelAndView switchCreateTheme() {
        ModelAndView modelAndView = new ModelAndView(processPage("create_theme"));
        return modelAndView;
    }

    @RequestMapping(value = REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION, method = RequestMethod.GET)
    public ModelAndView initCreateQuestion() {
        ModelAndView modelAndView = new ModelAndView(processPage("create_question"));
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        modelAndView.addObject("question", new Question());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView switchCreateTestOne() {
        ModelAndView modelAndView = new ModelAndView(processPage("create_test_one"));
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = "/build", method = RequestMethod.GET)
    public ModelAndView switchCreateTestTwo(@RequestParam("theme") String theme, @RequestParam("lvl") int lvl,
                                            HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(processPage("create_test_two"));
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
