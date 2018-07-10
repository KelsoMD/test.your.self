package by.nesterenok.testyourself.web.action.implmvc.mentor;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_MAPPING_MENTOR_GROUPS_ETC;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

import by.nesterenok.testyourself.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;
import by.nesterenok.testyourself.service.ThemeService;

@Controller
@RequestMapping(REQUEST_MAPPING_MENTOR_GROUPS_ETC)
@SessionAttributes(REQUEST_PARAM_USER)
public class GroupController {

	@Autowired
	private GroupService groupService;

	@Autowired
	private UserService userService;

	@RequestMapping(value="/create_group",method=RequestMethod.POST)
	public ModelAndView createGroup(@ModelAttribute("group") Group group) {
		group.setMentor(userService.readByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
		groupService.createGroup(group);
		return new ModelAndView();
	}
	
	

}
