package by.nesterenok.testyourself.web.action.impl;

import static by.nesterenok.testyourself.web.util.WebConstantPool.*;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.web.action.BaseAction;
import by.nesterenok.testyourself.web.util.ResultParser;

public class FinishTestActionImpl implements BaseAction{
	
	private ResultParser rp;
	
	public void setRp(ResultParser rp) {
		this.rp = rp;
	}

	@Override
	public String executeAction(HttpServletRequest request) {
		String[] answers = request.getParameterValues(REQUEST_PARAM_ANSWER);
		Map<Question, String> answerMap = rp.parseAnswers(answers);
		
		request.setAttribute(REQUEST_PARAM_ANSWER_MAP, answerMap);
		int mark = rp.getMark(answerMap);
		request.setAttribute(REQUEST_PARAM_MARK, mark);
		if(rp.isPassed(mark)) {
			request.setAttribute(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_PASSED);	
		} else {
			request.setAttribute(REQUEST_PARAM_PASS_MSG, REQUEST_MSG_NOT_PASSED);
		}
		request.setAttribute(REQUEST_PARAM_TEST, Integer.parseInt(request.getParameter(REQUEST_PARAM_TEST)));
		
		return PAGE_RESULT;
	}

}
