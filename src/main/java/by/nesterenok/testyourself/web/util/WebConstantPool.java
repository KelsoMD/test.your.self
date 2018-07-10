package by.nesterenok.testyourself.web.util;

public final class WebConstantPool {
	
	private WebConstantPool() {
		
	}
	
	public static final String REQUEST_PARAM_QUESTION_COUNT =  "question_count";
	public static final String REQUEST_PARAM_LIST =  "list";
	public static final String REQUEST_PARAM_TEST_ID =  "test_id";
	public static final String REQUEST_PARAM_TEST_QUESTIONS = "test_questions";
	public static final String REQUEST_PARAM_ANSWER = "answer";
	public static final String REQUEST_PARAM_ANSWER1 = "answer1";
	public static final String REQUEST_PARAM_ANSWER2 = "answer2";
	public static final String REQUEST_PARAM_ANSWER3 = "answer3";
	public static final String REQUEST_PARAM_CORRECT_ANSWER = "correct_answer";
	public static final String REQUEST_PARAM_ANSWER_MAP = "answer_map";
	public static final String REQUEST_PARAM_MARK = "mark";
	public static final String REQUEST_PARAM_PASS_MSG = "pass_msg";
	public static final String REQUEST_PARAM_ROLE = "role";
	public static final String REQUEST_PARAM_TASK = "task";
	public static final String REQUEST_PARAM_TASKS = "tasks";
	public static final String REQUEST_PARAM_MEMBERS = "members";
	public static final String REQUEST_PARAM_TEST = "test";
	public static final String REQUEST_PARAM_USER = "user";
	public static final String REQUEST_PARAM_TESTS = "tests";
	public static final String REQUEST_PARAM_THEMES = "themes";
	public static final String REQUEST_PARAM_THEME = "theme";
	public static final String REQUEST_PARAM_LVL = "lvl";
	public static final String REQUEST_PARAM_TEXT = "text";
	public static final String REQUEST_PARAM_IMAGE = "image";
	public static final String REQUEST_PARAM_THEME_MSG = "theme_msg";
	public static final String REQUEST_PARAM_QUESTIONS_TO_CHOOSE = "testQuestionsToChoose";
	public static final String REQUEST_PARAM_QUESTIONS_ID = "question_id";
	public static final String REQUEST_PARAM_QUESTIONS_RECENT = "recentTestQuestions";
	public static final String REQUEST_PARAM_SHUFFLED = "shuffled";
	public static final String REQUEST_PARAM_NEW_QUESTIONS_COUNT = "new_questions";
	public static final String REQUEST_PARAM_NEW_TESTS_COUNT = "new_tests";
	public static final String REQUEST_PARAM_NEW_THEME_COUNT = "new_theme";
	public static final String REQUEST_PARAM_QUESTIONS = "questions";
	public static final String REQUEST_PARAM_IMAGE_LINK = "image_link";
	public static final String REQUEST_PARAM_GROUPS =  "groups";
	public static final String REQUEST_PARAM_GROUP =  "group";
	public static final String REQUEST_PARAM_GROUP_ID =  "group_id";
	
	public static final String REQUEST_MSG_PASSED = "Test passed";
	public static final String REQUEST_MSG_NOT_PASSED = "Test not passed";
	public static final String REQUEST_MSG_THEME_EXISTS = "Theme already exists";
	
	public static final String SESSION_PARAM_USER = "user";
	public static final String SESSION_PARAM_TEST = "test";
	
	
	public static final String REQUEST_MAPPING_TEMP_START = "/temp_start_new";
	public static final String REQUEST_MAPPING_START_USER = "/start_user_new";

	public static final String REQUEST_MAPPING_MENTOR = "mentor";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS = "/groups";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS_CREATE_PAGE = "/create_page";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS_INFO_TASK = "/group_info_tasks";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS_INFO_MEMBERS = "/group_info_members";
	public static final String REQUEST_MAPPING_MENTOR_TESTS = "/tests";
	public static final String REQUEST_MAPPING_MENTOR_GROUPS_ETC = "mentor/groups";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_ETC = "mentor/tests";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_CREATE_THEME = "/create_theme";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_CREATE_QUESTION = "/create_question";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_CREATE_TEST = "/create_test";
	public static final String REQUEST_MAPPING_MENTOR_TESTS_START_TEST = "/start_test";

	public static final String REQUEST_MAPPING_USER = "/user";
	public static final String REQUEST_MAPPING_USER_TESTS = "/tests";
	public static final String REQUEST_MAPPING_USER_GROUPS = "/groups";
	public static final String REQUEST_MAPPING_USER_TESTS_ETC = "user/tests";
	public static final String REQUEST_MAPPING_USER_GROUPS_ETC = "user/groups";
	public static final String REQUEST_MAPPING_USER_GROUPS_FINISH_TASK = "/finish";
	public static final String REQUEST_MAPPING_USER_GROUPS_START_TASK = "/start";
	public static final String REQUEST_MAPPING_USER_TESTS_CREATE_THEME = "/create_theme";
	public static final String REQUEST_MAPPING_USER_TESTS_CREATE_QUESTION = "/create_question";
	public static final String REQUEST_MAPPING_USER_TESTS_CREATE_TEST_ONE = "/create_test_one";
	public static final String REQUEST_MAPPING_USER_TESTS_CREATE_TEST_TWO = "/create_test_two";

	public static final String REQUEST_MAPPING_GUEST = "guest";
	public static final String REQUEST_MAPPING_GUEST_TESTS = "/tests";
	
