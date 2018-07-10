package by.nesterenok.testyourself.dao;

import java.util.List;

import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

public interface TaskDao extends BaseDao<Task> {

    List<Task> readUserTasks(User user);

    public List<Task> readGroupTasks(Group group);

    List<Task> readComplete4Tasks(User user);
}
