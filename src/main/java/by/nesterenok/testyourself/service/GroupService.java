package by.nesterenok.testyourself.service;

import java.util.List;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;

public interface GroupService {

    public List<Group> readGroups(User user);

    public List<Group> readMentorGroups(User user);

    public void createGroup(Group group);

    public Group readGroup(int id);
}
