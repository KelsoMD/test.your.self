package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.ResultDao;
import by.nesterenok.testyourself.domain.Result;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class ResultDaoHibernateImpl implements ResultDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void create(Result t) {

        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction()
                .commit();
        session.close();
    }

    @Override
    public Result read(int id) {

        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        Result result = (Result) session.get(Result.class, id);
        session.close();
        return result;
    }

    @Override
    public void update(Result t) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Result result) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Result> readAll() {

        Session session = SessionFactoryManager.getSessionFactory()
                .openSession();
        Criteria criteria = session.createCriteria(Result.class);
        List<Result> resultList = criteria.list();
        session.close();
        return resultList;
    }

    @Override
    public long counter() {
        Query query = entityManager.createQuery("SELECT count(t.id) FROM Result t WHERE t.passed = :passed");
        query.setParameter("passed", true);
        return (long) query.getSingleResult();
    }
}
