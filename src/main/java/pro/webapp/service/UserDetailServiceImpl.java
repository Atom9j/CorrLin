package pro.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.webapp.db.dao.UserDao;
import pro.webapp.db.model.Authorities;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao usersDao;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("Start user details method " + s);
        pro.webapp.db.model.User user = usersDao.findUserByName(s);
        System.out.println("USER: " + user.toString());
        User.UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.disabled(!user.isEnabled());
            builder.password(user.getPassword());
            String[] authorities = user.getAuthorities().stream().map(Authorities::getAuthprity).toArray(String[]::new);
            builder.authorities(authorities);
        }else {
            throw new UsernameNotFoundException("User not found!");
        }
        System.out.println("BUILD complete user details method");
        return builder.build();
    }
}
