package by.nesterenok.testyourself.dao.database.hbn;

import by.nesterenok.testyourself.dao.QuestionJPACriteriaDao;
import by.nesterenok.testyourself.domain.Question;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
@Transactional
public class QuestionDaoHibernateImpl implements QuestionJPACriteriaDao {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Question t) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
    }

    @Override
    public Question read(int id) {
        return entityManager.find(Question.class, id);
    }

    @Override
    public void update(Question t) {
       Session session = SessionFactoryManager.getSessionFactory().openSession();
       session.beginTransaction();
       session.update(t);
       session.getTransaction().commit();
    }

    @Override
    public void delete(Question question) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(question);
        session.getTransaction().commit();

    }

    @Override
    public List<Question> readAll() {
        CriteriaQuery<Question> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Question.class);
        Root<Question> root = criteriaQuery.from(Question.class);
        root.fetch("author", JoinType.INNER);
        criteriaQuery.select(root);
        TypedQuery<Question> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public long counter() {
        CriteriaQuery<Long> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Long.class);
        criteriaQuery.select(entityManager.getCriteriaBuilder().count(criteriaQuery.from(Question.class)));
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public List<Question> readTestQuestions(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Question> readQuestionsForTest(String theme, int lvl) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> root = criteriaQuery.from(Question.class);
        root.fetch("author", JoinType.INNER);
        Predicate predicate = criteriaBuilder.and(criteriaBuilder.equal(root.get("theme"), theme), criteriaBuilder
                .equal(root.get("lvl"), lvl), criteriaBuilder.equal(root.get("aprooved"), true));

        criteriaQuery.where(predicate);
//        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("theme"), ));
//        criteriaQuery.where(criteriaBuilder.equal(root.get("lvl"), ));
//        criteriaQuery.where(criteriaBuilder.equal(root.get("aprooved"), true));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<Question> readNotAprooved() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> criteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> root = criteriaQuery.from(Question.class);
        root.fetch("author", JoinType.INNER);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("aprooved"), false));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public long newQuestionsCount() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Question> questionCriteriaQuery = criteriaBuilder.createQuery(Question.class);
        Root<Question> root = questionCriteriaQuery.from(Question.class);
        root.fetch("author", JoinType.INNER);
        questionCriteriaQuery.select(root).where(criteriaBuilder.equal(root.get("aprooved"), false));

        return entityManager.createQuery(questionCriteriaQuery).getResultList().size();
    }
}
