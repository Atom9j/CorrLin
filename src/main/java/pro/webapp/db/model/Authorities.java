package pro.webapp.db.model;

import javax.persistence.*;

@Entity
@Table(name = "std_authorities")
public class Authorities {

    @Id
    @Column(name = "authority")
    private String authprity;

    @ManyToOne
    //@JoinColumn(name = "username")
    private User user;


    public String getAuthprity() {
        return authprity;
    }

    public void setAuthprity(String authprity) {
        this.authprity = authprity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
