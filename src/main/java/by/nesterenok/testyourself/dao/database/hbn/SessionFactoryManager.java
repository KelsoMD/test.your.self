package by.nesterenok.testyourself.dao.database.hbn;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public final class SessionFactoryManager {

    private static final String CONFIG_XML = "config/hibernate.cfg.xml";
    private static SessionFactory sessionFactory;

    private SessionFactoryManager() {
    }

    private static SessionFactory buildSessionFactory() {

        Configuration configuration = new Configuration();
        configuration.configure(CONFIG_XML);

        ServiceRegistry serviceRegistry =
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                        .build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
