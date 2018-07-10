package by.nesterenok.testyourself.web.action.implmvc.start;

import by.nesterenok.testyourself.dao.QuestionDao;
import by.nesterenok.testyourself.dao.UserRepository;
import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TaskService;
import by.nesterenok.testyourself.service.UserService;
import by.nesterenok.testyourself.service.impl.EmailService;
import by.nesterenok.testyourself.web.action.implmvc.RoleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping("/")
public class StartController implements RoleProcessor {

    @Autowired
    private UserService userService;

    @Autowired
    private StartService startService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String startUrl() {
        return REDIRECT + processUrl();

    }

    @Transactional
    @RequestMapping(value = {"/guest", "/user", "/mentor"}, method = RequestMethod.GET)
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView(processPage("main"));
        User user = userService.readByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user != null) {
            if ((user.getTheme() != null)) {
                modelAndView.addObject("tests", startService.getStartSubscribedTests(user.getTheme()));
            } else {
                modelAndView.addObject("tests", startService.getStartTests());
            }
            modelAndView.addObject("question_count", startService.getQuestionCount());
            modelAndView.addObject("user_count", startService.getUserCount());
            modelAndView.addObject("test_count", startService.getTestPassedCount());
            System.out.println(startService.getUserCount());
            if (user.getGroup().isEmpty()) {
               modelAndView.addObject("task", taskService.readUserTasks(user));
            }
        } else {
            modelAndView.addObject("tests", startService.getStartTests());
            modelAndView.addObject("question_count", startService.getQuestionCount());
            modelAndView.addObject("user_count", startService.getUserCount());
            modelAndView.addObject("test_count", startService.getTestPassedCount());
        }
//
//        emailService.sendSimpleMessage("p.grigoreva20@gmail.com", "Mail attemtp", "Furst email send from my project " +
//                "using Spring mail service");
        return modelAndView;
    }
    @Transactional
    @RequestMapping(value = ("/moderator"), method = RequestMethod.GET)
    public ModelAndView startModerator() {
        ModelAndView modelAndView = new ModelAndView("moderator/main");
        modelAndView.addObject(REQUEST_PARAM_NEW_QUESTIONS_COUNT, startService.getNewQuestionsCount());
        modelAndView.addObject(REQUEST_PARAM_NEW_TESTS_COUNT, startService.getNewTestsCount());
        modelAndView.addObject(REQUEST_PARAM_NEW_THEME_COUNT, startService.getNewThemeCount());
//
//        emailService.sendSimpleMessage("p.grigoreva20@gmail.com", "Mail attemtp", "Furst email send from my project " +
//                "using Spring mail service");
        return modelAndView;
    }
}
