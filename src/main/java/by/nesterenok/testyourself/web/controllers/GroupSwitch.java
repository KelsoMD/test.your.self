package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_GROUP_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_PAGE_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.GROUP_ID_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.GROUP_INFO_MEMBERS_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.GROUP_INFO_MEMBERS_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.GROUP_INFO_TASKS_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MENTOR_GROUPS_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_GROUP;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_GROUP_ID;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_MEMBERS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_TASKS;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_THEMES;
import static by.nesterenok.testyourself.web.util.WebConstantPool.USER_GROUPS_MAPPING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;
import by.nesterenok.testyourself.service.TaskService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.service.UserService;
import by.nesterenok.testyourself.web.util.WebConstantPool;

@Controller
@RequestMapping({USER_GROUPS_MAPPING, MENTOR_GROUPS_MAPPING})
public class GroupSwitch implements RoleProcessor {

    @Autowired
    private GroupService groupService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = CREATE_PAGE_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchCreateGroup() {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_GROUP_PAGE));
        Group group = new Group();
        modelAndView.addObject(REQUEST_PARAM_GROUP, group);
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = GROUP_ID_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchGroupInfoTasks(@PathVariable(REQUEST_PARAM_GROUP_ID) int groupId) {
        ModelAndView modelAndView = new ModelAndView(processPage(GROUP_INFO_TASKS_PAGE));
        User user = userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName());
        Group group = groupService.readGroup(groupId);
        modelAndView.addObject(REQUEST_PARAM_GROUP_ID, groupId);
        if (user.getRole()
            .equals(ROLE_USER)) {
            modelAndView.addObject(REQUEST_PARAM_TASKS, taskService.readGroupTasks(group));
            modelAndView.addObject(REQUEST_PARAM_MEMBERS, group.getMembers());
        } else if (user.getRole()
            .equals(ROLE_MENTOR)) {
            modelAndView.addObject(REQUEST_PARAM_TASKS, taskService.readGroupTasks(group));
        }
        return modelAndView;
    }

    @RequestMapping(value = GROUP_INFO_MEMBERS_MAPPING, method = RequestMethod.GET)
    public ModelAndView switchGroupInfoMembers(@RequestParam(REQUEST_PARAM_GROUP_ID) int groupId) {
        ModelAndView modelAndView = new ModelAndView(processPage(GROUP_INFO_MEMBERS_PAGE));
        Group group = groupService.readGroup(groupId);
        modelAndView.addObject(REQUEST_PARAM_GROUP_ID, groupId);
        modelAndView.addObject(WebConstantPool.REQUEST_PARAM_MEMBERS, group.getMembers());
        return modelAndView;
    }
}
