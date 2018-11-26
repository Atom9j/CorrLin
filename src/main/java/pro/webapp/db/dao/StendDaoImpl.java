package pro.webapp.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pro.webapp.db.model.Stend;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StendDaoImpl implements StendDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<Stend> stendList() {
        @SuppressWarnings("unchecked")
        TypedQuery<Stend> query = sessionFactory.getCurrentSession().createQuery("from Stend ");
        sessionFactory.getCurrentSession().beginTransaction();
        return query.getResultList();
    }
}
