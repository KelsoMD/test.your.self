package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import by.nesterenok.testyourself.domain.Question;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.UserDao;
import by.nesterenok.testyourself.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class UserDaoHibernateImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(User t) {
        // TODO Auto-generated method stub

    }

    @Override
    public User read(int id) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        User user = (User) session.get(User.class, id);
        return user;
    }

    @Override
    public void update(User t) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(User user) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByLogin(String login) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        return (User) session.createCriteria(User.class)
            .add(Restrictions.eq("login", login))
            .uniqueResult();
    }

    @Override
    public long counter() {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(User.class);
        List<User> list = criteria.list();
        //CriteriaQuery<Long> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Long.class);
        //criteriaQuery.select(entityManager.getCriteriaBuilder().count(criteriaQuery.from(User.class)));
        return list.size();//entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
