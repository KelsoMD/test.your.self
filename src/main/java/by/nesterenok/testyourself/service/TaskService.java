package by.nesterenok.testyourself.service;

import java.util.List;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

public interface TaskService {

    List<Task> readGroupTasksForUser(Group group, User user);

    List<Task> readGroupTasks(Group group);

    Task readTask(int id);

    List<Task> readUserTasks(User user);
}
