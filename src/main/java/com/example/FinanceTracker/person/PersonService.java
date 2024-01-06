package com.example.FinanceTracker.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService implements UserDetailsService {

    private final PersonRepository personRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder encoder) {
        this.personRepository = personRepository;
        this.encoder = encoder;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    //Needs editing
    public boolean getPerson() {
        return personRepository.existsById(1L);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("In the user details service");

        return personRepository.findByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("This user name is not found"));

    }
}
