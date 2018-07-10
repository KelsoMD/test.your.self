package by.nesterenok.testyourself.web.action;

import org.springframework.web.context.WebApplicationContext;

public class ActionManagerContext {

	private ActionManagerContext() {

	}

	public static BaseAction getAction(String action, WebApplicationContext webAppContext) {
		return (BaseAction) webAppContext.getBean(action);
	}
}
