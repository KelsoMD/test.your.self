package by.nesterenok.testyourself.web.controllers;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping(value = {USER_MAPPING, GUEST_MAPPING, MENTOR_MAPPING})
public class MenuSwitch implements RoleProcessor {

    @Autowired
    private TestService testService;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private StartService startService;

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = TESTS_MAPPING)
    public ModelAndView switchTestsMenu() {
        ModelAndView modelAndView = new ModelAndView(processPage(TESTS_PAGE));
        //TODO Pagination
        modelAndView.addObject(REQUEST_PARAM_TESTS, testService.readAll());
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = INFO_MAPPING)
    public ModelAndView switchInfoMenu() {
        ModelAndView modelAndView = new ModelAndView(processPage(INFO_PAGE));
        modelAndView.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
        modelAndView.addObject(REQUEST_PARAM_TEST_COUNT, startService.getTestPassedCount());
        modelAndView.addObject(REQUEST_PARAM_USER_COUNT, startService.getUserCount());
        return modelAndView;
    }

    @RequestMapping(value = GROUPS_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchGroupsMenu() {
        ModelAndView modelAndView = new ModelAndView(processPage(GROUPS_PAGE));
        User user = userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName());
        if (ROLE_MENTOR.equals(user.getRole())) {
            modelAndView.addObject(REQUEST_PARAM_GROUPS, groupService.readMentorGroups(user));
        } else if (ROLE_USER.equals(user.getRole())) {
            modelAndView.addObject(REQUEST_PARAM_GROUPS, groupService.readGroups(user));
            //TODO load invites
        }
        return modelAndView;
    }
}
