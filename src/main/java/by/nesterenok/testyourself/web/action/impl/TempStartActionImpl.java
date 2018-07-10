package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.UserService;
import by.nesterenok.testyourself.web.action.BaseAction;

public class TempStartActionImpl implements BaseAction {

	private UserService us;
	private StartUserActionImpl tempUserStart;
	private StartModeratorActionImpl tempModerStart;

	public void setUs(UserService us) {
		this.us = us;
	}

	public void setTempUserStart(StartUserActionImpl tempUserStart) {
		this.tempUserStart = tempUserStart;
	}

	public void setTempModerStart(StartModeratorActionImpl tempModerStart) {
		this.tempModerStart = tempModerStart;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		String role = request.getParameter(REQUEST_PARAM_ROLE);
		if (role != null) {
			HttpSession session = request.getSession();
			User user = null;
			switch (role) {
			case "user":
				user = us.readUser();
				user.setRole("user");
				session.setAttribute("user", user);
				return tempUserStart.executeAction(request);
			case "mentor":
				user = us.readUser();
				user.setRole("mentor");
				session.setAttribute("user", user);
				return null;
			case "admin":
				user = us.readUser();
				user.setRole("admin");
				session.setAttribute("user", user);
				return null;
			case "moderator":
				user = us.readUser();
				user.setRole("moderator");
				session.setAttribute("user", user);
				return tempModerStart.executeAction(request);
			default:
				return PAGE_INDEX_TEMP;
			}
		} else {
			return PAGE_INDEX_TEMP;
		}
	}
}
