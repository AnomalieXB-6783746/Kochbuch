package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authority {

    private Long id;

    private String name;

    private Set<User> users;

    public Authority(String name) {
        this.name = name;
        this.users = new HashSet<>();
    }

    public Authority() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", length = 20, nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "authorities",
            fetch = FetchType.LAZY)
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void removeUser(User user) {
        this.users.remove(user);
    }

}
