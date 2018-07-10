package by.nesterenok.testyourself.web.action.implmvc.start;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import by.nesterenok.testyourself.service.UserService;

@Controller
@SessionAttributes(REQUEST_PARAM_USER)
public class Logintemp {

	@Autowired
	private UserService us;
	
	public UserService getUs() {
		return us;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView logintemp() {
		return new ModelAndView("login");
	}
}
