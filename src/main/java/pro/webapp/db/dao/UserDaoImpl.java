package pro.webapp.db.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pro.webapp.db.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {

    }

    public List<User> listUser() {
        return null;
    }


    public User findUserByName(String user) {
        System.out.println("FROM USER DAO: " + user);
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        TypedQuery<User> query = session.createQuery("from User where username = :name");
        session.beginTransaction();
        query.setParameter("name", user);
        User usr = query.getSingleResult();
        System.out.println("RESULT USERS: " + usr.toString());
        return usr;
    }
}
