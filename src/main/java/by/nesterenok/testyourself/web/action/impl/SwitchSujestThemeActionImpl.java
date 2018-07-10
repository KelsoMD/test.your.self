package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.web.action.BaseAction;

public class SwitchSujestThemeActionImpl implements BaseAction{

	@Override
	public String executeAction(HttpServletRequest request) {
		return PAGE_USER_CREATE_THEME;
	}

}
