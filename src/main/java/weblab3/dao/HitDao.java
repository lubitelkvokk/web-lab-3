package weblab3.dao;

import org.hibernate.HibernateException;
import weblab3.models.Hit;
import org.hibernate.Session;
import weblab3.util.HibernateUtil;

public class HitDao {

    private static Session session;

    static {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void addHit(Hit hit) {

        try {
            session.beginTransaction();
            session.persist(hit);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }

    }
}
