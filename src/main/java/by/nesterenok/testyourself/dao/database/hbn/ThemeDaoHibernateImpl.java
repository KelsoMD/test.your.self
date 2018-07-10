package by.nesterenok.testyourself.dao.database.hbn;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import by.nesterenok.testyourself.dao.ThemeDao;
import by.nesterenok.testyourself.domain.Themes;

@Repository
public class ThemeDaoHibernateImpl implements ThemeDao {

    @Override
    public void create(String theme) {

        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        session.beginTransaction();
        session.save(new Themes(theme));
        session.getTransaction()
            .commit();
        session.close();
    }

    @Override
    public List<String> readAll() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Themes.class);
        criteria.add(Restrictions.eq("aprooved", true));
        List<Themes> themeList = criteria.list();
        session.close();
        List<String> list = new ArrayList<>();
        for (Themes theme : themeList) {
            list.add(theme.getTheme());
        }
        return list;
    }

    @Override
    public int newThemeCount() {
        Session session = SessionFactoryManager.getSessionFactory()
            .openSession();
        Criteria criteria = session.createCriteria(Themes.class);
        criteria.setProjection(Projections.property("id"));
        criteria.setProjection(Projections.property("aprooved"));
        criteria.add(Restrictions.eq("aprooved", false));
        List<Integer> list = criteria.list();
        session.close();
        return list.size();
    }
}
