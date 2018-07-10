package by.nesterenok.testyourself.dao;

import java.util.List;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Invite;
import by.nesterenok.testyourself.domain.User;

public interface InviteDao {

    public void create(Invite invite);

    public List<Invite> readUsers(User user);

    public List<Invite> reaGroups(Group group);

    public void delete(int id);
}
