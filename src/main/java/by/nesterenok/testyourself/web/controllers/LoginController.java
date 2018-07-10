package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.LOGIN_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.LOGIN_PAGE;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_USER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(REQUEST_PARAM_USER)
public class LoginController {

    @RequestMapping(value = LOGIN_MAPPING, method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView(LOGIN_PAGE);
    }
}
