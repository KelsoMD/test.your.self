package by.nesterenok.testyourself.web.controllers;

import static by.nesterenok.testyourself.web.util.WebConstantPool.NOT_IMPLEMENTED_MAPPING;
import static by.nesterenok.testyourself.web.util.WebConstantPool.NOT_IMPLEMENTED_PAGE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = NOT_IMPLEMENTED_MAPPING)
public class NotImplemented {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showErrorGet() {
        return new ModelAndView(NOT_IMPLEMENTED_PAGE);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView showErrorPost() {
        return new ModelAndView(NOT_IMPLEMENTED_PAGE);
    }
}
