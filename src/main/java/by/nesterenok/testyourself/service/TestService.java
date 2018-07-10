package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Test;
import lombok.NoArgsConstructor;

public interface TestService {
	
	public Test readTest(int id);
	
	public List<Test> readAll();
	
	public List<Test> searchTests(String theme, Integer lvl);
	
	public void createTest(Test test);
	
	public void prepareShuffled(Test test);

}
