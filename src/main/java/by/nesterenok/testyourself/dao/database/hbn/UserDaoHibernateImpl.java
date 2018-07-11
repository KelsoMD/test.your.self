package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(User t) {
        //TODO to test
        entityManager.getTransaction()
            .begin();
        entityManager.persist(t);
        entityManager.getTransaction()
            .commit();
    }

    @Override
    public User read(int id) {
        //TODO to test
        entityManager.getTransaction()
            .begin();
        User user = entityManager.find(User.class, id);
        entityManager.getTransaction()
            .commit();
        //        Session session = SessionFactoryManager.getSessionFactory()
        //            .openSession();
        //        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public void update(User t) {
        //TODO to test
        entityManager.getTransaction()
            .begin();
        entityManager.merge(t);
        entityManager.getTransaction()
            .commit();
    }

    @Override
    public void delete(User user) {
        // TODO to test
        entityManager.getTransaction()
            .begin();
        entityManager.remove(user);
        entityManager.getTransaction()
            .commit();
    }

    @Override
    public List<User> readAll() {
        // TODO to test
        Query query = entityManager.createQuery("SELECT u from User u");
        List<User> users = query.getResultList();
        return users;
    }

    @Override
    public User findByLogin(String login) {
        //TODO to test
        Query query = entityManager.createQuery("SELECT u from User u WHERE u.login = :login");
        query.setParameter("login", login);
        User user = (User) query.getSingleResult();
        return user;
        //        Session session = SessionFactoryManager.getSessionFactory()
        //            .openSession();
        //        return (User) session.createCriteria(User.class)
        //            .add(Restrictions.eq("login", login))
        //            .uniqueResult();
    }

    @Override
    public long counter() {
        //TODO to test
        Query query = entityManager.createQuery("SELECT count(u.id) FROM User u");
        long count = (long) query.getSingleResult();
        return count;
        //        Session session = SessionFactoryManager.getSessionFactory()
        //            .openSession();
        //        Criteria criteria = session.createCriteria(User.class);
        //        List<User> list = criteria.list();
        //        return list.size();
    }
}
