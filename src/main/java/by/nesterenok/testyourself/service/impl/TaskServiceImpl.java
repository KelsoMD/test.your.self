package by.nesterenok.testyourself.service.impl;

import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public List<Task> readUserTasks(User user) {
        List<Task> taskList = user.getGroup().stream().flatMap(group -> group.getTasks()
                .stream()).filter(task -> task.getFinishTo().before(new Date())).collect(Collectors.toList());
        for (Group group : user.getGroup()) {
            taskList.addAll(group.getTasks());
        }
        //TODO exclude completed tasks
        return taskList;
    }

    /**
     * Finds tasks for user that he haven't pass yet, because user have single attempt to pass task.
     *
     * @param group - User group that contains tasks to find.
     * @param user  - User looking for task to exclude passed tasks.
     * @return Collection of not passed tasks. (List).
     */
    @Override
    public List<Task> readGroupTasksForUser(Group group, User user) {
        //TODO
        return null;
    }

    @Override
    public List<Task> readGroupTasks(Group group) {
        return taskDao.readGroupTasks(group);
    }

    @Override
    public Task readTask(int id) {
        return taskDao.read(id);
    }
}