	public static final String REQUEST_MAPPING_TEST_DELETE_QUESTION = "/delete_question";
	public static final String REQUEST_MAPPING_TEST_ADD_QUESTION = "/add_question";
	public static final String REQUEST_MAPPING_TEST_CREATE_TEST = "/create_test";
	public static final String REQUEST_MAPPING_TEST_START_TEST = "/start_test";
	public static final String REQUEST_MAPPING_TEST_SUJEST_THEME = "/sujest_theme";
	public static final String REQUEST_MAPPING_TEST_SUJEST_QUESTION = "/sujest_question";
	public static final String REQUEST_MAPPING_TEST_SEARCH_TEST = "/search_test";
	public static final String REQUEST_MAPPING_TEST_PREVIEW = "/preview";
	public static final String REQUEST_MAPPING_TEST_FINISH = "/finish";
	public static final String REQUEST_MAPPING_TEST_SAVE_RESULT = "/save_result";
	
	public static final String REQUEST_MAPPING_INFO = "/info";



	
	public static final String PAGE_INDEX =  "/WEB-INF/index.jsp";
	public static final String PAGE_TEST = "/WEB-INF/jsp/user/test_page.jsp";
	public static final String PAGE_RESULT = "/WEB-INF/jsp/user/result_page.jsp";
	public static final String PAGE_INDEX_TEMP = "/indextemp.jsp";

	public static final String PAGE_USER_CREATE_QUESTION = "/WEB-INF/jsp/user/create_question.jsp";
	public static final String PAGE_USER_CREATE_THEME = "/WEB-INF/jsp/user/create_theme.jsp";
	public static final String PAGE_USER_CREATE_TEST_ST_ONE = "/WEB-INF/jsp/user/create_test_one.jsp";
	public static final String PAGE_USER_CREATE_TEST_ST_TWO = "/WEB-INF/jsp/user/create_test_two.jsp";
	public static final String PAGE_USER_PREVIEW = "/WEB-INF/jsp/user/preview.jsp";

	public static final String PAGE_MODERATOR_MAIN = "/WEB-INF/main.jsp";
	public static final String PAGE_MODERATOR_QUESTIONS = "/WEB-INF/questions.jsp";
	public static final String PAGE_MODERATOR_PREVIEW = "/WEB-INF/preview.jsp";
	
	public static final String REDIRECT = "redirect:";
	public static final String PAGE_NOT_IMPL = "notimplemented";

	public static final String PAGE_MENTOR_MAIN = "jsp/mentor/main";
	public static final String PAGE_MENTOR_GROUPS = "jsp/mentor/groups";
	public static final String PAGE_MENTOR_TESTS = "jsp/mentor/tests";
	public static final String PAGE_MENTOR_INFO = "jsp/mentor/info";
	public static final String PAGE_MENTOR_TESTS_CREATE_THEME = "jsp/mentor/create_theme";
	public static final String PAGE_MENTOR_TESTS_CREATE_QUESTION = "jsp/mentor/create_question";
	public static final String PAGE_MENTOR_TESTS_CREATE_TEST = "jsp/mentor/start_build_test";
	public static final String PAGE_MENTOR_TESTS_TEST = "jsp/mentor/test_page";
	public static final String PAGE_MENTOR_TESTS_CREATE_TEST_TWO = "jsp/mentor/create_test_two";
	public static final String PAGE_MENTOR_GROUPS_CREATE_GROUP = "jsp/mentor/create_group";
	public static final String PAGE_MENTOR_GROUPS_CREATE_INFO_TASKS = "jsp/mentor/group_info_tasks";
	public static final String PAGE_MENTOR_GROUPS_CREATE_INFO_MEMBERS = "jsp/mentor/group_info_members";
	

	public static final String PAGE_USER_MAIN = "jsp/user/main";
	public static final String PAGE_USER_TESTS = "jsp/user/tests";
	public static final String PAGE_USER_INFO = "jsp/user/info";
	public static final String PAGE_USER_TEST_PAGE = "jsp/user/test_page";
	public static final String PAGE_USER_TASK_PAGE = "jsp/user/task_page";
	public static final String PAGE_USER_TESTS_CREATE_THEME = "jsp/user/create_theme";
	public static final String PAGE_USER_TESTS_CREATE_QUESTION = "jsp/user/create_question";
	public static final String PAGE_USER_TESTS_CREATE_TEST_ONE = "jsp/user/create_test_one";
	public static final String PAGE_USER_TESTS_CREATE_TEST_TWO = "jsp/user/create_test_two";
	public static final String PAGE_USER_TESTS_PREVIEW = "jsp/user/preview_user";
	public static final String PAGE_USER_TESTS_RESULT = "jsp/user/result_page";
	public static final String PAGE_USER_GROUPS_RESULT = "jsp/user/task_result_page";

	public static final String PAGE_GUEST_MAIN = "jsp/guest/main";
	public static final String PAGE_GUEST_TESTS = "jsp/guest/tests";
	public static final String PAGE_GUEST_INFO = "jsp/guest/info";
	
	
	public static final String REDIRECT_URL_SEARCH_PAGE = "http://localhost:8080/testyourself/MainServlet?action=switch_search_page";
	public static final String REDIRECT_URL_MAIN_USER_PAGE = "http://localhost:8080/testyourself/MainServlet?action=start_user";
	public static final String REDIRECT_URL_MODERATOR_QUESTIONS = "http://localhost:8080/testyourself/MainServlet?action=moderate_questions";
	public static final String REDIRECT_URL_SEARCH_PAGE_CLOUD = "http://testyourself.mycloud.by/MainServlet?action=switch_search_page";
	public static final String REDIRECT_URL_MAIN_USER_PAGE_CLOUD = "http://testyourself.mycloud.by/MainServlet?action=start_user";
	public static final String REDIRECT_URL_MODERATOR_QUESTIONS_CLOUD = "http://testyourself.mycloud.by/MainServlet?action=moderate_questions";

}
