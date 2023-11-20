package weblab3.util;

import jakarta.annotation.PostConstruct;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

@Named("hibernateUtil")
@ApplicationScoped
public class HibernateUtil implements Serializable {
    private final SessionFactory sessionFactory;

    public org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public HibernateUtil() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @PreDestroy
    public void destroy() {
        sessionFactory.close();
    }

}
