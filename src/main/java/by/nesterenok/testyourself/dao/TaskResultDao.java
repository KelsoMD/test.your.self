package by.nesterenok.testyourself.dao;

import java.util.List;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.TaskResult;
import by.nesterenok.testyourself.domain.User;

public interface TaskResultDao extends BaseDao<TaskResult> {

    List<TaskResult> readUserResults(User user);

    List<TaskResult> readGroupResults(Group group);
}
