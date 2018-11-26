package pro.webapp.db.dao;



import pro.webapp.db.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);
    List<User> listUser();
    User findUserByName(String user);
}
