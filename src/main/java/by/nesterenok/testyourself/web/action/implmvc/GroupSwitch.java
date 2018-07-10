package by.nesterenok.testyourself.web.action.implmvc;


import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;
import by.nesterenok.testyourself.service.TaskService;
import by.nesterenok.testyourself.service.ThemeService;
import by.nesterenok.testyourself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping({"/user/groups", "/mentor/groups"})
public class GroupSwitch implements RoleProcessor {

    @Autowired
    private GroupService groupService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = REQUEST_MAPPING_MENTOR_GROUPS_CREATE_PAGE, method = RequestMethod.GET)
    public ModelAndView switchCreateGroup() {
        ModelAndView modelAndView = new ModelAndView(processPage("create_group"));
        Group group = new Group();
        modelAndView.addObject(REQUEST_PARAM_GROUP, group);
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = "/{group_id}", method = RequestMethod.GET)
    public ModelAndView switchGroupInfoTasks(@PathVariable(REQUEST_PARAM_GROUP_ID) int groupId) {
        ModelAndView modelAndView = new ModelAndView(processPage("group_info_tasks"));
        User user = userService.readByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        Group group = groupService.readGroup(groupId);
        modelAndView.addObject(REQUEST_PARAM_GROUP_ID, groupId);
        if (user.getRole().equals("ROLE_USER")) {
            modelAndView.addObject(REQUEST_PARAM_TASKS, taskService.readGroupTasks(group));
            modelAndView.addObject("members", group.getMembers());

        } else if (user.getRole().equals("ROLE_MENTOR")) {
            modelAndView.addObject(REQUEST_PARAM_TASKS, taskService.readGroupTasks(group));
        }
        return modelAndView;

    }

    @RequestMapping(value = "/group_info_members", method = RequestMethod.GET)
    public ModelAndView switchGroupInfoMembers(@RequestParam(REQUEST_PARAM_GROUP_ID) int groupId) {
        ModelAndView modelAndView = new ModelAndView(processPage("group_info_members"));
        Group group = groupService.readGroup(groupId);
        modelAndView.addObject(REQUEST_PARAM_GROUP_ID, groupId);
        modelAndView.addObject(REQUEST_PARAM_MEMBERS, group.getMembers());
        return modelAndView;

    }
}
