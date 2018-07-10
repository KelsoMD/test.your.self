package by.nesterenok.testyourself.temp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.dao.QuestionJPACriteriaDao;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.dao.UserDao;

public class Main {
	

	public static void main(String[] args) {
ApplicationContext context = new ClassPathXmlApplicationContext("web-context.xml");
		QuestionJPACriteriaDao dao = (QuestionJPACriteriaDao) context.getBean("questionDao");
		TestDao testDao = (TestDao) context.getBean("testDao");
		UserDao userDao = (UserDao) context.getBean("userDao");
		GroupDao groupDao = (GroupDao) context.getBean("groupDao");
		TaskDao taskDao = (TaskDao) context.getBean("taskDao");
		
		System.out.println(testDao.read(1));
		
		System.out.println();
		System.out.println(testDao.readAll());
		System.out.println();
		
		System.out.println(testDao.readLast());
		
	}

}
