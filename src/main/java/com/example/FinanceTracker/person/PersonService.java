package com.example.FinanceTracker.person;

import com.example.FinanceTracker.role.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class PersonService implements UserDetailsService {

    private final PersonRepository personRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public boolean getPerson() {
        return personRepository.existsById(1L);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("In the user details crap");

        return personRepository.findByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("This user name is not found"));

    }
}
