package com.example.FinanceTracker.person;

import com.example.FinanceTracker.role.Role;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "person")
public class Person implements UserDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "person_id")
    private Long id;
    /*
    The 'name' value will be the userName for the person
     */
    private String name;
    private String userName;
    private double budget;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_role_joint",
            joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;

    public Person() {
        this.authorities = new HashSet<Role>();
    }


    public Person(Long id, String name, String userName, double budget, String password) {
        this.id = id;
        this.name = name;
        this.budget = budget;
        this.password = password;
    }

    public Person(String name, String userName, double budget, String password) {
        this.name = name;
        this.budget = budget;
        this.password = password;
    }

    public Person(Long id, String userName, String password, Set<Role> authorities) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    public void setUserName() {
        this.userName = userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                ", password='" + password + '\'' +
                '}';
    }
}
