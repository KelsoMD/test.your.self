package by.nesterenok.testyourself.dao;

import java.util.List;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Invite;
import by.nesterenok.testyourself.domain.User;

public interface InviteDao {

    void create(Invite invite);

    List<Invite> readUserInvites(User user);

    List<Invite> readGroupInvites(Group group);

    void delete(int id);
}
