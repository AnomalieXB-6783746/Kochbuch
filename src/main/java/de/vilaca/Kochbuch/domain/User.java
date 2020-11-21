package de.vilaca.Kochbuch.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    public enum Role {
        ADMIN,
        USER,
        DEFAULT
    }

    private long id;

    private String username;

    private String password;

    private Role role;

    private String email;

    private boolean enabled;

    private Set<Recipe> recipes;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(length = 50, nullable = false, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 60, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(length = 50, nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false)
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(targetEntity = Recipe.class,
            mappedBy = "",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
