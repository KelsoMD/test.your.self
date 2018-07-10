package by.nesterenok.testyourself.web.action.implmvc.start;

import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_NEW_QUESTIONS_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_NEW_TESTS_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.REQUEST_PARAM_NEW_THEME_COUNT;
import static by.nesterenok.testyourself.web.util.WebConstantPool.SESSION_PARAM_USER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;

//@Controller
//@RequestMapping("start_moderator")
//@SessionAttributes(SESSION_PARAM_USER)
public class StartModerator {
//	@Autowired
//	private StartService startService;
//
//	public void setStartService(StartService startService) {
//		this.startService = startService;
//	}
//	@RequestMapping(method = RequestMethod.GET)
//	public String executeAction(@ModelAttribute User user, ModelMap model) {
//		model.addAttribute(REQUEST_PARAM_NEW_QUESTIONS_COUNT, startService.getNewQuestionsCount());
//		model.addAttribute(REQUEST_PARAM_NEW_TESTS_COUNT, startService.getNewTestsCount());
//		model.addAttribute(REQUEST_PARAM_NEW_THEME_COUNT, startService.getNewThemeCount());
//		return "moderator_main";
//	}

}
