package by.nesterenok.testyourself.service;

import java.util.List;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;

public interface GroupService {

    List<Group> readGroups(User user);

    List<Group> readMentorGroups(User user);

    void createGroup(Group group);

    Group readGroup(int id);
}
