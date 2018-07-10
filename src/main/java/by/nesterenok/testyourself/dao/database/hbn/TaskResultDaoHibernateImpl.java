package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;

import by.nesterenok.testyourself.domain.Task;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.TaskResultDao;
import by.nesterenok.testyourself.domain.TaskResult;

@Repository
public class TaskResultDaoHibernateImpl implements TaskResultDao {

    @Override
    public void create(TaskResult taskResult) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        session.beginTransaction();
        session.save(taskResult);
        session.getTransaction()
            .commit();
        session.close();
    }

    @Override
    public TaskResult read(int id) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        TaskResult result = (TaskResult) session.get(TaskResult.class, id);
        session.close();
        return result;
    }

    @Override
    public void update(TaskResult taskResult) {
        //TODO
    }

    @Override
    public void delete(TaskResult taskResult) {
        //TODO
    }

    @Override
    public List<TaskResult> readAll() {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(TaskResult.class);
        List<TaskResult> resultList = criteria.list();
        session.close();
        return resultList;
    }
}
