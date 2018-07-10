package by.nesterenok.testyourself.web.action;


import java.util.Map;

public class ActionManager {
	
	
	
	private ActionManager() {
		
	}
	
	private static final String CONSTANT_PARAM_ACTION_START = "start_action";
	private static final String CONSTANT_PARAM_START_TEST = "start_test";
	private static final String CONSTANT_PARAM_FINISH_TEST = "finish_test";
	private static final String CONSTANT_PARAM_EXIT_RESULTS = "exit_results";
	
	
	private static Map<String, BaseAction> actions;
	
//	static {
//		actions = new HashMap<>();		
//		actions.put(CONSTANT_PARAM_ACTION_START,(BaseAction) WebContext.Context.getBean(CONSTANT_PARAM_ACTION_START));
//		actions.put(CONSTANT_PARAM_START_TEST, (BaseAction) WebContext.Context.getBean(CONSTANT_PARAM_START_TEST));
//		actions.put(CONSTANT_PARAM_FINISH_TEST, (BaseAction) WebContext.Context.getBean(CONSTANT_PARAM_FINISH_TEST));
//	}
	
	
	public static BaseAction getAction(String action) {
		return actions.get(action);
	}

}
