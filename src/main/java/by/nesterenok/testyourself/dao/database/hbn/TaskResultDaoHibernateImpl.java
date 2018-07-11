package by.nesterenok.testyourself.dao.database.hbn;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.TaskResultDao;
import by.nesterenok.testyourself.domain.Group;
import by.nesterenok.testyourself.domain.TaskResult;
import by.nesterenok.testyourself.domain.User;

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
        //TODO update tasks results
    }

    @Override
    public void delete(TaskResult taskResult) {
        //TODO delete tasks results
    }

    @Override
    public List<TaskResult> readAll() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(TaskResult.class);
        List<TaskResult> resultList = criteria.list();
        session.close();
        return resultList;
    }

    @Override
    public List<TaskResult> readUserResults(User user) {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(TaskResult.class)
            .add(Restrictions.eq("member", user));
        List<TaskResult> taskResults = criteria.list();
        session.close();
        //TODO to test
        return taskResults;
    }

    @Override
    public List<TaskResult> readGroupResults(Group group) {
        //TODO to test
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(TaskResult.class)
            .createCriteria("task")
            .add(Restrictions.eq("id", group.getId()));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<TaskResult> taskResults = criteria.list();
        session.close();
        return taskResults;
    }
}
