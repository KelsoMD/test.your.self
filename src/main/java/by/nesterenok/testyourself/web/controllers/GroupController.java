package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.CREATE_GROUP_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MENTOR_GROUPS_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.MODEL_ATTRIBUTE_GROUP;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.service.GroupService;
import by.nesterenok.testyourself.service.UserService;

@Controller
@RequestMapping(MENTOR_GROUPS_MAPPING)
@SessionAttributes(REQUEST_PARAM_USER)
public class GroupController {
    //TODO Create groups controller
    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = CREATE_GROUP_MAPPING, method = RequestMethod.POST)
    public ModelAndView createGroup(@ModelAttribute(MODEL_ATTRIBUTE_GROUP) Group group) {
        group.setMentor(userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName()));
        groupService.createGroup(group);
        return new ModelAndView();
    }
}
