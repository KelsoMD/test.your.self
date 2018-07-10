package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.InviteDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.Invite;
import by.nesterenok.testyourself.domain.User;

@Repository
public class InviteDaoHibernateImpl implements InviteDao {

    public void create(Invite invite) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(invite);
        session.getTransaction().commit();
        session.close();
    }

    public List<Invite> readUsers(User user) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        List<Invite> inviteList = session.createCriteria(Invite.class).add(Restrictions.eq("user", user))
            .list();
        session.close();
        return inviteList;
    }

    public List<Invite> reaGroups(Group group) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        List<Invite> inviteList = session.createCriteria(Invite.class).add(Restrictions.eq("group", group))
            .list();
        session.close();
        return inviteList;
    }

    public void delete(int id) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(new Invite(id));
        session.getTransaction().commit();
        session.close();
    }
}
