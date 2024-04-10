package weblab3.util;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.hibernate.Session;

import java.io.Serializable;


@Named("userSession")
@RequestScoped
public class UserSession implements Serializable {

    @Inject
    private HibernateUtil hibernateUtil;
    private final Session session;

    public UserSession(){
        session = hibernateUtil.getSessionFactory().openSession();
    }


    public org.hibernate.Session getSession() {
        return session;
    }


    @PreDestroy
    public void destroy(){
        session.close();
    }
}
