package by.nesterenok.testyourself.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;
import by.nesterenok.testyourself.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public List<Group> readGroups(User user) {
        return groupDao.readUserGroups(user);
    }

    @Override
    public List<Group> readMentorGroups(User user) {
        return groupDao.readMentorGroups(user);
    }

    @Override
    public void createGroup(Group group) {
        groupDao.create(group);
    }

    @Override
    public Group readGroup(int id) {
        return groupDao.read(id);
    }
}
