package by.nesterenok.testyourself.web.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import by.nesterenok.testyourself.domain.Question;
import by.nesterenok.testyourself.service.QuestionService;

public class ResultParser {

	private static final String REGEX = "\\*";
	private static final int PASS_PERCENT = 70;
	
	private QuestionService questionService;
	
	public QuestionService getQuestionService() {
		return questionService;
	}

	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	private ResultParser() {

	}

	public Map<Question, String> parseAnswers(String[] answers) {

		Map<Question, String> map = new LinkedHashMap<>();

		for (int i = 0; i < answers.length; i++) {
			String[] pair = answers[i].split(REGEX);
			Question question = null;
			try {
				question = questionService.readQuestion(Integer.parseInt(pair[1]));
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put(question, pair[0].trim());
		}
		return map;
	}

	public int getMark(Map<Question, String> answers) {
		int correctAnswers = 0;
		for (Entry<Question, String> entry : answers.entrySet()) {
			if (entry.getKey().getCorrectAnswer().equals(entry.getValue())) {
				correctAnswers++;
			}
		}
		double mark = correctAnswers/ (double) answers.size() * 100;
		return (int) mark;
	}

	public boolean isPassed(int mark) {
		return mark > PASS_PERCENT;
	}

}
