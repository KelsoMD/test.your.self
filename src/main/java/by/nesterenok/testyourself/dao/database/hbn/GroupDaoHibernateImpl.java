package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.GroupDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class GroupDaoHibernateImpl implements GroupDao {

    @Autowired
    EntityManager entityManager;

    @Override
    public void create(Group t) {
        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction()
                .commit();
        session.close();
    }

    @Override
    public Group read(int id) {
        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        Group group = (Group) session.get(Group.class, id);
        return group;
    }

    @Override
    public void update(Group t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Group group) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Group> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Group> readUserGroups(User user) {
        Query query = entityManager.createQuery("select g from Group g where :user member of g.members");
        query.setParameter("user", user);
        List<Group> list = query.getResultList();
        return list;
    }

    @Override
    public List<Group> readMentorGroups(User user) {
        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        Criteria criteria = session.createCriteria(Group.class)
                .createCriteria("mentor")
                .add(Restrictions.eq("id", user.getId()));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Group> groupList = criteria.list();
        session.close();
        return groupList;
    }
}
