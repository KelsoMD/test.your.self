package by.nesterenok.testyourself.web.action.implmvc.guest;

import by.nesterenok.testyourself.dao.QuestionJPACriteriaDao;
import by.nesterenok.testyourself.service.QuestionService;
import by.nesterenok.testyourself.service.StartService;
import by.nesterenok.testyourself.service.TestService;
import by.nesterenok.testyourself.web.action.implmvc.RoleProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping(value = REQUEST_MAPPING_GUEST)
@SessionAttributes(SESSION_PARAM_USER)
public class GuestSwitchMenu implements RoleProcessor {

    @Autowired
    private TestService testService;

    @Autowired
    private StartService startService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionJPACriteriaDao questionDao;


    /* Rest Test */
    @RequestMapping(value = "/resttest", method = RequestMethod.GET)
    @ResponseBody
    public String restTest() {
//    Question restTestQuestion = new Question(1);
//    restTestQuestion.setText("Test");
//    restTestQuestion.setCorrectAnswer("Ccorrect answer");
//    restTestQuestion.setAnswer1("1");
//    restTestQuestion.setAnswer2("2");
//    restTestQuestion.setAnswer3("3");
//    restTestQuestion.setAprooved(true);
//    restTestQuestion.setLvl(1);
//    restTestQuestion.setTheme("RestTest");
//    try {
//        Question question = questionService.readQuestion(1);
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//    return "";
//    }
        //  System.out.println(questionRepository.findById(1));
        return "";
    }
}
