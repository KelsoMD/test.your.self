package by.nesterenok.testyourself.web.action.implmvc;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping(value = {"/user", "/guest", "/mentor"})
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

    @RequestMapping(value = "/tests")
    public ModelAndView switchTestsMenu() {
        ModelAndView modelAndView = new ModelAndView(processPage("tests"));
        //TODO Pagination
        modelAndView.addObject(REQUEST_PARAM_TESTS, testService.readAll());
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = "/info")
    public ModelAndView switchInfoMenu() {
        ModelAndView modelAndView = new ModelAndView(processPage("info"));
        modelAndView.addObject(REQUEST_PARAM_QUESTION_COUNT, startService.getQuestionCount());
        modelAndView.addObject("test_count", startService.getTestPassedCount());
        modelAndView.addObject("user_count", startService.getUserCount());

        //TODO Counters
        return modelAndView;
    }

    @RequestMapping(value = "/groups", method = RequestMethod.GET)
    public ModelAndView switchGroupsMenu() {
        ModelAndView modelAndView = new ModelAndView(processPage("groups"));
        User user = userService.readByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if ("ROLE_MENTOR".equals(user.getRole())) {
            modelAndView.addObject(REQUEST_PARAM_GROUPS, groupService.readMentorGroups(user));
        } else if ("ROLE_USER".equals(user.getRole())) {
            modelAndView.addObject(REQUEST_PARAM_GROUPS, groupService.readGroups(user));
            //TODO load invites
        }
        return modelAndView;
    }

}
