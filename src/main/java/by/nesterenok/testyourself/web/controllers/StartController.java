package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.GUEST_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MAIN_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MENTOR_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MODERATOR_MAIN_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MODERATOR_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REDIRECT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_NEW_QUESTIONS_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_NEW_TESTS_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_NEW_THEME_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_QUESTION_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TASK;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TESTS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TEST_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.START_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.USER_MAPPING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TaskService;
import by.nesterenok.testyourself.service.UserService;
import by.nesterenok.testyourself.web.controllers.RoleProcessor;

@Controller
@RequestMapping(START_MAPPING)
public class StartController implements RoleProcessor {

    @Autowired
    private UserService userService;

    @Autowired
    private StartService startService;

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public String startUrl() {
        return REDIRECT + processUrl();
    }

    @Transactional
    @RequestMapping(value = {GUEST_MAPPING, USER_MAPPING, MENTOR_MAPPING}, method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView(processPage(MAIN_PAGE));
        User user = userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName());
        if (user != null) {
            if ((user.getTheme() != null)) {
                modelAndView.addObject(REQUEST_PARAM_TESTS, startService.getStartSubscribedTests(user.getTheme()));
            } else {
                modelAndView.addObject(REQUEST_PARAM_TESTS, startService.getStartTests());
            }
            modelAndView.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
            modelAndView.addObject(REQUEST_PARAM_USER_COUNT, startService.getUserCount());
            modelAndView.addObject(REQUEST_PARAM_TEST_COUNT, startService.getTestPassedCount());
            System.out.println(startService.getUserCount());
            if (user.getGroup()
                .isEmpty()) {
                modelAndView.addObject(REQUEST_PARAM_TASK, taskService.readUserTasks(user));
            }
        } else {
            modelAndView.addObject(REQUEST_PARAM_TESTS, startService.getStartTests());
            modelAndView.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
            modelAndView.addObject(REQUEST_PARAM_USER_COUNT, startService.getUserCount());
            modelAndView.addObject(REQUEST_PARAM_TEST_COUNT, startService.getTestPassedCount());
        }
        return modelAndView;
    }

    @Transactional
    @RequestMapping(value = (MODERATOR_MAPPING), method = RequestMethod.GET)
    public ModelAndView startModerator() {
        ModelAndView modelAndView = new ModelAndView(MODERATOR_MAIN_PAGE);
        modelAndView.addObject(REQUEST_PARAM_NEW_QUESTIONS_COUNT, startService.getNewQuestionsCount());
        modelAndView.addObject(REQUEST_PARAM_NEW_TESTS_COUNT, startService.getNewTestsCount());
        modelAndView.addObject(REQUEST_PARAM_NEW_THEME_COUNT, startService.getNewThemeCount());
        return modelAndView;
    }
}
