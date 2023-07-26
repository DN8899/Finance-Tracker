package com.example.FinanceTracker.security;

import com.example.FinanceTracker.person.Person;
import com.example.FinanceTracker.person.PersonRepository;
import com.example.FinanceTracker.role.Role;
import com.example.FinanceTracker.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person registerUser(String userName, String password) {

        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return personRepository.save(new Person(1L, userName, encodedPassword, authorities));
    }

}
