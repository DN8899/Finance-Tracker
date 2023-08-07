package com.example.FinanceTracker.person;

import com.example.FinanceTracker.role.Role;
import com.example.FinanceTracker.transaction.Transaction;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Entity
@Table(name = "person")
public class Person implements UserDetails {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "personId")
    private Long userId;
    @Column(unique = true)
    private String userName;
    private double budget;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "person_role_joint",
            joinColumns = {@JoinColumn(name = "personId")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;

    @OneToMany(mappedBy = "person")
    private List<Transaction> transactionList = new ArrayList<>();




    public Person() {
        authorities = new HashSet<Role>();
    }


    public Person(Long userId, String userName, double budget, String password) {
        this.userId = userId;
        this.userName = userName;
        this.budget = budget;
        this.password = password;
    }

    public Person(String userName, double budget, String password) {
        this.budget = budget;
        this.userName = userName;
        this.password = password;
    }

    public Person(Long userId, String userName, String password, Set<Role> authorities) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", budget=" + budget +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
