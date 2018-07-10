package by.nesterenok.testyourself.web.util;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.nesterenok.testyourself.domain.User;

public class ActionHelper {
	
	private ActionHelper() {
		
	}
	
	public static User getUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (User) session.getAttribute(SESSION_PARAM_USER);
	}
	
}
