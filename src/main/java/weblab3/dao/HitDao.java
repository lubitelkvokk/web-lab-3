package weblab3.dao;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import weblab3.models.Hit;
import weblab3.util.HibernateUtil;
import weblab3.util.UserSession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Основное взаимодействие с таблицей результатов в базе данных
 */
@Named("hitDao")
@SessionScoped
public class HitDao implements Serializable {

    @Inject
    private UserSession userSession;


    /**
     * Добавление результата в базу данных
     * @param hit
     */
    public void addHit(Hit hit) {
        Session session = userSession.getSession();
        try {
            session.beginTransaction();
            session.persist(hit);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    //    public List<Hit> getPaginationHitList(Integer pageSize, Integer pageNumber) {

    /**
     * Получение списка результатов попаданий с учетом пагинации
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public List<Hit> getPaginationHitList(int pageSize, int pageNumber) {
        System.out.println(pageNumber);
        Session session = userSession.getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Hit> criteria = builder.createQuery(Hit.class);
        Root<Hit> root = criteria.from(Hit.class);
        criteria.select(root);
        criteria.orderBy(builder.asc(root.get("id")));
        Query<Hit> query = session.createQuery(criteria);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }


}
