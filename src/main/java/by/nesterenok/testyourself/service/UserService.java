package by.nesterenok.testyourself.service;

import by.nesterenok.testyourself.domain.User;

public interface UserService {
	
	 User readUser();
	
	 User readByLogin(String login);
	
}
