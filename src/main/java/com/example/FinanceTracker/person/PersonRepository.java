package com.example.FinanceTracker.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository
        extends JpaRepository<Person, Long> {

    /*
    Used to get the person by their username
     */
    Optional<Person> findByUserName(String userName);
}
