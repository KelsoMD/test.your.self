package by.nesterenok.testyourself.service;

import by.nesterenok.testyourself.domain.User;

public interface UserService {
	
	public User readUser();
	
	public User readByLogin(String login);
	
}
