package by.nesterenok.testyourself.web.action.implmvc;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value= {"/not_implemented","mentor/not_implemented", "user/not_implemented"})
public class NotImplemented {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showErrorGet() {
		return new ModelAndView(PAGE_NOT_IMPL);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView showErrorPost() {
		return new ModelAndView(PAGE_NOT_IMPL);
	}

}
