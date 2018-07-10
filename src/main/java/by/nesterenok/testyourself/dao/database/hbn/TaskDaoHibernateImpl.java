package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import by.nesterenok.testyourself.domain.Group;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.TaskDao;
import by.nesterenok.testyourself.domain.Task;
import by.nesterenok.testyourself.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class TaskDaoHibernateImpl implements TaskDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Task t) {

        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction()
                .commit();
        session.close();
    }

    @Override
    public Task read(int id) {
        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        Task task = (Task) session.get(Task.class, id);
        return task;
    }

    @Override
    public void update(Task t) {

        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction()
                .commit();
        session.close();
    }

    @Override
    public void delete(Task task) {

        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.delete(task);
        session.getTransaction()
                .commit();
        session.close();
    }

    @Override
    public List<Task> readAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Task> readUserTasks(User user) {
        Query query = entityManager.createQuery("SELECT t FROM Task t JOIN t.group g WHERE :user member of g.members");
        query.setParameter("user", user);
        List<Task> list = query.getResultList();
        return list;
    }

    @Override
    public List<Task> readGroupTasks(Group group) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Task.class)
                .createCriteria("group")
                .add(Restrictions.eq("id", group.getId()));
        criteria.setResultTransformer((Criteria.DISTINCT_ROOT_ENTITY));
        List<Task> list = criteria.list();
        return list;
    }

    @Override
    public List<Task> readComplete4Tasks(User user) {
        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        Criteria criteria = session.createCriteria(Task.class)
                .createCriteria("group")
                .createCriteria("mentor")
                .add(Restrictions.eq("id", user.getId()));
        criteria.addOrder(Order.desc("id"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Task> taskList = criteria.list();
        session.close();
        return taskList;
    }
}
