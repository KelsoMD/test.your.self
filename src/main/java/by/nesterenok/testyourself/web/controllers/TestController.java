package by.nesterenok.testyourself.web.controllers;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.domain.Result;
import by.nesterenok.testyourself.domain.Test;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

@Controller
@RequestMapping(value = {USER_TESTS_MAPPING, MENTOR_TESTS_MAPPING, GUEST_TESTS_MAPPING})
@SessionAttributes(SESSION_PARAM_TEST)
public class TestController implements RoleProcessor {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private TestService testService;
    @Autowired
    private ThemeService themeService;
    @Autowired
    private ResultService resultService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = TEST_MAPPING, method = RequestMethod.GET)
    public ModelAndView startTest(@PathVariable(PATH_VARIABLE_TEST) int testId) {
        ModelAndView modelAndView = new ModelAndView(processPage(TEST_PAGE_PAGE));
        Test test = testService.readTest(testId);
        testService.prepareShuffled(test);
        modelAndView.addObject(REQUEST_PARAM_TEST_QUESTIONS, test.getQuestions());
        modelAndView.addObject(REQUEST_PARAM_TEST, test.getId());
        return modelAndView;
    }

    @RequestMapping(value = BUILD_DELETE_MAPPING, method = RequestMethod.GET)
    public ModelAndView deleteQuestion(@RequestParam(REQUEST_PARAM_QUESTIONS_ID) int questionId,
                                       @ModelAttribute(MODEL_ATTRIBUTE_TEST) Test test) {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_TEST_TWO_PAGE));
        Question question = null;
        question = questionService.readQuestion(questionId);
        test.getQuestions()
            .remove(question);
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE,
            questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
        return modelAndView;
    }

    @RequestMapping(value = BUILD_ADD_MAPPING, method = RequestMethod.GET)
    public ModelAndView addQuestion(@ModelAttribute(MODEL_ATTRIBUTE_TEST) Test test,
                                    @RequestParam(REQUEST_PARAM_QUESTIONS_ID) int questionId, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView(processPage(CREATE_TEST_TWO_PAGE));
        test.getQuestions()
            .add(questionService.readQuestion(questionId));
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS_RECENT, test.getQuestions());
        modelAndView.addObject(REQUEST_PARAM_QUESTIONS_TO_CHOOSE,
            questionService.returnQuestionsForTest(test.getTheme(), test.getLvl()));
        return modelAndView;
    }

    @RequestMapping(value = BUILD_CREATE_TEST_MAPPING, method = RequestMethod.POST)
    public ModelAndView createTest(@ModelAttribute(MODEL_ATTRIBUTE_TEST) Test test, ModelMap modelMap) {
        testService.createTest(test);
        ModelAndView modelAndView = new ModelAndView(REDIRECT + processUrl(), modelMap);
        return modelAndView;
    }

    @RequestMapping(value = SUJEST_THEME_MAPPING, method = RequestMethod.POST)
    public ModelAndView sujestTheme(@RequestParam(REQUEST_PARAM_THEME) String theme, ModelMap modelMap) {
        List<String> themeList = themeService.readThemes();
        if (themeList.contains(theme)) {
            return new ModelAndView(processPage(CREATE_THEME_PAGE), REQUEST_PARAM_THEME_MSG, REQUEST_MSG_THEME_EXISTS);
        } else {
            themeService.createTheme(theme);
            return new ModelAndView(REDIRECT + processUrl(), modelMap);
        }
    }

    @RequestMapping(value = SUJEST_QUESTION_MAPPING, method = RequestMethod.POST)
    public String sujestQuestion(@ModelAttribute(MODEL_ATTRIBUTE_QUESTION) Question question) {
        // Question question = questionService.buildQuestion(request);
        question.setAuthor(userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName()));
        questionService.createQuestion(question);
        return REDIRECT + processUrl();
    }

    @RequestMapping(value = SEARCH_TEST_MAPPING, method = RequestMethod.GET)
    public ModelAndView searchTests(@RequestParam(REQUEST_PARAM_THEME) String theme,
                                    @RequestParam(REQUEST_PARAM_LVL) int lvl) {
        ModelAndView modelAndView = new ModelAndView(processPage(TESTS_PAGE));
        modelAndView.addObject(REQUEST_PARAM_TESTS, testService.searchTests(theme, lvl));
        modelAndView.addObject(REQUEST_PARAM_THEMES, themeService.readThemes());
        return modelAndView;
    }

    @RequestMapping(value = BUILD_QUESTION_ID_MAPPING, method = RequestMethod.GET)
    public ModelAndView preview(@PathVariable(REQUEST_PARAM_QUESTIONS_ID) int id) {
        ModelAndView modelAndView = new ModelAndView(processPage(PREVIEW_PAGE));
        Question question = null;
        question = questionService.readQuestion(id);
        modelAndView.addObject(REQUEST_PARAM_TEXT, question.getText());
        if (question.getImage() != null) {
            modelAndView.addObject(REQUEST_PARAM_IMAGE, question.getImage());
        }
        questionService.shuffleAnswers(question);
        modelAndView.addObject(REQUEST_PARAM_SHUFFLED, question.getShuffledAnswers());
        return modelAndView;
    }

    @RequestMapping(value = RESULT_MAPPING, method = RequestMethod.POST)
    public ModelAndView finishTest(@RequestParam(REQUEST_PARAM_ANSWER) String[] answers,
                                   @RequestParam(REQUEST_PARAM_TEST) int testId) {
        ModelAndView modelAndView = new ModelAndView(processPage(RESULT_PAGE_PAGE));
        User user = userService.readByLogin(SecurityContextHolder.getContext()
            .getAuthentication()
            .getName());
        Result result = resultService.buildResult(testId, user, answers);
        if (user != null && (user.getRole()
            .equals(ROLE_USER) || user.getRole()
            .equals(ROLE_MENTOR))) {
            resultService.createResult(result);
        }
        modelAndView.addObject(REQUEST_PARAM_ANSWER_MAP, resultService.getAnswerMap(answers));
        modelAndView.addObject(REQUEST_PARAM_MARK, result.getMark());
        if (result.isPassed()) {
            modelAndView.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_PASSED);
        } else {
            modelAndView.addObject(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_NOT_PASSED);
        }
        return modelAndView;
    }
}
