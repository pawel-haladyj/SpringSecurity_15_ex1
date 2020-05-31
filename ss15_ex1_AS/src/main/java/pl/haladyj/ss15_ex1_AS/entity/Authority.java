package pl.haladyj.ss15_ex1_AS.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToOne
    @JoinColumn(name = "user")
    @JsonIgnoreProperties({"authorities"})
    private User user;

    public Authority() {
    }

    public Authority(Long id, AuthorityName name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authority authority = (Authority) o;
        return Objects.equals(id, authority.id) &&
                name == authority.name &&
                Objects.equals(user, authority.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, user);
    }
}
