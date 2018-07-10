package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.TestDao;
import by.nesterenok.testyourself.domain.Test;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class TestDaoHibernateImpl implements TestDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Test t) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction()
            .commit();
        session.close();
    }

    @Override
    public Test read(int id) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        session.beginTransaction();
        Test test = (Test) session.get(Test.class, id);
        session.getTransaction()
            .commit();
        session.close();
        return test;
    }

    @Override
    public void update(Test t) {

        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction()
            .commit();
        session.close();
    }

    @Override
    public void delete(Test test) {

        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        session.beginTransaction();
        session.delete(test);
        session.getTransaction()
            .commit();
        session.close();
    }

    @Override
    public List<Test> readAll() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.addOrder(Order.desc("id"));
        criteria.add(Restrictions.eq("aprooved", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Test> testList = criteria.list();
        session.close();
        return testList;
    }

    @Override
    public List<Test> readLast() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.addOrder(Order.desc("id"));
        criteria.add(Restrictions.eq("aprooved", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Test> testList = criteria.list();
        session.close();
        if (testList.size()>4) {
            return testList.subList(0, 4);
        } else {
            return testList;
        }
    }

    @Override
    public List<Test> readSubscribed(String theme) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.addOrder(Order.desc("id"));
        criteria.add(Restrictions.eq("theme", theme));
        criteria.add(Restrictions.eq("aprooved", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Test> testList = criteria.list();
        session.close();
        return testList;
    }

    @Override
    public List<Test> searchTheme(String theme) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.addOrder(Order.desc("id"));
        criteria.add(Restrictions.eq("theme", theme));
        criteria.add(Restrictions.eq("aprooved", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Test> testList = criteria.list();
        session.close();
        return testList;
    }

    @Override
    public List<Test> searchLvl(int lvl) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.addOrder(Order.desc("id"));
        criteria.add(Restrictions.eq("level", lvl));
        criteria.add(Restrictions.eq("aprooved", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Test> testList = criteria.list();
        session.close();
        return testList;
    }

    @Override
    public List<Test> searchThemeLvl(String theme, int lvl) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.addOrder(Order.desc("id"));
        criteria.add(Restrictions.eq("theme", theme));
        criteria.add(Restrictions.eq("lvl", lvl));
        criteria.add(Restrictions.eq("aprooved", true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Test> testList = criteria.list();
        session.close();
        return testList;
    }

    @Override
    public List<Test> readNotAprooved() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.add(Restrictions.eq("aprooved", false));
        List<Test> list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public int newTestsCount() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Test.class);
        criteria.setProjection(Projections.property("id"));
        criteria.setProjection(Projections.property("aprooved"));
        criteria.add(Restrictions.eq("aprooved", false));
        List<Integer> list = criteria.list();
        session.close();
        return list.size();
    }
}
